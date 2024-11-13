package miprimerabd;

import java.sql.*;

/**
 *
 * @author Aaron
 */
public class MiPrimeraBD {

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        String url = "jdbc:mysql://localhost:3306/";
        String usuario = "root";
        String contrasena = "";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            System.out.println("Fallo driver");
        }
        
        try {
            conn = DriverManager.getConnection(url, usuario, contrasena);
            stmt = conn.createStatement();
            
            //stmt.execute("CREATE DATABASE PROBANDODANI");
            rs = stmt.executeQuery("SELECT * FROM ciclistas.ciclista");
            
            String nombre;
            int edad;
            
            while (rs.next()) {
                nombre = rs.getString("nombre");
                edad = rs.getInt("edad");

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
