package beans;

/**
 *
 * @author Killer Eagle
 */
public class Socio {
private String curp;
private String nombre;
private String apellidoP;
private String apellidoM;
private String fechaNacimiento;
private int idStatus;
private int idResumenMedico;
private int idDireccion;

    public Socio() {
        this("","","","","",0,0,0);
    }

    public Socio(String curp, String nombre, String apellidoP, String apellidoM, String fechaNacimiento, int idStatus, int idResumenMedico, int idDireccion) {
        this.curp = curp;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.fechaNacimiento = fechaNacimiento;
        this.idStatus = idStatus;
        this.idResumenMedico = idResumenMedico;
        this.idDireccion = idDireccion;
    }

    public Socio(Socio socio){
        this(socio.curp, socio.nombre, socio.apellidoP, socio.apellidoM, socio.fechaNacimiento, socio.idStatus, socio.idResumenMedico, socio.idDireccion);
    
    }

    @Override
    public String toString() {
        return "Socio{" + "curp=" + curp + ", nombre=" + nombre + ", apellidoP=" + apellidoP + ", apellidoM=" + apellidoM + ", fechaNacimiento=" + fechaNacimiento + '}';
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(int idStatus) {
        this.idStatus = idStatus;
    }

    public int getIdResumenMedico() {
        return idResumenMedico;
    }

    public void setIdResumenMedico(int idResumenMedico) {
        this.idResumenMedico = idResumenMedico;
    }

    public int getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(int idDireccion) {
        this.idDireccion = idDireccion;
    }
    
    
    
}
