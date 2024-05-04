package TripBuddy.Records;

import TripBuddy.TripBuddy;

import java.util.Date;

public class Booking {
    private final String email;
    private final Object entity;
    private final int people;
    private final String type;
    private String status;
    private Double price;
    private Date journeyDate;
    private Date returnDate;

    /**
     * Constructor for Booking
     *
     * @param email       Email of the customer
     * @param packages    Package to be booked
     * @param price       Price of the package
     * @param people      Number of people
     * @param journeyDate Journey date
     * @param returnDate  Return date
     * @param type        Type of booking
     *                    1. Packages
     *                    2. Hotels
     *                    3. Cruises
     */
    public Booking(String email, Object packages, Double price, int people, Date journeyDate, Date returnDate, String type) {
        this.email = email;
        this.entity = packages;
        this.price = price;
        this.people = people;
        this.journeyDate = journeyDate;
        this.returnDate = returnDate;
        this.status = "pending";
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getEntity() {
        return entity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getPeople() {
        return people;
    }

    public Date getJourneyDate() {
        return journeyDate;
    }

    public void setJourneyDate(Date journeyDate) {
        this.journeyDate = journeyDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        sb.append("Customer Name: ").append(TripBuddy.users.get(email).getName()).append(", ").append(type).append(": ");
        if (type.equals("Packages")) {
            sb.append(((Packages) entity).getName());
        } else if (type.equals("Hotels")) {
            sb.append(((Hotel) entity).getName());
        } else {
            sb.append(((Cruises) entity).getName());
        }
        sb.append("}");
        return sb.toString();
    }

    public void display() {
        System.out.println("\nTotal Price: " + getPrice());
        System.out.println("People: " + getPeople());
        System.out.println("Journey Date: " + getJourneyDate());
        System.out.println("Return Date: " + getReturnDate());
        System.out.println("Status: " + getStatus());
        System.out.println("\n" + getType());
    }
}