/*
 * Autor: Roberto Mendoza Saavedra
 * 
 * */
package controlador;

import java.sql.*;

import beans.Empleado;
import modelo.Conexion;

public class EmpleadoCrud {
	
	public static boolean agregarEmpleado(Empleado nuevoEmpleado){
		boolean exitoso = false;
		try {
			Conexion c = new Conexion();
			Connection con = c.getConexion();
			if(con != null){
				Statement st = con.createStatement();
				String query = "INSERT INTO Empleado(curp, Nombre, apellidoP, apellidoM, nss, fechaIngreso, fechaBaja, fechaFinContrato, " +
								"fechaNacimiento, Tipo_Empleado_idTipoEmpleado, Direccion_idDireccion, Estatus_idEstatus, Usuario, Clave) " + 
								"VALUES ('" + nuevoEmpleado.getCurp() + "','" + nuevoEmpleado.getNombre() + "','" + nuevoEmpleado.getApellidoP() + 
								"','" + nuevoEmpleado.getApellidoM() + "','" + nuevoEmpleado.getNss() + "','" + nuevoEmpleado.getFechaIngreso() + 
								"','" + nuevoEmpleado.getFechaBaja() + "','" + nuevoEmpleado.getFechaFinContrato() + "','" + nuevoEmpleado.getFechaNacimiento() + 
								"','" + nuevoEmpleado.getIdTipoEmpleado() + "','" + nuevoEmpleado.getIdDireccion() + "','" + nuevoEmpleado.getIdEstatus() + 
								"','" + nuevoEmpleado.getUsuario() + "','" + nuevoEmpleado.getClave() + "');";
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
	
	public static boolean actualizarEmpleado(Empleado nuevoEmpleado, String curp){
		boolean exitoso = false;
		try {
			Conexion c = new Conexion();
			Connection con = c.getConexion();
			if(con != null){
				Statement st = con.createStatement();
				String query = "UPDATE Empleado SET Nombre='" + nuevoEmpleado.getNombre() + "',apellidoP='" + nuevoEmpleado.getApellidoP() +
								"',apellidoM='" + nuevoEmpleado.getApellidoM() + "',nss='" + nuevoEmpleado.getNss() + "',fechaBaja ='" + 
								nuevoEmpleado.getFechaBaja() + "',fechaFinContrato='" + nuevoEmpleado.getFechaFinContrato() + "',fechaNacimiento='" +
								nuevoEmpleado.getFechaNacimiento() + "',Tipo_Empleado_idTipoEmpleado=" + nuevoEmpleado.getIdTipoEmpleado() + "Estatus_idEstatus=" +
								nuevoEmpleado.getIdEstatus() + ",Usuario='" + nuevoEmpleado.getUsuario() + "',Clave='" + nuevoEmpleado.getClave() + "'" + 
								"WHERE curp ='" + curp +"';";
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
	
	
        public static ResultSet mostrarTipoEmpleado() throws SQLException{
//			ArrayList<Object> estados = new ArrayList<>();
			Conexion c = new Conexion();
			Connection con = c.getConexion();
			
			String query = "SELECT idTipoEmpleado, empleado FROM tipo_Empleado";
			Statement st = con.createStatement();
			ResultSet rst = st.executeQuery(query);
			return rst;
        }
        
        public static ResultSet mostrarEstatus() throws SQLException{
//			ArrayList<Object> estados = new ArrayList<>();
			Conexion c = new Conexion();
			Connection con = c.getConexion();
			
			String query = "SELECT idEstatus, estatus FROM Estatus";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			return rs;
        }
         
}
