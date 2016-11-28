/* Variables globales para la identificacion de telelfonos y correos */
var contTels = 2;
var contMail = 2;

function verificarCP() {
    cp = document.getElementById("cp").value;
    var regExp = /([a-z]|[A-Z])/g;
    var result = cp.match(regExp);

    if ( result !== null ) {
        alert("Codigo postal no valido"); //mostrarMensaje("#hideCP");
        document.getElementById("cp").value = "";
    } else {
        result = document.getElementById("cp").value;

        if (result.length > 6) {
            alert("Codigo postal no debe ser mayor a 5 digitos");
            document.getElementById("cp").value = "";
        }
    }
}

function verificarTel( id ) {
    var tel;
    
    if (typeof id === "undefined") {
        id = document.getElementById("tel");
        tel = id.value;
    } else {
        tel = id.value;
    }

    var regExp = /([a-z]|[A-Z])/g;
    var result = tel.match( regExp );

    if( result !== null ) {
        alert("Inserte un numero");
        id.value = "";
    } else {
        result = id.value;

        if( result.length <= 15 && result !== "" ) {
            //Numero valido
        } else if (result === "") {
            alert("introduzca un numero telefonico valido");
            id.value = "";
        } else {
            alert("El numero telefonico no debe contener mas de 15 digitos");
            id.value = "";
        }
    }
}

function moreTel() {
    var desicionUser = confirm("Desea aniadir un numero telefonico mas?");

    if (desicionUser) {
        var newTel = document.createElement("input");
        document.getElementById("teles").appendChild(newTel).id = "tel" + contTels;
        document.getElementById("tel" + contTels).setAttribute("type", "text");
        document.getElementById("tel" + contTels).setAttribute("placeholder", "01 800 i wanna be sedated");
        document.getElementById("tel" + contTels).setAttribute("onblur", "verificarTel(this)");
    }
}

function mostrarFecha() {
    document.getElementById("ui-datepicker-div").style.display = "block";
}
//Fucnion original para verificar y aniadir mas telefonos
/* function moreTel( id ) {
 if( typeof id === "undefined" ){
 id = document.getElementById("tel");
 var tel = id.value;
 } else {
 tel = id.value;
 }
 
 var regExp = /([a-z]|[A-Z])/g;
 var result = tel.match(regExp);
 
 if (result !== null) {
 alert("Inserte un numero");
 id.focus();
 } else {
 result = id.value;
 
 if ( result.length <= 15 && result !== "" ) {
 var desicionUser = confirm("Desea aniadir un numero telefonico mas?");
 
 if (desicionUser) {
 var newTel = document.createElement("input");
 document.getElementById("teles").appendChild(newTel).id = "tel" + contTels;
 document.getElementById("tel" + contTels).setAttribute("type", "text");
 document.getElementById("tel" + contTels).setAttribute("placeholder", "01 800 i wanna be sedated");
 document.getElementById("tel" + contTels).focus();
 document.getElementById("tel" + contTels).setAttribute("onblur", "moreTel(this)");
 document.getElementById("tel" + contTels++).focus();
 }
 } else if( result === "" ) {
 alert("introduzca un numero telefonico valido");
 id.focus();
 }else {
 alert("El numero telefonico no debe contener mas de 15 digitos");
 id.focus();
 }
 }
 } */

function moreMail(id) {
    if (typeof id === "undefined") {
        id = document.getElementById("email");
        mail = id.value;
    } else {
        mail = id.value;
    }

    var regExp = /^[a-z]([\w\.]*)@[a-z]([\w\.]*)\.[a-z]{2,3}$/;
    //var result = mail.match( regExp ); //regresa todas las coincidencias
    var mailValido = regExp.test(mail);//si coincide regresa true en caso contrario false

    if (mailValido) {
        var desicionUser = confirm("Desea aniadir otro correo electronico?");

        if (desicionUser) {
            var newTel = document.createElement("input");
            document.getElementById("mails").appendChild(newTel).id = "mails" + contMail;
            document.getElementById("mails" + contMail).setAttribute("type", "email");
            document.getElementById("mails" + contMail).setAttribute("placeholder", "nile@song.com");
            document.getElementById("mails" + contMail++).setAttribute("onblur", "moreMail(this)");
        }
    } else {
        alert("Direccion de correo electronica no valida");
        id.value = "";
    }
}

function mostrarEstado() {
    var x = "needState";
    
    $.ajax({
        type: "post",
        url: "EstadoMexico",
        data: {consultar: x},
        success: function (data) {
            var states = data.split("**");
            var len = states.length;
            var dato;
            var select = document.getElementById("state");
            var option;
            
            for( var i = 0; i < len; i++ ) {
                dato = states[i].split("_");
                option = document.createElement("option");
                option.value = dato[0];
                option.text = dato[1];
                select.add(option);  
            }
            
            select.setAttribute("onchange", "selectMunicipio()");
        }
    });
}

