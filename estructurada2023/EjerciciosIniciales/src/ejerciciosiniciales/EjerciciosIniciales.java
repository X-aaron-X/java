package ejerciciosiniciales;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Aaron
 */
public class EjerciciosIniciales {

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
     * Pide al usuario dos variables numéricas, muestra por consola la suma, resta, multiplicación, división y módulo (resto de la división)
    */
    public static void ejercicio1 () {
        try {
            int num1 = Integer.parseInt(JOptionPane.showInputDialog("Introduce un número:"));
            int num2 = Integer.parseInt(JOptionPane.showInputDialog("Introduce un número:"));

            System.out.println("Suma: " + (num1 + num2));
            System.out.println("Resta: " + (num1 - num2));
            System.out.println("Multiplicación: " + (num1 * num2));
            System.out.println("División: " + (num1 / num2));
            System.out.println("Módulo: " + (num1 % num2));
        }
        catch (NumberFormatException e) {
            System.out.println("Introduce un numero");
        }
        catch (ArithmeticException e) {
            System.out.println("Error en la division");
        }
    }
    
    /**
     * Haz una aplicación que calcule el área de un círculo(pi*R2). 
     * El radio se pedirá por teclado (recuerda que necesitamos un dato de tipo double). 
     * Usa la constante PI y el método pow de Math 
    */
    public static void ejercicio5 () {
        try {
            double radio = Double.parseDouble(JOptionPane.showInputDialog("Introduce el radio del círculo:"));
            double area = Math.PI * Math.pow(radio, 2);

            System.out.println(String.format("El área del círculo es: %.2f", area));
        }
        catch (NumberFormatException e) {
            System.out.println("Introduce un numero");
        }
    }
    
    /**
     * Lee un número por teclado que pida el precio de un producto (puede tener decimales) 
     * y calcule el precio final con IVA. El IVA será una constante que será del 21%.
    */
    public static void ejercicio7 () {
        final double IVA = 0.21;
        
        try {
            double precio = Double.parseDouble(JOptionPane.showInputDialog("Introduce el precio del producto:"));
            double precioFinal = precio + (precio * IVA);
            
             System.out.println(String.format("El precio final con IVA es: %.2f", precioFinal));
        }
        catch (NumberFormatException e) {
            System.out.println("Introduce un numero");
        }
    }
    
    /**
     *  Muestra los números del 1 al 100 (ambos incluidos) divisibles entre 2 y 3. Utiliza el bucle que desees 
    */
    public static void ejercicio11 () {
        for (int i = 6; i <= 100; i += 6) {
            System.out.println(i);
        }
    }
    
    /**
     * Realiza una aplicación que nos pida un número de ventas a introducir, 
     * después nos pedirá tantas ventas por teclado como número de ventas se hayan indicado. 
     * Al final mostrara la suma de todas las ventas 
    */
    public static void ejercicio12 () {
        try {
            int sumaVentas = 0;
            
            int numVentas = Integer.parseInt(JOptionPane.showInputDialog("Introduce el número de ventas:"));
            
            for (int i = 0; i < numVentas; i++) {
                int venta = Integer.parseInt(JOptionPane.showInputDialog("Introduce la venta " + (i + 1) + ":")); 
                sumaVentas += venta;
            }
            
            System.out.println("La suma total de las ventas es: " + sumaVentas); 
        }
        catch (NumberFormatException e) {
            System.out.println("Introduce un numero");
        }
    }
    
    /**
     * Realiza una aplicación que nos calcule una ecuación de segundo grado. 
     * Debes pedir las variables a, b y c por teclado y comprobar antes que el discriminante (operación en la raíz cuadrada). 
     * Para la raíz cuadrada usa el método sqlrt de Math. Te recomiendo que uses mensajes de traza. 
    */
    public static void ejercicio13 () {
        try {
            double a = Double.parseDouble(JOptionPane.showInputDialog("Introduce el valor de a:"));
            double b = Double.parseDouble(JOptionPane.showInputDialog("Introduce el valor de b:"));
            double c = Double.parseDouble(JOptionPane.showInputDialog("Introduce el valor de c:"));
            
            double discriminante = Math.pow(b, 2) - 4 * a * c;
            
            if (discriminante < 0) {
                System.out.println("La ecuación no tiene soluciones reales");
            }
            else {
                double x1 = (-b + Math.sqrt(discriminante)) / (2 * a);
                double x2 = (-b - Math.sqrt(discriminante)) / (2 * a);
                
                System.out.println("Solución x1: " + x1);
                System.out.println("Solución x2: " + x2);
            }
        }
        catch (NumberFormatException e) {
            System.out.println("Introduce un numero");
        }
    }
    
