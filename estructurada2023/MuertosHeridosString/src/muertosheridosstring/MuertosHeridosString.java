package muertosheridosstring;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Aaron
 */
public class MuertosHeridosString {

    public static void main(String[] args) {
        String clave = generarClave();
        String claveUsuario;
        int muertos, heridos;
        boolean ganador = false;
        
        System.out.println(clave);
        
        do {
            claveUsuario = JOptionPane.showInputDialog("Introduce un numero de 4 cifras:");

            if (claveUsuario.length() != 4) {
                System.out.println("Debes introducir un numero de 4 cifras. No pueden repetirse los numeros");
            } 
            else {
                if (numerosRepetidos(claveUsuario)) {
                    System.out.println("No se pueden repetir los numeros");
                }
                else {
                    muertos = contarMuertos(clave, claveUsuario);
                    heridos = contarHeridos(clave, claveUsuario);

                    System.out.println("\nNumero: " + claveUsuario);
                    System.out.println("Muertos: " + muertos);
                    System.out.println("Heridos: " + heridos);

                    if (muertos == 4) {
                        System.out.println("\nGanaste");
                        System.out.println("La clave es: " + clave);

                        ganador = true;
                    }
                }
            }
        } while (!ganador);
    }

    /**
     * Genera una clave aleatoria de 4 digitos y los numeros no se repiten entre si
     * @return String
    */
    private static String generarClave() {
        Random random = new Random();
        int numAleatorio;
        char caracter;
        String clave = "";

        while (clave.length() < 4) { 
            numAleatorio = random.nextInt(10);
            caracter = (char) (numAleatorio + '0');
            
            if (clave.indexOf(caracter) == -1) {
                clave += caracter;
            }
        } 

        return clave;
    }
    
    /**
     * Comprueba que los numeros no son repetidos
     * @param claveUsuario
     * @return boolean
    */
    private static boolean numerosRepetidos(String claveUsuario) {
        char caracter;
        
        for (int i = 0; i < claveUsuario.length(); i++) { 
            caracter = claveUsuario.charAt(i);
            
            if (claveUsuario.indexOf(caracter) != claveUsuario.lastIndexOf(caracter)) { 
                return true;
            } 
        } 

        return false;
    }
    
    /**
     * Cuenta cuantos muertos hay
     * @param clave
     * @param claveUsuario
     * @return 
    */
    private static int contarMuertos(String clave, String claveUsuario) {
        char caracterClave, caracterUsuario;
        int muertos = 0;
        
        for (int i = 0; i < 4; i++) {
            caracterClave = clave.charAt(i);
            caracterUsuario = claveUsuario.charAt(i);
            
            if (caracterClave == caracterUsuario) {
                muertos++;
            }
        }
        
        return muertos;
    }
    
    /**
     * Cuenta cuantos heridos hay 
     * @param clave
     * @param claveUsuario
     * @return int
    */
    private static int contarHeridos(String clave, String claveUsuario) {
        char caracterClave, caracterUsuario;
        int heridos = 0;
       
        for (int i = 0; i < 4; i++) {
            caracterClave = clave.charAt(i);
            
            for (int j = 0; j < 4; j++) {
                caracterUsuario = claveUsuario.charAt(j);
                
                if (i != j && caracterClave == caracterUsuario) {
                    heridos++;
                }
             }
        }
        
        return heridos;
    }
}