function selectMunicipio() {
    var index = document.getElementById("state").selectedIndex;
    var idState = document.getElementById("state").options[index].value; //Lee el id del estado
    
    $.ajax({
        type: "post",
        url: "EstadoMexico",
        data: {deleg: idState},
        success: function (data) {
            if( data !== "" ) {
                var deleg = data.split("**");
                var len = deleg.length;
                var dato;
                var select = document.getElementById("del");
                var option;
            
                for( var i = 0; i < len; i++ ) {
                    dato = deleg[i].split("_");
                    option = document.createElement("option");
                    option.value = dato[1];
                    option.text = dato[1];
                    select.add(option);  
                }
            } else {
                alert("No se encontro ni madres!!");
            }
        }
    });
}

/* Funcion jquery fundamental añadir jquery para poder usar*/
function mostrarMensaje(IDmensaje) {
    $(function () {
        $(IDmensaje).dialog({
            modal: true,
            buttons: {
                Ok: function () {
                    $(this).dialog("close");
                }
            }
        });
    });
}

function eliminarFila(id) {
    if (confirm("Seguro de querer eliminar la fila?")) {
        id.style.display = "none";
        var x = id.firstChild.firstChild.nodeValue;//=id a eliminar;

        $.ajax({
            type: "post",
            url: "RegSuc",
            data: {eliminar: x},
            success: function (data) {
                alert(data);
            }
        });
    }
}

/* AJAX para conectar con el servidor */
function mostrarDatos(idTab) {
    var mge = "prueba";
    var tabDelete = idTab.getAttribute("href");

    $.ajax({
        type: "post", //metodo a utilizar
        url: "RegSuc", //nombre del servlet en el servidor
        data: {consultar: mge}, //mensaje: correo variable que se recibe en servlet mge contenido que se envia
        success: function (data) {
            if (data !== "") {
                var sucursales = data.split("**");
                var len = sucursales.length;
                var sucData, len2;
                var cabecera = "<tr> <th>ID</th><th>Nombre Sucursal</th><th>Estado</th><th>Telefono</th><th>Mail</th></tr>";

                if (tabDelete === "#tabs-3") {
                    document.getElementById("bajas").innerHTML = cabecera;
                } else {
                    document.getElementById("update").innerHTML = cabecera;
                }


                for (var i = 0; i < len; i++) {
                    sucData = sucursales[i].split("__");
                    len2 = sucData.length;
                    var fila = document.createElement("tr");
                    fila.setAttribute("id", i);
                    if (tabDelete === "#tabs-3") {
                        fila.setAttribute("onclick", "eliminarFila(this)");
                        document.getElementById("bajas").appendChild(fila);
                    } else {
                        document.getElementById("update").appendChild(fila);
                    }

                    for (var j = 0; j < len2; j++) {
                        var col = document.createElement("td");
                        var txt = document.createTextNode(sucData[j]);
                        col.appendChild(txt);
                        document.getElementById(i).appendChild(col);
                    }
                }
            } else {
                alert("No hay datos que mostrar");

            }
        }
    });

    if (tabDelete === "#tabs-2") {
        initMap();
    } else {
        document.getElementById('map').style.display = "none";
        document.getElementById("floating-panel").style.display = "none";
    }
}

function mostrarAreas() {
    var id = document.getElementById("areas");
    var mge = "areas";

    $.ajax({
        type: "post", //metodo a utilizar
        url: "RegSuc", //nombre del servlet en el servidor
        data: {areas: mge}, //mensaje: correo variable que se recibe en servlet mge contenido que se envia
        success: function (data) {
            if (data !== "") {
                var areas = data.split("**");
                var len = areas.length;
                id.innerHTML = "<summary>¿Con que áreas cuanta la sucursal?</summary>";

                /*<div class="6u 12u$(small)">
                 <input type="checkbox" id="demo-copy" name="demo-copy">
                 <label for="demo-copy">Email me a copy</label>
                 </div> */
                var div = document.createElement("div");
                div.setAttribute("class", "12u$(small)");

                for (var i = 0; i < len - 1; i++) {
                    var etiqueta = document.createElement("label");
                    var text = document.createTextNode(areas[i]);
                    etiqueta.appendChild(text);
                    etiqueta.setAttribute("for", areas[i]);

                    var input = document.createElement("input");
                    input.setAttribute("type", "checkbox");
                    input.setAttribute("id", areas[i]);
                    input.setAttribute("name", "areasSuc");

                    div.appendChild(input);
                    div.appendChild(etiqueta);
                }
                id.appendChild(div);
            } else {
                alert("No hay datos que mostrar");

            }
        }
    });
}

function ocultar() {
    document.getElementById('map').style.display = "none";
    document.getElementById("floating-panel").style.display = "none";
    document.getElementById("ui-datepicker-div").style.display = "none";
}

/*Funciones js para mapa*/
/*function initMap() {
 var uluru = {lat: 19.50477246893206, lng: -99.14681971429444};
 document.getElementById('map').style.display = "block";
 
 var map = new google.maps.Map(document.getElementById('map'), {
 zoom: 17,
 center: uluru
 });
 
 var marker = new google.maps.Marker({
 position: uluru,
 icon: 'images/pesas.png',
 map: map
 });
 } */

