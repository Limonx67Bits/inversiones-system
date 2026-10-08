package main.java.com.inversionesmagdezis.inversionessystem.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection conn;
    
    private DBConnection() {
    }
    
    public static Connection getDBConnection() throws SQLException {
        if (conn == null || conn.isClosed()) {
            conn = DriverManager.getConnection(Credentials.DB_URL, Credentials.DB_USER, Credentials.DB_PASS);
        }
        return conn;
    }
}
