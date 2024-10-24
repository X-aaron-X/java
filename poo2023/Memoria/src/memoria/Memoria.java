package memoria;

import javax.swing.JFrame;

/**
 *
 * @author Aaron
 */
public class Memoria {

    public static void main(String[] args) {
        Ventana ventana = new Ventana();
        
        ventana.setResizable(false);
        
        ventana.setVisible(true);
        
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}