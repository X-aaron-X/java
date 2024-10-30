package conectacuatro;

import java.util.Scanner;

/**
 *
 * @author Aaron
 */
public class ConectaCuatro {
    public static char[][] tablero;
    public static final char SIMBOLO1 = 'x';
    public static final char SIMBOLO2 = 'o';
    public static char simboloJugador; 
    public static final char SIMBOLOVACIO = '-';
    public static final int FILAS = 6;
    public static final int COLUMNAS = 6;
    public static int turno;
    public static boolean ganador = false;
    public static boolean alterno = true;
    public static Scanner entrada = new Scanner(System.in);
    
    public static void main(String[] args) {
        comenzarPartida();
        
        System.out.println("Juego conecta cuatro");
        
        do {
            simboloJugador = alterno ? SIMBOLO1 : SIMBOLO2;
            System.out.println("\nTurno del jugador " + (alterno ? "1" : "2") + ": ");
            
            imprimeTablero();
            dibujarEnCoordenada();
            
            ganador = comprobar();
            alterno = !alterno;
        }
        while (!ganador && turno < FILAS * COLUMNAS);
        
        resultadoJuego();
    }
    
    private static void comenzarPartida() {
        tablero = new char[FILAS][COLUMNAS];
        
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                tablero[i][j] = SIMBOLOVACIO;
            }
        }
    }
    
    private static void imprimeTablero() { 
        for (int i = 0; i < FILAS; i++) { 
            for (int j = 0; j < COLUMNAS; j++) { 
                System.out.print(tablero[i][j] + "   "); 
            } 
            
            System.out.println(); 
        } 
    }
    
    private static void dibujarEnCoordenada() {
        int columna;

        do {
            columna = validarNumEntero("Introduce la columna '" + simboloJugador + "': ");
        }
        while (!datosCorrectos(columna));
        
        escribirDatoUsuario(columna);
        turno++;
    }

    public static void escribirDatoUsuario(int columna) {
        int fila = FILAS - 1; 
        boolean encontrado = false;

        while (fila >= 0 && !encontrado) {
            if (tablero[fila][columna - 1] == SIMBOLOVACIO) {
                encontrado = true; 
            }
            else {
                fila--; 
            }
        }

        if (encontrado) {
            tablero[fila][columna - 1] = simboloJugador;
        }
    }

    private static int validarNumEntero(String message) {
        while (true) {
            try {
                System.out.print(message); 
                return Integer.parseInt(entrada.next());
            }
            catch (NumberFormatException e) {
                System.out.println("\nIntroduce un número válido");
            }
        }
    }

    private static boolean datosCorrectos(int columna) {
        if (columna < 1 || columna > COLUMNAS) {
            System.out.println("\nLa columna introducida es incorrecta");
            return false;
        }
        
        if (tablero[0][columna - 1] != SIMBOLOVACIO) {
            System.out.println("\nLa columna está llena, elige otra");
            return false;
        }
        
        return true;
    }
    
    public static boolean comprobarDiagonales() {
        boolean diagonalIzquierda = true;
        boolean diagonalDerecha = true;
        int i = 1;
        
        // Diagonal izquierda
        while (i < 4 && diagonalIzquierda) {
            // Comprobamos que la posicion de la diagonal izquierda es distinta a la posicion [0,0] del tablero
            // Comprobamos que la posicion de la diagonal izquierda es igual al simbolo '-'
            if (tablero[i][i] != tablero[0][0] || tablero[i][i] == SIMBOLOVACIO) {
                diagonalIzquierda = false;
            }
            
            i++;
        }
        
        i = 1;
        // Diagonal derecha
        while (i < 4 && diagonalDerecha) {
            int j = (COLUMNAS - 1) - i;

            // Comprobamos que la posición en la diagonal derecha es igual al símbolo en [0, COLUMNAS - 1] y que no es SIMBOLOVACIO
            if (tablero[i][j] != tablero[0][COLUMNAS - 1] || tablero[i][j] == SIMBOLOVACIO) {
                diagonalDerecha = false;
            }
            i++;
        }
        
        return diagonalIzquierda || diagonalDerecha;
    }

    public static void resultadoJuego() {
        if (ganador) {
            System.out.println("\nEl jugador " + (alterno ? "1" : "2") + " con el símbolo '" + simboloJugador + "' ha ganado\n");
        }
        else {
            System.out.println("\nLos jugadores han empatado\n");
        }
        
        imprimeTablero();
    }
}
