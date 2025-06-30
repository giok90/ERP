package com.giok90.erp;

import java.util.ArrayList;
import java.util.List;

public class CustomerManager {
    private List<Customer> customers = new ArrayList<>();

    public CustomerManager() {
        customers.add(new Customer(1, "Μαρία Παπαδοπούλου", "maria@example.com"));
        customers.add(new Customer(2, "Γιάννης Γεωργίου", "giannis@example.com"));
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public Customer findById(int id) {
        return customers.stream()
            .filter(c -> c.getId() == id)
            .findFirst()
            .orElse(null);
    }
}
