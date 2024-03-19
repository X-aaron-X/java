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
    public static char simboloJugador; 
    public static int turno;
    public static boolean alterno = true;
    public static Scanner entrada = new Scanner(System.in);

   public static void main(String[] args) {
        boolean ganador = false;
        inicializaPartida();

        do {
            simboloJugador = alterno ? SIMBOLO1 : SIMBOLO2;
            System.out.println("\nTurno del jugador " + (alterno ? "1" : "2") + ": ");

            imprimeTablero();
            dibujarEnCoordenada();

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
    
    public static void dibujarEnCoordenada() {
        int fila, columna;

        do {
            System.out.print("Introduce número de fila para símbolo " + simboloJugador + ": ");
            fila = entrada.nextInt();

            System.out.print("Introduce número de columna para símbolo " + simboloJugador + ": ");
            columna = entrada.nextInt();
        } while (!datosCorrectos(fila, columna));

        escribeDato(fila, columna);
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
    
    public static void escribeDato(int fila, int columna) {
        tablero[fila - 1][columna - 1] = simboloJugador;
    }
    
    public static boolean comprobar() {
        for (int i = 0; i < DIMENSION; i++) {
            char simboloFila = tablero[i][0];
            char simboloColumna = tablero[0][i];
        
            // Fila
            if (simboloFila != SIMBOLOV && comprobarFila(i, simboloFila)) {
                return true;
            }
            
            // Columna
            if (simboloColumna != SIMBOLOV && comprobarColumna(i, simboloColumna)) {
                return true;
            }
        }
        
        // Verificar diagonales
        if (comprobarDiagonales()) {
            return true;
        }



        return false;    
    }

    public static boolean comprobarFila(int fila, char simbolo) {
        for (int columna = 0; columna < DIMENSION; columna++) {
            if (tablero[fila][columna] != simbolo) {
              return false;
            }
        }

        return true;
      }

    public static boolean comprobarColumna(int columna, char simbolo) {
        for (int fila = 0; fila < DIMENSION; fila++) {
        if (tablero[fila][columna] != simbolo) {
            return false;
        }
    }
    return true;
    }
    
    public static boolean comprobarDiagonales() {
        // Diagonal izquierda
        for (int i = 0; i < DIMENSION; i++) {        
            if (tablero[i][i] != SIMBOLO1 && tablero[i][i] != SIMBOLO2) {
              return false;
            }
        }
        
        // Diagonal derecha
        
    
        return true;
    }
}