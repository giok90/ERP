package com.giok90.erp;

import java.sql.*;
import java.util.List;

public class OrderDAO {

    public void saveOrder(Order order) {
        String insertOrderSQL = "INSERT INTO orders (customer_id, total) VALUES (?, ?)";
        String insertItemSQL = "INSERT INTO order_items (order_id, product_code) VALUES (?, ?)";

        try (Connection conn = DBUtil.getConnection()) {
            conn.setAutoCommit(false);

            try (PreparedStatement orderStmt = conn.prepareStatement(insertOrderSQL, Statement.RETURN_GENERATED_KEYS)) {
                orderStmt.setInt(1, order.getCustomer().getId());
                orderStmt.setDouble(2, order.getTotal());
                orderStmt.executeUpdate();

                ResultSet generatedKeys = orderStmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int orderId = generatedKeys.getInt(1);

                    try (PreparedStatement itemStmt = conn.prepareStatement(insertItemSQL)) {
                        for (Product p : order.getProducts()) {
                            itemStmt.setInt(1, orderId);
                            itemStmt.setInt(2, p.getCode());
                            itemStmt.addBatch();
                        }
                        itemStmt.executeBatch();
                    }

                    conn.commit();
                    System.out.println("✅ Παραγγελία αποθηκεύτηκε με ID: " + orderId);
                }
            } catch (SQLException e) {
                conn.rollback();
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}