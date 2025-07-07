package com.giok90.erp;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CustomerDAO customerDAO = new CustomerDAO();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== MENU ===");
            System.out.println("1. View all customers");
            System.out.println("2. Search customer by ID");
            System.out.println("3. Add new customer");
            System.out.println("4. Exit");
            System.out.print("Choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    List<Customer> customers = customerDAO.getAllCustomers();
                    System.out.println("\nCustomers:");
                    for (Customer c : customers) {
                        System.out.println("ID: " + c.getId() + " - " + c.getName());
                    }
                    break;

                case "2":
                    try {
                        System.out.print("Enter customer ID: ");
                        int id = Integer.parseInt(scanner.nextLine());
                        Customer found = customerDAO.findById(id);
                        if (found != null) {
                            System.out.println("Customer: " + found);
                        } else {
                            System.out.println("No customer found with ID " + id);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID. Please enter a number.");
                    }
                    break;

                case "3":
                    System.out.print("Customer name: ");
                    String name = scanner.nextLine();
                    System.out.print("Customer email: ");
                    String email = scanner.nextLine();
                    Customer newCustomer = new Customer(0, name, email);
                    customerDAO.insert(newCustomer);
                    System.out.println("Customer added successfully!");
                    break;

                case "4":
                    running = false;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }
}