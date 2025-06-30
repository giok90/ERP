package com.giok90.erp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseSeeder {

    public static void seedCustomers(Connection conn) throws SQLException {
        String sql = "INSERT IGNORE INTO customers (id, name, email) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, 1);
            stmt.setString(2, "Μαρία Παπαδοπούλου");
            stmt.setString(3, "maria@example.com");
            stmt.executeUpdate();

            stmt.setInt(1, 2);
            stmt.setString(2, "Γιάννης Γεωργίου");
            stmt.setString(3, "giannis@example.com");
            stmt.executeUpdate();

            stmt.setInt(1, 3);
            stmt.setString(2, "Νίκος Οικονόμου");
            stmt.setString(3, "nikos@example.com");
            stmt.executeUpdate();
        }
    }

    public static void seedProducts(Connection conn) throws SQLException {
        String sql = "INSERT IGNORE INTO products (code, name, price) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, 101);
            stmt.setString(2, "Laptop");
            stmt.setDouble(3, 999.99);
            stmt.executeUpdate();

            stmt.setInt(1, 102);
            stmt.setString(2, "Οθόνη");
            stmt.setDouble(3, 199.99);
            stmt.executeUpdate();

            stmt.setInt(1, 103);
            stmt.setString(2, "Πληκτρολόγιο");
            stmt.setDouble(3, 29.99);
            stmt.executeUpdate();

            stmt.setInt(1, 104);
            stmt.setString(2, "Ποντίκι");
            stmt.setDouble(3, 19.90);
            stmt.executeUpdate();

            stmt.setInt(1, 105);
            stmt.setString(2, "Εκτυπωτής");
            stmt.setDouble(3, 149.00);
            stmt.executeUpdate();
        }
    }

    public static void seedAll(Connection conn) throws SQLException {
        seedCustomers(conn);
        seedProducts(conn);
        System.out.println("✅ Η βάση δεδομένων γέμισε με αρχικά δεδομένα.");
    }
}
