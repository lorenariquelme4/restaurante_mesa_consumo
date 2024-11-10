/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Lorena
 */
    
package miproyecto.restaurante;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionPostgres {

    // Método para conectar a PostgreSQL
    public static Connection conectar() {
        Connection conn = null;
        try {
            // Cambia la URL, usuario y contraseña según tu configuración de PostgreSQL
            String url = "jdbc:postgresql://localhost:5432/restaurante";
            String user = "postgres";
            String password = "1999";
            
            // Conexión a la base de datos
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa a PostgreSQL.");
        } catch (SQLException e) {
            System.out.println("Error al conectar a PostgreSQL: " + e.getMessage());
        }
        return conn;
    }
}
