<%-- 
    Document   : eliminar
    Created on : 13-oct-2016, 11:47:10
    Author     : franciscogarcia
--%>
<%@page import = "java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style type="text/css">
            body{
            text-align:center;
            font-family:verdana, arial, helvetica, sans-serif;
            }

            #formulario{
            border:solid 2px #708090;
            background:#dcdcdc;
            margin:0 auto;
            width:400px;
            padding:15px;
            }
            #formulario h1 {
            font-size:24px;
            font-weight:bold;
            margin-bottom:10px;
            }
            #formulario label{
            display:block;
            font-weight:bold;
            text-align:right;
            width:140px;
            float:left;
            }
            #formulario .detalle{
            color:#666666;
            display:block;
            font-size:11px;
            font-weight:normal;
            text-align:right;
            width:140px;
            }
            #formulario input{
            float:left;
            font-size:12px;
            padding:4px 2px;
            border:solid 1px #708090;
            width:200px;
            margin:2px 0 20px 10px;
            }
            #formulario button{
            clear:both;
            margin:0 auto;
            width:100px;
            height:31px;
            background:#696969;
            text-align:center;
            line-height:31px;
            color:#FFFFFF;
            font-size:11px;
            font-weight:bold;
        </style>
    </head>
    <body>
         <center><h3>Eliminar Áreas</h3></center>
        <div id="formulario">
        <form id="form" name="form" method="post" action="eliminaDato.jsp">

        <label>Nombre Area:</label>
        <select id="esteCampo" name="esteCampo">
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
            rs = s.executeQuery("select nombre from area;");
            rsmd = rs.getMetaData();
            
            while(rs.next()){
                out.println("<option>"+rs.getString(1)+"</option>");
            }
            %>
        </select><br><br>

        <button type="submit">Eliminar</button>
        </form>
    </body>
</html>
