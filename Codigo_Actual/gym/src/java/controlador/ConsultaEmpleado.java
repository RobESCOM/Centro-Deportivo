
package controlador;

import beans.Empleado;
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
public class ConsultaEmpleado {
    
    Conexion conexion;
    Connection connection;
    Statement statement;
    ResultSet resultset;
    Empleado empleado;

    public ConsultaEmpleado() {
        
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
            resultset = statement.executeQuery("SELECT * FROM Empleado WHERE nombre LIKE \"%"+nombre+"%\" ");
            while(resultset.next()){
            empleado = new Empleado();
            empleado.setCurp(resultset.getObject("curp").toString());
            empleado.setNombre(resultset.getObject("nombre").toString());
            empleado.setApellidoP(resultset.getObject("apellidoP").toString());
            empleado.setApellidoM(resultset.getObject("apellidoM").toString());
            empleado.setNss(resultset.getObject("nss").toString());
            empleado.setFechaIngreso(resultset.getObject("fechaIngreso").toString());
            //empleado.setFechaBaja(resultset.getObject("fechaBaja").toString());
            empleado.setFechaBaja(resultset.getObject("fechaIngreso").toString());
            empleado.setFechaFinContrato(resultset.getObject("fechaFinContrato").toString());
            empleado.setFechaNacimiento(resultset.getObject("fechaNacimiento").toString());
            empleado.setUsuario(resultset.getObject("usuario").toString());
            empleado.setIdTipoEmpleado( Integer.parseInt(resultset.getObject("Tipo_Empleado_idTipoEmpleado").toString()) );
            empleado.setIdDireccion( Integer.parseInt( resultset.getObject("Direccion_idDireccion").toString() ) );
            empleado.setIdEstatus(Integer.parseInt( resultset.getObject("Estatus_idEstatus").toString() ) );
            empleado.setClave(Integer.parseInt(resultset.getObject("clave").toString()));
            resultado.add(empleado);
            }
        } catch (SQLException ex) {
            System.err.println("Error SQL: "+ex.getSQLState());
        }
        return resultado;
    }
    
    public int consultaAcceso(String user, String contra){
        try {
            resultset = statement.executeQuery("SELECT * FROM Empleado ");
             
            while(resultset.next()){
               
            if (user.equals(resultset.getObject("Usuario").toString()) && contra.equals(resultset.getObject("Clave").toString())){
                 return Integer.parseInt(resultset.getObject("Tipo_Empleado_idTipoEmpleado").toString());
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
            resultset = statement.executeQuery("SELECT * FROM Empleado WHERE curp LIKE \"%"+id+"%\" ");
            while(resultset.next()){
            empleado = new Empleado();
            empleado.setCurp(resultset.getObject("curp").toString());
            empleado.setNombre(resultset.getObject("nombre").toString());
            empleado.setApellidoP(resultset.getObject("apellidoP").toString());
            empleado.setApellidoM(resultset.getObject("apellidoM").toString());
            empleado.setNss(resultset.getObject("nss").toString());
            empleado.setFechaIngreso(resultset.getObject("fechaIngreso").toString());
            //empleado.setFechaBaja(resultset.getObject("fechaBaja").toString());
            empleado.setFechaBaja(resultset.getObject("fechaIngreso").toString());
            empleado.setFechaFinContrato(resultset.getObject("fechaFinContrato").toString());
            empleado.setFechaNacimiento(resultset.getObject("fechaNacimiento").toString());
            empleado.setUsuario(resultset.getObject("usuario").toString());
            empleado.setIdTipoEmpleado( Integer.parseInt(resultset.getObject("Tipo_Empleado_idTipoEmpleado").toString()) );
            empleado.setIdDireccion( Integer.parseInt( resultset.getObject("Direccion_idDireccion").toString() ) );
            empleado.setIdEstatus(Integer.parseInt( resultset.getObject("Estatus_idEstatus").toString() ) );
            empleado.setClave(Integer.parseInt(resultset.getObject("clave").toString()));
            resultado.add(empleado);
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
            Logger.getLogger(ConsultaEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                super.finalize();
            } catch (Throwable ex) {
                Logger.getLogger(ConsultaEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
}
