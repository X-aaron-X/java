package puntoapp;

/**
 *
 * @author Aaron
 */
public class PuntoApp {

    public static void main(String[] args) {
        Punto punto1, punto2;
        Linea linea1, linea2;
        
        punto1 = new Punto();
        punto2 = new Punto(2, 3);
        linea1 = new Linea(punto1, punto2);
        
        // Imprimimos las coordenadas de la linea1      
        System.out.println("Linea1" + linea1.info());
        
        // Movemos la línea 2 puntos a la derecha
        System.out.println("Movemos 2 puntos a la derecha");
        linea1.mueveDerecha(2);
        System.out.println("Linea1 movida dos puntos a la derecha)" + linea1.info());
        
        // Movemos la linea 2 puntos arriba
        System.out.println("Movemos 2 puntos arriba");
        linea1.mueveArriba(2);
        System.out.println(linea1.info());
        
        linea2= new Linea(2, 1, 4, 5);
        System.out.println(linea2.info());
    }
}
