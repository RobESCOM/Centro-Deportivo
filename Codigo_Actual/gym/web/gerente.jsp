<%-- 
    Document   : gerente
    Created on : 1/10/2017, 01:22:40 AM
    Author     : martin
--%>

<div class="middle">
    
        <div class="panelL"> 
            </br>
            <center>
                <label > Sesión Empleado</label>  
                <input type="search" style="width: 80%" name="txtSearch" placeholder="Buscar"/>
             </center>
            <div class="pbtn">
                <form id="consulta" action="./servletGer" method="POST">
                 
                    <table>
                <tr>
                    <input type="checkbox" name="buscarId" value="checked">ID<br />
                </tr> 
                <tr>
                    <td id="filtro"><input type="radio" name="filtro" value="0" <%if(option==0){%>checked<%}%> required>Sucursal</td>
                </tr>
                <tr>
                    <td id="filtro"><input type="radio" name="filtro" value="1" <%if(option==1){%>checked<%}%> >Membresia</td>
                </tr>
                <tr>
                    <td id="filtro"><input type="radio" name="filtro" value="2" <%if(option==2){%>checked<%}%> >Servicio</td>
                </tr>
                <tr>
                    <td id="filtro"><input type="radio" name="filtro" value="3" <%if(option==3){%>checked<%}%> >Socio</td>
                </tr>
                <tr>
                    <td id="filtro"><input type="radio" name="filtro" value="4" <%if(option==4){%>checked<%}%> >Empleado</td>
                </tr>
            </table>                    
                        <input class="btn1"  type="submit" name="send"  style="top:  85%"/>
                        <input class="btn2" onclick="quitGer();" style="top:  90%"/>
                </form>
                        
            </div>
        <br>
        <hr/>
        </div> 
                        
        <div class="panelR" style="overflow-x:auto; overflow-y: auto; " >
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
            <table style="border-color: black; width: 100%;  font-size: 11px;"  >
            <tr>
                <th style="font-size: 22px; align-content: center; vertical-align: central; background-color: #ebebeb; " colspan="<%=campos.size()%>"><!--Titulo de Tabla--><%=title%></th>
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
    </div>
