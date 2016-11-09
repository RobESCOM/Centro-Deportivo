
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
            
            String nombre;
            String tipo;
            String ancho;
            String largo;
            String alto;
            String responsable;
            String descripcion;
        %>
        
        <%
            nombre = request.getParameter("nomArea");
            tipo = request.getParameter("tipoArea");
            ancho = request.getParameter("anchoDim");
            largo = request.getParameter("largoDim");
            alto = request.getParameter("altoDim");
            responsable = request.getParameter("respArea");
            descripcion = request.getParameter("descArea");
            
            try
            {
                // Conexion con bd
                Class.forName("com.mysql.jdbc.Driver");
                Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/gimnasio", "root", "root");
                if (!conexion.isClosed()){

                    Statement st = conexion.createStatement();

                    Statement statement = conexion.createStatement();
                    statement.execute("INSERT INTO area (tipo,nombre,ancho,largo,alto) values('"+tipo+"','"+nombre+"','"+ancho+"','"+largo+"','"+alto+"');");
                    // cierre de la conexion
                    conexion.close();
                    out.println("El adto fue insertado");
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
        <h3><center>El registro fue exitoso</center></h3>
        <a href="index.html"><center>Menu de Inicio</center></a>
    </body>
</html>
