package ahorcado;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Ahorcado {
    public static void main(String[] args) {
        final String FICHERO = "files\\palabras.txt";
        
        try {
            BufferedReader fichero = new BufferedReader(new FileReader(FICHERO));
            String palabraAdivinar = palabraAleatoria(fichero);
            
            if (palabraAdivinar != null) {
                jugarAhorcado(palabraAdivinar);
            }
            else {
                System.out.println("El fichero esta vacio");
            }
        }
        catch (Exception e) {
            System.out.println("El fichero no existe o la ruta es incorrecta");
        }
    }
    
    /**
     * Cogemos una palabra aleatoria de un fichero. Si el fichero esta vacio devuelve null
     * @param fichero
     * @return String
     * @throws IOException 
    **/
    public static String palabraAleatoria(BufferedReader fichero) throws IOException {
        String palabraAdivinar = null, linea;
        Random random = new Random();
        int numLineas = 0;

        while ((linea = fichero.readLine()) != null) {
            numLineas++;
            
            if (random.nextInt(numLineas) == 0) {
                palabraAdivinar = linea.trim();
            }
        }

        return palabraAdivinar;
    }
    
    /**
     * Jugar al ahorcado pidiendo al usuario caracteres con 6 intentos
     * @param palabraSecreta
    **/
    public static void jugarAhorcado(String palabraSecreta) {
        Scanner scanner = new Scanner(System.in);
        int intentosRestantes = 6;
        char[] palabraParaAdivinar = inicializarPalabraAdivinada(palabraSecreta);

        boolean juegoTerminado = false;

        while (!juegoTerminado) {
            System.out.println("\nAdivina los " + contarGuionesBajos(palabraParaAdivinar) + " caracteres");
            mostrarPalabraAdivinada(palabraParaAdivinar);
            System.out.println("\nIntentos restantes: " + intentosRestantes);

            System.out.print("Introduce una letra: ");
            char letra = scanner.next().toLowerCase().charAt(0);

            if (!adivinarLetra(letra, palabraSecreta.toLowerCase(), palabraParaAdivinar)) {
                intentosRestantes--;
            }

            if (intentosRestantes <= 0) {
                System.out.println("\nPerdiste\nLa palabra correcta es: " + palabraSecreta);
                juegoTerminado = true;
            }
            else if (String.valueOf(palabraParaAdivinar).equalsIgnoreCase(palabraSecreta)) {
                System.out.println("\nGanaste.\nLa palabra adivinada es:");
                
                mostrarPalabraAdivinada(palabraSecreta.toCharArray());
                juegoTerminado = true;
            }
        }
    }
    
    /**
     * Contamos cuantos caracteres tiene y lo trasformamos a '_' cada caracter
     * @param palabraSecreta
     * @return char
    **/
    public static char[] inicializarPalabraAdivinada(String palabraSecreta) {
        char[] palabraParaAdivinar = new char[palabraSecreta.length()];
        
        for (int i = 0; i < palabraParaAdivinar.length; i++) {
            palabraParaAdivinar[i] = '_';
        }
        return palabraParaAdivinar;
    }
    
    /**
     * Buscaos con la letra que pasamos si esta en palabraAdivinar
     * @param letra
     * @param palabraSecreta
     * @param palabraParaAdivinar
     * @return boolean
    **/
    public static boolean adivinarLetra(char letra, String palabraSecreta, char[] palabraParaAdivinar) {
        boolean letraEncontrada = false;
        
        for (int i = 0; i < palabraSecreta.length(); i++) {
            if (Character.toLowerCase(palabraSecreta.charAt(i)) == letra) {
                palabraParaAdivinar[i] = palabraSecreta.charAt(i);
                letraEncontrada = true;
            }
        }
        return letraEncontrada;
    }
    
    /**
     * 
     * @param palabraAdivinada 
    **/
    public static void mostrarPalabraAdivinada(char[] palabraAdivinada) {
        for (char caracter : palabraAdivinada) {
            System.out.print(caracter + " ");
        }
        System.out.println();
    }
    
    /**
     * Contamos los giones que tiene palabraAdivinada
     * @param palabraAdivinada
     * @return int
    **/
    public static int contarGuionesBajos(char[] palabraAdivinada) {
        int contador = 0;
        
        for (char caracter : palabraAdivinada) {
            if (caracter == '_') {
                contador++;
            }
        }
        return contador;
    }
}