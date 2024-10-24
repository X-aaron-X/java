package passwordapp;

import java.util.Scanner;

/**
 *
 * @author terry
 */
public class PasswordApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Introduce la longitud de las contrase?as (12 caracteres m?nimo): ");
        int longitud = scanner.nextInt();
        
        System.out.print("Introduce la cantidad de contrase?as a generar: ");
        int cantidad = scanner.nextInt();
        
        for (int i = 0; i < cantidad; i++) {
            Password password = new Password(longitud);
            System.out.println("Contrase?a: " + password.getContrasena() + " => Fuerte: " + password.esFuerte());
        }
        
        System.out.println("\n--------------------------");
        Password segura = new Password();

        segura.generarPasswordFuerte(15);
        String contrasenaFuerte = segura.getContrasena();
        System.out.println(contrasenaFuerte);
    }
}