package nenraya;

import java.util.Scanner;

/**
 *
 * @author Aaron
 */
public class NEnRaya {
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
            alterno = !alterno;
        }
        while (!ganador && turno < DIMENSION * DIMENSION);
        
        resultadoJuego();
    }
    
    /**
     * Inicializa la partida generando un tablero de juego
    */
    private static void inicializaPartida() {
        tablero = new char[DIMENSION][DIMENSION];
        
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                tablero[i][j] = SIMBOLOV;
            }
        }
    }
    
    /**
     * Imprime el tablero de juego en la consola
    */
    private static void imprimeTablero() {
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            
            System.out.println();
        }
    }
    
    /**
     * Dibuja el simbolo del jugador en la coordenada especificada por el usuario
    */
    private static void dibujarEnCoordenada() {
        int fila, columna;

        do {
            fila = validarNumEntero("Introduce numero de fila para simbolo '" + simboloJugador + "': ");
            columna = validarNumEntero("Introduce numero de columna para simbolo '" + simboloJugador + "': ");
        }
        while (!datosCorrectos(fila, columna));

        escribeDato(fila, columna);
        turno++;
    }
    
    /**
     * Pide un numero enterio y validamos que sea un numero entero
     * @param message Mensaje que mostrara la consola
     * @return int Numero introducido por el usuario
    */
    private static int validarNumEntero(String message) {
        while (true) {
            try {
                System.out.print(message); 
                return Integer.parseInt(entrada.next());
            }
            catch (NumberFormatException e) {
                System.out.println("\nIntroduce un numero valido");
            }
        }
    }
    
    /**
     * Verifica si los datos introducidos para una coordenada son correctos
     * 
     * @param fila La fila de la coordenada (debe ser entre 1 y DIMENSION)
     * @param columna La columna de la coordenada (debe ser entre 1 y DIMENSION)
     * @return boolean - true si los datos son correctos
    */
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
    
    /**
     * Escribe el simbolo del jugador en la coordenada especificada
     * 
     * @param fila La fila de la coordenada (debe ser entre 1 y DIMENSION)
     * @param columna La columna de la coordenada (debe ser entre 1 y DIMENSION)
    */
    public static void escribeDato(int fila, int columna) {
        tablero[fila - 1][columna - 1] = simboloJugador;
    }
    
    /**
     * Comprueba si hay un ganador en el tablero
     * 
     * @return - true si hay un ganador
    */
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
    
    /**
     * Comprueba si una fila del tablero tiene un ganador
     * 
     * @param fila La fila a comprobar
     * @param simbolo El simbolo a buscar en la fila
     * @return boolean - true si la fila tiene un ganador (si todas las celdas tienen el simbolo pasado como argumento)
    */
    public static boolean comprobarFila(int fila, char simbolo) {
        for (int columna = 0; columna < DIMENSION; columna++) {
            // Comprobamos si el simbolo de posición actual es distinto al simbolo pasado como argumento
            if (tablero[fila][columna] != simbolo) {
              return false;
            }
        }
        
        return true;
    }
    
    /**
     * Comprueba si una columna del tablero tiene un ganador
     * @param columna La columna a comprobar
     * @param simbolo El simbolo a buscar en la columna
     * @return boolean - true si la fila tiene un ganador (si todas las celdas tienen el simbolo pasado como argumento)
    */
    public static boolean comprobarColumna(int columna, char simbolo) {
        for (int fila = 0; fila < DIMENSION; fila++) {
            // Comprobamos si el simbolo de posición actual es distinto al simbolo pasado como argumento
            if (tablero[fila][columna] != simbolo) {
                return false;
            }
        }
        
        return true;
    }
    
    /**
     * Comprueba si hay una diagonal ganadora en el tablero. Comprueba las diagonales izquierda y derecha
     * 
     * @return boolean - true si hay una diagonal ganadora
    */
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
    
    /**
     * Muestra el resultado del juego y imprime el tablero
    */
    public static void resultadoJuego() {
        if (ganador) {
            System.out.println("\nEl jugador " + (alterno ? "1" : "2") + " con el simbolo '" + simboloJugador + "' ha ganado\n");
        }
        else {
            System.out.println("\nSois unos loser");
        }
        
        imprimeTablero();
    }
}
