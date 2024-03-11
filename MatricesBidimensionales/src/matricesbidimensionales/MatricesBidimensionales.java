package matricesbidimensionales;

import java.util.Arrays;

/**
 *
 * @author Aaron
 */
public class MatricesBidimensionales {
    public static void main(String[] args) {
        int numeritos[][] = new int [5][4];
        
        for (int[] numerito : numeritos) {
            for (int i = 0; i < numerito.length; i++) {
                numerito[i] = (int) (Math.random() * 100 + 1);
            }
        }
        
        // Imprimo la matriz bidimensional de golpe con el meto deepToString
        System.out.println(Arrays.deepToString(numeritos));
        
        // Recorro las "Filas" y las voy imprimiendo una a una con el metodo toString
        for (int[] numerito : numeritos) {
            System.out.println(Arrays.toString(numerito));
        }
    }
}