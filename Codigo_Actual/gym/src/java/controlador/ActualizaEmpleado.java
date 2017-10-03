package controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Empleado;

/*
 *	Autor: Roberto Mendoza Saavedra
 *
 * */
@WebServlet("/ActualizaEmpleado")
public class ActualizaEmpleado extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ActualizaEmpleado() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}*/

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String curp = request.getParameter("curpAct");
		String nombre = request.getParameter("nombre");
		String apPaterno = request.getParameter("apPat");
		String apMaterno = request.getParameter("apMat");
		String nss = request.getParameter("nss");
		String fechaBaja = request.getParameter("fechaBaja");
		String fechaFinContrato = request.getParameter("fechaFinC");
		String fechaNacimiento = request.getParameter("fechaNac");
		int tipoEmpleado = Integer.parseInt(request.getParameter("tipoEmpleado"));
		int estatus = Integer.parseInt(request.getParameter("estatus"));
		String usuario = request.getParameter("usuario");
		int clave = Integer.parseInt(request.getParameter("clave"));
		
		//if(!curp.equals("") && !nombre.equals("") && !apPaterno.equals("") && !apMaterno.equals("") && !nss.equals("") && !fechaBaja.equals("") 
		//		&& !fechaFinContrato.equals("") && !fechaNacimiento.equals("") && !usuario.equals("") && !clave.equals("")){
			Empleado empleado = new Empleado(curp, nombre, apPaterno, apMaterno, nss, fechaBaja, fechaFinContrato, fechaNacimiento, usuario, tipoEmpleado, estatus, clave);
			boolean registroExitoso = EmpleadoCrud.actualizarEmpleado(empleado, curp);
			if(registroExitoso){
				request.getRequestDispatcher("RegistroExitoso.jsp").forward(request, response);
			}
			else{
				PrintWriter out = response.getWriter();
				out.println("Uuuups!! Algo salio mal, revisa tu informacion");
			}
		
	}

}
