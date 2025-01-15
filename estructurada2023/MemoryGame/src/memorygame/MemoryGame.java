package memorygame;

import javax.swing.JFrame;

/**
 *
 * @author Alpe
 */
public class MemoryGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        NewJFrame ventana1 = new NewJFrame();
        ventana1.setSize(800,800);
        ventana1.setTitle("Juego memory art");
        ventana1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana1.setVisible(true);
    }
    
}
