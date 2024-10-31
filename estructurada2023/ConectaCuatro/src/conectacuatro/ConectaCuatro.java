package conectacuatro;

import java.util.Scanner;

/**
 *
 * @author Aaron
 */
public class ConectaCuatro {
    public static char[][] tablero;
    public static final char SIMBOLO1 = 'X';
    public static final char SIMBOLO2 = 'O';
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
    
    /**
     * Inicializa el tablero del juego con los símbolos vacios
    */
    private static void comenzarPartida() {
        tablero = new char[FILAS][COLUMNAS];
        
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                tablero[i][j] = SIMBOLOVACIO;
            }
        }
    }
    
    /**
     * Pinta en la consola el tablero
    */
    private static void imprimeTablero() {
        System.out.println("Tablero de Conecta Cuatro:");

        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                System.out.print("   " + tablero[i][j]);
            }

            System.out.println();
        }
    }
    
    /**
     * Solicita al usuario una columna y dibuja el simbolo del jugador en esa posicion
    */
    private static void dibujarEnCoordenada() {
        int columna;

        do {
            columna = validarNumEntero("Introduce la columna '" + simboloJugador + "': ");
        }
        while (!datosCorrectos(columna));
        
        escribirDatoUsuario(columna);
        turno++;
    }
    
    /**
     * Pinta el símbolo del jugador en la primera posición vacia
     * @param columna -> La columna que pasa el usuario donde se colocara el simbolo del jugador
    */
    public static void escribirDatoUsuario(int columna) {
        int fila = FILAS - 1;
        
        // Busca la primera posicion vacia de abajo hacia arriba
        while (fila >= 0 && tablero[fila][columna - 1] != SIMBOLOVACIO) {
            fila--;
        }
        
        if (fila >= 0) {
            tablero[fila][columna - 1] = simboloJugador;
        }
    }
    
    /**
     * Pide un numero enterio y validamos que sea un numero entero
     * @param message -> Mensaje que mostrara la consola
     * @return int -> Numero introducido por el usuario
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
     * Comprueba si la columna introducida es valida y tiene espacio disponible en el tablero
     * 
     * @param columna -> La columna introducida por el usuario
     * @return boolean - true -> Si la columna y hay un espacio disponible en el tablero
    */
    private static boolean datosCorrectos(int columna) {
        if (columna < 1 || columna > COLUMNAS) {
            System.out.println("\nLa columna introducida es incorrecta");
            return false;
        }
         
        if (tablero[0][columna - 1] != SIMBOLOVACIO) {
            System.out.println("\nLa columna está llena");
            return false;
        }
        
        return true;
    }
    
    /**
    * Comprueba si hay un ganador en filas, columnas o diagonales
    * 
    * @return boolean - true -> si hay un ganador
    */
    public static boolean comprobar() {
        for (int i = 0; i < FILAS; i++) {
            if (comprobarFila(i, simboloJugador)) return true;
        }

        for (int i = 0; i < COLUMNAS; i++) {
            if (comprobarColumna(i, simboloJugador)) return true;
        }

       // Comprueba las diagonales
       return comprobarDiagonales();
    }
    
    /**
     * Comprueba si hay cuatro símbolos iguales en una fila
     * 
     * @param fila -> Fila introducida por el usuario
     * @param simbolo -> Simbolo del jugador
     * @return boolean - true -> Con cuatro símbolos iguales consecutivos en la fila
    */
    public static boolean comprobarFila(int fila, char simbolo) {
        int contador = 0;

        for (int i = 0; i < COLUMNAS; i++) {
            contador = (tablero[fila][i] == simbolo) ? contador + 1 : 0;

            if (contador == 4) return true;
        }
        
        return false;
    }
    
    /**
     * Comprueba si hay cuatro símbolos iguales en una columna
     * 
     * @param columna -> Columna introducida por el usuario
     * @param simbolo -> Simbolo del jugador
     * @return boolean - true -> Con cuatro simbolos iguales consecutivos en la columna
    */
    public static boolean comprobarColumna(int columna, char simbolo) {
        int contador = 0;

        for (int i = 0; i < FILAS; i++) {
            contador = (tablero[i][columna] == simbolo) ? contador + 1 : 0;

            if (contador == 4) return true;
        }
        
        return false;
    }
    
    /**
    * Comprueba si hay un ganador en las diagonales.
    * 
    * @return boolean - true si hay un ganador.
    */
    public static boolean comprobarDiagonales() {
        // Diagonal izquierda
        for (int i = 0; i <= FILAS - 4; i++) {
            for (int j = 0; j <= COLUMNAS - 4; j++) {
                // Comprobamos que el simbolo actual no sea el de una casilla vacía
                // Y que los siguientes tres elementos en diagonal sean iguales
                if (tablero[i][j] != SIMBOLOVACIO && 
                    tablero[i][j] == tablero[i + 1][j + 1] && 
                    tablero[i][j] == tablero[i + 2][j + 2] && 
                    tablero[i][j] == tablero[i + 3][j + 3]) 
                {
                   return true;
               }
           }
        }

        // Diagonal derecha
        for (int i = 3; i < FILAS; i++) {
            for (int j = 0; j <= COLUMNAS - 4; j++) {
                // Comprobamos que el simbolo actual no sea el de una casilla vacía
                // Y que los siguientes tres elementos en diagonal sean iguales
                if (tablero[i][j] != SIMBOLOVACIO && 
                    tablero[i][j] == tablero[i - 1][j + 1] && 
                    tablero[i][j] == tablero[i - 2][j + 2] && 
                    tablero[i][j] == tablero[i - 3][j + 3]) 
                {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Muestra el resultado del juego y imprime el tablero
    */
    public static void resultadoJuego() {
        if (ganador) {
            System.out.println("\nEl jugador " + (alterno ? "1" : "2") + " con el símbolo '" + simboloJugador + "' ha ganado\n");
        }
        else {
            System.out.println("\nSois unos loser");
        }
        
        imprimeTablero();
    }
}
