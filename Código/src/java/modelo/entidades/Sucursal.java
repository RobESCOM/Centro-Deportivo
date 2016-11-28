package modelo.entidades;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author Bad MotherFucker
 */
public class Sucursal {
    private String nombre;
    private String inauguracion;
    private float latitud;
    private float longitud;
    private ArrayList telefonos;
    private ArrayList emails;
    private Direccion direccion;

    public Sucursal() {
        this.nombre = "";
        this.inauguracion = "";
        this.latitud = 0;
        this.longitud = 0;
        this.telefonos = new ArrayList();
        this.emails = new ArrayList();
        this.direccion = new Direccion();
    }
    
    public Sucursal( String nombre, String inauguracion, float latitud, float longitud, ArrayList telefonos, ArrayList emails, Direccion direccion ) {
        this.nombre = nombre;
        this.inauguracion = inauguracion;
        this.latitud = latitud;
        this.longitud = longitud;
        this.telefonos = telefonos;
        this.emails = emails;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getInauguracion() {
        return inauguracion;
    }

    public void setInauguracion(String inauguracion) {
        this.inauguracion = acomodarFecha( inauguracion );
    }

    public float getLatitud() {
        return latitud;
    }

    public void setLatitud(float latitud) {
        this.latitud = latitud;
    }

    public float getLongitud() {
        return longitud;
    }

    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }

    public void addTel( String tel ) {
        this.telefonos.add( tel );
    }
    
    public ArrayList getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(ArrayList telefonos) {
        this.telefonos = telefonos;
    }

    public void addMail( String email ) {
        this.emails.add( email );
    }
    
    public ArrayList getEmails() {
        return emails;
    }

    public void setEmails(ArrayList emails) {
        this.emails = emails;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
    
    public String acomodarFecha( String inauguracion ) {
        String dia, mes, anio;
        StringTokenizer token = new StringTokenizer( inauguracion, "/" );
        
        mes = token.nextToken();
        dia = token.nextToken();
        anio = token.nextToken();
        
        return anio + "-" + mes + "-" + dia;
    }
    
    @Override
    public String toString() {
        return "'" + nombre + "', '" + inauguracion + "', " + latitud + ", " + longitud + ", " + direccion.getId() + ", " + direccion.getIdEstado();
    }
}
