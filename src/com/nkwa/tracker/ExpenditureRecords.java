package com.nkwa.tracker;
import java.util.HashMap;
import java.util.Scanner;

class Expenditure {
    String code;
    double amount;
    String date;
    String phase;
    String category;
    String accountUsed;

    public Expenditure(String code, double amount, String date, String phase, String category, String accountUsed) {
        this.code = code;
        this.amount = amount;
        this.date = date;
        this.phase = phase;
        this.category = category;
        this.accountUsed = accountUsed;
    }

    @Override
    public String toString() {
        return "Code: " + code + ", Amount: " + amount + ", Date: " + date + ", Phase: " + phase + 
               ", Category: " + category + ", Account Used: " + accountUsed;
    }
}

public class ExpenditureRecords {
    static Scanner scanner = new Scanner(System.in);
    static HashMap<String, Expenditure> expenditures = new HashMap<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Expenditure Records Menu ---");
            System.out.println("1. Add Expenditure");
            System.out.println("2. View Expenditure by Code");
            System.out.println("3. Exit");
            System.out.print("Select option: ");
            int choice = scanner.nextInt(); scanner.nextLine();

            switch (choice) {
                case 1 -> addExpenditure();
                case 2 -> viewExpenditure();
                case 3 -> System.exit(0);
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    static void addExpenditure() {
        System.out.print("Enter Code: ");
        String code = scanner.nextLine();
        System.out.print("Enter Amount: ");
        double amount = scanner.nextDouble(); scanner.nextLine();
        System.out.print("Enter Date: ");
        String date = scanner.nextLine();
        System.out.print("Enter Phase: ");
        String phase = scanner.nextLine();
        System.out.print("Enter Category: ");
        String category = scanner.nextLine();
        System.out.print("Enter Account Used: ");
        String accountUsed = scanner.nextLine();

        Expenditure exp = new Expenditure(code, amount, date, phase, category, accountUsed);
        expenditures.put(code, exp);
        System.out.println("Expenditure recorded successfully.");
    }

    static void viewExpenditure() {
        System.out.print("Enter Expenditure Code: ");
        String code = scanner.nextLine();

        if (expenditures.containsKey(code)) {
            System.out.println(expenditures.get(code));
        } else {
            System.out.println("Expenditure not found.");
        }
    }
}