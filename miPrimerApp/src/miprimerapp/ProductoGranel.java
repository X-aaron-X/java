package miprimerapp;

/**
 *
 * @author Aaron
 */
public class ProductoGranel extends Producto{
    private double peso;

    public ProductoGranel(int codigo, String descripcion, double precio, double peso) {
        super(codigo, descripcion, precio);
        this.peso = peso;
    }

    public ProductoGranel() {
        super();
        this.peso = 0;
    }
    
    @Override
    public double obtenerPrecio() {
        return getPrecio() * peso;
    }
}
