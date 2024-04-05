package accesoficheros;

import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author Aaron
 */
public class AccesoFicheros {
    
    // Metodo que lea un fichero y almacena TODAS sus palabras en array de String
    public static void main(String[] args) {
        final String nombreFichero = "files\\fichero.txt";
        
        try {
            FileReader fichero = new FileReader(nombreFichero);
            ArrayList<String> palabrasArray = new ArrayList<String>();
            
            String texto = "";
            int index = 0;
            int valor = fichero.read();
            
            while (valor != -1) {
                if ((char) valor != ' ') {
                    texto = texto + (char) valor;
                    
                    palabrasArray.add(index, texto);
                }
                else {
                    index++;
                }
                
                valor = fichero.read();
            }
            
            System.out.println(palabrasArray.toString());
        }
        catch (Exception e) {
            System.out.println("Fichero no existe o ruta invalida");
        }
    }
    
   
}