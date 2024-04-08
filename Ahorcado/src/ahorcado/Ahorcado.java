package ahorcado;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Ahorcado {
    private static final String NOMBRE_FICHERO = "files\\palabras.txt";
    private static final int MAX_INTENTOS = 6;

    public static void main(String[] args) {
        try (BufferedReader fichero = new BufferedReader(new FileReader(NOMBRE_FICHERO))) {
            Random random = new Random();
            String palabraAdivinar = seleccionarPalabraAleatoria(fichero, random);
            
            if (palabraAdivinar != null) {
                jugarAhorcado(palabraAdivinar);
            }
            else {
                System.out.println("El fichero esta vacio");
            }
        }
        catch (IOException e) {
            System.out.println("El fichero no existe o la ruta es incorrecta");
        }
    }

    public static String seleccionarPalabraAleatoria(BufferedReader fichero, Random random) throws IOException {
        String palabraAdivinar = null;
        int numLineas = 0;
        String linea;

        while ((linea = fichero.readLine()) != null) {
            numLineas++;
            if (random.nextInt(numLineas) == 0) {
                palabraAdivinar = linea.trim();
            }
        }

        return palabraAdivinar;
    }

    public static void jugarAhorcado(String palabraSecreta) {
        Scanner scanner = new Scanner(System.in);
        int intentosRestantes = MAX_INTENTOS;
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
                System.out.println("Perdiste. La palabra correcta era: " + palabraSecreta);
                juegoTerminado = true;
            }
            else if (String.valueOf(palabraParaAdivinar).equalsIgnoreCase(palabraSecreta)) {
                System.out.println("\nGanaste. La palabra adivinada es:");
                
                mostrarPalabraAdivinada(palabraSecreta.toCharArray());
                juegoTerminado = true;
            }
        }
    }

    public static char[] inicializarPalabraAdivinada(String palabraSecreta) {
        char[] palabraParaAdivinar = new char[palabraSecreta.length()];
        for (int i = 0; i < palabraParaAdivinar.length; i++) {
            palabraParaAdivinar[i] = '_';
        }
        return palabraParaAdivinar;
    }

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

    public static void mostrarPalabraAdivinada(char[] palabraAdivinada) {
        for (char c : palabraAdivinada) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    public static int contarGuionesBajos(char[] palabraAdivinada) {
        int contador = 0;
        for (char c : palabraAdivinada) {
            if (c == '_') {
                contador++;
            }
        }
        return contador;
    }
}