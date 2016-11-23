/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.CRUD;
import modelo.ConexionMySQL;
import modelo.PropiedadConexion;

/**
 *
 * @author Bad MotherFucker
 */
@WebServlet(name = "Estado", urlPatterns = {"/EstadoMexico"})
public class Estado extends HttpServlet {
    PropiedadConexion prop;
    ConexionMySQL connBD;
    CRUD cruds;
    
    @Override
    public void init() {
        String ruta = getServletContext().getRealPath("/conf/config.properties");
        prop = new PropiedadConexion( ruta );
        connBD = new ConexionMySQL( prop );
        connBD.getConexion();
        cruds = new CRUD( connBD.getConn() );
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String estados = cruds.consultarEstados();
        response.getWriter().write( estados );
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idState = request.getParameter("deleg");
        
        if( idState == null ) {
            processRequest(request, response);
        } else {
            String delegaciones = cruds.consultarDelegaciones(idState);
            response.getWriter().write( delegaciones );
        }
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
