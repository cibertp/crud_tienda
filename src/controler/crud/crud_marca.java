
package controler.crud;

import controler.conex;
import java.sql.ResultSet;
import modelo.Collector;
import modelo.Marca;

/**
 *
 * @author Cibert Poet
 */
public class crud_marca {
    
    conex cnx= new conex();
    
    
    public void listar() {
        try {
            ResultSet rs = cnx.ejecutarSQL("select * from marca");            
            while (rs.next()) {                
                Collector.listaMarcas.add(new Marca(rs.getInt(1),//idmarca
                        rs.getString(2)));//nombre de la marca
            }
        } catch (Exception e) {
            System.out.println("listar marca :"+e.getMessage());
        }
    }
}
