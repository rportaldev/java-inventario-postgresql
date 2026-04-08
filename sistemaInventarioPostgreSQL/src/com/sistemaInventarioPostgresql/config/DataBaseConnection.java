package com.sistemaInventarioPostgresql.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {

	static String url = "jdbc:postgresql://localhost:5432/db_inventario";
    static String usuario = "usuario_dev";
    static String password = "devzero";

    public static Connection getConexion() {
        try {
            Connection conn = DriverManager.getConnection(url, usuario, password);
            return conn;
        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e.getMessage());
            return null;
        }
    }

	
}



