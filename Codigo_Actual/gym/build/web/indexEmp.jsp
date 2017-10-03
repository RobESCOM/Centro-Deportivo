<%-- 
    Document   : home
    Created on : 24/09/2017, 11:04:54 PM
    Author     : martin
--%>

<%@page import="controlador.ConsultaServicio"%>
<%@page import="beans.Servicio"%>
<%@page import="beans.Empleado"%>
<%@page import="controlador.ConsultaEmpleado"%>
<%@page import="controlador.ConsultaSocio"%>
<%@page import="beans.Socio"%>
<%@page import="beans.Sucursal"%>
<%@page import="controlador.ConsultaSucursal"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Conexion"%>
<%@page import="java.io.PrintWriter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    int option=-1;
    boolean buscarId=false;
    String title="Búsqueda";
    if(request.getParameter("option")!=null)
        option = Integer.parseInt(request.getParameter("option"));
    if(request.getParameter("buscarId")!=null)
        buscarId = request.getParameter("buscarId").equalsIgnoreCase("true");
%>
<!DOCTYPE html>

<html>
    <head>  
        <title>Index Gerente</title>
        <%@ include file="meta.jsp" %> 
        <%@ include file="header.jsp" %>  
    </head>
        <body style="background-image: url('img/index.png');">
        <%@ include file="empleado.jsp" %>
        </body>
    <footer>
        
    </footer>
        <%@ include file="footer.jsp" %>
</html>
