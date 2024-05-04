package TripBuddy.Records;

public class Hotel implements Comparable<Hotel> {
    private final String city;
    private final String country;
    private final Double rating;
    private final String amenities;
    private String name;
    private Double price;

    /**
     * Constructor for Hotel
     *
     * @param name      Name of the hotel
     * @param city      City the hotel is located in
     * @param country   Country the hotel is located in
     * @param rating    Rating of the hotel
     * @param price     Price of the hotel
     * @param amenities Amenities of the hotel
     */
    public Hotel(String name, String city, String country, Double rating, Double price, String amenities) {
        this.name = name;
        this.city = city;
        this.country = country;
        this.rating = rating;
        this.price = price;
        this.amenities = amenities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public Double getRating() {
        return rating;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getAmenities() {
        return amenities;
    }

    @Override
    public int compareTo(Hotel o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return name;
    }

    public void display() {
        System.out.println("\nHotel name: " + getName());
        System.out.println("Location: " + getCity() + ", " + getCountry());
        System.out.println("Price: " + getPrice());
        System.out.println("Rating: " + getRating());
        System.out.println("Amenities: " + getAmenities());
    }
}