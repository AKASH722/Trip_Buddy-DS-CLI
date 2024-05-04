package TripBuddy.Customer;

import TripBuddy.Records.User;
import TripBuddy.TripBuddy;
import TripBuddy.Utilities.Validator;

import java.util.Scanner;

import static TripBuddy.TripBuddy.viewDataStructures;

public class CustomerDashboard {
    private final User user;
    private final Scanner scanner = new Scanner(System.in);

    public CustomerDashboard(User user) {
        System.out.println("\nWelcome, " + user.getName() + "!");
        this.user = user;
    }

    public void display() {
        while (true) {
            System.out.println("\n-----------------------------");
            System.out.println("Customer Dashboard:");
            System.out.println("1. Packages");
            System.out.println("2. Hotels");
            System.out.println("3. Cruises");
            System.out.println("4. Bookings");
            System.out.println("5. Profile");
            System.out.println("6. Logout");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> new PackagesDashboard(user).display();
                case "2" -> new HotelsDashboard(user).display();
                case "3" -> new CruiseDashboard(user).display();
                case "4" -> new BookingsDashboard(user).display();
                case "5" -> displayProfile();
                case "6" -> {
                    System.out.println("Successfully Logged Out.");
                    return;
                }
                case "view ds" -> viewDataStructures();
                default -> System.out.println("Invalid Input. Please try again.");
            }
        }
    }

    private void displayProfile() {
        while (true) {
            System.out.println("\n-----------------------------");
            System.out.println("Profile Options:");
            System.out.println("1. View Profile");
            System.out.println("2. Edit Profile");
            System.out.println("3. Go Back");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> {
                    System.out.println("\nName: " + user.getName());
                    System.out.println("Email: " + user.getEmail());
                    System.out.println("Phone: " + user.getPhoneNumber());
                    System.out.println("Country: " + user.getCountry());
                }
                case "2" -> editProfile();
                case "3" -> {
                    return;
                }
                default -> System.out.println("Invalid Input. Please try again.");
            }
        }
    }

    private void editProfile() {
        while (true) {
            System.out.println("\n-----------------------------");
            System.out.println("Edit Profile:");
            System.out.println("1. Name");
            System.out.println("2. Phone");
            System.out.println("3. Country");
            System.out.println("4. Go Back");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> {
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine().trim();
                    while (name.isEmpty()) {
                        System.out.println("Name cannot be empty");
                        System.out.print("Enter Name: ");
                        name = scanner.nextLine().trim();
                    }
                    user.setName(name);
                    System.out.println("Name Updated Successfully");
                }
                case "2" -> {
                    System.out.print("Enter Phone Number: ");
                    String phoneNumber = scanner.nextLine().trim();
                    while (!Validator.contact(phoneNumber)) {
                        System.out.println("Invalid Phone Number");
                        System.out.print("Enter Phone Number: ");
                        phoneNumber = scanner.nextLine().trim();
                    }
                    user.setPhoneNumber(phoneNumber);
                    System.out.println("Phone Number Updated Successfully");
                }
                case "3" -> {
                    String country;
                    do {
                        System.out.print("Country: ");
                        country = scanner.nextLine().trim();
                        if (!TripBuddy.countries.search(country.toUpperCase())) {
                            System.out.println("Enter a valid country");
                        } else {
                            break;
                        }
                    } while (true);
                    user.setCountry(country);
                    System.out.println("Country Updated Successfully");
                }
                case "4" -> {
                    return;
                }
                default -> System.out.println("Invalid Input. Please try again.");
            }
        }
    }
}
