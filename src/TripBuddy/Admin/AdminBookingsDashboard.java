package TripBuddy.Admin;

import TripBuddy.DataStructures.LinkedList;
import TripBuddy.Records.Booking;
import TripBuddy.Records.Cruises;
import TripBuddy.Records.Hotel;
import TripBuddy.Records.Packages;
import TripBuddy.TripBuddy;
import TripBuddy.Utilities.Validator;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class AdminBookingsDashboard {
    private final Scanner scanner = new Scanner(System.in);

    public void display() {
        while (true) {
            System.out.println("\n-----------------------------");
            System.out.println("Admin Bookings Dashboard:");
            System.out.println("1. View All Customer Bookings");
            System.out.println("2. Confirm/Cancel Bookings");
            System.out.println("3. Go Back");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> viewAllBookings();
                case "2" -> confirmCancelBookings();
                case "3" -> {
                    return;
                }
                default -> System.out.println("Invalid Input. Please try again.");
            }
        }
    }

    private void confirmCancelBookings() {
        if (TripBuddy.bookingsQueue.isEmpty()) {
            System.out.println("No Bookings to Confirm/Cancel");
            return;
        }
        Booking booking = TripBuddy.bookingsQueue.dequeue();
        if (booking.getStatus().equals("Cancelled")) {
            confirmCancelBookings();
        } else {
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println("\n" + booking + "\n");
            booking.display();
            System.out.println("\n" + booking.getEntity().toString());
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.print("Confirm Booking? (y/n): ");
            String choice = scanner.nextLine().trim();
            if (choice.equals("y")) {
                if (booking.getType().equals("Cruises")) {
                    System.out.print("Enter date of journey(DD MM YYYY): ");
                    Date jourenyStartDate = Validator.getDate(scanner.nextLine().trim());
                    while (jourenyStartDate == null) {
                        System.out.println("Invalid date");
                        System.out.print("Enter date of journey(DD MM YYYY): ");
                        jourenyStartDate = Validator.getDate(scanner.nextLine().trim());
                    }
                    booking.setJourneyDate(jourenyStartDate);
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(jourenyStartDate);
                    calendar.add(Calendar.DAY_OF_MONTH, Integer.parseInt(((Cruises) booking.getEntity()).getDuration().split(" ")[0]));
                    Date returnDate = calendar.getTime();
                    booking.setReturnDate(returnDate);
                }
                booking.setStatus("Confirmed");
                TripBuddy.bookings.addLast(booking);
                System.out.println("Booking Confirmed");
            } else {
                booking.setStatus("Cancelled");
                System.out.println("Booking Cancelled");
            }
            System.out.print("Do you want to confirm/cancel more bookings? (y/n): ");
            choice = scanner.nextLine().trim();
            if (choice.equals("y")) {
                confirmCancelBookings();
            }
        }
    }

    private void viewAllBookings() {
        if (TripBuddy.bookings.isEmpty()) {
            System.out.println("No Bookings to display");
            return;
        }
        LinkedList.Node<Booking> temp = TripBuddy.bookings.getHead();
        while (temp != null) {
            Booking booking = temp.data;
            System.out.println("--------------------------------------------------------------------------------------");
            booking.display();
            if (booking.getType().equals("Packages")) {
                Packages selectedPackage = (Packages) booking.getEntity();
                selectedPackage.display();
            } else if (booking.getType().equals("Hotels")) {
                Hotel hotel = (Hotel) booking.getEntity();
                hotel.display();
            } else {
                Cruises cruise = (Cruises) booking.getEntity();
                cruise.display();
            }
            System.out.println("--------------------------------------------------------------------------------------");
            temp = temp.next;
        }
    }
}
