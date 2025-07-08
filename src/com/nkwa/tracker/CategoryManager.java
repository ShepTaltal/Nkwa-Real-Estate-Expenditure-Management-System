package com.nkwa.tracker;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CategoryManager {
    static Scanner scanner = new Scanner(System.in);
    static Set<String> categories = new HashSet<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Category Management Menu ---");
            System.out.println("1. Add Category");
            System.out.println("2. View All Categories");
            System.out.println("3. Search Category");
            System.out.println("4. Exit");
            System.out.print("Select option: ");
            int choice = scanner.nextInt(); scanner.nextLine();

            switch (choice) {
                case 1 -> addCategory();
                case 2 -> viewCategories();
                case 3 -> searchCategory();
                case 4 -> System.exit(0);
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    static void addCategory() {
        System.out.print("Enter Category Name: ");
        String category = scanner.nextLine();
        if (categories.add(category)) {
            System.out.println("Category added.");
        } else {
            System.out.println("Category already exists.");
        }
    }

    static void viewCategories() {
        System.out.println("All Categories:");
        for (String cat : categories) {
            System.out.println("- " + cat);
        }
    }

    static void searchCategory() {
        System.out.print("Enter Category to Search: ");
        String search = scanner.nextLine();
        if (categories.contains(search)) {
            System.out.println("Category found.");
        } else {
            System.out.println("Category not found.");
        }
    }
}