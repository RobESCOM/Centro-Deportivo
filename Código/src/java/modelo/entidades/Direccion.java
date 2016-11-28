package modelo.entidades;

/**
 *
 * @author Bad MotherFucker
 */
public class Direccion {
    private String calle;
    private String colonia;
    private int numExt;
    private String municipio;
    private int codigoPostal;
    private int numInt;
    private int idEstado;
    private int id;
    
    public Direccion() {
        calle = colonia = municipio = "";
        numExt = codigoPostal = numInt = idEstado = 0;
    }
    
    public Direccion( String calle, String colonia, String municipio, int numExt, int codigoPostal, int numInt, int idEstado ) {
        this.calle = calle;
        this.colonia = colonia;
        this.municipio = municipio;
        this.numExt = numExt;
        this.codigoPostal = codigoPostal;
        this.numInt = numInt;
        this.idEstado = idEstado;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public int getNumExt() {
        return numExt;
    }

    public void setNumExt(int numExt) {
        this.numExt = numExt;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public int getNumInt() {
        return numInt;
    }

    public void setNumInt(int numInt) {
        this.numInt = numInt;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return " '" + calle + "', '" + colonia + "', " + numExt + ", '" + municipio + "', " + codigoPostal + ", " + numInt + ", " + idEstado;
    }    
}
