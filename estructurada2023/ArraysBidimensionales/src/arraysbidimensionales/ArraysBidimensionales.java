package arraysbidimensionales;

import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.util.Arrays;

/**
 *
 * @author Aaron
 */
public class ArraysBidimensionales {
    /**
     * Comprueba que se le introduce minimo un caracter
     * @param message
     * @return 
     */
    private static String comprobarUnCaracter(String message) {
        String palabra;
        
        while (true) {
            try {
                palabra = JOptionPane.showInputDialog(message).toLowerCase();

                if (palabra.length() == 1) {
                    return palabra;
                }
                else { 
                    throw new IllegalArgumentException("Introduce un caracter"); 
                }
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    /**
     * Comprueba si es un numero int
     * @param message Muestra el mensaje para el JOptionPane
     * @return int
    */
    private static int validarNumEntero(String message) {
        while (true) {
            try {
                return Integer.parseInt(JOptionPane.showInputDialog(message));
            }
            catch (NumberFormatException e) {
                System.out.println("Introduce un numero valido");
            }
        }
    }

    public static void main(String[] args) {
        //ejercicio1();
        mayorColumnaPrimero();
    }
    
    /**
     * Programa que cree una matriz de diez filas y dos columnas de la siguiente forma
     * Los nombres de los alumnos se le pedirán al usuario y las notas se generarán aleatoriamente entre 0 y 10
    */
    private static void ejercicio1() {
        String nombre;
        int nota;

        String[][] matriz = new String[10][2];
        Random random = new Random();
        
        for (int i = 0; i < 10; i++) { 
            nombre = comprobarUnCaracter("Introduce el nombre del alumno " + (i + 1) + ":"); 
            nota = random.nextInt(11);
            
            matriz[i][0] = nombre; 
            matriz[i][1] = String.valueOf(nota);
        }
        
        for (String[] alumno : matriz) { 
            System.out.println("El alumno '" + alumno[0] + "' tiene de nota de un " + alumno[1]);
        }
    }
    
    /**
     * Crea una función llamada mayorColumnaPrimero. Esta función genera un array de enteros de NxM 
     * (la N, la M y los valores se introducen por teclado) y muéstrala en pantalla. 
     * Luego calcula cual es la columna cuya suma es mayor y por último intercámbiala por la primera columna. 
     * (Crea las funciones sumaColumna e intercambiaColumna, piensa qué parámetros necesita cada una y qué devuelven)
    */
    public static void mayorColumnaPrimero() {
        int filas = validarNumEntero("Introduce el numero de filas del array: ");
        int columnas = validarNumEntero("Introduce el numero de columnas del array: ");

        int[][] array = generarArray(filas, columnas);
           
        mostrarArray(array);
        
        int columnaMayor = columnaSumaMayor(array);
        System.out.println("\nLa columna mayor es: " + (columnaMayor + 1));
        
        intercambiarColumnas(array, columnaMayor);
        mostrarArray(array);
    }
    
    /**
     * Crea un array bidimensonales dandole nosotros sus dimensiones.
     * El array que se genera son con valores aletorios del 0 a 9
     * @param filas
     * @param columnas
     * @return int 
    */
    public static int[][] generarArray(int filas, int columnas) {
        Random random = new Random();
        int[][] array = new int[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                array[i][j] = random.nextInt(10);
            }
        }

        return array;
    }
   
    /**
     * Muestra el array bidimensional
     * @param array 
    */
    public static void mostrarArray(int[][] array) {
        for (int[] fila : array) {
            System.out.println(Arrays.toString(fila));
        }
    }
    
    /**
     * Calcula la columna cuya suma de valores es mayor
     * @param array
     * @return int
    */
    public static int columnaSumaMayor(int[][] array) {
        int suma = 0, columnaMayor = 0, sumaColumna;

        for (int i = 0; i < array[0].length; i++) {
            sumaColumna = 0;
            
            for (int[] fila : array) { 
                sumaColumna += fila[i];
            }
            
            if (sumaColumna > suma) {
                suma = sumaColumna;
                columnaMayor = i;
            }
        }
        
        return columnaMayor;
    }
    
    /**
     * Cambia la columna con la mayor suma al principio del array
     * @param array
     * @param columnaMayor 
    */
    public static void intercambiarColumnas(int[][] array, int columnaMayor) {
        if (columnaMayor != 0) {
            int columnaTemp;
            
            for (int i = 0; i < array.length; i++) {
                columnaTemp = array[i][0];

                array[i][0] = array[i][columnaMayor];
                array[i][columnaMayor] = columnaTemp;
            }
        }
    }
}
