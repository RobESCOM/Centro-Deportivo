/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author Killer Eagle
 */
public class Servicio {

    private int idServicio;
    private int idEstatus;
    private int idUbicacion;
    private String nombreServicio;
    private String descripcion;

    public Servicio() {
    }
    
    
    public Servicio(int idServicio, int idEstatus, int idUbicacion, String nombreServicio, String descripcion) {
        this.idServicio = idServicio;
        this.idEstatus = idEstatus;
        this.idUbicacion = idUbicacion;
        this.nombreServicio = nombreServicio;
        this.descripcion = descripcion;
    }
    
    

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public int getIdEstatus() {
        return idEstatus;
    }

    public void setIdEstatus(int idEstatus) {
        this.idEstatus = idEstatus;
    }

    public int getIdUbicacion() {
        return idUbicacion;
    }

    public void setIdUbicacion(int idUbicacion) {
        this.idUbicacion = idUbicacion;
    }


    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
}
