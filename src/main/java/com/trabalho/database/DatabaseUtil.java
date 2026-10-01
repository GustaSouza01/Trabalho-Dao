package com.trabalho.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DatabaseUtil {
    private DatabaseUtil() {
    }

    public static Connection getConnection() throws SQLException {
        String url = System.getProperty("db.url", "jdbc:mysql://localhost:3306/empresa_x?useSSL=false&serverTimezone=UTC");
        String user = System.getProperty("db.user", "root");
        String password = System.getProperty("db.password", "");

        return DriverManager.getConnection(url, user, password);
    }
}
