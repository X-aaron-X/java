package ahorcadosimple;

import java.util.HashSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Aaron
 */
public class AhorcadoSimple {
    
    public static void main(String[] args) {
        String palabraSecreta = palabraAdivinar("Introduce la palabra a adivinar: ");
        
        jugarAhorcado(palabraSecreta);
    }

    private static String palabraAdivinar(String message) {
        String palabra;
        
        do {
            palabra = JOptionPane.showInputDialog(message);
            
            if (palabra == null || palabra.trim().isEmpty()) {
                System.out.println("Introduce al menos un caracter");
            }
        } while (palabra == null || palabra.trim().isEmpty());
        
        return palabra;
    }
    
    private static void jugarAhorcado(String palabraSecreta) {
        int intentosRestantes = 10;
        char letra;
        boolean juegoTerminado = false;
        
        char[] palabraParaAdivinar = inicializarPalabraAdivinada(palabraSecreta);
        HashSet<Character> caracteresIntroducidos = new HashSet<>();

        System.out.println("Juego del Ahorcado:");
        System.out.println("La palabra adivinar tiene " + palabraParaAdivinar.length + " caracteres\n");
        
        while (!juegoTerminado) {
            mostrarPalabraParaAdivinada(palabraParaAdivinar);
            System.out.println("\nIntentos restantes: " + intentosRestantes);

            letra = comprobarCaracter("Introduce una letra:: ");
            
            if (!caracteresIntroducidos.contains(letra)) {
                caracteresIntroducidos.add(letra);
                
                if (!adivinarLetra(letra, palabraSecreta, palabraParaAdivinar)) {
                    intentosRestantes--;
                }
                
                if (intentosRestantes <= 0) {
                    System.out.println("\nPerdiste\nLa palabra correcta es: " + palabraSecreta);
                    juegoTerminado = true;
                }
                else if (String.valueOf(palabraParaAdivinar).equalsIgnoreCase(palabraSecreta)) {
                    System.out.println("\nGanaste.\nLa palabra secreta es:");
                    mostrarPalabraParaAdivinada(palabraSecreta.toCharArray());
                    juegoTerminado = true;
                }
            }
            else {
                System.out.println("El caracter '" + letra +"' ya lo haz introducido\n");
            }
        }
    }
    
    private static char[] inicializarPalabraAdivinada(String palabraSecreta) {
        char[] palabraParaAdivinar = new char[palabraSecreta.length()];
        
        for (int i = 0; i < palabraParaAdivinar.length; i++) {
            palabraParaAdivinar[i] = '_';
        }
        
        return palabraParaAdivinar;
    }
    
    private static void mostrarPalabraParaAdivinada(char[] palabraAdivinada) {
        for (char caracter : palabraAdivinada) {
            System.out.print(caracter + " ");
        }
        
        System.out.println();
    }
    
    private static char comprobarCaracter(String message) {
        String caracter;
        
        while (true) {
            try {
                caracter = JOptionPane.showInputDialog(message).toLowerCase();

                if (caracter.length() == 1) {
                    return caracter.charAt(0);
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
}
