package modelo;

import controler.conex;
import java.util.ArrayList;

/**
 *
 * @author Cibert Poet
 */

public class Marca  {

    private int idMarca;
    private String nombre;
    


    public Marca() {
        Collector.listaMarcas = new ArrayList<>();
    }

    public Marca(String nombre) {
        this.nombre = nombre;
    }

    public Marca(int idMarca, String nombre) {
        this.idMarca = idMarca;
        this.nombre = nombre;
    }
    
    

    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return this.getNombre();
    }

}
