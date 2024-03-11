package arraylist;

import java.util.Scanner;

/**
 *
 * @author Aaron
 */
public class ArrayList {
    static ArrayList<Double> listaArray = new ArrayList<>();

    public static void main(String[] args) {
        int opcion = 0;
        
        
        Scanner entrada = new Scanner(System.in);

        do {
            System.out.println("\nMenu:");
            System.out.println("[1] Agregar");
            System.out.println("[2] Buscar");
            System.out.println("[3] Modificar Elemento");
            System.out.println("[4] Eliminar Elemento");
            System.out.println("[5] Insertar Elemento");
            System.out.println("[6] Mostrar Elementos");
            System.out.println("[7] Orden Ascendete");
            System.out.println("[8] Orden Descendente");
            System.out.println("[9] Salir");

            System.out.print("\nIntroduzca opción [1-9]: ");
            opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    
                    break;
                case 2:
                    System.out.println("i es dos.");
                    break;
                case 3:
                    System.out.println("i es tres.");
                    break;
                case 4:
                    System.out.println("i es cuatro.");
                    break;
                case 5:
                    System.out.println("i es cinco.");
                    break;
                case 6:
                    System.out.println("i es seis.");
                    break;
                case 7:
                    System.out.println("i es siete.");
                    break;
                case 8:
                    System.out.println("i es ocho.");
                    break;
                case 9:
                    System.out.println("Adiós");
                    break;
                default:
                    System.out.println("Por favor, elige una opción entre [1-9]");
            }

        } while (opcion != 9);
    }
}
