package muertosyheridos;

import java.util.Arrays;
import javax.swing.JOptionPane;

public class MuertosYHeridos {

    public static void main(String[] args) {
        int[] muertosHeridos;
        String secreto, intento = "";
        char[] clave;
        char[] adivina;
        
        //Pido Numero secreto hasta que sea correcto, cuando lo sea lo almaceno en el array de chars llamado clave
        do {
            secreto = JOptionPane.showInputDialog("Introduce el Numero secreto \n Debe tener cuatro cifras distintas entre si");
        }
        while (!esCorrecto(secreto) || secreto.equals("claudico"));
        
        clave = secreto.toCharArray();

        //Pido una y otra vez el Numero a adivinar hasta que ocurra una de estas
        //dos cosas: que lo acierte o que se rinda
        do {
            do {
                intento = JOptionPane.showInputDialog("Introduce el Numero a adivinar \n Debe tener cuatro cifras distintas entre si");
            }
            while (!esCorrecto(intento));
            
            adivina = intento.toCharArray();
            muertosHeridos = calculaMyH(clave, adivina);
            
            System.out.println("Numero "+intento);
            System.out.println("El Numero de muertos es: " + muertosHeridos[0]);
            System.out.println("El Numero de heridos es: " + muertosHeridos[1]);
        }
        while (!Arrays.equals(clave, adivina) && !intento.equals("claudico"));

        if (intento.equals("claudico")) {
            System.out.println("Cagon!!");
        }
        else {
            System.out.println("ENHORABUENA! El nNumeromero era: "+secreto);
        }

    }

    // Comprobamos que el Numero tenga cuatro caracteres, que efectivamente sean
    // Numero, y que no se repita ninguno. Ademas, claudico es una palabra valida
    public static boolean esCorrecto(String clave) {
        if (clave.equals("claudico")) return true;
        
        if (clave.length() != 4) {
            return false;
        }
        
        for (int i = 0; i < 4; i++) {
            if (clave.charAt(i) < 48 || clave.charAt(i) > 57) {
                return false;
            }
            for (int j = i + 1; j < 4; j++) {
                if (clave.charAt(i) == clave.charAt(j)) {
                    return false;
                }
            }
        }
        
        return true;
    }

    public static int[] calculaMyH(char[] principal, char[] intentos) {
        int[] MyH = new int[2];
        
        for (int i = 0; i < principal.length; i++) {
            for (int j = 0; j < intentos.length; j++) {
                if (principal[i] == intentos[j]) {
                    if (i == j) {
                        MyH[0]++;
                    } else {
                        MyH[1]++;
                    }
                }
            }
        }
        
        return MyH;
    }
}
