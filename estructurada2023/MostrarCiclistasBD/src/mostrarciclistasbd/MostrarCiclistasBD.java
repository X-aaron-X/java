package mostrarciclistasbd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Aaron
 */
public class MostrarCiclistasBD {
    static Connection conexion = null;
    static String url = "jdbc:mysql://localhost:3306/ciclistas";
    static String usuario = "root";
    static String contrasena = "";
    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, usuario, contrasena);
        }
        catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error de la conexion de la base de datos");
        }
        
        int opciones;

        do {
            System.out.println("\nMenu: ");
            System.out.println("[1] Mostrar todos los datos de la tabla ciclistas");
            System.out.println("[2] Mostrar todos los datos de la tabla etapa");
            System.out.println("[3] Mostrar todos los datos de la tabla equipo");
            System.out.println("[4] Consultar un clicista");
            System.out.println("[5] Consultar equipo");
            System.out.println("[6] Consultar una etapa");
            System.out.println("[7] salir");
            
            opciones = validarNumEntero("\nIntroduce una opcion: ");
            entrada.nextLine();
            
            switch (opciones) {
                case 1 -> verTodosDatos("ciclista");
                case 2 -> verTodosDatos("etapa");
                case 3 -> verTodosDatos("equipo");
                case 4 -> { 
                    int dorsal = validarNumEntero("\nIntroduce el dorsal: ");
                    verDato("ciclista", "dorsal", String.valueOf(dorsal));
                }   
                case 5 -> {
                    System.out.print("\nIntroduce el nombre del equipo: ");
                    String nombreEquipo = entrada.nextLine();

                    verDato("equipo", "nomequipo", nombreEquipo);
                }
                case 6 -> {
                    int etapa = validarNumEntero("\nIntroduce la etapa: ");

                    verDato("etapa", "numetapa", String.valueOf(etapa));
                }
                case 7 -> System.out.print("Adios\n");
                default -> System.out.println("La opcion escogida es incorrecta");
            }
        }
        while (opciones != 7);
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
     * Realiza una consulta para ver todos los datos de la tabla
     * @param tabla Nombre de la tabla
    */
    private static void verTodosDatos(String tabla) {
        String consulta = "SELECT * FROM " + tabla;
        
        try (PreparedStatement comprobar = conexion.prepareStatement(consulta)) {
            try (ResultSet resultados = comprobar.executeQuery()) {
                imprimirResultados(resultados);
            }
        }
        catch (SQLException e) {
            System.out.println("Error. El dato introducido no existe3");
        }
    }
    
    /**
     * Realiza una consulta a la base de datos mostrando todos los datos. El PK puede ser INT o VARCHAR
     * @param tabla Nombre de la tabla
     * @param pk Primary key de la tabla
     * @param id Identificador para la consulta
    */
    private static void verDato(String tabla, String pk, String id) {
        String consulta = "SELECT * FROM " + tabla + " WHERE " + pk + " = ?";
        
        try (PreparedStatement comprobar = conexion.prepareStatement(consulta)) {
            if (id.matches("\\d+")) {
                comprobar.setInt(1, Integer.parseInt(id));
            }
            else {
                comprobar.setString(1, id);
            }
            
            ResultSet resultados = comprobar.executeQuery();

            if (!resultados.isBeforeFirst()) {
                System.out.println("En la tabla '" + tabla + "' no existe el " + pk + " con '" + id + "'");
            }
            else {
                imprimirResultados(resultados);
            }
        }
        catch (SQLException e) {
            System.out.println("Error al ejecutar la consulta");
        }
    }
    
    /**
     * Imprime los resultados de una consulta a la base de datos. Mostrando todas las columas de la tabla
     * @param resultados Los resultados de la consulta a imprimir
    */
    private static void imprimirResultados(ResultSet resultados) {
        try {
            ResultSetMetaData datos = resultados.getMetaData();
            int numColumnas = datos.getColumnCount();

            while (resultados.next()) {
                for (int i = 1; i <= numColumnas; i++) {
                    Object valor = resultados.getObject(i);
                    String nombreColumna = datos.getColumnName(i);

                    System.out.println(nombreColumna + ": " + valor);
                }

                System.out.println();
            }
        }
        catch (SQLException e) {
            System.out.println("Error al imprimir los resultados");
        }
    }
}
