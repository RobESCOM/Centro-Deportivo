/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Registro;

/**
 *
 * @author Roberto
 */
public class ClienteBean {
    private String nombre;
    private String curp;
    private String tipo;
    private String correo;

    public ClienteBean(String nombre, String curp, String tipo, String correo){
        this.nombre = nombre;
        this.curp = curp;
        this.tipo = tipo;
        this.correo = correo;        
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }  
}
