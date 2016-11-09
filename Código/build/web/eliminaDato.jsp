<%-- 
    Document   : eliminaDato
    Created on : 13-oct-2016, 12:24:03
    Author     : franciscogarcia
--%>
<%@page import = "java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%!
            String nom;
        %>
        
        <%
            nom = request.getParameter("esteCampo");
            
            try
            {
                // Conexion con bd
                Class.forName("com.mysql.jdbc.Driver");
                Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/gimnasio", "root", "root");
                if (!conexion.isClosed()){

                    Statement st = conexion.createStatement();

                    Statement statement = conexion.createStatement();
                    statement.execute("delete from area where nombre = '"+nom+"';");
                    // cierre de la conexion
                    conexion.close();
                    out.println("El dato fue eliminado");
                }
                else
                // Error en la conexion
                out.println("fallo");
            }
            catch (Exception e)
            {
            // Error en algun momento.
            out.println("Excepcion "+e);
            e.printStackTrace();
            }
        %>
    </body>
    <h3><center>El registro se elimino correctamente</center></h3>
    <a href="index.html"><center>Página de inicio</center></a>
</html>
