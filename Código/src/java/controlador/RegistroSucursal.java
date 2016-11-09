package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.*;
/**
 *
 * @author Bad MotherFucker
 */
//@WebServlet(name = "RegistroSucursal", urlPatterns = {"/RegSuc"})
public class RegistroSucursal extends HttpServlet {
    PropiedadConexion prop;
    ConexionMySQL connBD;
    CRUD cruds;
    
    @Override
    public void init() {
        String ruta = getServletContext().getRealPath("/conf/config.properties");
        System.out.println("ruta: " + ruta );
        prop = new PropiedadConexion( ruta );
        connBD = new ConexionMySQL( prop );
        connBD.getConexion();
        cruds = new CRUD( connBD.getConn() );
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<script>"
                    + "function iniciar() {demora = setInterval('ajustar()',1000);}"
                    + "function ajustar() { tiempo = new Date(); segundos = tiempo.getSeconds(); indice = segundos % 10;"
                    + " document.getElementById('seg').innerHTML = indice; if( indice%4 == 0  ) { location.href='http://localhost:8080/GYM/tabs.html' } }"
                    + "</script>");
            out.println("<title>Servlet RegistroSucursal</title>");            
            out.println("</head>");
            out.println("<body onload='iniciar();'>");
            out.println("<h1>Servlet RegistroSucursal at " + request.getContextPath() + "</h1>");
            out.println("<h1>¡Su regitro fue exitoso!</h1>");
            out.println("<h1>Esta pagina se redireccionara en:<p id='seg'></p> </h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String codep = request.getParameter("cp");
        String consulta = request.getParameter("consultar");
        String eliminarSuc = request.getParameter("eliminar");
        
        if( consulta == null && codep != null ) {
            String nameSucursal = request.getParameter("nameS");
            String calle = request.getParameter("calle");
            String colonia = request.getParameter("col");
            String deleg = request.getParameter("del");
            String estado = request.getParameter("state");
            String tel = request.getParameter("tels");
            String mail = request.getParameter("email");
            String namAdmin = request.getParameter("adminPila");
            namAdmin += " " + request.getParameter("adminFap");
            namAdmin += " " + request.getParameter("adminSap");
            String dirAdmin = request.getParameter("dirG");
            
            cruds.insertarSuc( nameSucursal, calle, colonia, deleg, codep, estado, tel, mail );
            //cruds.insertarAdmin( namAdmin, dirAdmin ); Pedo con las Foreign key 
            processRequest(request, response);
        } else if( consulta != null && consulta.equals("prueba") ){
            String data = getDatosSucursal();
            response.getWriter().write( data );
        } else if( eliminarSuc != null ) {
            boolean eliminado = cruds.eliminar( eliminarSuc );
            String msg = ( eliminado )? "Registro eliminado":"Error al eliminar";
            response.getWriter().write( msg );
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String area = request.getParameter("areas");
        
        if( area == null )
            doGet( request, response );
        else {
            area = cruds.getNombreAreas();
            response.getWriter().write( area );
        }
        //processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Registra una sucursal";
    }

    private String getDatosSucursal() {
       String datos = "", temp[];
       ArrayList datosSuc = cruds.consultar("");
       int len, size = datosSuc.size();
       
       for( int i = 0; i < size; i++ ) {
           temp = ( String[] ) datosSuc.get(i);
           len = temp.length;
           
           for( int j = 0; j < len; j++ ) {
               datos += temp[j];
               datos += ( j == len - 1 )? "": "__";
           }
           
           datos += ( i == size - 1 )? "": "**";
       }
       
       return datos;
    }
}
