package com.giok90.erp;

import java.util.List;

public class Order {
    private int orderId;
    private Customer customer;
    private List<Product> products;

    public Order(int orderId, Customer customer, List<Product> products) {
        this.orderId = orderId;
        this.customer = customer;
        this.products = products;
    }

    public int getOrderId() { return orderId; }
    public Customer getCustomer() { return customer; }
    public List<Product> getProducts() { return products; }

    public double getTotal() {
        return products.stream().mapToDouble(Product::getPrice).sum();
    }

    @Override
    public String toString() {
        return "Order{" +
               "orderId=" + orderId +
               ", customer=" + customer +
               ", products=" + products +
               ", total=" + getTotal() +
               '}';
    }
}
