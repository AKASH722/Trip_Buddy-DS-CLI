package TripBuddy.Customer;

import TripBuddy.Records.Booking;
import TripBuddy.Records.Hotel;
import TripBuddy.Records.Packages;
import TripBuddy.Records.User;
import TripBuddy.TripBuddy;
import TripBuddy.Utilities.Validator;

import java.util.Date;
import java.util.Scanner;

public class PackagesDashboard {
    private final User user;
    private final Scanner scanner = new Scanner(System.in);

    public PackagesDashboard(User user) {
        this.user = user;
    }

    public void display() {
        while (true) {
            System.out.println("\n-----------------------------");
            System.out.println("Packages Dashboard:");
            System.out.println("1. View Packages");
            System.out.println("2. Go Back");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> viewPackages();
                case "2" -> {
                    return;
                }
                default -> System.out.println("Invalid Input. Please try again.");
            }
        }
    }

    private void viewPackages() {
        System.out.println("\nAvailable Packages:");
        for (int i = 0; i < TripBuddy.packages.size(); i++) {
            System.out.println(i + 1 + ". " + TripBuddy.packages.get(i).getName());
        }
        System.out.print("Enter Package Number To view details (or 'b' to go back): ");
        String choice = scanner.nextLine().trim();

        if (choice.equals("b")) {
            return;
        }

        try {
            int packageIndex = Integer.parseInt(choice) - 1;

            if (packageIndex < 0 || packageIndex >= TripBuddy.packages.size()) {
                System.out.println("Invalid Package Number. Please try again.");
            } else {
                viewPackage(packageIndex);
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid Input. Please enter a valid package number.");
        }
    }

    private void viewPackage(int packageIndex) {
        Packages selectedPackage = TripBuddy.packages.get(packageIndex);
        Hotel packageHotel = selectedPackage.getHotel();

        System.out.println("\n-----------------------------");
        System.out.println("Package Details:");
        System.out.println("Name: " + selectedPackage.getName());
        System.out.println("Location: " + selectedPackage.getLocation());
        System.out.println("Price: " + selectedPackage.getPrice());
        System.out.println("Description: ");

        for (String line : selectedPackage.getDescription().split("\\.")) {
            System.out.println("  " + line.trim() + ".");
        }

        System.out.println("\nHotel Details:");
        System.out.println("Name: " + packageHotel.getName());
        System.out.println("Rating: " + packageHotel.getRating());
        System.out.println("Amenities: " + packageHotel.getAmenities());

        System.out.print("\nDo you want to book this package? (y/n): ");
        String book = scanner.nextLine().trim();

        if (book.equals("y")) {
            bookPackage(packageIndex);
        }
    }

    private void bookPackage(int packageIndex) {
        System.out.println("\n-----------------------------");
        System.out.print("Enter the number of people: ");
        int people = Integer.parseInt(scanner.nextLine().trim());
        Date journeyStartDate, returnDate;

        do {
            System.out.print("Enter the date of journey (DD MM YYYY): ");
            journeyStartDate = Validator.getDate(scanner.nextLine().trim());

            while (journeyStartDate == null) {
                System.out.println("Invalid date");
                System.out.print("Enter the date of journey (DD MM YYYY): ");
                journeyStartDate = Validator.getDate(scanner.nextLine().trim());
            }

            System.out.print("Enter the date of return (DD MM YYYY): ");
            returnDate = Validator.getDate(scanner.nextLine().trim());

            while (returnDate == null) {
                System.out.println("Invalid date");
                System.out.print("Enter the date of return (DD MM YYYY): ");
                returnDate = Validator.getDate(scanner.nextLine().trim());
            }

            if (returnDate.before(journeyStartDate)) {
                System.out.println("Return date should be after the journey date");
            }
        } while (returnDate.before(journeyStartDate));

        double price = TripBuddy.packages.get(packageIndex).getPrice() * people;

        Booking booking = new Booking(user.getEmail(), TripBuddy.packages.get(packageIndex), price, people, journeyStartDate, returnDate, "Packages");

        System.out.println("\nBooking Details:");
        booking.display();

        System.out.print("Confirm Booking? (y/n): ");
        String confirm = scanner.nextLine().trim();

        if (confirm.equals("y")) {
            user.getBookings().addFirst(booking);
            TripBuddy.bookingsQueue.enqueue(booking);
            System.out.println("\nBooking Confirmation Pending.");
            System.out.println("You will receive confirmation soon. Thank You!");
        } else {
            System.out.println("\nBooking Cancelled.");
        }
    }
}
