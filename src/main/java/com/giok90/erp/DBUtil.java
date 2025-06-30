package com.giok90.erp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/erpdb";
    private static final String USER = "root";
    private static final String PASSWORD = ""; // βάλε τον δικό σου κωδικό

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}