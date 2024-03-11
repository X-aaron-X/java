
package ejemplosarraylist;


import java.util.ArrayList;
/**
 *
 * @author Aaron
 */
public class EjemplosArrayList {
    
    public static void main(String[] args) {
        ArrayList<String> ejemplo = new ArrayList<String>();
                 
        for (int i = 0; i <= 10; i++) {
            ejemplo.add("Elemento " + i);
        }
        
        ejemplo.remove("Elemento 3");
        System.out.println(ejemplo.toString());
    }
}