/*      var marker = new google.maps.Marker({
 position : latlon,
 icon : 'images/beer.png',
 map : map,
 title : "Estas aquí!"
 });
 
 marker.addListener('click', function() {
 infowindow.open(map, marker);
 });
 
 var contentString = "<h2 style='color:#1EC9E4;'> La incidencia ocurrio Aqui</h2><ol style='color:#1EC9E4;'> "
 + "<li>Fecha " + date + "</li>" 
 + "<li>Hora: " + time + "</li></ol>";
 
 var infowindow = new google.maps.InfoWindow({
 content : contentString
 }); */

/* Mapa chingon */
function initMap() {
    document.getElementById('map').style.display = "block";
    document.getElementById("floating-panel").style.display = "block";
    var directionsService = new google.maps.DirectionsService;
    var directionsDisplay = new google.maps.DirectionsRenderer;
    var map = new google.maps.Map(document.getElementById('map'), {
        zoom: 7,
        center: {lat: 19.50477246893206, lng: -99.14681971429444}
    });
    directionsDisplay.setMap(map);

    var onChangeHandler = function () {
        calculateAndDisplayRoute(directionsService, directionsDisplay);
    };
    document.getElementById('inicio').addEventListener('change', onChangeHandler);
    document.getElementById('fin').addEventListener('change', onChangeHandler);
}

function calculateAndDisplayRoute(directionsService, directionsDisplay) {
    directionsService.route({
        origin: document.getElementById('inicio').value,
        destination: document.getElementById('fin').value,
        travelMode: 'DRIVING'
    }, function (response, status) {
        if (status === 'OK') {
            directionsDisplay.setDirections(response);
        } else {
            window.alert('Lugar no encontrado ' + status);
        }
    });
}

function mostrarUbicacion() {
    var mapOptions = {
        zoom: 16,
        center: {lat: 19.5045672, lng: -99.1469098}
    };
    var chicago = {lat: 19.5045672, lng: -99.1469098};
    var map = new google.maps.Map(document.getElementById('map'), mapOptions);
    var centerControlDiv = document.createElement('div');
    var centerControl = new CenterControl(centerControlDiv, map, chicago);

    centerControlDiv.index = 1;
    centerControlDiv.style['padding-top'] = '10px';
    map.controls[google.maps.ControlPosition.TOP_CENTER].push(centerControlDiv);
    
    getUbicacionEstado_Sucursal();
}

function CenterControl(controlDiv, map, center) {
    // We set up a variable for this since we're adding event listeners later.
    var control = this;

    // Set the center property upon construction
    control.center_ = center;
    controlDiv.style.clear = 'both';

    // Set CSS for the control border
    var goCenterUI = document.createElement('div');
    goCenterUI.id = 'goCenterUI';
    goCenterUI.title = 'Selecciona un estado';
    controlDiv.appendChild(goCenterUI);

    var goCenterText = document.createElement('select');
    goCenterText.id = 'goCenterText';
    var optionState = document.createElement('option');
    optionState.setAttribute("value", 'Aguascalientes');
    var text = document.createTextNode("Aguascalientes");
    optionState.appendChild(text);
    goCenterText.appendChild(optionState);
    goCenterUI.appendChild(goCenterText);

    // Set CSS for the setCenter control border
    var setCenterUI = document.createElement('div');
    setCenterUI.id = 'setCenterUI';
    setCenterUI.title = 'Selecciona tu sucursal';
    controlDiv.appendChild(setCenterUI);

    var setCenterText = document.createElement('select');
    setCenterText.id = 'setCenterText';
    var optionSuc = document.createElement('option');
    optionSuc.setAttribute("value", "Kilamangiro");
    var nameSuc = document.createTextNode("Kilamangiro");
    optionSuc.appendChild(nameSuc);
    setCenterText.appendChild(optionSuc);
    setCenterUI.appendChild(setCenterText);

    // Set up the click event listener for 'Center Map': Set the center of the map
    // to the current center of the control.
    goCenterUI.addEventListener('click', function () {
        var currentCenter = control.getCenter();
        map.setCenter(currentCenter);
    });

    // Set up the click event listener for 'Set Center': Set the center of the
    // control to the current center of the map.
    setCenterUI.addEventListener('click', function () {
        var newCenter = map.getCenter();
        control.setCenter(newCenter);
    });
}

/**
 * Define a property to hold the center state.
 * @private
 */
CenterControl.prototype.center_ = null;

/**
 * Gets the map center.
 * @return {?google.maps.LatLng}
 */
CenterControl.prototype.getCenter = function () {
    return this.center_;
};

/**
 * Sets the map center.
 * @param {?google.maps.LatLng} center
 */
CenterControl.prototype.setCenter = function (center) {
    this.center_ = center;
};

function getUbicacionEstado_Sucursal() {
    var mge = "Sucursales";
    
    $.ajax( {
        type: "post", //metodo a utilizar
        url: "UbicacionSucursal", //nombre del servlet en el servidor
        data: { getUbicacion: mge }, //mensaje: correo variable que se recibe en servlet mge contenido que se envia
        success: function (data) {
            alert( data );
        }
    });
}






