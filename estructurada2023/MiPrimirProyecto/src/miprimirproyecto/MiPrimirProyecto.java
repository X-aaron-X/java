package miprimirproyecto;

import static java.io.IO.println;
import java.util.Random;
import javax.swing.JOptionPane;


public class MiPrimirProyecto {
    static void main() {
        Random random = new Random();

        int numeroAleatorio = random.nextInt(100);
        println(numeroAleatorio);
        
        try {
            int edad = Integer.parseInt(JOptionPane.showInputDialog("Introduce tu edad:"));
            
            switch (edad) {
                case 0, 1, 2 -> println("Eres un bebe");
                case 3, 4, 5 -> println("Eres un niño pequeño");
                default -> println("Edad no valida");
            }
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, introduce un número válido.");
            return;
        }
    }
}
