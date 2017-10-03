/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import beans.Sucursal;
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
public class ConsultaSucursal {
    
    Conexion conexion;
    Connection connection;
    Statement statement;
    ResultSet resultset;
    Sucursal sucursal;

    public ConsultaSucursal() {
        
        try {
            conexion = new Conexion();
            connection = conexion.getConexion();
            statement = connection.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaSucursal.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    


    public ArrayList<Object> consultaNombre(String nombre){
        ArrayList<Object> resultado = new ArrayList<>();
        
        try {
            resultset = statement.executeQuery("SELECT * FROM Sucursal WHERE sucursal LIKE \"%"+nombre+"%\" ");
            while(resultset.next()){
            sucursal = new Sucursal();
            sucursal.setIdSucursal(Integer.parseInt(resultset.getObject("idSucursal").toString()) );
            sucursal.setSucursal(resultset.getObject("sucursal").toString());
            sucursal.setFechaInauguracion(resultset.getObject("fechaInauguracion").toString());
            //sucursal.setFechaCierre(resultset.getObject("fechaCierre").toString());
            sucursal.setFechaCierre(resultset.getObject("fechaInauguracion").toString());
            sucursal.setIdDireccion( Integer.parseInt( resultset.getObject("Direccion_idDireccion").toString() ) );
            //}}
            resultado.add(sucursal);
                System.out.println("Accedi asfasfasfasf");
            }
            
        } catch (SQLException ex) {
            System.err.println("Error SQL: "+ex.getMessage());
        }
        return resultado;
    }

    public ArrayList<Object> consultaId(String id){
        ArrayList<Object> resultado = new ArrayList<>();
        
        try {
            resultset = statement.executeQuery("SELECT * FROM Sucursal WHERE idSucursal LIKE \"%"+id+"%\" ");
            while(resultset.next()){
            sucursal = new Sucursal();
            sucursal.setIdSucursal(Integer.parseInt(resultset.getObject("idSucursal").toString()) );
            sucursal.setSucursal(resultset.getObject("sucursal").toString());
            sucursal.setFechaInauguracion(resultset.getObject("fechaInauguracion").toString());
            //sucursal.setFechaCierre(resultset.getObject("fechaCierre").toString());
            sucursal.setFechaCierre(resultset.getObject("fechaInauguracion").toString());
            sucursal.setIdDireccion( Integer.parseInt( resultset.getObject("Direccion_idDireccion").toString() ) );
            //}}
            resultado.add(sucursal);
                System.out.println("Accedi asfasfasfasf");
            }
            
        } catch (SQLException ex) {
            System.err.println("Error SQL: "+ex.getMessage());
        }
        return resultado;
    }
    
    
    
}
