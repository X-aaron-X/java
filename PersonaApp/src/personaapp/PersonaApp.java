package personaapp;

import java.util.Scanner;

/**
 *
 * @author Aaron
 */
public class PersonaApp {
    // Pide por teclado el nombre, la edad, sexo, peso y altura.
    // Crea 3 objetos de la clase anterior, el primer objeto obtendrá las anteriores variables pedidas por teclado, 
    // el segundo objeto obtendrá todos los anteriores menos el peso y la altura y el último por defecto, 
    // para este último utiliza los métodos set para darle a los atributos un valor.
    // Para cada objeto, deberá comprobar si está en su peso ideal, tiene sobrepeso o por debajo de su peso ideal con un mensaje.
    // Indicar para cada objeto si es mayor de edad.
    // Por último, mostrar la información de cada objeto.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce el nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Introduce la edad: ");
        int edad = scanner.nextInt();

        System.out.print("Introduce el sexo: ");
        char sexo = scanner.next().charAt(0);

        System.out.print("Introduce el peso: ");
        double peso = scanner.nextDouble();
        
        System.out.print("Introduce la altura: ");
        double altura = scanner.nextDouble();

        Persona persona1 = new Persona(nombre, edad, sexo, peso, altura);
        Persona persona2 = new Persona(nombre, edad, sexo);
        Persona persona3 = new Persona();
        
        persona3.setNombre("Nombre por defecto");
        persona3.setEdad(25);
        persona3.setSexo('H');
        persona3.setPeso(70);
        persona3.setAltura(1.50);
        
         Persona[] personas = {persona1, persona2, persona3};

        for (Persona persona : personas) {
            switch (persona.calcularIMC()) {
                case -1:
                    System.out.println(persona.getNombre() + " está por debajo de su peso ideal.");
                    break;
                case 0:
                    System.out.println(persona.getNombre() + " está en su peso ideal.");
                    break;
                case 1:
                    System.out.println(persona.getNombre() + " tiene sobrepeso.");
                    break;
            }

            if (persona.esMayorDeEdad()) {
                System.out.println(persona.getNombre() + " es mayor de edad.");
            } else {
                System.out.println(persona.getNombre() + " no es mayor de edad.");
            }

            System.out.println(persona);
        }
    }
}
