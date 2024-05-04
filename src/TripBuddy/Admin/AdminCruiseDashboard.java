package TripBuddy.Admin;

import TripBuddy.Records.Cruises;
import TripBuddy.TripBuddy;

import java.util.Scanner;

public class AdminCruiseDashboard {
    private final Scanner scanner = new Scanner(System.in);

    public void display() {
        while (true) {
            System.out.println("\n-----------------------------");
            System.out.println("Admin Cruise Dashboard:");
            System.out.println("1. Search Cruise");
            System.out.println("2. View all Cruise");
            System.out.println("3. Add new Cruise");
            System.out.println("4. Go Back");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> searchCruise();
                case "2" -> viewAllCruises();
                case "3" -> addCruise();
                case "4" -> {
                    return;
                }
                default -> System.out.println("Invalid Input. Please try again.");
            }
        }
    }

    private void searchCruise() {
        System.out.print("Enter Cruise Name: ");
        String cruiseName = scanner.nextLine().trim();
        Cruises cruise = TripBuddy.cruisesTree.searchByName(cruiseName);
        if (cruise == null) {
            System.out.println("Cruise Not Found");
        } else {
            viewCruise(cruise);
        }
    }

    private void viewAllCruises() {
        System.out.println("Cruises: ");
        for (int i = 0; i < TripBuddy.cruises.size(); i++) {
            System.out.println(i + 1 + ". " + TripBuddy.cruises.get(i).getName());
        }
        System.out.print("Enter Cruise Number To view details: ");
        int cruiseIndex = Integer.parseInt(scanner.nextLine().trim()) - 1;
        if (cruiseIndex < 0 || cruiseIndex >= TripBuddy.cruises.size()) {
            System.out.println("Invalid Cruise Number");
        } else {
            viewCruise(TripBuddy.cruises.get(cruiseIndex));
        }
    }

    private void addCruise() {
        System.out.println("\nAdding a New Cruise:");
        System.out.print("Enter Cruise Name: ");
        String cruiseName = scanner.nextLine().trim();
        while (cruiseName.isEmpty()) {
            System.out.println("Cruise Name cannot be empty");
            System.out.print("Enter Cruise Name: ");
            cruiseName = scanner.nextLine().trim();
        }

        System.out.print("Enter Origin Port: ");
        String originPort = scanner.nextLine().trim();
        while (originPort.isEmpty()) {
            System.out.println("Origin Port cannot be empty");
            System.out.print("Enter Origin Port: ");
            originPort = scanner.nextLine().trim();
        }

        System.out.print("Enter Destination Port: ");
        String destinationPort = scanner.nextLine().trim();
        while (destinationPort.isEmpty()) {
            System.out.println("Destination Port cannot be empty");
            System.out.print("Enter Destination Port: ");
            destinationPort = scanner.nextLine().trim();
        }

        System.out.print("Enter Price: ");
        double price = Double.parseDouble(scanner.nextLine().trim());
        while (price <= 0) {
            System.out.println("Price cannot be less than or equal to 0");
            System.out.print("Enter Price: ");
            price = Double.parseDouble(scanner.nextLine().trim());
        }

        System.out.print("Enter Duration (in days): ");
        int duration = Integer.parseInt(scanner.nextLine().trim());
        while (duration <= 0) {
            System.out.println("Duration cannot be less than or equal to 0");
            System.out.print("Enter Duration (in days): ");
            duration = Integer.parseInt(scanner.nextLine().trim());
        }

        System.out.print("Enter Description: ");
        String description = scanner.nextLine().trim();
        while (description.isEmpty()) {
            System.out.println("Description cannot be empty");
            System.out.print("Enter Description: ");
            description = scanner.nextLine().trim();
        }

        Cruises cruise = new Cruises(cruiseName, description, price, originPort, destinationPort, duration + " days");
        TripBuddy.cruisesTree.add(cruise);
        TripBuddy.cruises.add(cruise);
        System.out.println("Cruise Added Successfully");
    }

    private void viewCruise(Cruises cruise) {
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("\nCruise name: " + cruise.getName());
        System.out.println("Origin Port: " + cruise.getOriginPort());
        System.out.println("Destination Port: " + cruise.getDestinationPort());
        System.out.println("Price: " + cruise.getPrice());
        System.out.println("Duration: " + cruise.getDuration());
        System.out.print("Description: ");
        for (String line : cruise.getDescription().split("\\.")) {
            System.out.println(line.trim() + ".");
        }
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.print("\nDo you want to delete this Cruise? (y/n): ");
        String choice = scanner.nextLine().trim();
        if (choice.equals("y")) {
            TripBuddy.cruisesTree.remove(cruise);
            TripBuddy.cruises.remove(TripBuddy.cruises.get(cruise));
            System.out.println("Cruise Deleted Successfully");
        }
    }
}
