package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Martin Carrillo
 */
public class acceso extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //response.setContentType("text/html;charset=UTF-8");
        
        //try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            /*out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet servletConsultas</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet servletConsultas at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }*/
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);           
        String user = (String)request.getParameter("user");
        String pass = (String)request.getParameter("contra");
        int filter = Integer.parseInt(request.getParameter("filtro"));
        
            if(filter == 0){
                if(user!=null && pass!= null){
                    ConsultaEmpleado emp = new ConsultaEmpleado();
                    int resp = emp.consultaAcceso(user,pass);
                    if( resp == 1)                                                             // Empleado Comun > 1
                        response.sendRedirect("http://localhost:8080/queriesProyect/indexGer.jsp?");
                    else 
                        response.sendRedirect("http://localhost:8080/queriesProyect/home.jsp?");  //no es un empleado
                }
            }
                else if(filter == 1){
                    if(user!=null && pass!= null){
                        ConsultaEmpleado emp = new ConsultaEmpleado();
                        int resp = emp.consultaAcceso(user,pass);
                        if( resp > 1)                                                             // Empleado Comun > 1
                            response.sendRedirect("http://localhost:8080/queriesProyect/indexEmp.jsp?");
                        else 
                            response.sendRedirect("http://localhost:8080/queriesProyect/home.jsp?");  //no es un empleado
                    }
                }
            else
                response.sendRedirect("http://localhost:8080/queriesProyect/home.jsp?");               //Opcion no valida
            
    }
}
    