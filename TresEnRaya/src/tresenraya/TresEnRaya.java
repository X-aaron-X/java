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
    public static int turno;
    public static boolean alterno = true;
    public static Scanner entrada = new Scanner(System.in);

   public static void main(String[] args) {
        inicializaPartida();
        
        do {
            char simboloJugador = alterno ? SIMBOLO1 : SIMBOLO2;
            System.out.println("\nTurno del jugador " + (alterno ? "1" : "2") + ": ");
            
            // Dibujamos el tablero
            imprimeTablero();
            // Dibujamos el simbolo del jugador
            dibujarEnCoordenada(simboloJugador);

            // Cambiamos de jugador
            alterno = !alterno;
        } while (!comprobar() && turno < DIMENSION * DIMENSION);
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
            System.out.print("Introduce número de fila para símbolo " + simboloJugador + ": ");
            fila = entrada.nextInt();

            System.out.print("Introduce número de columna para símbolo " + simboloJugador + ": ");
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
                    // Comprobar fila
                    if (j <= DIMENSION - 3 && tablero[i][j + 1] == simboloActual && tablero[i][j + 2] == simboloActual) {
                        return true;
                    }
                    // Comprobar columna
                    if (i <= DIMENSION - 3 && tablero[i + 1][j] == simboloActual && tablero[i + 2][j] == simboloActual) {
                        return true;
                    }
                }
            }
        }

        
        // Cuando no hay ganador
        return false;
    }
}