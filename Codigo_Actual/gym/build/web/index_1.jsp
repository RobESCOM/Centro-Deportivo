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
<html>
    <head>  
        <title>Perfil</title>
    </head>
    <body>
<div class="middle">
    
       
            <label style="color: #9E9E9E;"> Sesión Gerente</label> 
        <form id="consulta" action="./servletConsultas" method="POST">
            <input type="search" name="txtSearch" style="width: 200px;"/>            
            <input type="submit" name="send" value="Consultar"/>
            <a href="RegistroEmpleado.jsp"><input type="button" value="Registrar empleado"></a>
            <br>
            <input type="checkbox" name="buscarId" value="checked"><label style="color: #9E9E9E;">Buscar por ID (Primary Key)</label>
            <br><br>
            <table>
                <tr>
                    <td id="filtro" style="color: #9E9E9E;"><input style="color: #9E9E9E;" type="radio" name="filtro" value="0" <%if(option==0){%>checked<%}%> required>Sucursal</td>
                </tr>
                <tr>
                    <td id="filtro" style="color: #9E9E9E;"><input style="color: #9E9E9E;" type="radio" name="filtro" value="2" <%if(option==2){%>checked<%}%> >Servicio</td>
                </tr>
                <tr>
                    <td id="filtro" style="color: #9E9E9E;"><input style="color: #9E9E9E;" type="radio" name="filtro" value="3" <%if(option==3){%>checked<%}%> >Socio</td>
                </tr>
                <tr>
                    <td id="filtro" style="color: #9E9E9E;"><input style="color: #9E9E9E;" type="radio" name="filtro" value="4" <%if(option==4){%>checked<%}%> >Empleado</td>
                </tr>
            </table>
                <a href="home.jsp"><button  class="btn2" onclick="quitGer();" style="width: 100px;">Salir</button></a>
        </form> 
                
        <%
            ArrayList<String> campos = new ArrayList<String>();
            ArrayList<Object> resultado = new ArrayList<Object>();
            String q = request.getParameter("q");
            if(option>=0){
        %>
        <%
            switch(option){
                case 0:
                    title="Sucursal";
                    campos.clear();
                    campos.add("idSucursal");
                    campos.add("Sucursal");
                    campos.add("Fecha de Inauguracion");
                    campos.add("Fecha de Cierre");
                    campos.add("idDireccion");
                    
                    if(q!=null){
                        ConsultaSucursal cs = new ConsultaSucursal();
                        if(!buscarId) resultado = cs.consultaNombre(q);
                        else resultado = cs.consultaId(q);
                    } 
                    
                break;

                case 1:
                    title="Membresia";
                    campos.clear();
                    campos.add("idMembresia");
                    campos.add("Costo");
                    campos.add("idEstatus");                    
                break;

                case 2:
                    title="Servicio";
                    campos.clear();
                    campos.add("idServicio");
                    campos.add("Nombre");
                    campos.add("Descripcion");   
                    campos.add("idEstatus");   
                    campos.add("idUbicacion");  
                    if(q!=null){
                        ConsultaServicio cs = new ConsultaServicio();
                        if(!buscarId) resultado = cs.consultaNombre(q);
                        else resultado = cs.consultaId(q);
                    }                     
                break;

                case 3:
                    title="Socio";
                    campos.clear();
                    campos.add("CURP");
                    campos.add("Nombre");
                    campos.add("Apellido Paterno");                       
                    campos.add("Apellido Materno");                       
                    campos.add("Fecha de Nacimiento");                       
                    campos.add("idEstatus");                       
                    campos.add("idResumenMedico");                       
                    campos.add("idDireccion");
                    
                    if(q!=null){
                        ConsultaSocio cs = new ConsultaSocio();
                        if(!buscarId) resultado = cs.consultaNombre(q);
                        else resultado = cs.consultaId(q);
                    }
                    
                break;

                case 4:
                    title="Empleado";
                    campos.clear();
                    campos.add("CURP");
                    campos.add("Nombre");
                    campos.add("Apellido Paterno");                       
                    campos.add("Apellido Materno");
                    campos.add("NSS");
                    campos.add("Fecha de Ingreso");                       
                    campos.add("Fecha de Baja");                       
                    campos.add("Fin de Contrato");                       
                    campos.add("Fecha de Nac.");    
                    campos.add("Usuario");
                    campos.add("idTipoEmpleado");                       
                    campos.add("idDireccion");                       
                    campos.add("idEstatus");
                    //campos.add("Clave");
                    
                    if(q!=null){
                        ConsultaEmpleado ce = new ConsultaEmpleado();
                        if(!buscarId) resultado = ce.consultaNombre(q);
                        else resultado = ce.consultaId(q);
                    }                     
                    
                    break;
            }
        }
        %>
        <br>
        <hr/>
        <table style="border-color: black; width: 100%; padding: 5px; background-color: graytext;"  >
            <tr>
                <th style="font-size: 22px; align-content: center; vertical-align: central; color:blue; " colspan="<%=campos.size()%>"><!--Titulo de Tabla--><%=title%></th>
            </tr>
            <tr>
                <%
                
                for(int i=0; i<campos.size(); i++){
                    %>
                    <th><%=campos.get(i)%></th>
                    <%
                }
                

                %>
            </tr>
            <!--<tr>-->
                <%
                    //ArrayList<Sucursal> resultado = new ArrayList<Sucursal>();
                    
                    if(q!=null){
                    for(int i=0; i<resultado.size();i++){
                        switch(option){
                            case 0:
                                ConsultaSucursal consulta = new ConsultaSucursal();
                                Sucursal sucursal = (Sucursal) resultado.get(i);
                %>
                    <tr>
                    <td><%= sucursal.getIdSucursal() %></td>
                    <td><%= sucursal.getSucursal() %></td>
                    <td><%= sucursal.getFechaInauguracion() %></td>
                    <td><%= sucursal.getFechaCierre() %></td>
                    <td><%= sucursal.getIdDireccion() %></td>
                    <td><a href="#">Actualizar</a></td>
                    <td><a href="#">Eliminar</a></td>
                    </tr>
                <%                               
                                break;
                            case 1:
                                break;
                            case 2:
                                Servicio servicio = (Servicio) resultado.get(i);

                %>
                    <tr>
                    <td><%= servicio.getIdServicio() %></td>
                    <td><%= servicio.getNombreServicio()%></td>
                    <td><%= servicio.getDescripcion()%></td>
                    <td><%= servicio.getIdEstatus()%></td>
                    <td><%= servicio.getIdUbicacion()%></td>
                    <td><a href="#">Actualizar</a></td>
                    <td><a href="#">Eliminar</a></td>
                    </tr>
                <%                                                             
                                break;
                            case 3:
                                ConsultaSocio consulta1 = new ConsultaSocio();                          
                                Socio socio = (Socio) resultado.get(i);
                %>
                    <tr>
                    <td><%= socio.getCurp() %></td>
                    <td><%= socio.getNombre() %></td>
                    <td><%= socio.getApellidoP() %></td>
                    <td><%= socio.getApellidoM() %></td>
                    <td><%= socio.getFechaNacimiento() %></td>
                    <td><%= socio.getIdStatus() %></td>
                    <td><%= socio.getIdResumenMedico() %></td>
                    <td><%= socio.getIdDireccion() %></td>
                    <td><a href="#">Actualizar</a></td>
                    <td><a href="#">Eliminar</a></td>
                    </tr>
                <%                                
                                break;
                            
                            case 4:
                                //ConsultaEmpleado consulta2 = new ConsultaEmpleado();                          
                                Empleado empleado = (Empleado) resultado.get(i);

                %>
                    <tr>
                    <td><%= empleado.getCurp() %></td>
                    <td><%= empleado.getNombre() %></td>
                    <td><%= empleado.getApellidoP() %></td>
                    <td><%= empleado.getApellidoM() %></td>
                    <td><%= empleado.getNss()%></td>
                    <td><%= empleado.getFechaIngreso()%></td>
                    <td><%= empleado.getFechaBaja() %></td>
                    <td><%= empleado.getFechaFinContrato() %></td>
                    <td><%= empleado.getFechaNacimiento() %></td>
                    <td><%= empleado.getUsuario()%></td>
                    <td><%= empleado.getIdTipoEmpleado()%></td>
                    <td><%= empleado.getIdDireccion()%></td>
                    <td><%= empleado.getIdEstatus() %></td>
                    <td><a href="#">Actualizar</a></td>
                    <td><a href="#">Eliminar</a></td>
                    </tr>
                <%                                 
                                break;
                        }

                    }
                    resultado.clear();
                }

                %>
        </table>
        
          </div>
        </body>
</html>
