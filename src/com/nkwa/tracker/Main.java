package com.nkwa.tracker;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Nkwa Real Estate Expenditure Tracker ===");
            System.out.println("1. Manage Expenditure Records");
            System.out.println("2. Manage Categories");
            System.out.println("3. Manage Bank Ledger");
            System.out.println("4. Exit");
            System.out.print("Select option: ");
            int choice = scanner.nextInt(); scanner.nextLine();

            switch (choice) {
                case 1 -> ExpenditureRecords.main(null);
                case 2 -> CategoryManager.main(null);
                case 3 -> BankLedger.main(null);
                case 4 -> {
                    System.out.println("Goodbye.");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}