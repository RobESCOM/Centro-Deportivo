function validarLogin(){
        
     if((document.getElementsByName("user") === '')||(document.getElementsByName("contra") === '')){
         alert("Porfavor llene todos los campos! ");
         return false;
     }
     else 
         return true;  
}

  