    /**
     * Lee un número por teclado y comprueba que este número es mayor o igual que cero, 
     * si no lo es lo volverá a pedir, después muestra ese número por consola. 
    */
    public static void ejercicio14 () {
       int numero = 0;

        while (numero <= 0) {
            try {
                numero = Integer.parseInt(JOptionPane.showInputDialog("Introduce un número mayor o igual que cero:"));
            }
            catch (NumberFormatException e) {
                System.out.println("Introduce un numero");
            }
        }

        System.out.println("El número introducido es: " + numero);
    }
    
    /**
     * Escribe una aplicación con un String que contenga una contraseña cualquiera. 
     * Después se te pedirá que introduzcas la contraseña, con 3 intentos. 
     * Cuando aciertes ya no pedirá más la contraseña y mostrará un mensaje diciendo ?Enhorabuena?. 
     * Piensa bien en la condición de salida (3 intentos y si acierta sale, aunque le queden intentos). 
    */
    public static void ejercicio15() {
        String contrasenaCorrecta = "1234";
        String contrasena = "";
        int intentos = 3;
        boolean acertado = false;

        while (intentos > 0 && !acertado) {
            contrasena = JOptionPane.showInputDialog("Introduce la contraseña:");
            
            if (contrasena.equals(contrasenaCorrecta)) {
                System.out.println("Enhorabuena");
                acertado = true;
            }
            else {
                intentos--;
                System.out.println("Contraseña incorrecta tienes " + intentos + " intentos");
            }
        }

        if (!acertado) {
            System.out.println("Perdedor");
        }
    }
    
    /**
     * Crea una aplicación que nos pida un día de la semana y que nos diga si es un día laboral o no. 
     * Si el día no se reconoce, mostrar el mensaje ?Día incorrecto?. Usa un switch para ello.             
    */
    public static void ejercicio16() {
        try {
            int dia = Integer.parseInt(JOptionPane.showInputDialog("Introduce el dia de la semana (numerico):"));

            switch (dia) {
                case 1, 2, 3, 4, 5 -> System.out.println("Es laboral");
                case 6, 7 -> System.out.println("No es laboral");
                default -> System.out.println("Día incorrecto");
            }
        }
        catch (NumberFormatException e) {
            System.out.println("Introduce un numero");
        }
    }
    
    /**
     * Introducir 2 números por teclado y luego un carácter indicando la operación a realizar (+,-,*,/) 
     * y devolver el resultado de la operación, utilizando un switch 
    */
    public static void ejercicio17() {
        try {
            int resultado = 0;
            int num1 = Integer.parseInt(JOptionPane.showInputDialog("Introduce el primer número:"));
            int num2 = Integer.parseInt(JOptionPane.showInputDialog("Introduce el segundo número:"));
            char operacion;
            boolean operacionValida = false;

            while (!operacionValida) {
                operacion = JOptionPane.showInputDialog("Introduce la operación a realizar (+, -, *, /):").charAt(0);

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
                        } else {
                            resultado = num1 / num2;
                            operacionValida = true;
                        }
                        break;
                    default:
                        System.out.println("Opción incorrecta");
                }
            }

