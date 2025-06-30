package com.giok90.erp;

public class Product {
    private int code;
    private String name;
    private double price;

    public Product(int code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public int getCode() { return code; }
    public String getName() { return name; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return "Product{" +
               "code=" + code +
               ", name='" + name + ''' +
               ", price=" + price +
               '}';
    }
}
