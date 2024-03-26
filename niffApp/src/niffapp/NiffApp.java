package niffapp;

/**
 *
 * @author Aaron
 */
public class NiffApp {
    public static void main(String[] args) {
        // Ahora, en la clase NifApp, define tres NIFs, dos con el constructor por defecto y otro con el que recibe un parámetro. 
        // Utiliza el método leer() con uno de los creados por defecto y el setter con el otro. 
        // Por último, muestra por pantalla con toString() el estado de los tres.       
        Niff nif1 = new Niff();
        Niff nif2 = new Niff();
        Niff nif3 = new Niff(12345678);
        Niff nif4 = new Niff();
        
        nif1.leer();
        
        nif2.setDniNum(90183696);
        
        System.out.println("\nDNI 1: " + nif1.mostrarNif());
        System.out.println("DNI 2: " + nif2.mostrarNif());
        System.out.println("DNI 3: " + nif3.mostrarNif());
        System.out.println("DNI 4: " + nif4.mostrarNif());
    }
}