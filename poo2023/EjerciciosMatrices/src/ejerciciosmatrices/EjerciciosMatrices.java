package ejerciciosmatrices;

import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author Aaron
 */
public class EjerciciosMatrices {

    public static void main(String[] args) {
        //ejercicio1();
        //ejercicio2();
        //ejercicio3();
        //ejercicio4();
        //ejercicio5();
        //ejercicio6();
        //ejercicio7();
        //ejercicio7V2();
        ejercicio7ConArrayList();
    }
    
    public static void ejercicio1() {
        float[] notas = {5.8f ,6.2f, 7.1f, 5.9f, 3.6f, 9.9f, 1.2f, 10.0f, 4.6f, 5.0f};
        String[] nombres = {"Pedro", "Ana", "Luis", "Luis", "Juan", "Eva", "Mari", "Fran", "Luz", "Sol"};
        
        int notasAprobados = 0;
        String nombreAprobados = "";

        for (int i = 0; i < notas.length; i++) {
            System.out.println(nombres[i] + ": " + notas[i]);
            
            if (notas[i] >= 5) {
               notasAprobados++;
               nombreAprobados += nombres[i] + " ";
           }
        }
 
//        for(float nota : notas) {
//           System.out.println(nota);
//        }

        System.out.println("\nAprobados: " + notasAprobados);
        System.out.println("Aprobados: " + nombreAprobados);
    }
    
    // Crea un array de números de 100 posiciones, que contendrá los números del 1 al 100. Obtén la suma de todos ellos y la media
    public static void ejercicio2() {
        int suma = 0;
        double media;
        int numeros[] = new int[100];
        
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = i + 1;
        
            suma += numeros[i];
        }
        
        media = (double)suma / numeros.length;
        
