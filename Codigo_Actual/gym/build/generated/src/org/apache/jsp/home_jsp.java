package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import controlador.ConsultaServicio;
import beans.Servicio;
import beans.Empleado;
import controlador.ConsultaEmpleado;
import controlador.ConsultaSocio;
import beans.Socio;
import beans.Sucursal;
import controlador.ConsultaSucursal;
import java.util.ArrayList;
import modelo.Conexion;
import java.io.PrintWriter;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(4);
    _jspx_dependants.add("/meta.jsp");
    _jspx_dependants.add("/header.jsp");
    _jspx_dependants.add("/login.jsp");
    _jspx_dependants.add("/footer.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>  \n");
      out.write("        <title>Home</title>\n");
      out.write("        ");
      out.write("\n");
      out.write("<script type=\"text/javascript\" src=\"js/redirectBtn.js\"></script>\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/cajas.css\">\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/nav.css\">\n");
      out.write("<link href='https://fonts.googleapis.com/css?family=Open+Sans:700,600' rel='stylesheet' type='text/css'>\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600' rel='stylesheet' type='text/css'>\n");
      out.write("<link href=\"//netdna.bootstrapcdn.com/font-awesome/3.1.1/css/font-awesome.css\" rel=\"stylesheet\">\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("<link rel=\"stylesheet\" href=\"css/styles.css\">\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        \n");
      out.write("\n");
      out.write(" \n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("<div class=\"header\">\n");
      out.write("        <h1 >GYM Distributed Database</h1>\n");
      out.write("</div>\n");
      out.write("  \n");
      out.write("    </head>\n");
      out.write("        <body style=\"background-image: url('img/log.png');\">\n");
      out.write("            ");
      out.write("\n");
      out.write("    <div class=\"middle\">\n");
      out.write("        <div class=\"testbox\">\n");
      out.write("                <form action=\"./acceso\" method=\"POST\" >\n");
      out.write("                   \n");
      out.write("                    <center><h1>Bienvenido</h1></center>\n");
      out.write("                    <center><label>Ingresa usuario y contraseña válidos.</label></br></br></center>\n");
      out.write("                      \n");
      out.write("                    \n");
      out.write("                    <center><label id=\"icon\" for=\"name\"><i class=\"icon-user\"></i></label>\n");
      out.write("                    <input type=\"text\" name=\"user\" id=\"name\" placeholder=\"Usuario\"  style=\"width: 200px;\"  required autofocus/></br>\n");
      out.write("                    <label id=\"icon\" for=\"name\"><i class=\"icon-shield\"></i></label>\n");
      out.write("                    <input type=\"password\" name=\"contra\" id=\"name\" placeholder=\"Password\" style=\"width: 200px;\" required autofocus/></br>\n");
      out.write("                    </center></br>\n");
      out.write("\n");
      out.write("\n");
      out.write("                        <center>\n");
      out.write("                            <input type=\"radio\" value=\"0\"  name=\"filtro\" required/>\n");
      out.write("                            <label chec>Gerente</label>\n");
      out.write("                            <input type=\"radio\" value=\"1\" name=\"filtro\" required/>\n");
      out.write("                            <label chec>Empleado</label>\n");
      out.write("                            </br></br>\n");
      out.write("                        </center>\n");
      out.write("                        \n");
      out.write("                    <center>\n");
      out.write("                    <button  class=\"button\" type=\"submit\" name=\"send\"/>Enviar</button>\n");
      out.write("                    <button  class=\"button\" onclick=\"clrLog()\">Limpiar</button>\n");
      out.write("                    </center>\n");
      out.write("                </form>\n");
      out.write("            </div>      \n");
      out.write("    </div>\n");
      out.write("            \n");
      out.write("    \n");
      out.write("    ");
      out.write("\n");
      out.write("        </body>\n");
      out.write("    <footer>\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\" src=\"js/clrForm.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"js/validations.js\"></script>\n");
      out.write("<script src=\"/ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js\" type=\"text/javascript\"></script> \n");
      out.write("<script src=\"http://code.jquery.com/jquery-latest.min.js\" type=\"text/javascript\"></script> \n");
      out.write("        \n");
      out.write("\n");
      out.write("    </footer>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
