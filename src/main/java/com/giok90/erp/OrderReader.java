package com.giok90.erp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class OrderReader {

    public void displayAllOrders() {
        System.out.println("\n📖 Παραγγελίες από αρχείο orders.txt:");

        try (BufferedReader reader = new BufferedReader(new FileReader("orders.txt"))) {
            String line;
            int count = 0;
            while ((line = reader.readLine()) != null) {
                count++;
                System.out.println(count + ". " + line);
            }

            if (count == 0) {
                System.out.println("⚠ Δεν υπάρχουν παραγγελίες στο αρχείο.");
            }

        } catch (IOException e) {
            System.out.println("❌ Σφάλμα κατά την ανάγνωση του αρχείου.");
            e.printStackTrace();
        }
    }
}
