package miprimerapp;

/**
 *
 * @author Aaron
*/
public class MiPrimerApp {
    
    /**
     * @param args the command line arguments
    */
    public static void main(String[] args) {
        Producto sal, azucar, leche;
        
        sal = new Producto(1, "Sal Comun", 2.3);
        azucar = new Producto(1, "Azúcar Blanquilla", 1.5);
        leche = new Producto();
  
        sal.fijarPrecio(0.60);
        azucar.fijarPrecio(0.81);
        
        // Imprimir por pantalla
        System.out.println("El precio de la sal es " + sal.obtenerPrecio() + " del producto " + sal.getDescripcion());
        System.out.println("El precio del azúcar es " + azucar.obtenerPrecio() + " del producto " + azucar.getDescripcion());
        System.out.println("El precio de la leche es " + leche.obtenerPrecio());
    }
}
