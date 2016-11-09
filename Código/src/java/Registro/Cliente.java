
package Registro;
import java.sql.*;
import BaseDeDatos.ConexionBaseDeDatos;
/**
 *
 * @author Roberto
 */
public class Cliente {
    
    /**
     *
     * @param cb
     * @return
     */
    public static boolean altaCliente(ClienteBean cb){
        try{
            ConexionBaseDeDatos con = new ConexionBaseDeDatos();
            Statement s = con.realizarConexion();
            s.executeUpdate("INSERT INTO cliente (nombre,crup,tipo,correo, USUARIO_FINAL_idUSUARIO_FINAL,MEMBRESIA_idMEMBRESIA  ) VALUES ('"
                    +cb.getNombre()+"','"+cb.getCurp()+"', '"+cb.getTipo()+"', '"+cb.getCorreo()+"'," + 1 + ", " + 2 +")" );
            
            System.out.println("");
            con.cerrarConexion();
        }
        catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
