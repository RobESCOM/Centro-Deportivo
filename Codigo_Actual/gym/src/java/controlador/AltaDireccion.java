package controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Direccion;
/**
 * Autor: Roberto Mendoza Saavedra
 */
@WebServlet("/AltaDireccion")
public class AltaDireccion extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AltaDireccion() {
        super();
    }

	/**
     * @param request
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}*/

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String calle = request.getParameter("calle");
		String numInt = request.getParameter("numInt");
		int numExt = Integer.parseInt(request.getParameter("numExt"));
		String colonia = request.getParameter("colonia");
		int cp = Integer.parseInt(request.getParameter("cp"));
		int estado = Integer.parseInt(request.getParameter("esRep"));
		//int estado = 7;
                        
		//if(!calle.equals("") && !numInt.equals("") && numExt!=0 && !colonia.equals("") && cp!=0 && estado!=0){
			Direccion dir = new Direccion(calle, numInt, numExt, colonia, cp, estado);
			boolean registroExitoso = DireccionCrud.registrarDireccion(dir);
			if(registroExitoso){
				request.getRequestDispatcher("RegistroDirExitoso.jsp").forward(request, response);
			}
			else{
				PrintWriter out = response.getWriter();
				out.println("Uupss!! Algo salio mal. Revisa tu informacion");
			}
		
	}

}
