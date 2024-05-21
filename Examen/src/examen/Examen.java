package examen;

/**
 *
 * @author Aaron
 */
public class Examen {

    public static void main(String[] args) {
        // Inicializa rect1 con el constructor por defecto
        RectanguloApp rect1 = new RectanguloApp();
        
        // Inicializa rect2 con base y altura 4 x 7
        RectanguloApp rect2 = new RectanguloApp(4, 7);
        
        // Inicializa rect3 con base y altura 5 x 5 y nombre Rectángulo3
        RectanguloApp rect3 = new RectanguloApp("Rectangulo3", 5, 5);

        // Establece el atributo nombre de rect1 y rect2 como Rectángulo1 y Rectángulo2
        rect1.setNombre("Rectangulo1");
        rect2.setNombre("Rectangulo2");

        // Establece la altura de rect1 a 12 y la base a 15
        rect1.setAltura(12);
        rect1.setBase(15);

        // Utiliza los métodos toString y esCuadrado con los tres objetos creado
        System.out.println(rect1.toString());
        System.out.println("- Es cuadrado: " + rect1.esCuadrado() + "\n");

        System.out.println(rect2.toString());
        System.out.println("- Es cuadrado: " + rect2.esCuadrado() + "\n");

        System.out.println(rect3.toString());
        System.out.println("- Es cuadrado: " + rect3.esCuadrado() + "\n");
    }
}
