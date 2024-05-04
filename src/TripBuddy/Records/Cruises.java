package TripBuddy.Records;

public class Cruises implements Comparable<Cruises> {
    private String name;
    private String description;
    private Double price;
    private String originPort;
    private String destinationPort;
    private String duration;

    /**
     * Constructor for Cruises
     *
     * @param name            Name of the cruise
     * @param description     Description of the cruise
     * @param price           Price of the cruise
     * @param originPort      Origin port of the cruise
     * @param destinationPort Destination port of the cruise
     * @param duration        Duration of the cruise
     */
    public Cruises(String name, String description, Double price, String originPort, String destinationPort, String duration) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.originPort = originPort;
        this.destinationPort = destinationPort;
        this.duration = duration;
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

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getOriginPort() {
        return originPort;
    }

    public void setOriginPort(String originPort) {
        this.originPort = originPort;
    }

    public String getDestinationPort() {
        return destinationPort;
    }

    public void setDestinationPort(String destinationPort) {
        this.destinationPort = destinationPort;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public int compareTo(Cruises o) {
        return this.getName().compareTo(o.getName());
    }

    @Override
    public String toString() {
        return name;
    }

    public void display() {
        System.out.println("\nCruise name: " + getName());
        System.out.println("Origin Port: " + getOriginPort());
        System.out.println("Destination Port: " + getDestinationPort());
        System.out.println("Price: " + getPrice());
        System.out.println("Duration: " + getDuration());
        System.out.print("Description: ");
        for (String line : getDescription().split("\\.")) {
            System.out.println(line.trim() + ".");
        }
    }
}

