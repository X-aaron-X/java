package ejerciciosiniciales;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Aaron
 */
public class EjerciciosIniciales {
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
                System.out.println("Introduce un numero valido");
            }
        }
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
                System.out.println("Introduce un numero valido");
            }
        }
    }
    

    public static void main(String[] args) {
        //ejercicio1();
        //ejercicio5();
        //ejercicio7();
        //ejercicio11();
        //ejercicio12();
        //ejercicio13();
        //ejercicio14();
        //ejercicio15();
        //ejercicio16();
        //ejercicio17();
        //ejercicio18();
        //ejercicio19();
        //ejercicio20();
        //ejercicio21();
        //ejercicio22();
        //ejercicio23();
        ejercicio24();
    }
    
    /**
     * Pide al usuario dos variables num�ricas, muestra por consola la suma, resta, multiplicaci�n, 
     * divisi�n y m�dulo (resto de la divisi�n)
    */
    public static void ejercicio1 () {        
        int num1 = validarNumEntero("Introduce el primer numero:");
        int num2 = validarNumEntero("Introduce el segundo numero:");

        System.out.println("Suma: " + (num1 + num2));
        System.out.println("Resta: " + (num1 - num2));
        System.out.println("Multiplicacion: " + (num1 * num2));

        if (num2 != 0) {
            System.out.println("Vivision: " + (num1 / num2));
            System.out.println("Modulo: " + (num1 % num2));
        }
        else {
            System.out.println("No se puede dividir entre 0");
        }
    }    
    /**
     * Haz una aplicaci�n que calcule el �rea de un c�rculo(pi*R2). 
     * El radio se pedir� por teclado (recuerda que necesitamos un dato de tipo double). 
     * Usa la constante PI y el m�todo pow de Math 
    */
    public static void ejercicio5 () {
        double radio = validarNumDouble("Introduce el radio del c�rculo:");      
        double area = Math.PI * Math.pow(radio, 2);
        
        System.out.println(String.format("El �rea del c�rculo es: %.2f", area));
    }
    
    /**
     * Lee un n�mero por teclado que pida el precio de un producto (puede tener decimales) 
     * y calcule el precio final con IVA. El IVA ser� una constante que ser� del 21%.
    */
    public static void ejercicio7 () {
        final double IVA = 0.21;

        double precio = validarNumDouble("Introduce el precio del producto:");
        double precioFinal = precio + (precio * IVA);

        System.out.println(String.format("El precio final es: %.2f", precioFinal));
    }
    
    /**
     *  Muestra los n�meros del 1 al 100 (ambos incluidos) divisibles entre 2 y 3. Utiliza el bucle que desees 
    */
    public static void ejercicio11 () {
        for (int i = 6; i <= 100; i += 6) {
            System.out.println(i);
        }
    }
    
    /**
     * Realiza una aplicaci�n que nos pida un n�mero de ventas a introducir, 
     * despu�s nos pedir� tantas ventas por teclado como n�mero de ventas se hayan indicado. 
     * Al final mostrara la suma de todas las ventas 
    */
    public static void ejercicio12 () {
        int numVentas = validarNumEntero("Introduce el numero de ventas:");
        int sumaVentas = 0, venta;
        
        for (int i = 0; i < numVentas; i++) {
            venta = validarNumEntero("Introduce la venta " + (i + 1) + ":");
            sumaVentas += venta;
        }
        
         System.out.println("La suma total de las ventas es: " + sumaVentas);
    }
    
    /**
     * Realiza una aplicaci�n que nos calcule una ecuaci�n de segundo grado. 
     * Debes pedir las variables a, b y c por teclado y comprobar antes que el discriminante (operaci�n en la ra�z cuadrada). 
     * Para la ra�z cuadrada usa el m�todo sqlrt de Math. Te recomiendo que uses mensajes de traza. 
    */
    public static void ejercicio13 () {
       double discriminante; 
       
       double a = validarNumDouble("Introduce el valor de a:");
       double b = validarNumDouble("Introduce el valor de b:");
       double c = validarNumDouble("Introduce el valor de c:");
       
       discriminante = Math.pow(b, 2) - 4 * a * c;
       System.out.println("Discriminante: " + discriminante);
       
        if (discriminante < 0) {
            System.out.println("No tiene valor real");
        }
        else {
            double x1 = (-b + Math.sqrt(discriminante)) / (2 * a);
            double x2 = (-b - Math.sqrt(discriminante)) / (2 * a);
            
            System.out.println("x1: " + x1);
            System.out.println("x2: " + x2);
        }
    }
    
    /**
     * Lee un n�mero por teclado y comprueba que este n�mero es mayor o igual que cero, 
     * si no lo es lo volver� a pedir, despu�s muestra ese n�mero por consola. 
    */
    public static void ejercicio14 () {
       int numero = 0;

        while (numero <= 0) {
            numero = validarNumEntero("Introduce un numero mayor o igual que cero:");
        }

        System.out.println("El numero introducido es: " + numero);
    }
    
    /**
     * Escribe una aplicaci�n con un String que contenga una contrase�a cualquiera. 
     * Despu�s se te pedir� que introduzcas la contrase�a, con 3 intentos. 
     * Cuando aciertes ya no pedir� m�s la contrase�a y mostrar� un mensaje diciendo ?Enhorabuena?. 
     * Piensa bien en la condici�n de salida (3 intentos y si acierta sale, aunque le queden intentos). 
    */
    public static void ejercicio15() {
        final String CONTRASENACORRECTA = "1234";
        String contrasena;
        int intentos = 3;
        boolean acertado = false;

        while (intentos > 0 && !acertado) {
            contrasena = JOptionPane.showInputDialog("Introduce la contrase�a:");
            
            if (contrasena.equals(CONTRASENACORRECTA)) {
                System.out.println("Enhorabuena");
                acertado = true;
            }
            else {
                intentos--;
                System.out.println("Contrase�a incorrecta tienes " + intentos + " intentos");
            }
        }

        if (!acertado) {
            System.out.println("Perdedor");
        }
    }
    
    /**
     * Crea una aplicaci�n que nos pida un d�a de la semana y que nos diga si es un d�a laboral o no. 
     * Si el d�a no se reconoce, mostrar el mensaje ?D�a incorrecto?. Usa un switch para ello.             
    */
    public static void ejercicio16() {
        int dia = validarNumEntero("Introduce el dia de la semana (numerico):");

        switch (dia) {
            case 1, 2, 3, 4, 5 -> System.out.println("Es laboral");
            case 6, 7 -> System.out.println("No es laboral");
            default -> System.out.println("D�a incorrecto");
        }
    }
    
    /**
     * Introducir 2 n�meros por teclado y luego un car�cter indicando la operaci�n a realizar (+,-,*,/) 
     * y devolver el resultado de la operaci�n, utilizando un switch 
    */
    public static void ejercicio17() {
        char operacion;
        int resultado = 0;
        int num1 = validarNumEntero("Introduce el primer n�mero:");
        int num2 = validarNumEntero("Introduce el segundo n�mero:");
        boolean operacionValida = false;
            
        while (!operacionValida) {
            operacion = JOptionPane.showInputDialog("Introduce la operacion a realizar (+, -, *, /):").charAt(0);

            switch (operacion) {
                case '+':
                    resultado = num1 + num2;
                    operacionValida = true;
                    break;
                case '-':
                    resultado = num1 - num2;
                    operacionValida = true;
                    break;
                case '*':
                    resultado = num1 * num2;
                    operacionValida = true;
                    break;
                case '/':
                    if (num2 == 0) {
                        System.out.println("No se puede dividir entre 0");
                    }
                    else {
                        resultado = num1 / num2;
                        operacionValida = true;
                    }
                    break;
                default:
                    System.out.println("Opcion incorrecta");
            }
        }

        System.out.println(resultado);
    }
    
    /**
     * Realice un programa que genere un n�mero entero entre el 1 y el 10. 
     * El usuario deber� introducir un n�mero hasta acertarlo, cuando eso ocurra aparecer� un mensaje de "Eureka" y mostrar� el n�mero de intentos.
    */
    public static void ejercicio18() {
        Random random = new Random();
        int numeroAleatorio = random.nextInt(10) + 1;
        int intentos = 0, numeroUsuario;
        boolean acertado = false;
        
        while (!acertado) {
            intentos++;
            
            numeroUsuario = validarNumEntero("Introduce un n�mero entre 1 y 10:");
           
            if (numeroUsuario == numeroAleatorio) {
                System.out.println("�Eureka!");
                System.out.println("Intentos: " + intentos);
                acertado = true;
            }
        }
    }
    
    /**
     * Piensa un n�mero entre 1 y 10. Ahora el ordenador generar� aleatoriamente n�meros en ese intervalo y te lo mostrar�. 
     * Te preguntar� si ha acertado y contestar�s con "s" o "n" en funci�n de si ha acertado o no. 
     * Finalmente mostrar�s el n�mero y el n�mero de intentos. 
    */
    public static void ejercicio19() {
        Random random = new Random();
        boolean acertado = false;
        int intentos = 0;
        int numeroAleatorio;
        String respuesta;
        
        System.out.println("Piensa en un numero entre 1 y 10");

        while (!acertado) {
            intentos++;
            numeroAleatorio = random.nextInt(10) + 1;

            respuesta = JOptionPane.showInputDialog("Es " + numeroAleatorio + "? (s/n)");

            if (respuesta.equalsIgnoreCase("s")) {
                System.out.println("�Eureka!");
                System.out.println("Intentos: " + intentos);
                acertado = true;
            }
        }
    }
    
    /**
     * Realiza un programa en Java al que le introduzcas 10 n�meros por teclado, 
     * cuente el n�mero de n�meros positivos, el n�mero de n�meros negativos y realice la suma de todos ellos 
    */
    public static void ejercicio20() {
        int positivos = 0, negativos = 0, suma = 0, numero;

        for (int i = 0; i < 10; i++) {
            numero = validarNumEntero("Introduce un numero " + (i + 1) + ":");
            
            if (numero > 0) {
                positivos++;
            }
            else if (numero < 0) {
                negativos++;
            }
            
            suma += numero;
        }
        
        System.out.println("Numeros positivos: " + positivos);
        System.out.println("Numeros negativos: " + negativos);
        System.out.println("Suma total: " + suma);
    }
    
    /**
     * Escribir un programa en Java que lea un n�mero entero por el teclado e imprima todos los n�meros impares menores que �l
    */
    public static void ejercicio21() {
        int numero = validarNumEntero("Introduce un numero entero:");
        
        for (int i = 1; i < numero; i++) {
            if (i % 2 != 0) {
                System.out.println(i);
            }
        }
    }
    
    /**
     * Haz un programa que pida un n�mero de cuenta de veinte d�gitos y muestre por pantalla la siguiente informaci�n: 
     * C�digo del Banco, C�digo de la oficina, D�gitos de control y n�mero de cuenta. 
     * Se debe comprobar que haya introducido el n�mero correcto de d�gitos. 
     * (Necesitaras utilizar dos m�todos de la clase String: lenght y substring.)   
    */
    public static void ejercicio22() {
        String numeroCuenta = "";

        while (numeroCuenta.length() != 20) {
            numeroCuenta = JOptionPane.showInputDialog("Introduce un numero de cuenta de 20 d�gitos:");
        }

        String codigoBanco = numeroCuenta.substring(0, 4);
        String codigoOficina = numeroCuenta.substring(4, 8);
        String digitosControl = numeroCuenta.substring(8, 10);
        String numeroCuentaRestante = numeroCuenta.substring(10);
        
        System.out.println("Codigo del banco: " + codigoBanco);
        System.out.println("Codigo de la oficina: " + codigoOficina);
        System.out.println("Digitos de control: " + digitosControl);
        System.out.println("Numero de cuenta: " + numeroCuentaRestante);
    }
    
    /**
     * Pedir n�meros al usuario y cuando el usuario meta un -1 se terminar� el programa. Al terminar, mostrar� lo siguiente:
     *  - mayor numero introducido
     *  - menor numero introducido
     *  - suma de todos los numeros
     *  - suma de los numeros positivos
     *  - suma de los numeros negativos
     *  
     *   El n�mero -1 no contara para ning�n c�lculo, �nicamente para terminar el programa
    */
    public static void ejercicio23() {
        int mayor = 0, menor = 0, sumaTotal = 0, sumaPositivos = 0, sumaNegativos = 0;
        boolean continuar = true;
        
        while (continuar) {
            int numero = validarNumEntero("Introduce un numero (-1 para terminar):");

            if (numero == -1) {
                continuar = false;
            }
            else {
                mayor = (numero > mayor) ? numero : mayor;
                menor = (numero < menor) ? numero : menor;
 
                sumaTotal += numero;
                
                sumaPositivos += (numero > 0) ? numero : 0;
                sumaNegativos += (numero <= 0) ? numero : 0;
            }
        }
        
        System.out.println("Numero mayor introducido: " + mayor);
        System.out.println("Numero menor introducido: " + menor);
        System.out.println("Suma de todos los numeros: " + sumaTotal);
        System.out.println("Suma positivos: " + sumaPositivos);
        System.out.println("Suma negativos: " + sumaNegativos);
    }
    
    /**
     * Pide un n�mero por teclado e imprime todos los n�meros primos que existen entre 1 el n�mero introducido
    */
    public static void ejercicio24() {
        int numero = validarNumEntero("Introduce un numero:");
        
        for (int i = 2; i <= numero; i++) {
            if (esPrimo(i)) {
                System.out.println(i);
            }
        }
    }
    
    
    /**
     * Verifica si un n�mero es primo.
     * 
     * @param numero
     * @return boolean
     */
    public static boolean esPrimo(int numero) {
        if (numero == 2) {
            return true;
        }
        
        if (numero <= 1 || (numero != 2 && numero % 2 == 0)) {
            return false;
        }

        for (int i = 3; i <= Math.sqrt(numero); i += 2) {
            if (numero % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}
