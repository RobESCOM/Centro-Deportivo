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
public class Empleado {
    
    private String curp;
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String nss;
    private String fechaIngreso;
    private String fechaBaja;
    private String fechaFinContrato;
    private String fechaNacimiento;
    private String usuario;
    private int idTipoEmpleado;
    private int idDireccion;
    private int idEstatus;
    private int clave;

    @Override
    public String toString() {
        return "Empleado{" + "curp=" + curp + ", nombre=" + nombre + ", apellidoP=" + apellidoP + ", apellidoM=" + apellidoM + ", nss=" + nss + ", fechaIngreso=" + fechaIngreso + ", fechaBaja=" + fechaBaja + ", fechaFinContrato=" + fechaFinContrato + ", fechaNacimiento=" + fechaNacimiento + ", usuario=" + usuario + '}';
    }

    public Empleado() {
    }

    public Empleado(String curp, String nombre, String apellidoP, String apellidoM, String nss, String fechaIngreso, String fechaBaja, String fechaFinContrato, String fechaNacimiento, String usuario, int idTipoEmpleado, int idDireccion, int idEstatus, int clave) {
        this.curp = curp;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.nss = nss;
        this.fechaIngreso = fechaIngreso;
        this.fechaBaja = fechaBaja;
        this.fechaFinContrato = fechaFinContrato;
        this.fechaNacimiento = fechaNacimiento;
        this.usuario = usuario;
        this.idTipoEmpleado = idTipoEmpleado;
        this.idDireccion = idDireccion;
        this.idEstatus = idEstatus;
        this.clave = clave;
    }

    public Empleado(String curp2, String nombre2, String apPaterno, String apMaterno, String nss2, String fechaBaja2,
			String fechaFinContrato2, String fechaNacimiento2, String usuario2, int tipoEmpleado, int estatus,
			int clave2) {
		this.curp = curp2;
		this.nombre = nombre2;
		this.apellidoP = apPaterno;
		this.apellidoM = apMaterno;
		this.nss = nss2;
		this.fechaBaja = fechaBaja2;
		this.fechaFinContrato = fechaFinContrato2;
		this.fechaNacimiento = fechaNacimiento2;
		this.usuario = usuario2;
		this.idTipoEmpleado = tipoEmpleado;
		this.idEstatus = estatus;
		this.clave = clave2;
	}

	public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
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

    public String getNss() {
        return nss;
    }

    public void setNss(String nss) {
        this.nss = nss;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(String fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public String getFechaFinContrato() {
        return fechaFinContrato;
    }

    public void setFechaFinContrato(String fechaFinContrato) {
        this.fechaFinContrato = fechaFinContrato;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getIdTipoEmpleado() {
        return idTipoEmpleado;
    }

    public void setIdTipoEmpleado(int idTipoEmpleado) {
        this.idTipoEmpleado = idTipoEmpleado;
    }

    public int getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(int idDireccion) {
        this.idDireccion = idDireccion;
    }

    public int getIdEstatus() {
        return idEstatus;
    }

    public void setIdEstatus(int idEstatus) {
        this.idEstatus = idEstatus;
    }

    
    
}
