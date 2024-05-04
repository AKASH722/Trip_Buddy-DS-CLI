package TripBuddy.Customer;

import TripBuddy.Records.Booking;
import TripBuddy.Records.Hotel;
import TripBuddy.Records.User;
import TripBuddy.TripBuddy;
import TripBuddy.Utilities.Validator;

import java.util.Date;
import java.util.Scanner;

public class HotelsDashboard {
    private final User user;
    private final Scanner scanner = new Scanner(System.in);

    public HotelsDashboard(User user) {
        this.user = user;
    }

    public void display() {
        while (true) {
            System.out.println("\n-----------------------------");
            System.out.println("Hotels Dashboard:");
            System.out.println("1. Search Hotels");
            System.out.println("2. View all Hotels");
            System.out.println("3. Go Back");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> searchHotels();
                case "2" -> viewAllHotels();
                case "3" -> {
                    return;
                }
                default -> System.out.println("Invalid Input. Please try again.");
            }
        }
    }

    private void searchHotels() {
        System.out.print("Enter Hotel Name: ");
        String hotelName = scanner.nextLine().trim();
        Hotel hotel = TripBuddy.hotelsTree.searchByName(hotelName);

        if (hotel == null) {
            System.out.println("Hotel Not Found");
        } else {
            viewHotel(hotel);
        }
    }

    private void viewAllHotels() {
        System.out.println("\nAvailable Hotels:");
        for (int i = 0; i < TripBuddy.hotels.size(); i++) {
            System.out.println(i + 1 + ". " + TripBuddy.hotels.get(i).getName());
        }
        System.out.print("Enter Hotel Number To view details (or 'b' to go back): ");
        String choice = scanner.nextLine().trim();

        if (choice.equals("b")) {
            return;
        }

        try {
            int hotelIndex = Integer.parseInt(choice) - 1;

            if (hotelIndex < 0 || hotelIndex >= TripBuddy.hotels.size()) {
                System.out.println("Invalid Hotel Number. Please try again.");
            } else {
                viewHotel(TripBuddy.hotels.get(hotelIndex));
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid Input. Please enter a valid hotel number.");
        }
    }

    private void viewHotel(Hotel hotel) {
        System.out.println("\n-----------------------------");
        hotel.display();

        System.out.print("\nDo you want to book this Hotel? (y/n): ");
        String book = scanner.nextLine().trim();

        if (book.equals("y")) {
            bookHotel(hotel);
        }
    }

    private void bookHotel(Hotel hotel) {
        System.out.println("\n-----------------------------");
        System.out.print("Enter number of people: ");
        int people = Integer.parseInt(scanner.nextLine().trim());
        Date checkInDate, checkOutDate;

        do {
            System.out.print("Enter Check-In date (DD MM YYYY): ");
            checkInDate = Validator.getDate(scanner.nextLine().trim());

            while (checkInDate == null) {
                System.out.println("Invalid date");
                System.out.print("Enter Check-In date (DD MM YYYY): ");
                checkInDate = Validator.getDate(scanner.nextLine().trim());
            }

            System.out.print("Enter Check-Out date (DD MM YYYY): ");
            checkOutDate = Validator.getDate(scanner.nextLine().trim());

            while (checkOutDate == null) {
                System.out.println("Invalid date");
                System.out.print("Enter Check-Out date (DD MM YYYY): ");
                checkOutDate = Validator.getDate(scanner.nextLine().trim());
            }

            if (checkOutDate.before(checkInDate)) {
                System.out.println("Check-Out date should be after Check-In date");
            }
        } while (checkOutDate.before(checkInDate));

        double price = hotel.getPrice() * people;

        Booking booking = new Booking(user.getEmail(), hotel, price, people, checkInDate, checkOutDate, "Hotels");

        System.out.println("\nBooking Details:");
        booking.display();

        System.out.print("Confirm Booking? (y/n): ");
        String confirm = scanner.nextLine().trim();

        if (confirm.equals("y")) {
            user.getBookings().addLast(booking);
            TripBuddy.bookingsQueue.enqueue(booking);
            System.out.println("\nBooking Confirmation Pending.");
            System.out.println("You will receive confirmation soon. Thank You!");
        } else {
            System.out.println("\nBooking Cancelled.");
        }
    }
}
