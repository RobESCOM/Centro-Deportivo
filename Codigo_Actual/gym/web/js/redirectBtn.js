function quitEmp(){
window.alert('Cerrando Sesion de Empleado');
window.location="home.jsp";
}

function quitGer(){
window.alert('Cerrando Sesion');
location.href = "http://localhost:8080/queriesProyect/home.jsp?";
}

function quitSocio(){
window.alert('Cerrando Sesion de Socio');
window.location="home.jsp";
}

function getPage(match){
    var arr = new Array();
    var ele = document.getElementById('');
    for(var i=0;i<match;i++){
        var newdiv = document.createElement("label");
        newdiv.id = arr[i];
        newdiv.value="Page";
        ele.appendChild(newdiv);
    }
}


