<%@page import="beans.EstadoRepublica"%>
<%@page import="java.sql.*"%>
<%@page import="controlador.DireccionCrud"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dirección</title>
<style type="text/css">
    .label {
        color: #9E9E9E;
        font-weight: bold;
        font-size: 14px;
        font-family: 'Open Sans', sans-serif;
    }
    
    .btn {
        color: #374044;
        font-weight: bold;
        font-size: 14px;
        font-family: 'Open Sans', sans-serif;
    }
    
    .note {
        color: #374044;
        font-size: 12px;
        font-style: italic;
        font-family: 'Open Sans', sans-serif;
    }
    
</style>
</head>
<body style="background-image: url('img/log.png');">
	<div id="main">
		<h1 style="color:#9E9E9E;">Dirección</h1>
			<form action="AltaDireccion" method="post">
				<table>
					<tr>
                                            <td class="label">Calle:*</td>
                                                <td><input type="text" name="calle" placeholder="Calle"></td>
					</tr>
					<tr>
						<td class="label">Núm. exterior:*</td>
                                                <td><input type="text" name="numExt" placeholder="Número exterior"></td>
					</tr>
                                        <tr>
						<td class="label">Núm. Interior:</td>
                                                <td><input type="text" name="numInt" placeholder="Número interior"></td>
					</tr>
					<tr>
						<td class="label">Colonia:*</td>
                                                <td><input type="text" name="colonia" placeholder="Colonia"></td>
					</tr>
					<tr>
						<td class="label">CP:*</td>
                                                <td><input type="text" name="cp" placeholder="Código Postal"></td>
					</tr>
					<tr>
						<td class="label">Estado:*</td> 
							<%
								ResultSet rs = DireccionCrud.mostrarEstados();
							%>
                                                <td>
                                                    <select name="esRep">
								<option>Selecciona el estado de la República</option>
								<% while(rs.next()){  %>
								<option value="<%=rs.getString("idEstadoRepublica")%>" name="estado"><%=rs.getString("nombreEstado") %></option>
								<%
								}
								%>
							</select>
						</td>
					</tr>
                                        <tr>
                                            <td class="note">*Campos obligatorios</td>
                                        </tr>
                                        <tr>
                                            <td></td>
                                            <td><input type="submit" value="Registrar" class="btn"></td>
                                        </tr>
				</table>                    
			</form>
	</div>
</body>
</html>