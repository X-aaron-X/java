package ejerciciosvarios;

import javax.swing.JOptionPane;

/**
 *
 * @author Aaron
*/
public class EjerciciosVarios {
    
    public static void main(String[] args) {
        // pedirDosNumeros();
        // areaCuadrado();
        // promedioDiez();
        // parImpar();
        // hastaCero();
        // bisiesto();
        // asteriscos();
        // primos();
        primoshastaN();
    }
    
    // Pide 2 variables enteras al usuario e indica cual es mayor de las dos. Si son iguales indicarlo tambien. 
    public static void pedirDosNumeros() {
        int num, num2;
        String texto;
  
        texto = JOptionPane.showInputDialog("Introduce un numero entero");
        num = Integer.parseInt(texto);

        texto = JOptionPane.showInputDialog("Introduce otro numero entero");
        num2 = Integer.parseInt(texto);
        
        if (num > num2) {
            System.out.println("El numero " + num + " es mayor");
        }
        else if (num2 > num) {
            System.out.println("El numero " + num2 + " es mayor");
        }
        else {
            System.out.println("Los numeros son iguales " + num + " = " + num2);
        }
    }
    
    // Algoritmo que lea el lado de un cuadrado y me calcule su área
    public static void areaCuadrado() {
        int lado;
        String texto;
        
        texto = JOptionPane.showInputDialog("Introduce el lado del cuadrado");
        lado = Integer.parseInt(texto);
        
        System.out.println("El area del cuadrado es: " + lado * lado);
    }
    
    // Algoritmo que genere diez numeros aletorios entre 1 y el 100, los imprima y muestre su promedio
    public static void promedioDiez() {
        int numeroAletorio, suma = 0;
        double promedio;
        
        for (int i = 0; i < 10; i++) {
            numeroAletorio =(int)Math.floor(Math.random() * 100 + 1);
            
            System.out.println(numeroAletorio);
            suma = suma + numeroAletorio;
        }
        
        promedio = (double)suma / 10;
        System.out.println("El promedio de los numeros mostrados es: " + promedio);
    }
    
    // Desarrolle un algoritmo que permita leer un valor cualquiera N y escriba si dicho número es par o impar
    public static void parImpar() {
        int num;
        String texto;
        
        texto = JOptionPane.showInputDialog("Introduce número para saber si es par o impar");
        num = Integer.parseInt(texto);
        
        if (num % 2 == 0) {
            System.out.println("El numero " + num + " es par");
        }
        else {
            System.out.println("El numero " + num + " es impar");
        }
    }
    
    // Escribe un algoritmo que pida números hasta que el usuario introduzca un 0. Cuando lo haga muestra el número total de 
    // números introducidos, el mayor, el menor y su promedio
    public static void hastaCero() {
        int num = 0, cont = 0, numMayor = 0, numMenor = 0, suma = 0;
        String texto;
        
        do {
            texto = JOptionPane.showInputDialog("Introduce un numero:");
            num = Integer.parseInt(texto);
            
            if (num >= 0) {
                cont++;
                suma = suma + num;
                numMayor = Math.max(numMayor, num);
                
               if (num != 0) {
                   numMenor = Math.min(numMenor, num);
               }
            }
            else {
                System.out.println("No puedes introducir numeros negativos");
            }      
            
        } while(num != 0);
        
        if (cont > 0) {
            System.out.println("Ha introducido en total " + cont + " de números");
            System.out.println("El numero mayor es " + numMayor);
            System.out.println("El numero menor es " + numMenor);
            System.out.println("El promedio es: " + (double) suma / cont);
        }
        else {
            System.out.println("No has introducido ningun numero");
        }
        
    }
    
    // Algoritmo que, dado un año, nos diga si es bisiesto o no. Un año es bisiesto bajo las siguientes condiciones:
    // a. Un año divisible por 4 es bisiesto y no debe ser divisible entre 100.
    // b. Si un año es divisible entre 100 y además es divisible entre 400, también resulta bisiesto.
    public static void bisiesto() {
        int year;
        String texto;
        
        texto = JOptionPane.showInputDialog("Introduzca el año:");
        year = Integer.parseInt(texto);
        
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            System.out.println("El año " + year + " es bisiesto");
        }
        else {
            System.out.println("El año " + year + " no es bisiesto");
        }
    }
    
    // Algoritmo que lea un numero entero (altura) y a partir de el cree una escalera invertida de asteriscos con esa altura.
    // Por ejemplo, si tenemos una altura de 5, la salida sera la siguiente
    // *****
    // ****
    // ***
    // **
    // *
    public static void asteriscos() {
        int asteriscos;
        String texto;
        
        texto = JOptionPane.showInputDialog("Introduzca el numero de asteriscos:");
        asteriscos = Integer.parseInt(texto);
        
       for (int i = asteriscos; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            
            System.out.println();
        }
    }
    
    // Algoritmo que, introducido un número, me muestre todos sus divisores y en caso de que primo, que lo indique al final del programa
    public static void primos() {
        int num = 0, divisor = 1;
        String texto;
        
        do {
            texto = JOptionPane.showInputDialog("Introduce un número mayor que 0:");
            num = Integer.parseInt(texto);
            
        } while(num <= 0);
        
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                System.out.println(i);
                divisor = divisor + 1;
            }
        }
        
        if (divisor == 2) {
            System.out.println("El número " + num + " es primo");
        }
        else {
            System.out.println("El número " + num + " no es primo");
        }
    }
    
    // Programa que pida un numero al usuario y muestre en en pantalla los numeros primos entre 1 y ese numero.
    // Para saber el numero primo utiliza una funcion
    public static void primoshastaN() {
        int num;
        String texto;
        
        do {
            texto = JOptionPane.showInputDialog("Introduce un numero mayor que 1");
            num = Integer.parseInt(texto);

            if (num <= 1) {
                System.out.println("No puedes introducir numeros menores o iguales que 1");
            }
            else {
                for (int i = 2; i <= num; i++) {
                    if (esPrimo(i)) {
                        System.out.println(i);
                    }
                }
            }
            
        } while(num <= 1);
    }
    
    public static boolean esPrimo(int num) {  
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}
