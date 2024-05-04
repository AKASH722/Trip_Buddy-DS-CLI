package TripBuddy.Customer;

import TripBuddy.Records.Booking;
import TripBuddy.Records.Cruises;
import TripBuddy.Records.User;
import TripBuddy.TripBuddy;

import java.util.Scanner;

public class CruiseDashboard {
    private final User user;
    private final Scanner scanner = new Scanner(System.in);

    public CruiseDashboard(User user) {
        this.user = user;
    }

    public void display() {
        while (true) {
            System.out.println("\n-----------------------------");
            System.out.println("Cruise Dashboard:");
            System.out.println("1. Search Cruise");
            System.out.println("2. View all Cruise");
            System.out.println("3. Go Back");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> searchCruise();
                case "2" -> viewAllCruises();
                case "3" -> {
                    System.out.println("Go Back To Customer Dashboard");
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
        System.out.println("\nAvailable Cruises:");
        for (int i = 0; i < TripBuddy.cruises.size(); i++) {
            System.out.println(i + 1 + ". " + TripBuddy.cruises.get(i).getName());
        }
        System.out.print("Enter Cruise Number To view details (or 'b' to go back): ");
        String choice = scanner.nextLine().trim();

        if (choice.equals("b")) {
            return;
        }

        try {
            int cruiseIndex = Integer.parseInt(choice) - 1;

            if (cruiseIndex < 0 || cruiseIndex >= TripBuddy.cruises.size()) {
                System.out.println("Invalid Cruise Number. Please try again.");
            } else {
                viewCruise(TripBuddy.cruises.get(cruiseIndex));
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid Input. Please enter a valid cruise number.");
        }
    }

    private void viewCruise(Cruises cruise) {
        System.out.println("\n-----------------------------");
        cruise.display();
        System.out.println("\nDo you want to book this Cruise? (y/n)");
        String book = scanner.nextLine().trim();
        if (book.equals("y")) {
            bookCruise(cruise);
        }
    }

    private void bookCruise(Cruises cruise) {
        System.out.println("\n-----------------------------");
        System.out.print("Enter number of people: ");
        int people = Integer.parseInt(scanner.nextLine().trim());
        double price = cruise.getPrice() * people;
        System.out.println("Total Price: " + price);
        System.out.println("\nConfirm Booking? (y/n)");
        String confirm = scanner.nextLine().trim();
        if (confirm.equals("y")) {
            Booking booking = new Booking(user.getEmail(), cruise, price, people, null, null, "Cruises");
            user.getBookings().addLast(booking);
            TripBuddy.bookingsQueue.enqueue(booking);
            System.out.println("Booking Confirmation Pending.");
            System.out.println("You will receive confirmation with journey date soon. Thank You!");
        } else {
            System.out.println("Booking Cancelled");
        }
    }
}
