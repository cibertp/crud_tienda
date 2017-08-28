package controler;

import java.sql.*;

/**
 *
 * @author Cibert Poet
 */
public class conex {

    private String user = "root";
    private String pass = "";
    private String driver = "com.mysql.jdbc.Driver";
    private String jdbc = "jdbc:mysql://localhost/tienda";
    private Connection conex = null;

    public Connection getAbrirConexion() throws Exception {
        if (conex == null) {
            Class.forName(driver);
            conex = DriverManager.getConnection(jdbc, user, pass);
        }

        return conex;
    }

    protected void cerrar() throws Exception {
        if (conex != null) { 
            conex = null;
        }
    }

    public ResultSet ejecutarSQL(String sql) throws Exception {
        ResultSet rs = null;
        Statement st = null;

        st = getAbrirConexion().createStatement();
        rs = st.executeQuery(sql); 

        cerrar();
        return rs;
    }

    
    public ResultSet ejecutarSP(PreparedStatement sentencia) throws Exception {
        ResultSet rs = null;
        getAbrirConexion();

        rs = sentencia.executeQuery(); 

        cerrar();
        return rs;
    }

    
    public int ejecutarTS(PreparedStatement sentencia, Connection con) throws Exception, SQLException, SQLException, SQLException, SQLException {
        int fila = 0;
        try {
            fila = sentencia.executeUpdate();            
        } catch (Exception e) {
            con.rollback(); 
            throw e;        }
        return fila;
    }


}
