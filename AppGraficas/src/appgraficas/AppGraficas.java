package appgraficas;

import javax.swing.JFrame;

public class AppGraficas {
    
    public static void main(String[] args) {
        //MiVentana v1 = new MiVentana();
        
        //v1.setSize(600, 600);
//        
//        v1.setResizable(false);
//        
//        v1.setVisible(true);
//        
//        v1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MiVentana2Select v2 = new MiVentana2Select();
        
        v2.setResizable(false);
        
        v2.setVisible(true);
        
        v2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}