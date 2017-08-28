
package controler.crud;

import controler.conex;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.Collector;
import modelo.Marca;
import modelo.Producto;

/**
 *
 * @author Cibert Poet
 */
public class crud_producto {
    
    conex cnx= new conex();
    Producto prod= new Producto();
    
    
    
    public void listar() {
        try {           
            PreparedStatement ps = cnx.getAbrirConexion().prepareStatement("select * from producto");          

            ResultSet rs = cnx.ejecutarSP(ps);            
            while (rs.next()) {               
                Collector.listaProductos.add(
                        new Producto(rs.getInt(1), new Marca(rs.getString(2)), rs.getString(3), rs.getDouble(4))
                );
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public void registrar() {
        try {
            Connection con = cnx.getAbrirConexion(); 
            con.setAutoCommit(false);
            
            String insertsql="insert into producto (idmarca, nombre, precio) values (?,?,?)" ;

            PreparedStatement ps = con.prepareStatement(insertsql);
            ps.setInt(1, prod.getMarca().getIdMarca()); 
            ps.setString(2, prod.getNombre());
            ps.setDouble(3, prod.getPrecio());

            cnx.ejecutarTS(ps, con); 
            con.commit();
            con.close(); 
            ps.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public void eliminar() {
        
        try {
            Connection con = cnx.getAbrirConexion();
            con.setAutoCommit(false);
            String deletesql="delete from producto where idproducto = ?";

            PreparedStatement ps = con.prepareStatement(deletesql);
            ps.setInt(1, prod.getIdProducto()); 

            cnx.ejecutarTS(ps, con); 

            con.commit(); 
            con.close();
            ps.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

   
    public void actualizar() {
        try {
            
            String updateSQL="update producto set idmarca=?,nombre=?,precio=? where idproducto=?";         

            Connection con = cnx.getAbrirConexion(); 
            con.setAutoCommit(false); 

            PreparedStatement ps = con.prepareStatement(updateSQL);
            ps.setInt(1, prod.getMarca().getIdMarca()); 
            ps.setString(2, prod.getNombre());
            ps.setDouble(3, prod.getPrecio());
            ps.setInt(4, prod.getIdProducto());
            cnx.ejecutarTS(ps, con); 
            con.commit();
            con.close();
            ps.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