        System.out.println("La suma es: " + suma);
        System.out.println("La media es: " + media);
    }
    
    // Escribe una función que pida una frase, la convierta en una matriz de char y luego imprima esa matriz de char desde el final hacia el principio
    public static void ejercicio3() {
        String frase;
        
        frase = JOptionPane.showInputDialog("Introduce una palabra para ver sus caracteres:");
        
        char[] caracteres = frase.toCharArray();
        
        for (int i = 0; i < caracteres.length; i++) {
            System.out.println(caracteres[i]);
        }
    }
    
    // Pedir un número de alumnos y a partir de ahí pedir también nombre y nota de cada uno de ellos, almacenando cada lista en una matriz distinta. 
    // Una vez leídos los datos los mostrará los datos
    public static void ejercicio4() {
        int alumnos;
        String texto;

        do {
            texto = JOptionPane.showInputDialog("Introduce el número de alumnos tiene que ser un numero mayor que 0:");
            alumnos = Integer.parseInt(texto);
            
        } while (alumnos <= 0);
        
        String nombres[] = new String[alumnos];
        float notas[] = new float[alumnos];
        
        for (int i = 0; i < alumnos; i++) {
            texto = JOptionPane.showInputDialog("Introduce el nombre del " + (i + 1) + " alumno:");
            nombres[i] = texto;

            texto = JOptionPane.showInputDialog("Introduce la nota del alumno " + nombres[i] + ":");
            notas[i] = Float.parseFloat(texto);
        }
        
        for (int i = 0; i < alumnos; i++) {
            System.out.println("El alumno " + nombres[i] + " ha sacado una nota de " + notas[i]);
        }
    }
    
    // Crea una aplicación que pida un numero por teclado y después comprobaremos si el numero introducido es capicúa, es decir, 
    // que se lee igual sin importar la dirección. Por ejemplo, si introducimos 30303 es capicúa, si introducimos 30430 no es capicúa
    public static void ejercicio5() {
        int num;
        String texto;
        
        texto = JOptionPane.showInputDialog("Introduce un numero para saber si es capicua:");
        num = Integer.parseInt(texto);
        
        int numeroReverso = 0;
        int numeroOriginal = num;

        while (num > 0) {
            int digito = num % 10;
            
            numeroReverso = numeroReverso * 10 + digito;
            
            num /= 10;
        }

        if (numeroOriginal == numeroReverso) {
            System.out.println("Es capicua");
        }
        else {
            System.out.println("No es capicua");
        }
    }
    
    // Haz un programa que lea una frase por teclado y una vocal, y diga cuantas veces aparece dicha letra en la frase introducida     
    public static void ejercicio6() {
        String frase, textoVocal;
        int cont = 0;
        char vocal;
        
        frase = JOptionPane.showInputDialog("Introduce una frase: ").toLowerCase();

        textoVocal = JOptionPane.showInputDialog("Introduce una vocal: ").toLowerCase();
        vocal = textoVocal.charAt(0);
        
        for (int i = 0; i < frase.length(); i++) {
            if (frase.charAt(i) == vocal) {
                cont++;
            }
        }
        
        System.out.println("La frase es: " + frase);
        System.out.println("La vocal \"" + vocal + "\" aparece: " + cont);
    }
    
    // Escribe un programa que pida un tamaño de array y lo genere automáticamente. Luego pedirá otro número al usuario 
    // y lo sustituya por un cero en todo el array. El programa debe mostrar por pantalla el valor borrado, 
    // el número de veces que aparece ese valor, el array inicial y el array final
    public static void ejercicio7() {
        int cont = 0, i;
        
        String texto = JOptionPane.showInputDialog("Introduce el tamaño del array: ");
        int numArray = Integer.parseInt(texto);
        
        int[] arrayFinal = new int[numArray];
        int[] arrayInicial = new int[arrayFinal.length];
        
        for (i = 0; i < arrayFinal.length; i++) {   
            arrayFinal[i] = (int)Math.floor(Math.random() * 10 + 1);
            arrayInicial[i] = arrayFinal[i];
        }
        
//        i = 0;
//        for (int array : arrayFinal) {
//            arrayFinal[i] = (int)Math.floor(Math.random() * 10 + 1);
//            arrayFinal[i] = arrayFinal[i];
//            i++;
//        }

        System.out.println("Elige que numero quieres convertir a 0: " + Arrays.toString(arrayFinal));
        
        texto = JOptionPane.showInputDialog("Introduce un número para reemplazar por cero: ");
        int num = Integer.parseInt(texto);
       
        for (i = 0; i < arrayFinal.length; i++) {
            if (arrayFinal[i] == num) {
                arrayFinal[i] = 0;
                cont++;
            }
        }
        
//        i = 0;
//        for (int array : arrayFinal) {
//            if (arrayFinal[i] == num) {
//                arrayFinal[i] = 0;
//                cont++;
//            }
//            i++;
//        }
        
        System.out.println("Numero borrado: " + num);
        System.out.println("Veces que aparece el numero borrado: " + cont);
        System.out.println("El array inicial es: " + Arrays.toString(arrayInicial));  
        System.out.println("El array final es: " + Arrays.toString(arrayFinal));  
    }
    
    // Escribe un programa que pida un tamaño de array y lo genere automáticamente. Luego pedirá otro número al usuario 
    // y lo sustituya por un cero en todo el array. El programa debe mostrar por pantalla el valor borrado, 
    // el número de veces que aparece ese valor, el array inicial y el array final
    // El un nuevo array los valores que no se han eliminado osea quitar los 0
    public static void ejercicio7V2() {
        int cont = 0, i;
        
        String texto = JOptionPane.showInputDialog("Introduce el tamaño del array: ");
        int numArray = Integer.parseInt(texto);
        
        int[] arrayFinal = new int[numArray];
        int[] arrayInicial = new int[arrayFinal.length];
        
        for (i = 0; i < arrayFinal.length; i++) {   
            arrayFinal[i] = (int)Math.floor(Math.random() * 9 + 1);
            arrayInicial[i] = arrayFinal[i];
        }

        System.out.println("Elige que numero quieres convertir a 0: " + Arrays.toString(arrayFinal));
        
        texto = JOptionPane.showInputDialog("Introduce un número para reemplazar por cero: ");
        int num = Integer.parseInt(texto);
       
        for (i = 0; i < arrayFinal.length; i++) {
            if (arrayFinal[i] == num) {
                arrayFinal[i] = 0;
                cont++;
            }
        }
        
        // Queremos construir un nuevo array con los valores que no se han eliminado osea quitar los 0
        int[] arrayAcortado = new int[numArray - cont];
        int indiceAcortado = 0;
        
        for (i = 0; i < arrayInicial.length; i++) {
            if (arrayFinal[i] != 0) {
                arrayAcortado[indiceAcortado] = arrayInicial[i]; 
                indiceAcortado++;
            }
        }

        System.out.println("Numero borrado: " + num);
        System.out.println("Veces que aparece el numero borrado: " + cont);
        System.out.println(Arrays.toString(arrayInicial));  
        System.out.println(Arrays.toString(arrayFinal));
        System.out.println(Arrays.toString(arrayAcortado));   
    }
    
    public static void ejercicio7ConArrayList() {
        int cont = 0, i;
        
        String texto = JOptionPane.showInputDialog("Introduce el tamaño del array: ");
        int numArray = Integer.parseInt(texto);
        
        ArrayList<Integer> arrayOriginal = new ArrayList<Integer>();
        
        for (i = 0; i < numArray; i++) {
            arrayOriginal.add((int)Math.floor(Math.random() * 9 + 1));
        }
        
        System.out.println(arrayOriginal.toString());
        ArrayList<Integer> nuevoArray = new ArrayList<Integer>(arrayOriginal);
        
        texto = JOptionPane.showInputDialog("Introduce un número para reemplazar por cero: ");
        int numRemplazar = Integer.parseInt(texto);
        
        for (i = 0; i < numArray; i++) {
            if (nuevoArray.get(i) == numRemplazar) { 
                nuevoArray.set(i, 0);
                cont++;
            }
        }
        
        ArrayList<Integer> arrayAcortado = new ArrayList<Integer>();
        
        for (Integer valor : nuevoArray) {
            if (valor != 0) {
                arrayAcortado.add(valor);
            }
        }
        
        System.out.println("Numero borrado: " + numRemplazar);
        System.out.println("Veces que aparece el numero borrado: " + cont);
        System.out.println(arrayOriginal.toString());
        System.out.println(nuevoArray.toString());
        System.out.println(arrayAcortado.toString());
    }
}
