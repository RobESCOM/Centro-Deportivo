package beans;

public class Direccion {
	private String calle;
	private String numInt;
	private int numExt;
	private String colonia;
	private int cp;
	private int estado;
	
	public Direccion(String calle, String numInt, int numExt, String colonia, int cp, int estado) {
		super();
		this.calle = calle;
		this.numInt = numInt;
		this.numExt = numExt;
		this.colonia = colonia;
		this.cp = cp;
		this.estado = estado;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getNumInt() {
		return numInt;
	}
	public void setNumInt(String numInt) {
		this.numInt = numInt;
	}
	public int getNumExt() {
		return numExt;
	}
	public void setNumExt(int numExt) {
		this.numExt = numExt;
	}
	public String getColonia() {
		return colonia;
	}
	public void setColonia(String colonia) {
		this.colonia = colonia;
	}
	public int getCp() {
		return cp;
	}
	public void setCp(int cp) {
		this.cp = cp;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	
}
