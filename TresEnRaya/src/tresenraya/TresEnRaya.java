package tresenraya;

/**
 *
 * @author Aaron
 */

import java.util.Scanner;

public class TresEnRaya {
    public static char[][] tablero;
    public static final char SIMBOLO1 = 'X';
    public static final char SIMBOLO2 = 'O';
    public static final char SIMBOLOV = '-';
    public static final int DIMENSION = 3;
    public static char simboloJugador; 
    public static int turno;
    public static boolean alterno = true;
    public static boolean ganador = false;
    public static Scanner entrada = new Scanner(System.in);

   public static void main(String[] args) {
        inicializaPartida();

        do {
            simboloJugador = alterno ? SIMBOLO1 : SIMBOLO2;
            System.out.println("\nTurno del jugador " + (alterno ? "1" : "2") + ": ");

            imprimeTablero();
            dibujarEnCoordenada();
            
            ganador = comprobar();
            alterno = !ganador ? !alterno : alterno;
        } while (!ganador && turno < DIMENSION * DIMENSION);
        
        resultadoJuego();
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
            System.out.print("Introduce n�mero de fila para s�mbolo '" + simboloJugador + "': ");
            fila = entrada.nextInt();

            System.out.print("Introduce n�mero de columna para s�mbolo '" + simboloJugador + "': ");
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
        // Diagonales        
        return comprobarDiagonales();    
    }

    public static boolean comprobarFila(int fila, char simbolo) {
        for (int columna = 0; columna < DIMENSION; columna++) {
            // Comprobamos si el simbolo de posici�n actual es distinto al simbolo pasado como argumento
            if (tablero[fila][columna] != simbolo) {
              return false;
            }
        }
        return true;
      }

    public static boolean comprobarColumna(int columna, char simbolo) {
        for (int fila = 0; fila < DIMENSION; fila++) {
            // Comprobamos si el simbolo de posici�n actual es distinto al simbolo pasado como argumento
            if (tablero[fila][columna] != simbolo) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean comprobarDiagonales() {
        boolean diagonalIzquierda = true;
        boolean diagonalDerecha = true;
        int i = 1;
        
        // Diagonal izquierda
        while (i < DIMENSION && diagonalIzquierda) {
            // Comprobamos que la posicion de la diagonal izquierda es distinta a la posicion [0,0] del tablero
            // Comprobamos que la posicion de la diagonal izquierda es igual al simbolo '-'
            if (tablero[i][i] != tablero[0][0] || tablero[i][i] == SIMBOLOV) {
                diagonalIzquierda = false;
            }
            i++;
        }
        
        i = 1;
        // Diagonal derecha
        while (i < DIMENSION && diagonalDerecha) {
            // Nos posicionamos en la pocicion de la diagonal derecha
            int j = (DIMENSION - 1) - i;
            
            // Comprobamos que la posicion de la diagonal derecha es distinta a la posicion [0,2] del tablero
            // Comprobamos que la posicion de la diagonal derecha es igual al simbolo '-'
            if (tablero[i][j] != tablero[0][DIMENSION - 1] || tablero[i][j] == SIMBOLOV) {
                diagonalDerecha = false;
            }
            i++;
        }
        return diagonalIzquierda || diagonalDerecha;
    }
    
    public static void resultadoJuego() {
        if (ganador) {
            System.out.println("El jugador " + (alterno ? "1" : "2")  + " con el s�mbolo '" + simboloJugador + "' ha ganado");
        }
        else {
            System.out.println("Los jugadores han empatado");
        }
        imprimeTablero();
    }
}