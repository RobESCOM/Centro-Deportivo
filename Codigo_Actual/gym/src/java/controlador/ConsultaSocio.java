
package controlador;

import beans.Socio;
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
 * @author Killer Eagle & Martin Carrillo
 */
public class ConsultaSocio {
    
    Conexion conexion;
    Connection connection;
    Statement statement;
    ResultSet resultset;
    Socio socio;

    public ConsultaSocio() {
        
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
            resultset = statement.executeQuery("SELECT * FROM Socio WHERE nombre LIKE \"%"+nombre+"%\" ");
            while(resultset.next()){
            socio = new Socio();
            socio.setCurp(resultset.getObject("curp").toString());
            socio.setNombre(resultset.getObject("nombre").toString());
            socio.setApellidoP(resultset.getObject("apellidoP").toString());
            socio.setApellidoM(resultset.getObject("apellidoM").toString());
            socio.setFechaNacimiento(resultset.getObject("fechaNacimiento").toString());
            socio.setIdStatus(Integer.parseInt( resultset.getObject("Estatus_idEstatus").toString() ) );
            socio.setIdResumenMedico(Integer.parseInt( resultset.getObject("Resumen_Medico_idResumen_Medico").toString() ) );
            socio.setIdDireccion( Integer.parseInt( resultset.getObject("Direccion_idDireccion").toString() ) );
            resultado.add(socio);
            }
        } catch (SQLException ex) {
            System.err.println("Error SQL: "+ex.getSQLState());
        }
        return resultado;
    }
    
    public int consultaAcceso(String user, String contra){
        try {
            resultset = statement.executeQuery("SELECT * FROM Socio");
             
            while(resultset.next()){
               
            if (user.equals(resultset.getObject("curp").toString()) && contra.equals(resultset.getObject("fechaNacimiento").toString())){
                return Integer.parseInt(resultset.getObject("Estatus_idEstatus").toString());
                }
            }
        } catch (SQLException ex) {
            System.err.println("Error SQL: "+ex.getSQLState());
        }
        return -1;
    }

    public ArrayList<Object> consultaId(String id){
        ArrayList<Object> resultado = new ArrayList<>();
        
        try {
            resultset = statement.executeQuery("SELECT * FROM Socio WHERE curp LIKE \"%"+id+"%\" ");
            while(resultset.next()){
                socio = new Socio();
                socio.setCurp(resultset.getObject("curp").toString());
                socio.setNombre(resultset.getObject("nombre").toString());
                socio.setApellidoP(resultset.getObject("apellidoP").toString());
                socio.setApellidoM(resultset.getObject("apellidoM").toString());
                socio.setFechaNacimiento(resultset.getObject("fechaNacimiento").toString());
                socio.setIdStatus(Integer.parseInt( resultset.getObject("Estatus_idEstatus").toString() ) );
                socio.setIdResumenMedico(Integer.parseInt( resultset.getObject("Resumen_Medico_idResumen_Medico").toString() ) );
                socio.setIdDireccion( Integer.parseInt( resultset.getObject("Direccion_idDireccion").toString() ) );
                resultado.add(socio);
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
            Logger.getLogger(ConsultaSocio.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                super.finalize();
            } catch (Throwable ex) {
                Logger.getLogger(ConsultaSocio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
}
