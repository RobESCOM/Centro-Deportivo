package modelo;
/**
 *
 * @author Killer Eagle
 */

public interface IConexion {
    public String[] DRIVER = {"sun.jdbc.odbc.JdbcOdbcDriver",
                              "com.mysql.jdbc.Driver", 
                              "com.sqlmagic.tinysql.dbfFileDriver",
                              "oracle.jdbc.OracleDriver"};
    
    public String[] URL_DRIVER = {"jdbc:odbc:",
                                  "jdbc:mysql://localhost:3306/",
                                  "jdbc:dbfFile:",
                                  "jdbc:oracle:thn@localhost(ip)"};
}
