package TripBuddy;

import TripBuddy.Admin.AdminDashboard;
import TripBuddy.Customer.CustomerDashboard;
import TripBuddy.Data.Data;
import TripBuddy.DataStructures.*;
import TripBuddy.DataStructures.Modified.AVL_Hotels;
import TripBuddy.DataStructures.Modified.AVL_cruises;
import TripBuddy.Records.*;
import TripBuddy.Utilities.Validator;

import java.util.Scanner;

public class TripBuddy {
    public static Hashtable<String, User> users = new Hashtable<>(10);
    public static Scanner scanner = new Scanner(System.in);
    public static ArrayList<Packages> packages = new ArrayList<>();
    public static ArrayList<Hotel> hotels = new ArrayList<>();
    public static AVL_Hotels hotelsTree;
    public static AVL<String> countries = new AVL<>();
    public static Queue<Booking> bookingsQueue = new Queue<>();
    public static ArrayList<Cruises> cruises = new ArrayList<>();
    public static AVL_cruises cruisesTree;
    public static LinkedList<Booking> bookings = new LinkedList<>();
    private static User user;

    public static void main(String[] args) {
        getData();
        authenticateUser();
    }

    /**
     * This method is used to get static data and store it in the data structures
     */
    private static void getData() {
        Data data = new Data();
        data.getUsers(users);
        data.getHotels(hotels);
        hotelsTree = new AVL_Hotels(TripBuddy.hotels);
        data.getPackages(packages);
        data.setCountries(countries);
        data.getCruises(cruises);
        data.preBookings();
        cruisesTree = new AVL_cruises(TripBuddy.cruises);
    }

    /**
     * This method is used to authenticate the user
     * If the user is a customer, then the customer dashboard is displayed
     * If the user is an admin, then the admin dashboard is displayed
     * If the user is not registered, then the user is ask to sign up
     */
    public static void authenticateUser() {
        while (true) {
            System.out.println("\n-----------------------------");
            System.out.println("Welcome to TripBuddy!");
            System.out.println("1. Login");
            System.out.println("2. Sign Up");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1" -> {
                    User authenticatedUser = login();
                    if (authenticatedUser != null) {
                        user = authenticatedUser;
                        displayDashboard();
                    }
                }
                case "2" -> signUp();
                case "3" -> {
                    System.out.println("Thank you for using TripBuddy.");
                    scanner.close();
                    System.exit(0);
                }
                case "view ds" -> viewDataStructures();
                default -> System.out.println("Invalid Input. Please try again.");
            }
        }
    }

    /**
     * This method is used to view the data structures
     */
    public static void viewDataStructures() {
        while (true) {
            System.out.println("\n-----------------------------");
            System.out.println("Data Structures:");
            System.out.println("0. Continue to application");
            System.out.println("1. Users Hashtable");
            System.out.println("2. Hotels ArrayList");
            System.out.println("3. Hotels AVL Tree");
            System.out.println("4. Packages ArrayList");
            System.out.println("5. Countries AVL Tree");
            System.out.println("6. Cruises ArrayList");
            System.out.println("7. Cruises Tree");
            System.out.println("8. Bookings Queue");
            System.out.println("9. Bookings LinkedList");
            System.out.print("Enter your choice: ");
            String input = scanner.nextLine().trim();
            switch (input) {
                case "1" -> System.out.println("Users Hashtable:\n" + users);
                case "2" -> System.out.println("Hotels ArrayList:\n" + hotels);
                case "3" -> System.out.println("Hotels Tree:\n" + hotelsTree);
                case "4" -> System.out.println("Packages ArrayList:\n" + packages);
                case "5" -> System.out.println("Countries Tree:\n" + countries);
                case "6" -> System.out.println("Cruises ArrayList:\n" + cruises);
                case "7" -> System.out.println("Cruises Tree:\n" + cruisesTree);
                case "8" -> System.out.println("Bookings Queue:\n" + bookingsQueue);
                case "9" -> System.out.println("Bookings LinkedList:\n" + bookings);
                case "0" -> {
                    return;
                }
                default -> System.out.println("Invalid Input. Please try again.");
            }
        }
    }

    /**
     * This method is used to login the user
     *
     * @return User object if the user is authenticated, else null
     */
    private static User login() {
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        if (TripBuddy.users.contains(email)) {
            User user = TripBuddy.users.get(email);
            if (user.getPassword().equals(password)) {
                System.out.println("\nLogin Successful");
                return user;
            }
        }

        System.out.println("\nIncorrect Email or Password");
        return null;
    }

    /**
     * This method is used to sign up the user
     * If the user is already registered, then the user is asked to login
     */
    private static void signUp() {
        System.out.println("\nEnter your details:");

        System.out.print("Name: ");
        String name = scanner.nextLine().trim();
        while (name.isEmpty()) {
            System.out.println("Name cannot be empty");
            System.out.print("Name: ");
            name = scanner.nextLine().trim();
        }

        String email;
        do {
            System.out.print("Email: ");
            email = scanner.nextLine().trim();
            if (!Validator.email(email)) {
                System.out.println("Enter a valid email");
            } else {
                break;
            }
        } while (true);

        String password;
        do {
            System.out.print("Password: ");
            password = scanner.nextLine().trim();
            if (!Validator.password(password)) {
                System.out.println("\nPlease enter a password having:");
                System.out.println("-> Minimum length 8");
                System.out.println("-> Includes at least one lowercase letter");
                System.out.println("-> Includes at least one uppercase letter");
                System.out.println("-> Includes at least one number");
                System.out.println("-> Includes at least one special character\n");
            } else {
                break;
            }
        } while (true);

        String phoneNumber;
        do {
            System.out.print("Phone Number: ");
            phoneNumber = scanner.nextLine().trim();
            if (!Validator.contact(phoneNumber)) {
                System.out.println("Enter a valid phone number");
            } else {
                break;
            }
        } while (true);

        String country;
        do {
            System.out.print("Country: ");
            country = scanner.nextLine().trim();
            if (!countries.search(country.toUpperCase())) {
                System.out.println("Enter a valid country");
            } else {
                break;
            }
        } while (true);

        if (TripBuddy.users.contains(email)) {
            System.out.println("\nAccount already exists. Please login");
        } else {
            User user = new User(name, email, password, "Customer", phoneNumber, country);
            TripBuddy.users.put(user.getEmail(), user);
            System.out.println("\nAccount created successfully");
        }
    }

    /**
     * This method is used to display the dashboard
     * If the user is a customer, then the customer dashboard is displayed
     * If the user is an admin, then the admin dashboard is displayed
     */
    public static void displayDashboard() {
        if (user.getUserType().equals("Customer")) {
            CustomerDashboard customerDashboard = new CustomerDashboard(user);
            customerDashboard.display();
        } else {
            AdminDashboard adminDashboard = new AdminDashboard();
            adminDashboard.adminDashboard();
        }
    }
}
