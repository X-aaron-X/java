package guardarpassfichero;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import javax.swing.JOptionPane;

/**
 *
 * @author Aaron
 */
public class GuardarPassFichero {

    public static void main(String[] args) {
        String usuario, contrasena;
        int opcion;
        final String FICHERO = "files\\pass.txt";
        
        do {
            String menu = "\nMenu:\n" +
                          "[1] Crear usuario\n" +
                          "[2] Buscar Usuario\n" +
                          "[3] Limpiar Fichero\n" +
                          "[4] Salir";
            
            opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
            
            switch (opcion) {
                case 1:
                    do {
                        usuario = JOptionPane.showInputDialog("Introduce el nombre de usuario\n(Si el usuario ya existe volverá a pedirlo)");
                    }
                    while (comprobarUsuario(FICHERO, usuario));
                    
                    contrasena = JOptionPane.showInputDialog("Introduce la contraseña: ");
                    escribirFichero(FICHERO, usuario, contrasena);
                    
                    break;
                case 2:
                    usuario = JOptionPane.showInputDialog("Introduce el nombre de usuario");
                    String contrasenaEncontrada = buscarContrasena(FICHERO, usuario);
                    
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "\nAdiós");
                    
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
                    
                    break;
            }
        } while (opcion != 3);
    }
    
    public static void escribirFichero(String ficheroRuta, String nombre, String password) {
        try (BufferedWriter fichero = new BufferedWriter(new FileWriter(ficheroRuta, true))) {
            fichero.write("Usuario: " + nombre + "\n");
            fichero.write("Contraseña: " + password + "\n");
            fichero.write("--------------------------------\n");
        }
        catch (IOException e) {
            System.out.println("Error al escribir en el fichero: " + e.getMessage());
        }
    }
    
    public static boolean comprobarUsuario(String ficheroRuta, String nombre) {
        try (BufferedReader fichero = new BufferedReader(new InputStreamReader(new FileInputStream(ficheroRuta), StandardCharsets.UTF_8))) {
            String linea;
            
            while ((linea = fichero.readLine()) != null) {
                if (linea.equals("Usuario: " + nombre)) {
                    return true; // Usuario encontrado
                }
            }
        }
        catch (IOException e) {
            System.out.println("Error al leer el fichero: " + e.getMessage());
        }
        
        return false; 
    }
    
    public static String buscarContrasena(String ficheroRuta, String nombre) {
        try (BufferedReader fichero = new BufferedReader(new InputStreamReader(new FileInputStream(ficheroRuta), StandardCharsets.UTF_8))) {
            String linea;
            while ((linea = fichero.readLine()) != null) {
                if (linea.equals("Usuario: " + nombre)) {
                    String passwordLine = fichero.readLine();
                    if (passwordLine != null && passwordLine.startsWith("Contraseña: ")) {
                        return passwordLine.substring(12);
                    }
                }
            }
        }
        catch (IOException e) {
            System.out.println("Error al leer el fichero: " + e.getMessage());
        }
        
        return null; // Contraseña no encontrada
    }
}
