package modelo;

/**
 *
 * @author isaac_stark
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionMySQL {

    private Connection conn;
    private String driverName, url, usuario, password;
    private Statement sentenciaSQL;

    public ConexionMySQL() {
        driverName = url = usuario = password = "";
        sentenciaSQL = null;
    }

    public ConexionMySQL( String driverName, String url, String usuario, String password ) {
        this.driverName = driverName;
        this.url = url;
        this.usuario = usuario;
        this.password = password;
        sentenciaSQL = null;
    }

    public ConexionMySQL( PropiedadConexion pc ) {
        this(pc.getDriverName(), pc.getUrl(), pc.getUsuario(), pc.getPassword());
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn( Connection conn ) {
        this.conn = conn;
    }

    public void getConexion() {
        try {
            Class.forName(driverName);
            this.conn = DriverManager.getConnection( url, usuario, password );

            if (conn == null) {
                System.out.println("Conexion NO establecida");
            } else {
                System.out.println("La conexion se realizo correctamente");
            }
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void cerrarConexion() {
        if (sentenciaSQL != null) {
            try {
                sentenciaSQL.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("La conexion fue cerrada satisfactoriamente");
    }

    public static void main(String[] args) {
        PropiedadConexion prop = new PropiedadConexion();
        ConexionMySQL mysql = new ConexionMySQL(prop);

        mysql.getConexion();
    }
}
