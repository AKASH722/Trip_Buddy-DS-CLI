package TripBuddy.Records;

public class Packages implements Comparable<Packages> {
    private final String description;
    private final String location;
    private String name;
    private Double price;
    private Hotel hotel;

    /**
     * This is the constructor of the Packages class
     *
     * @param name        name of the package
     * @param description description of the package
     * @param price       price of the package
     * @param hotel       hotel include in the package
     * @param location    location of the package
     */
    public Packages(String name, String description, Double price, Hotel hotel, String location) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.hotel = hotel;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public int compareTo(Packages o) {
        return this.getName().compareTo(o.getName());
    }

    @Override
    public String toString() {
        return name;
    }

    public void display() {
        System.out.println("\nPackage Details:");
        System.out.println("Name: " + getName());
        System.out.println("Location: " + getLocation());
        System.out.println("Price: " + getPrice());
        System.out.println("Description:");
        for (String line : getDescription().split("\\.")) {
            System.out.println(line.trim() + ".");
        }
        System.out.println("\nHotel Details:");
        System.out.println("Name: " + hotel.getName());
        System.out.println("Rating: " + hotel.getRating());
        System.out.println("Amenities: " + hotel.getAmenities());

    }
}
