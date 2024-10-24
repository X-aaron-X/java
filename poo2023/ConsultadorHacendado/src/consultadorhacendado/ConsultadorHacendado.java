package consultadorhacendado;

import java.sql.*;
import java.util.Scanner;

public class ConsultadorHacendado {
    static Connection conexion = null;
    static String url = "jdbc:mysql://localhost:3307/ciclistas";
    static String user = "root";
    static String pass = "";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, user, pass);
        }
        catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error de la conexion de la base de datos");
        }

        Scanner escaner = new Scanner(System.in);

        System.out.println("Introduce dato a consultar: ");
        System.out.println("1. Ciclista");
        System.out.println("2. Equipo");
        System.out.println("3. Etapa");

        int opciones = escaner.nextInt();
        escaner.nextLine();

        switch (opciones) {
            case 1 -> {
                System.out.print("Introduce el dorsal: ");
                int dorsal = escaner.nextInt();

                consulta("ciclista", "dorsal", String.valueOf(dorsal));
            }   
            case 2 -> {
                System.out.print("Introduce el nombre del equipo: ");
                String nombreEquipo = escaner.nextLine();

                consulta("equipo", "nomequipo", nombreEquipo);
            }
            case 3 -> {
                System.out.print("Introduce la etapa: ");
                int etapa = escaner.nextInt();

                consulta("etapa", "numetapa", String.valueOf(etapa));
            }
            default -> System.out.println("La opcion escogida es incorrecta");
        }
    }
    
    /**
     * Realiza una consulta a la base de datos mostrando todos los datos. El PK puede ser INT o VARCHAR.
     * @param tabla Nombre de la tabla.
     * @param pk Primary key de la tabla.
     * @param id Identificador para la consulta.
    */
    public static void consulta(String tabla, String pk, String id) {
        String consulta = "SELECT * FROM " + tabla + " WHERE " + pk + " = ?";
        
        try (PreparedStatement comprobar = conexion.prepareStatement(consulta)) {
            // Comprobamos si "id" es solo numerico
            if (id.matches("\\d+")) {
                comprobar.setInt(1, Integer.parseInt(id));
            }
            else {
                comprobar.setString(1, id);
            }
            
            // Ejecutamos la consulta y lo guardamos en resultados
            try (ResultSet resultados = comprobar.executeQuery()) {
                imprimirResultados(resultados);
            }
        }
        catch (SQLException e) {
            System.out.println("Error al ejecutar la consulta");
        }
    }
    
    /**
     * Imprime los resultados de una consulta a la base de datos. Mostrando todas las columas de la tabla.
     * @param resultados Los resultados de la consulta a imprimir.
    */
    public static void imprimirResultados(ResultSet resultados) {
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