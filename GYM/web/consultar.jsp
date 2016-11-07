<%-- 
    Document   : consultar
    Created on : 13-oct-2016, 10:39:17
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
            Connection c;
            Statement s;
            ResultSet rs;
            ResultSetMetaData rsmd;
        %>
        
        <%
            String driver = "com.mysql.jdbc.Driver";
            //se carga el driver de la base de datos
            Class.forName(driver);
            //URL JDBC para la base de datos de la aplicacion
            String url = "jdbc:mysql://localhost:3306/gimnasio";
            //se crea la conexion con la BD
            c = DriverManager.getConnection(url, "root", "root");
            //se crea la sentencia para ejecutar algun sql
            s = c.createStatement();
            rs = s.executeQuery("select nombre,tipo,largo,ancho,alto from area;");
            rsmd = rs.getMetaData();
        %>
    <center><h3>Areas Disponibles</h3></center>
    <center><table border="1" cellpadding="0" cellspacing="0" width="50%">
        <tr>
                <%for (int i=1; i<=rsmd.getColumnCount(); i++){%>
                <th> <%= rsmd.getColumnLabel(i) %>  </th>
                <%}%>
        </tr>
        <%while (rs.next()) {%>
            <tr>
                 <%for (int i=1; i<=rsmd.getColumnCount(); i++){%>
                 <td> <center> <%= rs.getString(i) %> </center> </td>
                <%}%>
            </tr>
            <%}%>
    </table></center><br><br><br><br>
    <center><a href="index.html">Regresar al menu</a></center> 
    </body>
</html>
