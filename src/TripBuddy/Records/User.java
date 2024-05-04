package TripBuddy.Records;

import TripBuddy.DataStructures.LinkedList;

public class User {
    private final LinkedList<Booking> bookings;
    private final String email;
    private final String password;
    private final String userType;
    private String name;
    private String phoneNumber;
    private String country;

    /**
     * This is the constructor of the User class
     *
     * @param name        name of the user
     * @param email       email of the user
     * @param password    password of the user
     * @param userType    type of the user
     *                    1. Admin
     *                    2. Customer
     * @param phoneNumber phone number of the user
     * @param country     country of the user
     */
    public User(String name, String email, String password, String userType, String phoneNumber, String country) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.userType = userType;
        this.phoneNumber = phoneNumber;
        this.country = country;
        this.bookings = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUserType() {
        return userType;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LinkedList<Booking> getBookings() {
        return bookings;
    }

    @Override
    public String toString() {
        return name;
    }
}