package com.giok90.erp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CustomerDAO customerDAO = new CustomerDAO();
        ProductDAO productDAO = new ProductDAO();
        OrderDAO orderDAO = new OrderDAO();

        // ----- Επιλογή πελάτη -----
        List<Customer> customers = customerDAO.getAllCustomers();
        System.out.println("📋 Λίστα Πελατών:");
        for (Customer c : customers) {
            System.out.println("ID: " + c.getId() + " - " + c.getName());
        }

        System.out.print("➡ Δώσε το ID πελάτη: ");
        int customerId = Integer.parseInt(scanner.nextLine());
        Customer selectedCustomer = customerDAO.findById(customerId);

        if (selectedCustomer == null) {
            System.out.println("❌ Δεν βρέθηκε πελάτης με ID " + customerId);
            return;
        }

        // ----- Επιλογή προϊόντων -----
        List<Product> products = productDAO.getAllProducts();
        System.out.println("\n🛒 Διαθέσιμα προϊόντα:");
        for (Product p : products) {
            System.out.println("Code: " + p.getCode() + " - " + p.getName() + " (€" + p.getPrice() + ")");
        }

        System.out.print("➡ Πόσα προϊόντα θέλεις να προσθέσεις στην παραγγελία; ");
        int count = Integer.parseInt(scanner.nextLine());

        List<Product> selectedProducts = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            System.out.print("Δώσε τον κωδικό προϊόντος #" + (i + 1) + ": ");
            int code = Integer.parseInt(scanner.nextLine());
            Product p = productDAO.findByCode(code);
            if (p != null) {
                selectedProducts.add(p);
            } else {
                System.out.println("⚠ Το προϊόν με κωδικό " + code + " δεν βρέθηκε.");
            }
        }

        // ----- Δημιουργία και αποθήκευση παραγγελίας -----
        Order order = new Order(0, selectedCustomer, selectedProducts);
        orderDAO.saveOrder(order);

        scanner.close();
    }
}