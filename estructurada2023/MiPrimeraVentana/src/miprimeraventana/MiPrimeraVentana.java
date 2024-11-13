package miprimeraventana;

import javax.swing.JFrame;

/**
 *
 * @author Aaron
 */
public class MiPrimeraVentana {

    public static void main(String[] args) {
        Ejemplo1 ventana1 = new Ejemplo1();
        
        ventana1.setSize(500, 400);
        ventana1.setTitle("Mi primera ventana Chispas");
        
        ventana1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ventana1.setVisible(true);
    }
}
