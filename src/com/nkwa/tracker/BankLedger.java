package com.nkwa.tracker;
import java.util.*;

class BankAccount {
    String accountId;
    String bankName;
    double balance;
    List<String> expenditureCodes;

    public BankAccount(String accountId, String bankName, double balance) {
        this.accountId = accountId;
        this.bankName = bankName;
        this.balance = balance;
        this.expenditureCodes = new ArrayList<>();
    }

    @Override
    public String toString() {
        return accountId + " | " + bankName + " | Balance: " + balance + " | Expenditures: " + expenditureCodes;
    }
}

public class BankLedger {
    static Scanner scanner = new Scanner(System.in);
    static Map<String, BankAccount> accounts = new HashMap<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Bank Ledger Menu ---");
            System.out.println("1. Add Bank Account");
            System.out.println("2. View Bank Account");
            System.out.println("3. View All Accounts");
            System.out.println("4. Link Expenditure to Account");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt(); scanner.nextLine();

            switch (choice) {
                case 1 -> addAccount();
                case 2 -> viewAccount();
                case 3 -> viewAllAccounts();
                case 4 -> linkExpenditure();
                case 5 -> System.exit(0);
                default -> System.out.println("Invalid option.");
            }
        }
    }

    static void addAccount() {
        System.out.print("Enter Account ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Bank Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Balance: ");
        double balance = scanner.nextDouble(); scanner.nextLine();

        accounts.put(id, new BankAccount(id, name, balance));
        System.out.println("Account added.");
    }

    static void viewAccount() {
        System.out.print("Enter Account ID: ");
        String id = scanner.nextLine();
        if (accounts.containsKey(id)) {
            System.out.println(accounts.get(id));
        } else {
            System.out.println("Account not found.");
        }
    }

    static void viewAllAccounts() {
        for (BankAccount account : accounts.values()) {
            System.out.println(account);
        }
    }

    static void linkExpenditure() {
        System.out.print("Enter Account ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Expenditure Code: ");
        String code = scanner.nextLine();
        if (accounts.containsKey(id)) {
            accounts.get(id).expenditureCodes.add(code);
            System.out.println("Expenditure linked.");
        } else {
            System.out.println("Account not found.");
        }
    }
}