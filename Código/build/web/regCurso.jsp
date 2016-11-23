
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
            String costo;
            String fechaInicio;
            String fechaTermino;
            String descripcion;
            String horario;
            
        %>
        
        <%
            nombre = request.getParameter("nameC");
            costo = request.getParameter("costoC");
            fechaInicio = request.getParameter("dateini");
            fechaTerminoc = request.getParameter("datefin");
            descripcion = request.getParameter("descr");
            horario = request.getParameter("horario");
            
            
            try
            {
                // Conexion con bd
                Class.forName("com.mysql.jdbc.Driver");
                Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/gimnasio", "root", "root");
                if (!conexion.isClosed()){

                    Statement st = conexion.createStatement();

                    Statement statement = conexion.createStatement();
                    statement.execute("INSERT INTO Cursos (Nombre,Costo,FechaInicio,FechaTermino,Descripcion,Horario) values('"+nombre+"','"+costo+"','"+fechaInicio+"','"+fechaTermino+"','"+descripcion+"','"+horario+"');");
                    // cierre de la conexion
                    conexion.close();
                    out.println("Curso Almacenado");
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
        <h3><center>Alta de Curso Exitosa</center></h3>
        <a href="homeGteSuc.html"><center>Menu de Gerente</center></a>
    </body>
</html>
