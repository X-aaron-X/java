package passwordApp;

import java.util.Scanner;

public final class PasswordApp {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Introduce la longitud de las contraseņas (12 caracteres minimo): ");
        int longitud = scanner.nextInt();
           
        System.out.print("Introduce la cantidad de contraseņas a generar: ");
        int cantidad = scanner.nextInt();
        
        for (int i = 0; i < cantidad; i++) {
            PasswordApp password = new PasswordApp(longitud);
            System.out.println("Contraseņa: " + password.getContrasena() + " => Fuerte: " + password.esFuerte());
        }
    }
}
