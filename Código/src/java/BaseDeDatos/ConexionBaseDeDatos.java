/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDeDatos;

import java.sql.*;

/**
 *
 * @author Roberto
 */
public class ConexionBaseDeDatos {
    Statement s; //Objeto que me permite la consulta en la BD
    Connection conexion; //Objeto que me permitira la conexion
    
    public ConexionBaseDeDatos(){
        s = null;
        conexion = null;
    }
    
    public Statement realizarConexion() throws ClassNotFoundException{
        try{
            //Se lee el driver dela base de datos que se utiliza
            Class.forName("com.mysql.jdbc.Driver");
            //Se realiza la conexion a la BD
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/gimnasio","root","root");
            //Se crea un objeto para las consultas posteriores
            s = conexion.createStatement();          
        }
        catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return s;
    }
    
    public void cerrarConexion(){
        try{
            conexion.close();
        }
        catch(SQLException sqle){
            sqle.printStackTrace();
        }
    }
    
   /*public boolean probarConexion(){
        try{
            ResultSet r = s.executeQuery("select *from membresia");
            while(r.next()){
                System.out.println(r.getString(1));
            }
            cerrarConexion();
        }
        catch(SQLException sqle){
            sqle.printStackTrace();
            return false;
        }
        return true;
    }
    
    public static void main(String[] args){
        ConexionBaseDeDatos con = new ConexionBaseDeDatos();
        try{
            con.realizarConexion();
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        System.out.println(con.probarConexion());
    }*/
}
