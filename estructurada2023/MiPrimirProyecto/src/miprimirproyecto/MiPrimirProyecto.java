package miprimirproyecto;

import static java.io.IO.println;
import javax.swing.JOptionPane;

public class MiPrimirProyecto {
    public static void main() {
        parOIimpar();
    }
    
    public static void parOIimpar() {
        int num;
        
        num = Integer.parseInt(JOptionPane.showInputDialog("Introduce número para saber si es par o impar"));
        
        println((num % 2 == 0) ? "El número " + num + " es par" : "El número " + num + " es impar");
    }
}
