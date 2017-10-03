package beans;

/**
 *
 * @author Killer Eagle
 */
public class Sucursal {
    
private int idSucursal;
private String sucursal;
private String fechaInauguracion;
private String fechaCierre;
private int idDireccion;

    public Sucursal(int idSucursal, String sucursal, String fechaInauguracion, String fechaCierre, int idDireccion) {
        this.idSucursal = idSucursal;
        this.sucursal = sucursal;
        this.fechaInauguracion = fechaInauguracion;
        this.fechaCierre = fechaCierre;
        this.idDireccion = idDireccion;
    }

    public Sucursal() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public String getFechaInauguracion() {
        return fechaInauguracion;
    }

    public void setFechaInauguracion(String fechaInauguracion) {
        this.fechaInauguracion = fechaInauguracion;
    }

    public String getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(String fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public int getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(int idDireccion) {
        this.idDireccion = idDireccion;
    }

}
