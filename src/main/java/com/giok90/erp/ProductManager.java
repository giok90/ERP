package com.giok90.erp;

import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    private List<Product> products = new ArrayList<>();

    public ProductManager() {
        products.add(new Product(101, "Laptop", 999.99));
        products.add(new Product(102, "Οθόνη", 199.99));
        products.add(new Product(103, "Πληκτρολόγιο", 29.99));
    }

    public List<Product> getProducts() {
        return products;
    }

    public Product findByCode(int code) {
        return products.stream()
            .filter(p -> p.getCode() == code)
            .findFirst()
            .orElse(null);
    }
}
