package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import modelo.entidades.Direccion;
import modelo.entidades.Sucursal;

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
        String sql = "SELECT idSucursal, nombre, idEstado FROM sucursal";
        String row[]; 
        ArrayList rows = new ArrayList();
        
        try {
            sentencia = con.getConn().createStatement();
            ResultSet r = sentencia.executeQuery( sql );
            int n;
            
            while( r.next() ) {
                n = r.getMetaData().getColumnCount();
                row = new String[n + 2];
                
                for( int i = 1; i <= n; i++ ) {
                    row[i - 1] = r.getString( i );
                }
                
                System.out.println("sql " + sql );
                r = sentencia.executeQuery( sql );
                if( r.next() ) {
                    row[2] = r.getString( 1 );
                }
                
                sql = "SELECT numero FROM telefonos as t, sucursal_has_telefonos as st, sucursal as s WHERE " +
                        "st.idSucursal = " + row[0] + " AND t.idTel = st.idTel";
                System.out.println("sql " + sql );
                r = sentencia.executeQuery( sql );
                if( r.next() ) {
                    row[3] = r.getString( 1 );
                }
                
                sql = "SELECT email FROM emails as e, sucursal_has_emails as se, sucursal as s WHERE " +
                        "se.Sucursal_idSucursal = " + row[0] + " AND e.idMail = se.Emails_idMail";
                System.out.println("sql " + sql );
                r = sentencia.executeQuery( sql );
                if( r.next() ) {
                    row[4] = r.getString( 1 );
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
    
    public void insertarSuc( Sucursal suc ) {
        String sql = "INSERT INTO sucursal( Nombre, Inauguracion, Latitud, Longitud, idDireccion, idEstado ) VALUES" +
                        "( " + suc.toString() + " )";
        System.out.println("sql " + sql);
        
        try {
            sentencia = con.getConn().createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE );
            sentencia.executeUpdate( sql );
            System.out.println("¡¡El registro finalizo con exito!!");
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    public void insertarDir( Direccion dir ) {
        String sql = "INSERT INTO direccion( Calle, Colonia, numExt, Deleg_mun, CodePostal, numInt, Estado_idEstado ) VALUES" +
                        "( " + dir.toString() + " )";
        System.out.println("sql " + sql);
        
        try {
            sentencia = con.getConn().createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE );
            sentencia.executeUpdate( sql );
            System.out.println("¡¡El registro finalizo con exito!!");
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    public int getIdDireccion( String calle ) {
        String sql = "SELECT idDireccion FROM direccion WHERE Calle = " + "'" + calle + "'";
        int id = -1;
        
        try {
            sentencia = con.getConn().createStatement();
            ResultSet r = sentencia.executeQuery( sql );
            
            while( r.next() ) {
                id = Integer.parseInt( r.getString( 1 ) );
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return id;
    }
    
    public void insertarTel( ArrayList tel ) {
        String sql;
        
        try {
            sentencia = con.getConn().createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE );
            
            for( int i = 0; i < tel.size(); i++ ) {
                sql = "INSERT INTO telefonos( Numero ) VALUES( '" + tel.get(i) + "' )";
                sentencia.executeUpdate( sql );
            }
            
            System.out.println("¡¡El registro finalizo con exito!!");
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void insertarMail( ArrayList mail ) {
        String sql;
        
        try {
            sentencia = con.getConn().createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE );
            
            for( int i = 0; i < mail.size(); i++ ) {
                sql = "INSERT INTO emails( email ) VALUES( '" + mail.get(i) + "' )";
                sentencia.executeUpdate( sql );
            }
            
            System.out.println("¡¡El registro finalizo con exito!!");
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void insertarSuc_has_Tel( String name, ArrayList tel ) {
        String sql;
        int idSuc = getIdSuc( name );
        
        try {
            sentencia = con.getConn().createStatement();
            
            for( int i = 0; i < tel.size(); i++ ) {
                sql = "INSERT INTO sucursal_has_telefonos VALUES( " + idSuc + ", " + getIdTel( (String)tel.get(i) ) + ")";
                sentencia.executeUpdate(sql);
            }
            
        } catch( SQLException e ) {
            Logger.getLogger( CRUD.class.getName() ).log( Level.SEVERE, null, e );
        }
    }
    
    public int getIdTel( String num ) {
        String sql = "SELECT idTel FROM telefonos WHERE numero = '" + num + "'";
        int id = -1;
        
        try {
            sentencia = con.getConn().createStatement();
            ResultSet r = sentencia.executeQuery( sql );
            
            while( r.next() ) {
                id = Integer.parseInt( r.getString( 1 ) );
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return id;
    }
    
    public void insertarSuc_has_Mail( String name, ArrayList mail ) {
        String sql;
        int idSuc = getIdSuc( name );
        
        try {
            sentencia = con.getConn().createStatement();
            
            for( int i = 0; i < mail.size(); i++ ) {
                sql = "INSERT INTO sucursal_has_emails VALUES( " + idSuc + ", " + getIdMail( (String)mail.get(i) ) + ")";
                sentencia.executeUpdate(sql);
            }
            
        } catch( SQLException e ) {
            Logger.getLogger( CRUD.class.getName() ).log( Level.SEVERE, null, e );
        }
    }
    
    public int getIdMail( String mail ) {
        String sql = "SELECT idMail FROM emails WHERE email = '" + mail + "'";
        int id = -1;
        
        try {
            sentencia = con.getConn().createStatement();
            ResultSet r = sentencia.executeQuery( sql );
            
            while( r.next() ) {
                id = Integer.parseInt( r.getString( 1 ) );
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return id;
    }
    
    public int getIdSuc( String name ) {
        String sql = "SELECT idSucursal FROM sucursal WHERE nombre = '" + name + "'";
        int id = -1;
        
        try {
            sentencia = con.getConn().createStatement();
            ResultSet r = sentencia.executeQuery( sql );
            
            while( r.next() ) {
                id = Integer.parseInt( r.getString( 1 ) );
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return id;
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
    
    public String consultarEstados() {
       String sql = "SELECT * FROM estado"; 
       String row = "";
       
       try {
           sentencia = con.getConn().createStatement();
           ResultSet r = sentencia.executeQuery(sql);
           int n;
           
           while( r.next() ) {
                n = r.getMetaData().getColumnCount();
                
                for( int i = 1; i <= n; i++ ) {
                    if( i == 1 ) {
                        row += r.getString( i );
                        row += "_";
                    } else {
                        row += r.getString( i );
                    }
                }
                
                row += "**";
           }
       } catch( SQLException ex ) {
           Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       return row.substring(0, row.length() - 2 );
    }
    
    public String consultarEstados( int id ) {
       String sql = "SELECT nombre FROM estado WHERE idEstado = " + id; 
       String row = "";
       
       try {
           sentencia = con.getConn().createStatement();
           ResultSet r = sentencia.executeQuery(sql);
           int n;
           
           while( r.next() ) {
                n = r.getMetaData().getColumnCount();
                
                for( int i = 1; i <= n; i++ ) {
                    row += r.getString( i );
                }
           }
       } catch( SQLException ex ) {
           Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       return row;
    }
    
    public String consultarDelegaciones( String idState ) {
       String sql = "SELECT idDeleg_Mun, nombre FROM deleg_mun WHERE Estado_idEstado = " + idState; 
       String row = "";
       
       try {
           sentencia = con.getConn().createStatement();
           ResultSet r = sentencia.executeQuery(sql);
           int n;
           
           while( r.next() ) {
                n = r.getMetaData().getColumnCount();
                
                for( int i = 1; i <= n; i++ ) {
                    if( i == 1 ) {
                        row += r.getString( i );
                        row += "_";
                    } else {
                        row += r.getString( i );
                    }
                }
                
                row += "**";
           }
       } catch( SQLException ex ) {
           Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       return ( row.equals("") )? row:row.substring(0, row.length() - 2 );
    }
    /* public static void main( String args[] ) {
        CRUD test = new CRUD();
        
        test.consultar();
        //test.insertar( "Taco", "10.00", "Pastro, suadero, bisteck, longaniza. Con quesillo $5.00 mas" );
    } */
    
}
