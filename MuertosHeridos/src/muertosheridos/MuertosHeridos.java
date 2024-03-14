package muertosheridos;

import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author Aaron
 */
public class MuertosHeridos {
    
    // Muertos y Heridos es un juego de lógica para el que solo se necesita lápiz y papel. Se juega entre dos jugadores, 
    // el cifrador que piensa un número de 4 cifras del 0000 al 9999, la clave, y el descifrador que trata de deducirlo.
    // En cada intento el descifrador pregunta un número de cuatro cifras. El cifrador responde con un número de dos cifras. 
    // La primera, los muertos, representa el número de dígitos de la pregunta que coinciden con alguno de la clave y además se encuentran en la misma posición. 
    // La segunda, los heridos, representa el número de dígitos de la pregunta que coinciden con alguno de la clave pero que no están en la misma posición.
    // Si el jugador introduce "claudico", mostraremos la solución.
    public static void main(String[] args) {
        int[] clave = generarClave();
        int muertos = 0, heridos;
        String texto;
        boolean claudico = false;

        System.out.println(Arrays.toString(clave));

        do {
            texto = JOptionPane.showInputDialog("Introduce un numero de 4 cifras. Para salir escribe 'claudico':");

            if (texto.equals("claudico")) {
                System.out.println("Adios");
                
                claudico = true;
            }
            else {
               if (texto.length() != 4) {
                    System.out.println("Debes introducir un numero de 4 cifras. Entre [0000-9999]");
                } 
                else {
                    int[] numArray = convertirArrayInt(texto);
                    
                    muertos = contarMuertos(clave, numArray);
                    heridos = contarHeridos(clave, numArray);
                    
                    System.out.println("\nMuertos: " + muertos);
                    System.out.println("Heridos: " + heridos);
                    
                    if (muertos == 4) {
                        System.out.println("Felicidades la clave ganadora es " + Arrays.toString(clave));
                        
                        claudico = true;
                    }
               }
            }
        } while (!claudico || muertos != 4);
    }
    
    public static int[] generarClave() {
        int[] clave = new int[4];
        
        for (int i = 0; i < clave.length; i++) {
            clave[i] = (int) (Math.random() * 10);
        }
        
        return clave;
    }
    
    public static int[] convertirArrayInt(String numString) {
        int[] array = new int[4];

        char[] charArray = numString.toCharArray();
        
        for (int i = 0; i < array.length; i++) {
            array[i] = Character.getNumericValue(charArray[i]);
        }

        return array;
    }
    
    public static int contarMuertos(int[] clave, int[] array) {
        int muertos = 0;
        
        for (int i = 0; i < 4; i++) {    
            if (clave[i] == array[i]) {
                muertos++;
            }
        }
        
        return muertos;
    }
    
    public static int contarHeridos(int[] clave, int[] array) {
        int heridos = 0;
       
        for (int i = 0; i < 4; i++) {
           for (int j = 0; j < 4; j++) {
                if (i != j && clave[i] == array[j]) {
                    heridos++;
                }
            }
        }
        
        return heridos;
    }
}
