package ejerciciosarraylist;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;

/**
 * Escribe un programa en Java que muestre el siguiente menú de opciones para un ArrayList de Double creado al principio de dicho programa
 * @author Aaron
*/
public class EjerciciosArrayList {

    public static void main(String[] args) {
        int opcion;

        ArrayList<Double> listaArray = new ArrayList<>();
        
        do {
            System.out.println("\nMenu: ");
            System.out.println("[1] Agregar");
            System.out.println("[2] Buscar");
            System.out.println("[3] Modificar Elemento");
            System.out.println("[4] Eliminar Elemento");
            System.out.println("[5] Insertar Elemento");
            System.out.println("[6] Mostrar Elementos");
            System.out.println("[7] Orden Ascendente");
            System.out.println("[8] Orden Descendente");
            System.out.println("[9] Salir");
            
            System.out.print("\nIntroduzca opcion [1-9]: "); 
            opcion = validarNumEntero("Introduzca opción [1-9]: ");
            
            switch (opcion) {
                case 1 -> agregar(listaArray);
                case 2 -> buscar(listaArray);
                case 3 -> modificar(listaArray);
                case 4 -> eliminar(listaArray);
                case 5 -> insertarElemento(listaArray);
                case 6 -> mostrar(listaArray);
                case 7 -> ordenarAscendente(listaArray);
                case 8 -> ordenDescendente(listaArray);
                case 9 -> System.out.println("\nAdios");
                default -> System.out.println("\nERROR");
            }
        }
        while(opcion != 9);
    }
    
    /**
     * Comprueba si es un numero int
     * @param message Muestra el mensaje para el JOptionPane
     * @return int
    */
    private static int validarNumEntero(String message) {
        while (true) {
            try {
                return Integer.parseInt(JOptionPane.showInputDialog(message));
            }
            catch (NumberFormatException e) {
                System.out.println("\nIntroduce un numero valido");
            }
        }
    }
    
    /**
     * Comprueba si es un numero double
     * @param message Muestra el mensaje para el JOptionPane
     * @return double
    */
    private static double validarNumDouble(String message) {
        while (true) {
            try {
                return Double.parseDouble(JOptionPane.showInputDialog(message));
            }
            catch (NumberFormatException e) {
                System.out.println("\nIntroduce un numero valido");
            }
        }
    }
    
    /**
     * Comprueba si el array esta vacio o no
     * @param listaArray 
     * @return boolean - true - Si esta vacio 
    */
    private static boolean comprobarArray(ArrayList<Double> listaArray) {
        if (listaArray.isEmpty()) { 
            System.out.println("\nNo hay datos en la lista"); 
            return true; 
        }
        
        return false;
    }
 
    /**
     * Agrega al final del array un nuevo dato de tipo Double
     * @param listaArray
    */
    public static void agregar(ArrayList listaArray) {
        Double numero = validarNumDouble("Introduce el numero que deceas agregar: ");

        listaArray.add(numero);
    }
    
    /**
     * Busca un numero en la lista y lo muestra
     * @param listaArray
    */
    public static void buscar(ArrayList<Double> listaArray) {
       if (comprobarArray(listaArray)) return;

       Double numero = validarNumDouble("Introduce el numero a buscar: ");
       int indice = listaArray.indexOf(numero);

       if (indice != -1) {
           System.out.println("\nEl numero '" + numero + "' esta en la posición " + indice);
       }
       else {
           System.out.println("\nEl numero introducido no esta en la lista");
       }
    }
    
    /**
     * Modifica de la lista el dato con el indice que se le indica
     * @param listaArray 
    */
    public static void modificar(ArrayList listaArray) {
        if (comprobarArray(listaArray)) return;
        
        System.out.println("\n" + listaArray.toString());
        int indice = validarNumEntero("\nIntroduce el índice a modificar: ");
        
        if (indice >= 0 && indice < listaArray.size()) { 
            Double nuevoValor = validarNumDouble("\nIntroduce el nuevo valor: "); 
            
            listaArray.set(indice, nuevoValor); 
        } 
        else { 
            System.out.println("\nNo existe ese índice."); 
        }
    }
    
    /**
     * Elimina de la lista la primera ocurrencia con el valor que le pasemos
     * @param listaArray 
    */
    public static void eliminar(ArrayList listaArray) {
        if (comprobarArray(listaArray)) return;
        
        System.out.println("\n" + listaArray.toString());
        
        Double numero = validarNumDouble("Introduce el numero que deseas eliminar: ");
        boolean removed = listaArray.remove(numero);
        
        System.out.println(!removed ? "\nEl numero introducido no existe en la lista" : "");
    }
    
    /**
     * Insertar un elemento en una lista en un indice indicado
     * @param listaArray
    */
    public static void insertarElemento(ArrayList listaArray) {
        if (comprobarArray(listaArray)) return;
         
        System.out.println("\n" + listaArray.toString());
        int indice = validarNumEntero("\nIntroduce el índice a modificar: ");
        
        if (indice >= 0 && indice <= listaArray.size()) {
            Double nuevoValor = validarNumDouble("\nIntroduce el nuevo valor: "); 

            listaArray.add(indice, nuevoValor);
        }
        else {
            System.out.print("\nNo existe ese indice");
        }
    }
    
    /**
     * Muestra el contenido de la lista en la consola
     * @param listaArray 
    */
    public static void mostrar(ArrayList listaArray) {
        if (comprobarArray(listaArray)) return;
        
        System.out.println("\n" + listaArray.toString());
    }
    
    /**
     * Ordena en forma ascendente el array
     * @param listaArray
    */
    public static void ordenarAscendente(ArrayList listaArray) {
        if (comprobarArray(listaArray)) return;
 
        Collections.sort(listaArray);
        System.out.println("\n" + listaArray);
    }
    
    /**
     * Ordena en forma descendente el array
     * @param listaArray 
    */
    public static void ordenDescendente(ArrayList listaArray) {
        if (comprobarArray(listaArray)) return;
        
        Collections.sort(listaArray, Collections.reverseOrder());
        System.out.println("\n" + listaArray);
    }
}
