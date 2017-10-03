package controlador;

import java.sql.*;
import beans.Direccion;
import modelo.Conexion;

public class DireccionCrud {
	
	public static boolean registrarDireccion(Direccion direccion){
		boolean exitoso = false;
		try {
			Conexion c = new Conexion();
			Connection con = c.getConexion();
			if(con != null){
				Statement st = con.createStatement();
				String query = "INSERT INTO Direccion(calle, numInt, numExt, colonia, cp, Estado_Republica_idEstadoRepublica) " + 
								"VALUES('" + direccion.getCalle() + "','" + direccion.getNumInt() + "','" + direccion.getNumExt() +  
								"','" + direccion.getColonia() + "','" + direccion.getCp() + "','" + direccion.getEstado() + "');";
				st.executeUpdate(query);
				exitoso = true;
				st.close();
			}
			c.cerrarConexion();
		} catch (SQLException sqle) {
			exitoso = false;
			sqle.printStackTrace();
		}
		return exitoso;
	}
	
	public static ResultSet mostrarEstados() throws SQLException{
//			ArrayList<Object> estados = new ArrayList<>();
			Conexion c = new Conexion();
			Connection con = c.getConexion();
			
			String query = "SELECT idEstadoRepublica, nombreEstado FROM estado_Republica;";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			return rs;
	}
        
        public static ResultSet obtenerDireccion() throws SQLException{
            Conexion c =  new Conexion();
            Connection con = c.getConexion();
            
            Statement st = con.createStatement();
            String query;
            query = "SELECT MAX(IdDireccion) AS idDireccion FROM direccion";
            ResultSet rs = st.executeQuery(query);
            return rs;
	}
        
}
