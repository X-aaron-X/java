package ejerciciosarrays;

import javax.swing.JOptionPane;
import java.util.Arrays;

/**
 *
 * @author Aaron
 */
public class EjerciciosArrays {
    
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
    
    /**
     * Comprueba si es un numero double
     * @param message Muestra el mensaje para el JOptionPane
     * @return double
    */
    private static double validarNumDouble(String message) {
        while (true) {
            try {
                return Double.parseDouble(JOptionPane.showInputDialog(message));
            }
            catch (NumberFormatException e) {
                System.out.println("Introduce un numero valido");
            }
        }
    }
    
    /**
     * Comprobamos si el usuario intoduce alguna vocal
     * @param message
     * @return 
    */
    private static char comprobarVocal(String message) {
        String vocal;
        
        while (true) {
            try {
                vocal = JOptionPane.showInputDialog(message).toLowerCase();

                if ("aeiou".contains(vocal) && vocal.length() == 1) {
                    return vocal.charAt(0);
                }
                else { 
                    throw new IllegalArgumentException("Introduce una vocal (a, e, i, o, u)"); 
                }
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
       //ejercicio2();
       //ejercicio3();
       //ejercicio4();
       ejercicio5();
       //ejercicio6();
       //ejercicio7();
    }
    
    /**
     * Crea un array de números de 100 posiciones, que contendrá los números del 1 al 100. 
     * Obtén la suma de todos ellos y la media
    */
    private static void ejercicio2() {
        int suma = 0;
        double media;
        int numeros[] = new int[100];
        
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = i + 1;
        
            suma += numeros[i];
        }
        
        media = (double)suma / numeros.length;
        
        System.out.println("La suma es: " + suma);
        System.out.println("La media es: " + media);
    }
    
    /**
     * Escribe una función que pida una frase, la convierta en una matriz de char y 
     * luego imprima esa matriz de char desde el final hacia el principio 
    */
    private static void ejercicio3() {
        String frase;
        
        frase = JOptionPane.showInputDialog("Introduce una palabra para ver sus caracteres:");
        
        char[] caracteres = frase.toCharArray();
        
        for(char caracter : caracteres) {
            System.out.println(caracter);
        }
    }
    
    /**
     * Pedir un número de alumnos y a partir de ahí pedir también nombre y nota de cada uno de ellos, 
     * almacenando cada lista en una matriz distinta. Una vez leídos los datos los mostrará de la forma 
     * 
     * El alumno nombre ha sacado un nota
    */
    private static void ejercicio4() {
        int alumnos;
        String texto;

        do {
            alumnos = validarNumEntero("Introduce el número de alumnos tiene que ser un numero mayor que 0:");
        } while (alumnos <= 0);
        
        String nombres[] = new String[alumnos];
        double notas[] = new double[alumnos];
        
        for (int i = 0; i < alumnos; i++) {
            nombres[i] = JOptionPane.showInputDialog("Introduce el nombre del " + (i + 1) + " alumno:");     
            notas[i] = validarNumDouble("Introduce la nota del alumno " + nombres[i] + ":");
        }
        
        for (int i = 0; i < alumnos; i++) {
            System.out.println("El alumno " + nombres[i] + " ha sacado una nota de " + notas[i]);
        }
    }
    
    /**
     * Crea una aplicación que pida un numero por teclado y después comprobaremos si el numero 
     * introducido es capicúa, es decir, que se lee igual sin importar la dirección.
     * Por ejemplo, si introducimos 30303 es capicúa, si introducimos 30430 no es capicúa.
    */
    private static void ejercicio5() {
        int num, digito, numeroReversa = 0;
        
        num = validarNumEntero("Introduce un numero para saber si es capicua:");

        int numeroOriginal = num;

        while (num > 0) {
            digito = num % 10;
            
            numeroReversa = numeroReversa * 10 + digito;
            
            num /= 10;
        }
        
        System.out.println((numeroOriginal == numeroReversa) ? "Es capicua" : "No es capicua");
    }
    
    /**
     * Haz un programa que lea una frase por teclado y una vocal, y diga cuantas veces 
     * aparece dicha letra en la frase introducida
    */
    private static void ejercicio6() {
        String frase;
        int cont = 0;
        char vocal;
        
        frase = JOptionPane.showInputDialog("Introduce una frase: ").toLowerCase();
        vocal = comprobarVocal("Introduce una vocal: ");

        for (int i = 0; i < frase.length(); i++) {
            if (frase.charAt(i) == vocal) {
                cont++;
            }
        }
        
        System.out.println("La frase es: " + frase);
        System.out.println("La vocal \"" + vocal + "\" aparece: " + cont);
    }
    
    /**
     * Escribe un programa que pida un tamaño de array y lo genere automáticamente (de enteros).
     * Luego pedirá otro número al usuario y lo sustituya por un cero en todo el array.
     * El programa debe mostrar por pantalla el valor borrado, el número de veces que aparece ese valor, 
     * el array inicial y el array final 
    */
    private static void ejercicio7() {
        int cont = 0, num;
        
        int numArray = validarNumEntero("Introduce el tamaño del array: ");

        int[] arrayFinal = new int[numArray];
        int[] arrayInicial = new int[arrayFinal.length];
        
        for (int i = 0; i < arrayFinal.length; i++) {   
            arrayFinal[i] = (int)Math.floor(Math.random() * 10);
            arrayInicial[i] = arrayFinal[i];
        }

        System.out.println("Elige que numero quieres convertir a 0: " + Arrays.toString(arrayFinal));
        
        num = validarNumEntero("Introduce un número para reemplazar por cero: ");
        
        for (int i = 0; i < arrayFinal.length; i++) {
            if (arrayFinal[i] == num) {
                arrayFinal[i] = 0;
                cont++;
            }
        }

        System.out.println("\nNumero borrado: " + num);
        System.out.println("Veces que aparece el numero borrado: " + cont);
        System.out.println("El array inicial es: " + Arrays.toString(arrayInicial));  
        System.out.println("El array final es: " + Arrays.toString(arrayFinal));  
    }
}
