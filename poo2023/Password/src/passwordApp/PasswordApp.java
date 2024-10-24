package passwordApp;

import java.util.Scanner;

public final class PasswordApp {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Introduce la longitud de las contrase�as (12 caracteres minimo): ");
        int longitud = scanner.nextInt();
           
        System.out.print("Introduce la cantidad de contrase�as a generar: ");
        int cantidad = scanner.nextInt();
        
        for (int i = 0; i < cantidad; i++) {
            PasswordApp password = new PasswordApp(longitud);
            System.out.println("Contrase�a: " + password.getContrasena() + " => Fuerte: " + password.esFuerte());
        }
    }
}
