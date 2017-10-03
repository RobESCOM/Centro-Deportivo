package controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Empleado;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Autor: Roberto Mendoza Saavedra
 */
@WebServlet("/RegistroEmpleado")
public class RegistroEmpleado extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public RegistroEmpleado() {
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
		String curp = request.getParameter("curp");
		String nombre = request.getParameter("nombre");
		String apPaterno = request.getParameter("apPat");
		String apMaterno = request.getParameter("apMat");
		String nss = request.getParameter("nss");
                String fechaIngreso = request.getParameter("fechaIn");
                //String fechaIngreso = "2017/10/01";
		String fechaBaja = request.getParameter("fechaFinC");
		String fechaFinContrato = request.getParameter("fechaFinC");
                //String fechaFinContrato = "2020/10/01";
		String fechaNacimiento = request.getParameter("fechaNac");
                //String fechaNacimiento = "1993/10/04";
		int tipoEmpleado = Integer.parseInt(request.getParameter("tipE"));
		//int tipoEmpleado = 1;
                int direccion = Integer.parseInt(request.getParameter("dir"));
		//int direccion = 211;
                int estatus = Integer.parseInt(request.getParameter("est"));
		//int estatus = 1;
                String usuario = request.getParameter("usuario");
		int clave = Integer.parseInt(request.getParameter("clave"));
		
		          //if (!curp.equals("") && !nombre.equals("") && !apPaterno.equals("") && !apMaterno.equals("") && !nss.equals("") && !fechaIngreso.equals("")
                    //&& !fechaBaja.equals("") && !fechaFinContrato.equals("") && !fechaNacimiento.equals("") && !usuario.equals("") && !clave.equals("")) {
			Empleado empleado = new Empleado(curp, nombre, apPaterno, apMaterno, nss, fechaIngreso, fechaBaja, fechaFinContrato, fechaNacimiento, usuario, 
											tipoEmpleado, direccion, estatus, clave);
			boolean registroExitoso = EmpleadoCrud.agregarEmpleado(empleado);
			if(registroExitoso){
				request.getRequestDispatcher("RegistroExitoso.jsp").forward(request, response);
			}
			else{
				PrintWriter out = response.getWriter();
				out.println("Uuupps!! Algo salio mal, revisa tu informacion");
			}
		//}
	}

}
