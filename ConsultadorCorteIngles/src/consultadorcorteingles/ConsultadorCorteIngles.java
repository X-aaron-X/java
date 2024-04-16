package consultadorcorteingles;

import javax.swing.JFrame;

/**
 *
 * @author Aaron
 */
public class ConsultadorCorteIngles {

    public static void main(String[] args) {
        MiVentana ventana = new MiVentana();
        
        ventana.setResizable(false);
        
        ventana.setVisible(true);
        
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