            System.out.println(resultado);
        }
        catch (NumberFormatException e) {
            System.out.println("Introduce un numero");
        }
    }
    
    /**
     * Realice un programa que genere un número entero entre el 1 y el 10. 
     * El usuario deberá introducir un número hasta acertarlo, cuando eso ocurra aparecerá un mensaje de "Eureka" y mostrará el número de intentos.
    */
    public static void ejercicio18() {
        Random random = new Random();
        int numeroAleatorio = random.nextInt(10) + 1;
        int intentos = 0;
        boolean acertado = false;

        while (!acertado) {
            try {
                 int numeroUsuario = Integer.parseInt(JOptionPane.showInputDialog("Introduce un número entre 1 y 10:"));
                intentos++;

                if (numeroUsuario == numeroAleatorio) {
                    System.out.println("¡Eureka!");
                    System.out.println("Intentos: " + intentos);
                    acertado = true;
                }
            }
            catch (NumberFormatException e) {
                System.out.println("Introduce un numero");
            }
        }
    }
    
    /**
     * Piensa un número entre 1 y 10. Ahora el ordenador generará aleatoriamente números en ese intervalo y te lo mostrará. 
     * Te preguntará si ha acertado y contestarás con "s" o "n" en función de si ha acertado o no. 
     * Finalmente mostrarás el número y el número de intentos. 
    */
    public static void ejercicio19() {
        Random random = new Random();
        boolean acertado = false;
        int intentos = 0;
        int numeroAleatorio;
        
        System.out.println("Piensa en un número entre 1 y 10");

        while (!acertado) {
            try {
                numeroAleatorio = random.nextInt(10) + 1;
                intentos++;

                String respuesta = JOptionPane.showInputDialog("¿Es " + numeroAleatorio + "? (s/n)");

                if (respuesta.equalsIgnoreCase("s")) {
                    System.out.println("¡Eureka!");
                    System.out.println("Intentos: " + intentos);
                    acertado = true;
                }
            }
            catch (NumberFormatException e) {
                System.out.println("Introduce un numero");
            }
        }
    }
    
    /**
     * Realiza un programa en Java al que le introduzcas 10 números por teclado, 
     * cuente el número de números positivos, el número de números negativos y realice la suma de todos ellos 
    */
    public static void ejercicio20() {
        int numero = 0, positivos = 0, negativos = 0, suma = 0;

        for (int i = 0; i < 10; i++) {
            try {
                numero = Integer.parseInt(JOptionPane.showInputDialog("Introduce un numero " + (i + 1) + ":"));
                
                if (numero > 0) {
                    positivos++;
                }
                else if (numero < 0) {
                    negativos++;
                }
                
                suma += numero;
            }
            catch (NumberFormatException e) {
                System.out.println("Introduce un numero");
                i--;
            }
        }
        
        System.out.println("Numeros positivos: " + positivos);
        System.out.println("Numeros negativos: " + negativos);
        System.out.println("Suma total: " + suma);
    }
    
    /**
     * Escribir un programa en Java que lea un número entero por el teclado e imprima todos los números impares menores que él
    */
    public static void ejercicio21() {
        try {
            int numero = Integer.parseInt(JOptionPane.showInputDialog("Introduce un número entero:"));
            
            for (int i = 1; i < numero; i++) {
                if (i % 2 != 0) {
                    System.out.println(i);
                }
            }
        }
        catch (NumberFormatException e) {
            System.out.println("Introduce un numero");
        }
    }
    
    /**
     * Haz un programa que pida un número de cuenta de veinte dígitos y muestre por pantalla la siguiente información: 
     * Código del Banco, Código de la oficina, Dígitos de control y número de cuenta. 
     * Se debe comprobar que haya introducido el número correcto de dígitos. 
     * (Necesitaras utilizar dos métodos de la clase String: lenght y substring.)   
    */
    public static void ejercicio22() {
        String numeroCuenta = "";

        while (numeroCuenta.length() != 20) {
            numeroCuenta = JOptionPane.showInputDialog("Introduce un número de cuenta de 20 dígitos:");
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
     * Pedir números al usuario y cuando el usuario meta un -1 se terminará el programa. Al terminar, mostrará lo siguiente:
     *  ? mayor numero introducido
     *  ? menor numero introducido
     *  ? suma de todos los numeros
     *  ? suma de los numeros positivos
     *  ? suma de los numeros negativos
     *  
     *   El número -1 no contara para ningún cálculo, únicamente para terminar el programa
    */
    public static void ejercicio23() {
        int numero;
        int mayor = Integer.MIN_VALUE;
        int menor = Integer.MAX_VALUE;
        int sumaTotal = 0;
        int sumaPositivos = 0;
        int sumaNegativos = 0;
        boolean continuar = true;

        while (continuar) {
            try {
                numero = Integer.parseInt(JOptionPane.showInputDialog("Introduce un numero (-1 para terminar):"));

                if (numero == -1) {
                    continuar = false;
                }
                else {
                    if (numero > mayor) {
                        mayor = numero;
                    }

                    if (numero < menor) {
                        menor = numero;
                    }

                    sumaTotal += numero;

                    if (numero > 0) {
                        sumaPositivos += numero;
                    }
                    else {
                        sumaNegativos += numero;
                    }
                }
            }
            catch (NumberFormatException e) {
                System.out.println("Introduce un numero");
            }
        }
        
        System.out.println("Numero mayor introducido " + mayor);
        System.out.println("Numero menor introducido " + menor);
        System.out.println("Suma de todos los numeros es " + sumaTotal);
        System.out.println("Suma de los numeros positivos es " + sumaPositivos);
        System.out.println("Suma de los numeros negativos es " + sumaNegativos);
    }
    
    /**
     * Pide un número por teclado e imprime todos los números primos que existen entre 1 el número introducido
    */
    public static void ejercicio24() {
        try {
            int numero = Integer.parseInt(JOptionPane.showInputDialog("Introduce un número:"));
        
            for (int i = 2; i <= numero; i++) {
                if (esPrimo(i)) {
                    System.out.println(i);
                }
            }
        }
        catch (NumberFormatException e) {
            System.out.println("Introduce un numero");
        }
    }
    
    /**
     * Le pasas un numero y de devuelve si es primo o no
     * @param numero
     * @return boolean
    */
    public static boolean esPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }
        
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}
