package miprimirproyecto;

import static java.io.IO.println;
import javax.swing.JOptionPane;

public class MiPrimirProyecto {
    public static void main() {
        parOIimpar();
    }
    
    public static void parOIimpar() {
        int num;
        
        num = Integer.parseInt(JOptionPane.showInputDialog("Introduce n�mero para saber si es par o impar"));
        
        println((num % 2 == 0) ? "El n�mero " + num + " es par" : "El n�mero " + num + " es impar");
    }
}
