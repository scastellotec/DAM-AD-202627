package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    public static Connection getConexionBD() throws SQLException {
        // Creo la conexion y la devuelvo
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/tienda",
                "dam",
                "dam2026");
        return con;
    }
}
