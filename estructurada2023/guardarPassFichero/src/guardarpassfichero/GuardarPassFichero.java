package guardarpassfichero;

import java.io.*;
import java.nio.charset.StandardCharsets;
import javax.swing.JOptionPane;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class GuardarPassFichero {
    private static final String FICHERO = "files\\pass.txt";
    private static final String CLAVE_SECRETA = "AlpeFormacion24#";  // (16 bytes para AES-128)

    public static void main(String[] args) {
        int opcion;
        
        do {
            opcion = validarNumEntero("Menu:\n [1] Registrar Usuario\n [2] Buscar Contrase�a\n [3] Limpiar Fichero\n [4] Salir\n\nIntroduce una opcion: ");

            switch (opcion) {
                case 1 -> registrarUsuario();
                case 2 -> buscarContrasena();
                case 3 -> limpiarFichero();
                case 4 -> System.out.println("Adios");
                default -> JOptionPane.showMessageDialog(null, "Opci�n incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        while (opcion != 4);
    }
    
    /**
     * Pide un numero entero al usuario y lo valida
     * @param message
     * @return int
    */
    private static int validarNumEntero(String message) {
        while (true) {
            String entrada = JOptionPane.showInputDialog(message);
            
            try {
                return Integer.parseInt(entrada);
            }
            catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Introduce un numero valido", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Registra un nuevo usuario y su contrase�a en el fichero
    */
    private static void registrarUsuario() {
        String usuario;
        
        do {
            usuario = JOptionPane.showInputDialog("Introduce el nombre de usuario: ").toLowerCase();
        }
        while (obtenerContrasena(usuario) != null);

        String contrasena = JOptionPane.showInputDialog("Introduce la contrase�a: ");
        String contrasenaEncriptada = encriptarContrasena(contrasena);
        
        escribirUsuarioYContrasena(usuario, contrasenaEncriptada);
    }
    
    /**
     * Lee el fichero y busca la contrase�a encriptada
     * @param usuario 
     * @return Strin La contrase�a encriptada o null si el usuario no existe
    */
    private static String obtenerContrasena(String usuario) {
        try (BufferedReader fichero = new BufferedReader(new InputStreamReader(new FileInputStream(FICHERO), StandardCharsets.ISO_8859_1))) {
            String linea;

            while ((linea = fichero.readLine()) != null) {
                if (linea.equals("Usuario: " + usuario)) {
                    String lineaContrasena = fichero.readLine();
                    
                    if (lineaContrasena != null && lineaContrasena.startsWith("Contrase�a: ")) {
                        return lineaContrasena.substring(12);
                    }
                }
            }
        }
        catch (IOException e) {
            System.err.println("Error al leer el fichero: " + e.getMessage());
        }
        
        return null;
    }

    /**
     * Escribe el usuario y su contrase�a encriptada
     * @param usuario
     * @param contrasenaEncriptada
    */
    private static void escribirUsuarioYContrasena(String usuario, String contrasenaEncriptada) {
        try (BufferedWriter fichero = new BufferedWriter(new FileWriter(FICHERO, true))) {
            fichero.write("Usuario: " + usuario + "\n");
            fichero.write("Contrase�a: " + contrasenaEncriptada + "\n");
            fichero.write("--------------------------------\n");
        }
        catch (IOException e) {
            System.out.println("Error al escribir en el fichero: " + e.getMessage());
        }
    }

    /**
     * Busca la contrase�a encriptada de un usuario
     * @return La contrase�a encriptada o null si el usuario no existe
    */
    private static void buscarContrasena() {
        String usuario = JOptionPane.showInputDialog("Introduce el nombre de usuario: ").toLowerCase();
        String contrasenaEncriptada = obtenerContrasena(usuario);

        if (contrasenaEncriptada != null) {
            String contrasenaDesencriptada = desencriptarContrasena(contrasenaEncriptada);
            
            JOptionPane.showMessageDialog(null, "Usuario: " + usuario + "\nContrase�a: " + contrasenaDesencriptada);
        }
        else {
            JOptionPane.showMessageDialog(null, "Usuario no existe");
        }
    }

    /**
     * Encripta la contrase�a utilizando AES
     * @param contrasena
     * @return String Contrase�a en formato Base64
    */
    private static String encriptarContrasena(String contrasena) {
        try {
            // Crea un objeto SecretKeySpec con la clave secreta y el algoritmo AES
            SecretKeySpec key = new SecretKeySpec(CLAVE_SECRETA.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            
            cipher.init(Cipher.ENCRYPT_MODE, key);  // Inicializa el cifrador en modo encriptaci�n
            byte[] encrypted = cipher.doFinal(contrasena.getBytes());  // Encripta la contrase�a
            return Base64.getEncoder().encodeToString(encrypted);  // Devuelve la contrase�a encriptada en Base64
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }

    /**
     * Desencripta la contrase�a utilizando AES
     * @param contrasenaEncriptada
     * @return String Contrase�a original desencriptada
    */
    private static String desencriptarContrasena(String contrasenaEncriptada) {
        try {
            // Crea un objeto SecretKeySpec con la clave secreta y el algoritmo AES
            SecretKeySpec key = new SecretKeySpec(CLAVE_SECRETA.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            
            cipher.init(Cipher.DECRYPT_MODE, key);  // Inicializa el cifrador en modo desencriptaci�n
            byte[] decoded = Base64.getDecoder().decode(contrasenaEncriptada);  // Decodifica la contrase�a en Base64
            byte[] decrypted = cipher.doFinal(decoded);  // Desencripta la contrase�a
            return new String(decrypted);  // Devuelve la contrase�a desencriptada
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }

    /**
     * Limpia el contenido del fichero
    */
    private static void limpiarFichero() {
        try (BufferedWriter fichero = new BufferedWriter(new FileWriter(FICHERO))) {
            // El fichero se limpia porque escribe nada
        }
        catch (IOException e) {
            System.out.println("Error al limpiar el fichero: " + e.getMessage());
        }
    }
}
