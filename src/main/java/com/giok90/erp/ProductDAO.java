package com.giok90.erp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM products";

        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                products.add(new Product(
                    rs.getInt("code"),
                    rs.getString("name"),
                    rs.getDouble("price")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }

    public Product findByCode(int code) {
        String sql = "SELECT * FROM products WHERE code = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, code);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Product(
                    rs.getInt("code"),
                    rs.getString("name"),
                    rs.getDouble("price")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}