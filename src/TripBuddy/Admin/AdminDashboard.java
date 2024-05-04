package TripBuddy.Admin;

import java.util.Scanner;

import static TripBuddy.TripBuddy.viewDataStructures;

public class AdminDashboard {
    private final Scanner scanner = new Scanner(System.in);

    public void adminDashboard() {
        while (true) {
            System.out.println("\n-----------------------------");
            System.out.println("Admin Dashboard:");
            System.out.println("1. Packages");
            System.out.println("2. Hotels");
            System.out.println("3. Cruises");
            System.out.println("4. Bookings");
            System.out.println("5. Logout");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> new AdminPackagesDashboard().display();
                case "2" -> new AdminHotelsDashboard().display();
                case "3" -> new AdminCruiseDashboard().display();
                case "4" -> new AdminBookingsDashboard().display();
                case "5" -> {
                    System.out.println("Successfully Logged Out");
                    return;
                }
                case "view ds" -> viewDataStructures();
                default -> System.out.println("Invalid Input. Please try again.");
            }
        }
    }
}
