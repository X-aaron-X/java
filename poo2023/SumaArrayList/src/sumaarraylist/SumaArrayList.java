package sumaarraylist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Aaron
 */
public class SumaArrayList {
    static ArrayList<Integer> listaArray = new ArrayList<>();

    public static void main(String[] args) {
        leerValores();

        int suma = calcularSuma();
        double media = (double) suma / listaArray.size();

        mostrarResultados(suma, media);
    }

    public static void leerValores() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduce numeros enteros. Para salir (-99)");

        int num;
        
        do {
            num = entrada.nextInt();
            
            if (num != -99) {
                listaArray.add(num);
            }
        } while (num != -99);
    }

    public static int calcularSuma() {
        int suma = 0;
        
        Iterator<Integer> iteratorLista = listaArray.iterator();
        
        while (iteratorLista.hasNext()) {
            suma =  suma + iteratorLista.next();
        }
        
        return suma;
    }

    public static void mostrarResultados(int suma, double media) {
        System.out.println("Numeros de valores leidos: " + listaArray.size());
        System.out.println("La suma es: " + suma);
        System.out.println("La media es: " + media);

        int count = 0;
        for (Integer numero : listaArray) {
            if (numero > media) {
                count++;
            }
        }
        
        System.out.println("Los numeros mayores que la media son: " + count);
    }
}