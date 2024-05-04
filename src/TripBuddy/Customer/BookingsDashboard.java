package TripBuddy.Customer;

import TripBuddy.DataStructures.LinkedList;
import TripBuddy.Records.*;

import java.util.Scanner;

public class BookingsDashboard {
    private final User user;
    private final Scanner scanner = new Scanner(System.in);
    int i;

    public BookingsDashboard(User user) {
        this.user = user;
    }

    public void display() {
        while (true) {
            System.out.println("\n-----------------------------");
            System.out.println("Bookings Dashboard:");
            System.out.println("1. View Bookings");
            System.out.println("2. Go Back");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> viewBookings();
                case "2" -> {
                    return;
                }
                default -> System.out.println("Invalid Input. Please try again.");
            }
        }
    }

    private void viewBookings() {
        LinkedList<Booking> bookings = user.getBookings();
        LinkedList<Booking> packages = new LinkedList<>();
        LinkedList<Booking> cruises = new LinkedList<>();
        LinkedList<Booking> hotels = new LinkedList<>();
        if (user.getBookings().isEmpty()) {
            System.out.println("No Bookings Found");
        } else {
            {
                LinkedList.Node<Booking> temp = bookings.getHead();
                while (temp != null) {
                    Booking booking = temp.data;
                    if (booking.getType().equals("Packages")) {
                        packages.addLast(booking);
                    } else if (booking.getType().equals("Cruises")) {
                        cruises.addLast(booking);
                    } else {
                        hotels.addLast(booking);
                    }
                    temp = temp.next;
                }
            }
            i = 1;
            if (packages.isEmpty()) {
                System.out.println("No packages booked");
            } else {
                System.out.println("------------------------------- Booked Packages ------------------------------");
                i = 1;
                printBookings(packages);
            }
            if (hotels.isEmpty()) {
                System.out.println("No hotels booked");
            } else {
                System.out.println("------------------------------- Booked Hotels --------------------------------");
                printBookings(hotels);
            }
            if (cruises.isEmpty()) {
                System.out.println("No cruises booked");
            } else {
                System.out.println("------------------------------- Booked Cruises ------------------------------");
                printBookings(cruises);
            }

            System.out.print("Do you wish to cancel any Booking? (y/n): ");
            String confirm = scanner.nextLine().trim();
            if (confirm.equals("y")) {
                while (true) {
                    System.out.print("Enter Booking Number: ");
                    int bookingNumber = Integer.parseInt(scanner.nextLine().trim());
                    if (bookingNumber <= 0 || bookingNumber >= i) {
                        System.out.println("Enter a valid booking number");
                    } else {
                        bookingNumber--;
                        if (bookingNumber < packages.getSize()) {
                            deleteBooking(packages, bookingNumber);
                        } else {
                            bookingNumber -= packages.getSize();
                            if (bookingNumber < hotels.getSize()) {
                                deleteBooking(hotels, bookingNumber);
                            } else {
                                bookingNumber -= hotels.getSize();
                                if (bookingNumber < cruises.getSize()) {
                                    deleteBooking(cruises, bookingNumber);
                                }
                            }
                        }
                        break;
                    }
                }
            }
        }
    }

    private void printBookings(LinkedList<Booking> types) {
        LinkedList.Node<Booking> temp = types.getHead();
        while (temp != null) {
            Booking booking = temp.data;
            System.out.println("\n---------------------------------------------------------------------------------");
            System.out.println("Booking Number = " + i++);
            booking.display();

            if (booking.getType().equals("Packages")) {
                Packages packages = (Packages) booking.getEntity();
                packages.display();
            } else if (booking.getType().equals("Hotels")) {
                Hotel hotel = (Hotel) booking.getEntity();
                hotel.display();
            } else {
                Cruises cruise = (Cruises) booking.getEntity();
                cruise.display();
            }
            temp = temp.next;
        }
    }

    private void deleteBooking(LinkedList<Booking> types, int number) {
        LinkedList.Node<Booking> temp = types.getHead();
        for (int j = 1; j < number; j++) {
            temp = temp.next;
        }
        Booking booking = temp.data;
        booking.setStatus("Cancelled");
        types.remove(booking);
        user.getBookings().remove(booking);
        System.out.println("Booking Cancelled Successfully");
    }
}
