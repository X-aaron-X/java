package ejerciciosarraybidimensionales;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Aaron
 */
public class EjerciciosArrayBidimensionales {

    public static void main(String[] args) {
       //ejercicio8();
       //ejercicio9();
       ejercicio10();
    }
    
    // Crea una función que rellene una matriz de 12x30 con las temperaturas de Alpelandia. Se rellenará con doubles 
    // con valores entre 0 y 35. Una vez hecho esto se pedirá un número de mes al usuario y mostrará las temperaturas de ese mes.
    public static void ejercicio8() {
        Scanner scanner = new Scanner(System.in);
        
        double[][] temperaturasAlpe = new double[12][30];
        
        for (double[] temperatura : temperaturasAlpe) {
            for (int i = 0; i < temperatura.length; i++) {
                temperatura[i] = Math.random() * 35 + 1;
            }
        }

        System.out.print("Introduce el mes (1-12): ");
        int mes = scanner.nextInt();
        
        if (mes < 1 || mes > 12) {
            System.out.println("Numero incorrecto");
        }
        else {
            System.out.println(Arrays.deepToString(temperaturasAlpe));
            
            System.out.println(Arrays.toString(temperaturasAlpe[mes - 1]));
        }
    }
    
    // Crear automáticamente dos matrices de nxn (n lo introduce el usuario) y sumar sus valores, 
    // los resultados se deben almacenar en otra matriz tambien de nxn. Mostrar las matrices originales y el resultado.
    public static void ejercicio9() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce el tamaño de los arrays: ");
        int nTamanoArray= scanner.nextInt();

        int[][] arrayA = crearMatriz(nTamanoArray);
        int[][] arrayB = crearMatriz(nTamanoArray);
        
        int[][] arrayResultado = sumarMatrices(arrayA, arrayB);
        
        System.out.println("Array A: " + Arrays.deepToString(arrayA));
        System.out.println("Array B: " + Arrays.deepToString(arrayB));
        
        System.out.println("Resultado de la suma de arrays: " + Arrays.deepToString(arrayResultado));
    }

    public static int[][] crearMatriz(int nTamanoArray) {
        int[][] array = new int[nTamanoArray][2 * nTamanoArray];

        for (int[] fila : array) {
            for (int i = 0; i < fila.length; i++) {
                fila[i] = (int) (Math.random() * 10);
            }
        }

        return array;
    }
    
    public static int[][] sumarMatrices(int[][] arrayA, int[][] arrayB) {
        int filas = arrayA.length;
        int columnas = arrayB[0].length;

        int[][] arrayResultado = new int[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                arrayResultado[i][j] = arrayA[i][j] + arrayB[i][j];
            }
        }

        return arrayResultado;
    }
    
    // Crea una función llamada mayorColumnaPrimero. Esta función genera un array de enteros de NxM (la N, la M y los valores se introducen por teclado) 
    // y muéstrala en pantalla. Luego calcula cual es la columna cuya suma es mayor y por último intercámbiala por la primera columna
    public static void ejercicio10() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce el numero de filas del array: ");
        int filas = scanner.nextInt();

        System.out.print("Introduce el numero de columnas del array: ");
        int columnas = scanner.nextInt();

        int[][] array = generarArray(filas, columnas);
           
        System.out.println("");
        mostrarArray(array);
        
        int columnaMayor = columnaSumaMayor(array);
        System.out.println("\nLa columna mayor es: " + (columnaMayor + 1));
        
        intercambiarColumnas(array, columnaMayor);
        System.out.println("Ponemos la columna mayor al principio:");
        mostrarArray(array);
    }
    
    public static int[][] generarArray(int filas, int columnas) {
        Scanner scanner = new Scanner(System.in);

        int[][] array = new int[filas][columnas];

        //System.out.println("Introduce los valores del array:");

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                //System.out.print("[" + i + "][" + j + "]: ");
                //array[i][j] = scanner.nextInt();
                array[i][j] = (int) (Math.random() * 10);
            }
        }

        return array;
    }
    
   public static void mostrarArray(int[][] array) {
        for (int[] fila : array) {
            System.out.println(Arrays.toString(fila));
        }
    }
    
    public static int columnaSumaMayor(int[][] array) {
        int suma = 0;
        int columnaMayor = 0;

        for (int j = 0; j < array[0].length; j++) {
            int sumaColumna = 0;
            
            for (int i = 0; i < array.length; i++) {
                sumaColumna += array[i][j];
            }
            
            if (sumaColumna > suma) {
                suma = sumaColumna;
                columnaMayor = j;
            }
        }
        
        return columnaMayor;
    }
    
    public static void intercambiarColumnas(int[][] array, int columnaMayor) {
        if (columnaMayor != 0) {
            for (int i = 0; i < array.length; i++) {
                int columnaTemp = array[i][0];

                array[i][0] = array[i][columnaMayor];
                array[i][columnaMayor] = columnaTemp;
            }
        }
    }
}
