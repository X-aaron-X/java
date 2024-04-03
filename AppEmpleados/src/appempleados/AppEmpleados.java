package appempleados;

import java.util.Scanner;

/**
 *
 * @author Aaron
 */
public class AppEmpleados {

    public static void main(String[] args) {
        Comercial comercial1 = new Comercial("Pepe", 15, 2500, 500);
        Comercial comercial2 = new Comercial("Juan", 31, 1800, 300);
        
        Repartidor repartidor1 = new Repartidor("Antonio", 2, 3000, "Por ahi");
        Repartidor repartidor2 = new Repartidor("Pepa", 24, 1100, "zona 3");

        comercial1.plus();
        comercial2.plus();
        repartidor1.plus();
        repartidor2.plus();

        System.out.println(comercial1);
        System.out.println(comercial2);
        System.out.println(repartidor1);
        System.out.println(repartidor2);
        
        // ---------------------------------------------------------------------------------------------------------------------------
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Nombre: ");
        String nombreRepartidor = scanner.nextLine();

        System.out.print("Edad: ");
        int edadRepartidor = Integer.parseInt(scanner.nextLine());

        System.out.print("Salario: "); 
        double salarioRepartidor = Double.parseDouble(scanner.nextLine());

        System.out.print("Zona: ");
        String zonaRepartidor = scanner.nextLine();

        Repartidor repartidor3 = new Repartidor(nombreRepartidor, edadRepartidor, salarioRepartidor, zonaRepartidor);
        repartidor3.plus();
        
        System.out.println(repartidor3);
    }
}