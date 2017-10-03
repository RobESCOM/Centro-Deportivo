
package controlador;

import beans.Servicio;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Conexion;

/**
 *
 * @author Killer Eagle
 */
public class ConsultaServicio {
    
    Conexion conexion;
    Connection connection;
    Statement statement;
    ResultSet resultset;
    Servicio servicio;

    public ConsultaServicio() {
        
        try {
            conexion = new Conexion();
            connection = conexion.getConexion();
            statement = connection.createStatement();
        } catch (SQLException ex) {
            System.err.println("Error SQL: "+ex.getSQLState());
        }
    
    }
    

    public ArrayList<Object> consultaNombre(String nombre){
        ArrayList<Object> resultado = new ArrayList<>();
        
        try {
            resultset = statement.executeQuery("SELECT * FROM Servicio WHERE nombreServicio LIKE \"%"+nombre+"%\" ");
            while(resultset.next()){
            servicio = new Servicio();
            servicio.setIdServicio(Integer.parseInt(resultset.getObject("idServicio").toString() ));            
            servicio.setNombreServicio(resultset.getObject("nombreServicio").toString());
            servicio.setDescripcion(resultset.getObject("descripcion").toString());
            servicio.setIdEstatus(Integer.parseInt( resultset.getObject("Estatus_idEstatus").toString() ) );            
            servicio.setIdUbicacion(Integer.parseInt(resultset.getObject("Ubicacion_idUbicacion").toString()) );
            resultado.add(servicio);
            }
        } catch (SQLException ex) {
            System.err.println("Error SQL: "+ex.getSQLState());
        }
        return resultado;
    }

    public ArrayList<Object> consultaId(String id){
        ArrayList<Object> resultado = new ArrayList<>();
        
        try {
            resultset = statement.executeQuery("SELECT * FROM Servicio WHERE idServicio LIKE \"%"+id+"%\" ");
            while(resultset.next()){
            servicio = new Servicio();
            servicio.setIdServicio(Integer.parseInt(resultset.getObject("idServicio").toString() ));            
            servicio.setNombreServicio(resultset.getObject("nombreServicio").toString());
            servicio.setDescripcion(resultset.getObject("descripcion").toString());
            servicio.setIdEstatus(Integer.parseInt( resultset.getObject("Estatus_idEstatus").toString() ) );            
            servicio.setIdUbicacion(Integer.parseInt(resultset.getObject("Ubicacion_idUbicacion").toString()) );
            resultado.add(servicio);
            resultado.add(servicio);
            }
        } catch (SQLException ex) {
            System.err.println("Error SQL: "+ex.getSQLState());
        }
        return resultado;
    }
    /**
     * Cierra la conexion.
     */
    @Override
    protected void finalize(){
        try {
            System.out.println("Cerrando conexion...");
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaServicio.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                super.finalize();
            } catch (Throwable ex) {
                Logger.getLogger(ConsultaServicio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
}
