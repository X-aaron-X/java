package tresenraya;

/**
 *
 * @author Aaron
 */

import java.util.Scanner;

public class TresEnRaya {
    public static char[][] tablero;
    public static final char SIMBOLO1 = 'x';
    public static final char SIMBOLO2 = 'o';
    public static final char SIMBOLOV = '-';
    public static final int DIMENSION = 3;
    public static int turno = 0;
    public static boolean alterno = true;
    public static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        int fila, columna;
        inicializaPartida();
        
        do {
            char simboloJugador = alterno ? SIMBOLO1 : SIMBOLO2;
            System.out.println("\nTurno del jugador " + (alterno ? "1" : "2") + ": ");
            
            imprimeTablero();
            
            do {
                System.out.print("Introduce número de fila para símbolo " + simboloJugador + ": ");
                fila = entrada.nextInt();

                System.out.print("Introduce número de columna para símbolo " + simboloJugador + ": ");
                columna = entrada.nextInt();
            }
            while (!datosCorrectos(fila, columna));

            escribeDato(fila, columna, simboloJugador);
            turno++;

            // Cambiamos de jugador
            alterno = !alterno;
        }
        while (!comprobar() && turno < (DIMENSION*DIMENSION));
    }

    public static void inicializaPartida() {
        tablero = new char[DIMENSION][DIMENSION];

        // Rellenamos el array con 'SIMBOLOV'
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                tablero[i][j] = SIMBOLOV;
            }
        }
    }

    public static void imprimeTablero() {
        // Pintamos el tablero con los símbolos y los separamos con ' '
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                System.out.print(tablero[i][j] + " ");
            }

            System.out.println();
        }
    }

    public static boolean datosCorrectos(int fila, int columna) {
        // Comprobamos que el numero introducido sea mayor que '1' y la dimension sea entre 1 y la dimension establecida
        if (fila < 1 || fila > DIMENSION || columna < 1 || columna > DIMENSION) {
            System.out.println("\nLos datos introducidos son incorrectos");
            return false;
        }
        
        if (tablero[fila - 1][columna - 1] != SIMBOLOV) {
            System.out.println("\nLa celda introducida ya esta seleccionada");
            return false;
        }

        return true;
    }
    
    public static void escribeDato(int fila, int columna, char simboloJugador) {
        tablero[fila - 1][columna - 1] = simboloJugador;
    }
    
    public static boolean comprobar() {
        for (int i = 0; i < DIMENSION; i++) {
            // Comprobar filas
            if (tablero[i][0] != SIMBOLOV && tablero[i][0] == tablero[i][1] && tablero[i][1] == tablero[i][2]) {
                return true;
            }
        }

        return false; // No hay ganador aún
    }
}