package ejerciciosstring;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Aaron
 */
public class EjerciciosString {

    public static void main(String[] args) {
        //ejercicio1();
        //ejercicio3();
        //ejercicio4();
        ejercicio5();
    }
    
    /**
     * Haz un programa que lea un String y cuente todas sus vocales (mayúsculas o minúsculas, con o sin acento)
    */
    public static void ejercicio1() {
        String vocales = "aeiouáéíóú";
        int contVocales = 0;
        
        String texto = JOptionPane.showInputDialog("Introduce un texto:").toLowerCase(); 
        
        for (int i = 0; i < texto.length(); i++) { 
            if (vocales.indexOf(texto.charAt(i)) != -1) { 
                contVocales++;
            } 
        }
        
        System.out.println("El texto tiene " + contVocales + " vocales");
    }
    
    /**
     * Haz un programa que, dado un String, lo muestre por pantalla invertido (Ej: palabra -> arbalap)
    */
    public static void ejercicio3() {
        String texto = JOptionPane.showInputDialog("Introduce un texto:");
        String textoInvertido = new StringBuilder(texto).reverse().toString();
        
        System.out.println("Texto original: " + texto);
        System.out.println("Texto invertido: " + textoInvertido);
    }
    
    /**
     * Dada una cadena de texto, mostrarla sin espacio
    */
    public static void ejercicio4() {
        String texto = JOptionPane.showInputDialog("Introduce un texto:");
        String textoSinEspacios = texto.replace(" ", "");
        
        System.out.println("Texto original: " + texto);
        System.out.println("Texto sin espacios:" + textoSinEspacios);
    }
    
    /**
     * Escribe un programa que genera una contraseña segura. Para ello debe contener más de 2 mayúsculas, 
     * más de 1 minúscula y más de 5 números. Comprobamos si es segura devolvera un booleano
    */
    public static void ejercicio5() {
        final int longitud = 8;
        final int mayusculas = 2;
        final int minusculas = 1;
        final int numeros = 5;
        
        System.out.println(generarContrasena(longitud, mayusculas, minusculas, numeros));
    }
    
    /**
     * Genera una contraseña segura indicandole su longitud, mayusculas, minusculas y numeros
     * @param longitud
     * @param mayusculas
     * @param minusculas
     * @param numeros
     * @return String
    */
    private static String generarContrasena(int longitud, int mayusculas, int minusculas, int numeros) {
        String contrasena = "";
        boolean segura = false;
        String caracteresNum = "0123456789";
        String caracteresString = "abcdefghijklmnñopqrstuvwxyz";
        Random random = new Random();
        
        String todosCaracteres = caracteresNum + caracteresString + caracteresString.toUpperCase(); 
        
        while (!segura) {
            contrasena = "";
            
            for (int i = 0; i < longitud; i++) {
                int aleatorio = random.nextInt(todosCaracteres.length());

                char caracter = todosCaracteres.charAt(aleatorio);       
                contrasena += caracter;
            }
        
            segura = comprobarSeguridad(contrasena, mayusculas, minusculas, numeros);
        }
        
        return contrasena;
    }
    
    /**
     * Comprobamos si la contraseña si cumple los requisitos para la contraseña segura
     * @param contrasena
     * @param mayusculas
     * @param minusculas
     * @param numeros
     * @return boolean
    */
    private static boolean comprobarSeguridad(String contrasena, int mayusculas, int minusculas, int numeros) {
        int contadorMayusculas = 0; int contadorMinusculas = 0; int contadorNumeros = 0;
        
        for (char caracter : contrasena.toCharArray()) {
            if (Character.isUpperCase(caracter)) {
                contadorMayusculas++;
            }
            else if (Character.isLowerCase(caracter)) {
                contadorMinusculas++;
            }
            else if (Character.isDigit(caracter)) {
                contadorNumeros++;
            }
        }
        
        return (contadorMayusculas >= mayusculas && contadorMinusculas >= minusculas && contadorNumeros >= numeros);
    }
}
