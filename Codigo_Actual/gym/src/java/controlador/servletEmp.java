package controlador;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Martín Carrillo
 */
public class servletEmp extends HttpServlet {

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
        
        String q = request.getParameter("txtSearch");
        int filter = Integer.parseInt(request.getParameter("filtro"));
         boolean buscarId = false;
        if(request.getParameter("buscarId")!=null)
            buscarId = request.getParameter("buscarId").equalsIgnoreCase("checked");
        System.out.println("el valor del filtro es "+ filter);
        response.sendRedirect("body.jsp?option="+filter+"&q="+q+"&buscarId="+buscarId);
        
        switch(filter){
            case 0:
                
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4: 
                break;
            default: 
                
        }
        
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
