package arraylistmenu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Aaron
 */
public class ArrayListMenu {

    public static void main(String[] args) {
       int opcion = 0;
        
        Scanner entrada = new Scanner(System.in);
        ArrayList<Double> listaArray = new ArrayList<Double>();
         
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
                    agregar(listaArray);
                    break;
                case 2:
                    buscar(listaArray);
                    break;
                case 3:
                    modificar(listaArray);
                    break;
                case 4:
                    eliminar(listaArray);
                    break;
                case 5:
                    insertarElemento(listaArray);
                    break;
                case 6:
                    mostrar(listaArray);
                    break;
                case 7:
                    ordenarAscendente(listaArray);
                    break;
                case 8:
                    ordenarDescendente(listaArray);
                    break;
                case 9:
                    System.out.println("Adiós");
                    break;
                default:
                    System.out.println("Por favor, elige una opciones entre [1-9]");
            }

        } while (opcion != 9);
    }
    
    // 1
    public static void agregar(ArrayList listaArray) {
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Introduce el numero que deceas agregar: ");
        Double numero = entrada.nextDouble();
        
        listaArray.add(numero);
    }
    
    // 2
    public static void buscar(ArrayList listaArray) {
        if (!listaArray.isEmpty()) {
            Scanner entrada = new Scanner(System.in);
        
            System.out.print("Introduce el numero a buscar: ");
            double numero = entrada.nextDouble();

            int indice = listaArray.indexOf(numero);

            if (indice != -1) {
                System.out.println("El numero " + numero + " esta en la posision " + indice );
            }
            else {
                System.out.println("El numero introducido no esta en la lista.");
            }
        }
        else {
            System.out.println("No hay datos en la lista");
        }
    }
    
    // 3
    public static void modificar(ArrayList listaArray) {
        if (!listaArray.isEmpty()) {
            Scanner entrada = new Scanner(System.in);

            System.out.println(listaArray.toString());

            System.out.print("Introduce el indice a modificar: ");
            int indice = entrada.nextInt();

            if (indice >= 0 && indice < listaArray.size()) {
                System.out.print("Introduce el nuevo valor: ");
                double nuevoValor = entrada.nextDouble();

                listaArray.set(indice, nuevoValor);
            }
            else {
               System.out.print("No existe ese indice");
            }
        }
        else {
            System.out.println("No hay datos en la lista");
        }
    }
    
    // 4
    public static void eliminar(ArrayList listaArray) {
        if (!listaArray.isEmpty()) {
            Scanner entrada = new Scanner(System.in);

            System.out.println(listaArray.toString());

            System.out.print("Introduce el indice donde deseas eliminar el elemento: ");
            int indice = entrada.nextInt();

            if (indice >= 0 && indice < listaArray.size()) {
                listaArray.remove(indice);
            }
            else {
                System.out.print("No existe ese indice");
            }
        }
        else {
            System.out.println("No hay datos en la lista");
        }
    }
    
    // 5
    public static void insertarElemento(ArrayList listaArray) {
        if (!listaArray.isEmpty()) {
            Scanner entrada = new Scanner(System.in);

            System.out.println(listaArray.toString());

            System.out.print("Introduce el indice donde deseas insertar el nuevo elemento: ");
            int indice = entrada.nextInt();

            if (indice >= 0 && indice <= listaArray.size()) {
                System.out.print("Introduce el nuevo valor: ");
                double nuevoValor = entrada.nextDouble();

                listaArray.add(indice, nuevoValor);
            }
            else {
                System.out.print("No existe ese indice");
            }
        }
        else {
            System.out.println("No hay datos en la lista");
        }
    }
    
    // 6
    public static void mostrar(ArrayList listaArray) {
        if (!listaArray.isEmpty()) {
            System.out.println(listaArray.toString());
        }
        else {
            System.out.println("No hay datos en la lista");
        }
    }
    
    // 7
    public static void ordenarAscendente(ArrayList listaArray) {
        if (!listaArray.isEmpty()) {
            Collections.sort(listaArray);
            System.out.println(listaArray);
        }
        else {
            System.out.println("No hay datos en la lista");
        }
    }
    
    // 8
    public static void ordenarDescendente(ArrayList listaArray) {
        if (!listaArray.isEmpty()) {
            Collections.sort(listaArray, Collections.reverseOrder());
            System.out.println(listaArray);
        }
        else {
            System.out.println("No hay datos en la lista");
        }
    }
}
