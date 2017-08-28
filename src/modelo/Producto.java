package modelo;

import java.util.ArrayList;

/**
 *
 * @author Cibert Poet
 */
public class Producto {

    private int idProducto;
    private Marca marca;
    private String nombre;
    private double precio;
    
    
    public Producto() {
        Collector.listaProductos = new ArrayList<>();
    }

    public Producto(int idProducto, Marca marca, String nombre, double precio) {
        this.idProducto = idProducto;
        this.marca = marca;
        this.nombre = nombre;
        this.precio = precio;
    }

  
    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }



    

}
