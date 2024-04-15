package consultadorhacendado;

import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author Aaron
 */
public class ConsultadorHacendado {
    static Connection conn = null;
    static Statement stmt;
    static ResultSet rs;
    static String url = "jdbc:mysql://localhost:3307/ciclistas";
    static String user = "root";
    static String password = "";
    static String tabla = "";
    static String pk = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("MIntroduce dato a consultar: ");
        System.out.println("1. Ciclista");
        System.out.println("2. Equipo");
        System.out.println("3. Etapa");
        
        int opciones = scanner.nextInt();
        
        switch (opciones) { 
            case 1 -> {
                System.out.print("Introduce el dorsal: ");
                int dorsal = scanner.nextInt();
                tabla = "ciclista";
                pk = "dorsal";
                
                consulta(dorsal);
            }
            case 2 -> {
                System.out.print("Introduce el nombre del equipo: ");
                String nombreEquipo = scanner.nextLine();
                
                tabla = "equipo";
                pk = "nomequipo";
                
                consultaString(nombreEquipo);
            }
            case 3 -> {
                System.out.print("Introduce la etapa: ");
                int etapa = scanner.nextInt();
                
                tabla = "etapa";
                pk = "numetapa";
                
                consulta(etapa);
            }
            default -> System.out.println("La opcion escogida es incorrecta");
        }
    }
    
    public static void consulta(int id) {
        // Importar driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            System.out.println("Fallo al importal el driver");
        }
        
        // Trabajo con base de datos
        try {
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();
            
            //stmt.execute("CREATE DATABASE PROBANDO");
            rs = stmt.executeQuery("SELECT * FROM " + tabla + " WHERE " + pk + "=" + id);
                while (rs.next()) {
                    
                    ResultSetMetaData metaData = rs.getMetaData();
                    int columnCount = metaData.getColumnCount();

                    for (int i = 1; i <= columnCount; i++) {
                        Object value = rs.getObject(i);
                        String columnName = metaData.getColumnName(i);
                        System.out.println(columnName + ": " + value);
                    }
                    
                    System.out.println();
                }
            rs.close();
            stmt.close();
        }
        catch (SQLException e) {
            System.out.println("Fallo al hacer las consultas");
        }
    }
    
    public static void consultaString(String id) {
       // Importar driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            System.out.println("Fallo al importal el driver");
        }
        
        // Trabajo con base de datos
        try {
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();
            
            rs = stmt.executeQuery("SELECT * FROM " + tabla + " WHERE " + pk + "=" + id + "");
                while (rs.next()) {
                    
                    ResultSetMetaData metaData = rs.getMetaData();
                    int columnCount = metaData.getColumnCount();

                    for (int i = 1; i <= columnCount; i++) {
                        Object value = rs.getObject(i);
                        String columnName = metaData.getColumnName(i);
                        System.out.println(columnName + ": " + value);
                    }
                    
                    System.out.println();
                }
            rs.close();
            stmt.close();
        }
        catch (SQLException e) {
            System.out.println("Fallo al hacer las consultas");
        }
    }
}