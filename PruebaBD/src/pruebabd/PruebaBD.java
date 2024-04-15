package pruebabd;

import java.sql.*;

/**
 *
 * @author Aaron
 */
public class PruebaBD {
    
    
    public static void main(String[] args) {
        // Propiedades
        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        String url = "jdbc:mysql://localhost:3307/ciclistas";
        String user = "root";
        String password = "";
        
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
            rs = stmt.executeQuery("SELECT * FROM ciclista");
                while (rs.next()) {
                    String nombre;
                    nombre = rs.getString("nombre");
                    int edad = rs.getInt("edad");
                    System.out.println("El ciclista " + nombre + " tiene una edad de " + edad);
                }
            rs.close();
            stmt.close();
        }
        catch (SQLException e) {
            System.out.println("Fallo al hacer las consultas");
        }
    }
}