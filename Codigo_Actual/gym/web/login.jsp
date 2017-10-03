
    <div class="middle">
        <div class="testbox">
                <form action="./acceso" method="POST" >
                   
                    <center><h1>Bienvenido</h1></center>
                    <center><label>Ingresa usuario y contraseña válidos.</label></br></br></center>
                      
                    
                    <center><label id="icon" for="name"><i class="icon-user"></i></label>
                    <input type="text" name="user" id="name" placeholder="Usuario"  style="width: 200px;"  required autofocus/></br>
                    <label id="icon" for="name"><i class="icon-shield"></i></label>
                    <input type="password" name="contra" id="name" placeholder="Password" style="width: 200px;" required autofocus/></br>
                    </center></br>


                        <center>
                            <input type="radio" value="0"  name="filtro" required/>
                            <label chec>Gerente</label>
                            <input type="radio" value="1" name="filtro" required/>
                            <label chec>Empleado</label>
                            </br></br>
                        </center>
                        
                    <center>
                    <button  class="button" type="submit" name="send"/>Enviar</button>
                    <button  class="button" onclick="clrLog()">Limpiar</button>
                    </center>
                </form>
            </div>      
    </div>
            
    
    