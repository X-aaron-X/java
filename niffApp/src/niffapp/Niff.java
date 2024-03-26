package niffapp;

import java.util.Scanner;

/**
 *
 * @author Aaron
 */
public class Niff {
    private int dniNum;
    private char dniLetra;
    
    /**
     * Constructor predeterminado que inicialice el nº de DNI a 0 y la letra a espacio en blanco
    */
    public Niff() {
        this.dniNum = 0;
        this.dniLetra = ' ';
    }
    
    /**
     * Constructor que reciba el DNI y establezca la letra que le corresponde
     * @param dniNum
    */
    public Niff(int dniNum) {
        this.dniNum = dniNum;
        calcularLetra();
    }

    public void setDniNum(int dniNum) {
        this.dniNum = dniNum;
        calcularLetra();
    }
    
    /**
     * 	Pide por pantalla el número de DNI (ajustando automáticamente la letra)
    */
    public void leer () {
        Scanner scanner = new Scanner(System.in);
        
        do {
            System.out.print("Introduce el numero del DNI (8 caracteres): ");
            this.dniNum = scanner.nextInt();

        } while (String.valueOf(this.dniNum).length() == 9);
        
        calcularLetra();
    }
    
    /**
     * Método que nos permita mostrar el NIF (ocho dígitos, un guion y la letra en mayúscula; por ejemplo: 00395469-F)
    */
    public String mostrarNif() {
        return String.format("%08d", this.dniNum) + "-" + this.dniLetra;
    }
    
    /**
     * La letra se calculará con un método auxiliar (privado) de la siguiente forma: se obtiene el resto de la división entera del número 
     * de DNI entre 23 y se usa la siguiente tabla para obtener la letra que corresponde:
     * 0 - T, 1 -R, 2 - W, 3 - A, 4 - G, 5 - M, 6 - Y, 7 - F, 8 - P, 9 - D, 10 - X, 11 - B, 12 - N, 13 - J
     * 14 - Z, 15 - S, 16 - Q, 17 - V, 18 - H, 19 - L, 20 - C, 21 - K, 22 - E
    */
    private void calcularLetra() {
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        this.dniLetra = letras.charAt(this.dniNum % 23);
    }
}
