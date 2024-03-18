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
    public static final int DIMENSION = 4;
    public static int turno;
    public static boolean alterno = true;
    public static Scanner entrada = new Scanner(System.in);

   public static void main(String[] args) {
        boolean ganador = false;
        inicializaPartida();

        do {
            char simboloJugador = alterno ? SIMBOLO1 : SIMBOLO2;
            System.out.println("\nTurno del jugador " + (alterno ? "1" : "2") + ": ");

            imprimeTablero();
            dibujarEnCoordenada(simboloJugador);

            ganador = comprobar();

            if (!ganador) {
                alterno = !alterno;
            }
        } while (!ganador && turno < DIMENSION * DIMENSION);

        if (ganador) {
            System.out.println("El jugador " + (alterno ? "1" : "2") + " ha ganado");
        }
        else {
            System.out.println("Empate");
        }
        
        imprimeTablero();
    }
   
    public static void inicializaPartida() {
        tablero = new char[DIMENSION][DIMENSION];
        
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                tablero[i][j] = SIMBOLOV;
            }
        }
    }

    public static void imprimeTablero() {
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            
            System.out.println();
        }
    }
    
    public static void dibujarEnCoordenada(char simboloJugador) {
        int fila, columna;

        do {
            System.out.print("Introduce n�mero de fila para s�mbolo " + simboloJugador + ": ");
            fila = entrada.nextInt();

            System.out.print("Introduce n�mero de columna para s�mbolo " + simboloJugador + ": ");
            columna = entrada.nextInt();
        } while (!datosCorrectos(fila, columna));

        escribeDato(fila, columna, simboloJugador);
        turno++;
     }

    public static boolean datosCorrectos(int fila, int columna) {
        // Comprobamos que el numero introducido sea mayor que '1' y la dimension sea entre 1 y la dimension establecida
        if (fila < 1 || fila > DIMENSION || columna < 1 || columna > DIMENSION) {
            System.out.println("\nLos datos introducidos son incorrectos");
            return false;
        }
        
        // Comprobamos que la cordenada introducida este vacia
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
            for (int j = 0; j < DIMENSION; j++) {
                char simboloActual = tablero[i][j];
                
                if (simboloActual != SIMBOLOV) {
                    //  Fila
                    if (j <= 0) {
                        // Recorremos celdas
                        for (int k = 1; k < DIMENSION; k++) { 
                            if (tablero[i][j + k] != simboloActual) { 
                                break; 
                            }
                            if (k == (DIMENSION - 1)) { 
                                return true; 
                            }
                        }
                    }
                       
                    //  Columna
                    if (i <= 0) {
                        // Recorremos celdas
                        for (int k = 1; k < DIMENSION; k++) { 
                            if (tablero[i + k][j] != simboloActual) { 
                                break; 
                            }
                            if (k == (DIMENSION - 1)) { 
                                return true; 
                            }
                        }
                    }
                }
            }
        }

        return false;
    }
}