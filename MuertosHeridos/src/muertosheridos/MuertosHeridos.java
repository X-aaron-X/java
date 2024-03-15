package muertosheridos;

import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author Aaron
 */
public class MuertosHeridos {
    
    // Muertos y Heridos es un juego de l�gica para el que solo se necesita l�piz y papel. Se juega entre dos jugadores, 
    // el cifrador que piensa un n�mero de 4 cifras del 0000 al 9999, la clave, y el descifrador que trata de deducirlo.
    // En cada intento el descifrador pregunta un n�mero de cuatro cifras. El cifrador responde con un n�mero de dos cifras. 
    // La primera, los muertos, representa el n�mero de d�gitos de la pregunta que coinciden con alguno de la clave y adem�s se encuentran en la misma posici�n. 
    // La segunda, los heridos, representa el n�mero de d�gitos de la pregunta que coinciden con alguno de la clave pero que no est�n en la misma posici�n.
    // Si el jugador introduce "claudico", mostraremos la soluci�n.
    public static void main(String[] args) {
        int[] clave = generarClave();
        int muertos, heridos;
        
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
                    int[] stringAdivinar = convertirArrayInt(texto);
                    
                    if (numerosRepetidos(stringAdivinar)) {
                        System.out.println("No se pueden repetir los numeros");
                    }
                    else {
                        muertos = contarMuertos(clave, stringAdivinar);
                        heridos = contarHeridos(clave, stringAdivinar);
                        
                        System.out.println("\nNumero: " + texto);
                        System.out.println("Muertos: " + muertos);
                        System.out.println("Heridos: " + heridos);

                        if (muertos == 4) {
                            System.out.println("Felicidades la clave ganadora es " + Arrays.toString(clave));

                            claudico = true;
                        }
                    }
               }
            }
        } while (!claudico);
    }
    
    public static int[] generarClave() {
        int numAleatorio;
        int[] clave = new int[4];
        
        for (int i = 0; i < clave.length; i++) {
            do {
                numAleatorio = (int) (Math.random() * 10);
            
            // Buscamos en el array desde el indice '0' has el indice 'i' el 'numAleatorio'
            // Si el resultado es mayor o igual a 0 significa que esta en el array. Si es -1 no esta en el array
            } while (Arrays.binarySearch(clave, 0, i, numAleatorio) >= 0); 
            
            clave[i] = numAleatorio;
            // Ordenamos el array desde indice 0 hasta la posicion actual
            Arrays.sort(clave, 0, i + 1);
        }
        
        return clave;
    }
    
    public static int[] convertirArrayInt(String stringAdivinar) {
        int[] array = new int[4];

        char[] charArray = stringAdivinar.toCharArray();
        
        for (int i = 0; i < array.length; i++) {
            array[i] = Character.getNumericValue(charArray[i]);
        }

        return array;
    }
    
    public static boolean numerosRepetidos(int[] numeros) {
        Arrays.sort(numeros);
        
        for (int i = 0; i < numeros.length - 1; i++) {   
            if (numeros[i] == numeros[i + 1]) {
                return true; 
            }
        }
        
        return false;
    }
    
    public static int contarMuertos(int[] clave, int[] numAdivinar) {
        int muertos = 0;
        
        for (int i = 0; i < 4; i++) {    
            if (clave[i] == numAdivinar[i]) {
                muertos++;
            }
        }
        
        return muertos;
    }
    
    public static int contarHeridos(int[] clave, int[] numAdivinar) {
        int heridos = 0;
       
        for (int i = 0; i < 4; i++) {
           for (int j = 0; j < 4; j++) {
                if (i != j && clave[i] == numAdivinar[j]) {
                    heridos++;
                }
            }
        }
        
        return heridos;
    }
}
