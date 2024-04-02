package miprimerapp;

/**
 *
 * @author Aaron
 */
public class Producto {
    private int codigo;
    private String descripcion;
    private double precio;
    
    public Producto(int codigo, String descripcion, double precio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
    }
    
    public Producto() {
        this.codigo = 0;
        this.descripcion = "";
        this.precio = 0;
    }

    public double getPrecio() {
        return precio;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    // devuelve el precio del producto
    public double obtenerPrecio() {
        return precio;
    }  
    
    // fija el precio del producto
    public void fijarPrecio(double precioNuevo) {
        this.precio = precioNuevo;
    }
}
