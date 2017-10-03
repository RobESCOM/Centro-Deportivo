<%@page import="beans.EstadoRepublica"%>
<%@page import="java.sql.*"%>
<%@page import="controlador.EmpleadoCrud"%>
<%@page import="controlador.DireccionCrud"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registro empleado</title>
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
		<h1 style="color:#9E9E9E;">Nuevo empleado</h1>
			<form action="RegistroEmpleado" method="post">
				<table>
                                        <tr>
                                            <td><a href="RegistroDireccion.jsp"><input type="button" value="Registra su dirección" class="btn"></a></td>
                                        </tr>
					<tr>
                                            <td class="label">CURP:*</td>
                                            <td><input type="text" name="curp" placeholder="CURP"></td>
					</tr>
					<tr>
						<td class="label">Nombre(s):*</td>
                                                <td><input type="text" name="nombre" placeholder="Nombre(s)"></td>
					</tr>
					<tr>
						<td class="label">Apellido paterno:*</td>
                                                <td><input type="text" name="apPat" placeholder="Apellido paterno"></td>
					</tr>
					<tr>
						<td class="label">Apellido materno:*</td>
                                                <td><input type="text" name="apMat" placeholder="Apellido Materno"></td>
					</tr>
					<tr>
						<td class="label">N.S.S.:*</td>
                                                <td><input type="text" name="nss" placeholder="Número de Seguridad Social"></td>
					</tr>
                                        <tr>
						<td class="label">Fecha de ingreso:*</td>
                                                <td><input type="text" name="fechaIn" placeholder="AAAA/MM/DD"></td>
					</tr>
                                        <tr>
                                            <td class="label">Fecha de baja:</td>
                                            <td><input type="text" name="fechaBaja" placeholder="AAAA/MM/DD" disabled="true"></td>
					</tr>
                                        <tr>
						<td class="label">Fecha de fin de contrato:*</td> 
                                                <td><input type="text" name="fechaFinC" placeholder="Fecha de fin de contrato"></td>
					</tr>
                                        <tr>
						<td class="label">Fecha de nacimiento:*</td>
                                                <td><input type="text" name="fechaNac" placeholder="AAAA/MM/DD"></td>
					</tr>
					<tr>
						<td class="label">Tipo de empleado:* </td>
							<%
								ResultSet rs = EmpleadoCrud.mostrarTipoEmpleado();
							%>
                                                <td>
							<select name="tipE">
								<option>Selecciona el tipo de empleado</option>
								<% while(rs.next()){  %>
								<option value="<%=rs.getString("idTipoEmpleado")%>" name="tipoEmpleado"><%=rs.getString("empleado") %></option>
								<%
								}
								%>
							</select>
						</td>
					</tr>
                                        <tr>
						<td class="label">Estatus:* </td>
							<%
								ResultSet rsEstatus = EmpleadoCrud.mostrarEstatus();
							%>
                                                <td>
							<select name="est">
								<option>Selecciona el estatus</option>
								<% while(rsEstatus.next()){  %>
								<option value="<%=rsEstatus.getString("idEstatus")%>" name="estatus"><%=rsEstatus.getString("estatus") %></option>
								<%
								}
								%>
							</select>
						</td>
					</tr>
                                        <tr>
                                            <%
								ResultSet rsDir = DireccionCrud.obtenerDireccion();
                                            %>
                                            <td>
                                                <% while(rsDir.next()) { %>
                                            <td><input type="radio" name="dir" value="<%=rsDir.getString(1)%>" checked required style="visibility: hidden"></td>

                                                <% 
                                                }
                                                %>
                                            </td>
                                        </tr>
                                        
                                        <tr>
						<td class="label">Nombre de usuario:*</td>
                                                <td><input type="text" name="usuario" placeholder="Máximo 3 caracteres"></td>
					</tr>
                                        <tr>
						<td class="label">Contraseña:*</td>
                                                <td><input type="password" name="clave" placeholder="Cuatro digitos del 1 al 9"></td>
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