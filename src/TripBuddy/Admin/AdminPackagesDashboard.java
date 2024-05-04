package TripBuddy.Admin;

import TripBuddy.Records.Hotel;
import TripBuddy.Records.Packages;
import TripBuddy.TripBuddy;

import java.util.Scanner;

public class AdminPackagesDashboard {
    private final Scanner scanner = new Scanner(System.in);

    public void display() {
        while (true) {
            System.out.println("\n-----------------------------");
            System.out.println("Admin Packages Dashboard:");
            System.out.println("1. View all Packages");
            System.out.println("2. Add new Package");
            System.out.println("3. Go Back");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> viewAllPackages();
                case "2" -> addPackage();
                case "3" -> {
                    return;
                }
                default -> System.out.println("Invalid Input. Please try again.");
            }
        }
    }

    private void addPackage() {
        System.out.println("\nAdding a New Package:");
        System.out.print("Enter Package Name: ");
        String name = scanner.nextLine().trim();
        while (name.isEmpty()) {
            System.out.println("Name cannot be empty");
            System.out.print("Enter Package Name: ");
            name = scanner.nextLine().trim();
        }

        System.out.print("Enter Location: ");
        String location = scanner.nextLine().trim();
        while (location.isEmpty()) {
            System.out.println("Location cannot be empty");
            System.out.print("Enter Location: ");
            location = scanner.nextLine().trim();
        }

        System.out.print("Enter Price: ");
        double price = Double.parseDouble(scanner.nextLine().trim());
        while (price <= 0) {
            System.out.println("Price cannot be less than or equal to 0");
            System.out.print("Enter Price: ");
            price = Double.parseDouble(scanner.nextLine().trim());
        }

        System.out.print("Enter Description: ");
        String description = scanner.nextLine().trim();
        while (description.isEmpty()) {
            System.out.println("Description cannot be empty");
            System.out.print("Enter Description: ");
            description = scanner.nextLine().trim();
        }

        Hotel hotel;
        while (true) {
            System.out.print("Enter Hotel Name: ");
            String hotelName = scanner.nextLine().trim();
            while (hotelName.isEmpty()) {
                System.out.println("Hotel Name cannot be empty");
                System.out.print("Enter Hotel Name: ");
                hotelName = scanner.nextLine().trim();
            }
            hotel = TripBuddy.hotelsTree.searchByName(hotelName);
            if (hotel == null) {
                System.out.println("Hotel Not Found");
            } else {
                break;
            }
        }

        Packages newPackage = new Packages(name, location, price, hotel, description);
        TripBuddy.packages.add(newPackage);
        System.out.println("Package Added Successfully");
    }

    private void viewAllPackages() {
        System.out.println("\nPackages: ");
        for (int i = 0; i < TripBuddy.packages.size(); i++) {
            System.out.println(i + 1 + ". " + TripBuddy.packages.get(i).getName());
        }
        System.out.print("Enter Package Number To view details: ");
        int packageIndex = Integer.parseInt(scanner.nextLine().trim()) - 1;
        if (packageIndex < 0 || packageIndex >= TripBuddy.packages.size()) {
            System.out.println("Invalid Package Number");
        } else {
            viewPackage(packageIndex);
        }
    }

    private void viewPackage(int packageIndex) {
        Packages selectedPackage = TripBuddy.packages.get(packageIndex);
        selectedPackage.display();
        System.out.print("\nDo you want to delete this package? (y/n): ");
        String book = scanner.nextLine().trim();
        if (book.equals("y")) {
            TripBuddy.packages.remove(packageIndex);
            System.out.println("Package Deleted Successfully");
        }
    }
}
