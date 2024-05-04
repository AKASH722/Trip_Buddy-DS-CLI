package TripBuddy.Admin;

import TripBuddy.Records.Hotel;
import TripBuddy.TripBuddy;

import java.util.Scanner;

public class AdminHotelsDashboard {
    private final Scanner scanner = new Scanner(System.in);

    public void display() {
        while (true) {
            System.out.println("\n-----------------------------");
            System.out.println("Admin Hotel Dashboard:");
            System.out.println("1. Search Hotel");
            System.out.println("2. View all Hotels");
            System.out.println("3. Add new Hotel");
            System.out.println("4. Go Back");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> searchHotel();
                case "2" -> viewAllHotels();
                case "3" -> addHotel();
                case "4" -> {
                    return;
                }
                default -> System.out.println("Invalid Input. Please try again.");
            }
        }
    }

    private void searchHotel() {
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
        System.out.println("Hotels: ");
        for (int i = 0; i < TripBuddy.hotels.size(); i++) {
            System.out.println(i + 1 + ". " + TripBuddy.hotels.get(i).getName());
        }
        System.out.print("Enter Hotel Number To view details: ");
        int hotelIndex = Integer.parseInt(scanner.nextLine().trim()) - 1;
        if (hotelIndex < 0 || hotelIndex >= TripBuddy.hotels.size()) {
            System.out.println("Invalid Hotel Number");
        } else {
            viewHotel(TripBuddy.hotels.get(hotelIndex));
        }
    }

    private void addHotel() {
        System.out.println("\nAdding a New Hotel:");
        System.out.print("Enter Hotel Name: ");
        String name = scanner.nextLine().trim();
        while (name.isEmpty()) {
            System.out.println("Name cannot be empty");
            System.out.print("Enter Hotel Name: ");
            name = scanner.nextLine().trim();
        }

        System.out.print("Enter City: ");
        String city = scanner.nextLine().trim();
        while (city.isEmpty()) {
            System.out.println("City cannot be empty");
            System.out.print("Enter City: ");
            city = scanner.nextLine().trim();
        }

        System.out.print("Enter Country: ");
        String country = scanner.nextLine().trim().toUpperCase();
        while (!TripBuddy.countries.search(country)) {
            System.out.println("Country not found");
            System.out.print("Enter Country: ");
            country = scanner.nextLine().trim().toUpperCase();
        }

        System.out.print("Enter Price: ");
        double price = Double.parseDouble(scanner.nextLine().trim());
        while (price <= 0) {
            System.out.println("Price cannot be negative");
            System.out.print("Enter Price: ");
            price = Double.parseDouble(scanner.nextLine().trim());
        }

        System.out.print("Enter Rating: ");
        double rating = Double.parseDouble(scanner.nextLine().trim());
        while (rating < 0 || rating > 5) {
            System.out.println("Rating must be between 0 and 5");
            System.out.print("Enter Rating: ");
            rating = Double.parseDouble(scanner.nextLine().trim());
        }

        System.out.print("Enter Amenities: ");
        String amenities = scanner.nextLine().trim();
        while (amenities.isEmpty()) {
            System.out.println("Amenities cannot be empty");
            System.out.print("Enter Amenities: ");
            amenities = scanner.nextLine().trim();
        }

        Hotel hotel = new Hotel(name, city, country, rating, price, amenities);
        TripBuddy.hotelsTree.add(hotel);
        TripBuddy.hotels.add(hotel);
        System.out.println("Hotel Added Successfully");
    }

    private void viewHotel(Hotel hotel) {
        System.out.println("--------------------------------------------------------------------------------------");
        hotel.display();
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.print("\nDo you want to Delete this Hotel? (y/n): ");
        String choice = scanner.nextLine().trim();
        if (choice.equals("y")) {
            TripBuddy.hotelsTree.remove(hotel);
            TripBuddy.hotels.remove(TripBuddy.hotels.get(hotel));
            System.out.println("Hotel Deleted Successfully");
        }
    }
}
