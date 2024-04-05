package ahorcado;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author Aaron
 */
public class Ahorcado {

    public static void main(String[] args) {
        
        final String nombreFichero = "files\\palabras.txt";
        
        try {
            Scanner scanner = new Scanner(System.in);
            BufferedReader fichero = new BufferedReader(new FileReader(nombreFichero));
            String linea = fichero.readLine(1);
                
           

                System.out.println(linea);
            
            
            
            
            System.out.print("Introduce un caracter: ");
            char caracter = scanner.next().charAt(0);
            
            System.out.println(caracter);
        }
        catch (Exception e) {
            System.out.println("Fichero no existe o ruta invalida");
        }
    }
}