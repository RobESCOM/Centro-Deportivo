package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;

/**
 *
 * @author isaac_stark
 */
public class CRUD {
    private ConexionMySQL con;
    private PropiedadConexion pc;
    private Statement sentencia;
    private static int idAdmin = 1;
    
    public CRUD() {
        pc = new PropiedadConexion();
        con = new ConexionMySQL( pc );
        conectar();
    }
    
    public CRUD( Connection con ) {
        this.con = new ConexionMySQL();
        this.con.setConn( con );
    }
    
    private void conectar() {
        con.getConexion();
    }
    
    public ArrayList consultar() {
        String sql = "SELECT * FROM sucursal";
        String row[]; 
        ArrayList rows = new ArrayList();
        
        try {
            sentencia = con.getConn().createStatement();
            ResultSet r = sentencia.executeQuery( sql );
            int n;
            
            while( r.next() ) {
                n = r.getMetaData().getColumnCount();
                row = new String[n];
                
                for( int i = 1; i <= n; i++ ) {
                    row[i - 1] = r.getString( i );
                }
                rows.add( row );
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rows;
    }
    
    public ArrayList consultar( String tabla ) {
        String sql = "SELECT idSUCURSAL, nombre, estado, tel, mail FROM sucursal";
        String row[]; 
        ArrayList rows = new ArrayList();
        
        try {
            sentencia = con.getConn().createStatement();
            ResultSet r = sentencia.executeQuery( sql );
            int n;
            
            while( r.next() ) {
                n = r.getMetaData().getColumnCount();
                row = new String[n];
                
                for( int i = 1; i <= n; i++ ) {
                    row[i - 1] = r.getString( i );
                }
                rows.add( row );
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rows;
    }
    
    public void insertarSuc( String nameSucursal, String calle, String colonia, String deleg, String codep, String estado, String tel , String mail ) {
        String sql = "INSERT INTO sucursal( nombre, calle, colonia, Delegacion, CodePos, estado, tel, mail ) VALUES" +
                        "( '" + nameSucursal + "', '" + calle +"', '" + colonia + "', '" + deleg + "', " + 
                            codep + ", '" + estado + "', '" + tel + "', '" + mail + "' )";
        System.out.println("sql " + sql);
        try {
            sentencia = con.getConn().createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE );
            sentencia.executeUpdate( sql );
            System.out.println("¡¡El registro finalizo con exito!!");
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    public void insertarAdmin( String nameAdmin, String dir ) {
        String sql = "INSERT INTO administrador VALUES( " + idAdmin + ", '" + nameAdmin + "', " + 12 + ", '" + dir + "' )";
        System.out.println("sql " + sql);
        try {
            sentencia = con.getConn().createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE );
            sentencia.executeUpdate( sql );
            System.out.println("¡¡El registro finalizo con exito!!");
            idAdmin++;
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    public boolean eliminar( String id ) {
        String sql = "DELETE FROM sucursal WHERE idSUCURSAL = " + id ;
        
        try {
            sentencia = con.getConn().createStatement();
            sentencia.executeUpdate( sql );
            
            System.out.println("registro eliminado satisfactiamente");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public void update( String name, String price, String desc, int ID ) {
        String sql="";
      
        if(price.equals("")||desc.equals(""))
        {
            sql = " UPDATE platillos SET nombre = '"+name+"' WHERE idPlatillo="+ID;
        }
        else if(name.equals("")||desc.equals("")){
            sql = " UPDATE platillos SET precio = "+price+"WHERE idPlatillo="+ID;
        }
        else if(name.equals("")||price.equals("")){
            sql = " UPDATE platillos SET descripcion = "+desc+"WHERE idPlatillo="+ID; 
        }
        try {
            sentencia = con.getConn().createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE );
            sentencia.executeUpdate( sql );
            System.out.println("¡¡El registro finalizo con exito!!");
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public String getNombreAreas() {
        String sql = "SELECT nombre FROM area";
        String row = ""; 
        
        try {
            sentencia = con.getConn().createStatement();
            ResultSet r = sentencia.executeQuery( sql );
            int n;
            
            while( r.next() ) {
                n = r.getMetaData().getColumnCount();
                
                for( int i = 1; i <= n; i++ ) {
                    row += r.getString( i );
                }
                row += "**";
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return row;
    }
    
    public String getUbicaciones() {
        String sql = "SELECT nombre FROM area";
        String row = ""; 
        
        try {
            sentencia = con.getConn().createStatement();
            ResultSet r = sentencia.executeQuery( sql );
            int n;
            
            while( r.next() ) {
                n = r.getMetaData().getColumnCount();
                
                for( int i = 1; i <= n; i++ ) {
                    row += r.getString( i );
                }
                row += "**";
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return row;
    }
    
    
    /* public static void main( String args[] ) {
        CRUD test = new CRUD();
        
        test.consultar();
        //test.insertar( "Taco", "10.00", "Pastro, suadero, bisteck, longaniza. Con quesillo $5.00 mas" );
    } */
    
}
