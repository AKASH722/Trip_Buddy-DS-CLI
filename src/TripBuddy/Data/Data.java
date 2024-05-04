package TripBuddy.Data;

import TripBuddy.DataStructures.AVL;
import TripBuddy.DataStructures.ArrayList;
import TripBuddy.DataStructures.Hashtable;
import TripBuddy.Records.*;
import TripBuddy.TripBuddy;
import TripBuddy.Utilities.Validator;


public class Data {

    public void getUsers(Hashtable<String, User> users) {
        users.put("akashrai4546@gmail.com", new User("Akash Rai", "akashrai4546@gmail.com", "Akash@722", "Admin", "7226828524", "India"));
        users.put("zeelvyas29@gmail.com", new User("Zeel Vyas", "zeelvyas29@gmail.com", "Zeel@2906", "Customer", "8401082906", "India"));
        users.put("tithitripathi206@gmail.com", new User("Tithi Tripathi", "tithitripathi206@gmail.com", "Tithi@16", "Customer", "8160925787", "India"));
        users.put("user@test.com", new User("Customer", "user@test.com", "User@2004", "Customer", "8160925787", "India"));
    }

    public void getPackages(ArrayList<Packages> packages) {
        packages.add(new Packages("Goa Getaway", "Explore the beauty of Goa with our exclusive package.", 1000.00, TripBuddy.hotels.get(0), "Goa, India"));
        packages.add(new Packages("Parisian Escape", "Experience the romance of Paris with our special package.", 1500.00, TripBuddy.hotels.get(1), "Paris, France"));
        packages.add(new Packages("Tropical Paradise", "Relax on the pristine beaches of Bali with this package.", 1200.00, TripBuddy.hotels.get(2), "Bali, Indonesia"));
        packages.add(new Packages("New York Adventure", "Discover the vibrant culture of New York City.", 1800.00, TripBuddy.hotels.get(3), "New York, USA"));
        packages.add(new Packages("Rome Exploration", "Explore the historical treasures of Rome.", 1600.00, TripBuddy.hotels.get(4), "Rome, Italy"));
        packages.add(new Packages("Santorini Retreat", "Enjoy a tranquil getaway in Santorini.", 1400.00, TripBuddy.hotels.get(5), "Santorini, Greece"));
        packages.add(new Packages("Tokyo Adventure", "Experience the modern and traditional side of Tokyo.", 2000.00, TripBuddy.hotels.get(6), "Tokyo, Japan"));
        packages.add(new Packages("Rio Carnival", "Join the excitement of Rio de Janeiro's Carnival.", 1700.00, TripBuddy.hotels.get(7), "Rio de Janeiro, Brazil"));
        packages.add(new Packages("Dubai Luxury", "Indulge in luxury in the heart of Dubai.", 2200.00, TripBuddy.hotels.get(8), "Dubai, UAE"));
        packages.add(new Packages("Sydney Discovery", "Discover the beauty of Sydney and its landmarks.", 1900.00, TripBuddy.hotels.get(9), "Sydney, Australia"));
    }

    public void getHotels(ArrayList<Hotel> hotels) {
        hotels.add(new Hotel("Ocean View Hotel", "Goa", "India", 4.5, 150.00, "Pool, WiFi, AC, Breakfast"));
        hotels.add(new Hotel("Eiffel Grand Hotel", "Paris", "France", 4.7, 200.00, "Spa, Restaurant, WiFi, AC"));
        hotels.add(new Hotel("Bali Beach Resort", "Bali", "Indonesia", 4.3, 180.00, "Private Beach, Spa, Pool"));
        hotels.add(new Hotel("Central Park Suites", "New York", "USA", 4.6, 250.00, "City View, Gym, WiFi"));
        hotels.add(new Hotel("Roman Villa", "Rome", "Italy", 4.4, 190.00, "Historic Building, Restaurant"));
        hotels.add(new Hotel("Santorini Seaside", "Santorini", "Greece", 4.8, 220.00, "Ocean View, Infinity Pool"));
        hotels.add(new Hotel("Tokyo Tower Hotel", "Tokyo", "Japan", 4.5, 210.00, "Near Landmarks, WiFi"));
        hotels.add(new Hotel("Carnival Palace", "Rio de Janeiro", "Brazil", 4.6, 230.00, "Carnival Access, Rooftop Bar"));
        hotels.add(new Hotel("Dubai Oasis Resort", "Dubai", "UAE", 4.7, 270.00, "Luxury Spa, Private Beach"));
        hotels.add(new Hotel("Harbor View Hotel", "Sydney", "Australia", 4.4, 200.00, "Harbor View, Restaurant, WiFi"));
        hotels.add(new Hotel("Taj Palace", "Mumbai", "India", 4.7, 300.00, "Historic, Sea View, Dining"));
        hotels.add(new Hotel("Lakeview Resort", "Udaipur", "India", 4.3, 180.00, "Lake View, Spa, Pool"));
        hotels.add(new Hotel("Heritage Haveli", "Jaipur", "India", 4.6, 250.00, "Heritage, Courtyard, Dining"));
        hotels.add(new Hotel("Backwaters Retreat", "Kochi", "India", 4.4, 190.00, "Backwaters, Ayurveda Spa"));
        hotels.add(new Hotel("Himalayan Lodge", "Manali", "India", 4.8, 220.00, "Mountain View, Adventures"));
        hotels.add(new Hotel("Tech Hotel", "Bengaluru", "India", 4.5, 210.00, "Business, WiFi, Gym"));
        hotels.add(new Hotel("Beachfront Resort", "Chennai", "India", 4.6, 230.00, "Beachfront, Seafood Dining"));
        hotels.add(new Hotel("Luxury Suites", "New Delhi", "India", 4.7, 270.00, "Luxury, Spa, Dining"));
        hotels.add(new Hotel("Riverside Retreat", "Kolkata", "India", 4.4, 200.00, "Riverside View, Culture"));
        hotels.add(new Hotel("Business Hotel", "Hyderabad", "India", 4.5, 180.00, "Business, Conferences"));
        hotels.add(new Hotel("Ganges View", "Varanasi", "India", 4.3, 160.00, "Ganges View, Spirituality"));
    }

    public void getCruises(ArrayList<Cruises> cruisesArrayList) {
        cruisesArrayList.add(new Cruises("Caribbean Cruise", "Explore the stunning Caribbean islands on this relaxing cruise.", 1200.00, "Miami", "Bahamas", "7 days"));
        cruisesArrayList.add(new Cruises("Mediterranean Voyage", "Sail through the picturesque Mediterranean Sea and visit historic ports.", 1500.00, "Barcelona", "Athens", "10 days"));
        cruisesArrayList.add(new Cruises("Alaskan Adventure", "Experience the wilderness of Alaska on this remarkable cruise.", 1400.00, "Seattle", "Anchorage", "8 days"));
        cruisesArrayList.add(new Cruises("Hawaiian Paradise", "Discover the beauty of Hawaii and its lush landscapes.", 1600.00, "Honolulu", "Maui", "9 days"));
        cruisesArrayList.add(new Cruises("Nordic Discovery", "Explore the northern wonders of Scandinavia on this cruise.", 1700.00, "Copenhagen", "Oslo", "11 days"));
        cruisesArrayList.add(new Cruises("Caribbean Escape", "Relax on the Caribbean beaches and enjoy crystal-clear waters.", 1250.00, "Miami", "Aruba", "7 days"));
        cruisesArrayList.add(new Cruises("Greek Isles Cruise", "Visit the charming Greek islands and their rich history.", 1550.00, "Athens", "Santorini", "9 days"));
        cruisesArrayList.add(new Cruises("Pacific Paradise", "Cruise through the Pacific Islands and experience island life.", 1350.00, "Fiji", "Tahiti", "8 days"));
        cruisesArrayList.add(new Cruises("Norwegian Fjords", "Marvel at the stunning fjords of Norway on this cruise.", 1650.00, "Oslo", "Bergen", "10 days"));
        cruisesArrayList.add(new Cruises("Caribbean Adventure", "Embark on an adventurous journey through the Caribbean.", 1300.00, "Miami", "Jamaica", "7 days"));
    }

    public void preBookings() {
        User user1 = TripBuddy.users.get("zeelvyas29@gmail.com");
        User user2 = TripBuddy.users.get("tithitripathi206@gmail.com");

        // Booking for User 1
        Booking booking2 = new Booking("zeelvyas29@gmail.com", TripBuddy.packages.get(4), TripBuddy.packages.get(4).getPrice() * 2, 2, Validator.getDate("05 12 2023"), Validator.getDate("10 12 2023"), "Packages");
        Booking booking4 = new Booking("zeelvyas29@gmail.com", TripBuddy.hotels.get(6), TripBuddy.hotels.get(6).getPrice() * 2, 2, Validator.getDate("25 12 2023"), Validator.getDate("28 12 2023"), "Hotels");
        Booking booking5 = new Booking("zeelvyas29@gmail.com", TripBuddy.cruises.get(0), TripBuddy.cruises.get(0).getPrice() * 3, 3, null, null, "Cruises");

        user1.getBookings().addLast(booking2);
        user1.getBookings().addLast(booking4); // Add booking4 to user1
        user1.getBookings().addLast(booking5); // Add booking5 to user1

        // Booking for User 2
        Booking booking7 = new Booking("tithitripathi206@gmail.com", TripBuddy.hotels.get(7), TripBuddy.hotels.get(7).getPrice() * 3, 3, Validator.getDate("15 11 2023"), Validator.getDate("18 11 2023"), "Hotels");
        Booking booking9 = new Booking("tithitripathi206@gmail.com", TripBuddy.cruises.get(2), TripBuddy.cruises.get(2).getPrice() * 2, 2, null, null, "Cruises");
        Booking booking12 = new Booking("tithitripathi206@gmail.com", TripBuddy.packages.get(5), TripBuddy.packages.get(5).getPrice() * 3, 3, Validator.getDate("22 12 2023"), Validator.getDate("27 12 2023"), "Packages");

        user2.getBookings().addLast(booking7);
        user2.getBookings().addLast(booking9);
        user2.getBookings().addLast(booking12);

        // Add these bookings to the global bookings queue
        TripBuddy.bookingsQueue.enqueue(booking2);
        TripBuddy.bookingsQueue.enqueue(booking4);
        TripBuddy.bookingsQueue.enqueue(booking5);
        TripBuddy.bookingsQueue.enqueue(booking7);
        TripBuddy.bookingsQueue.enqueue(booking9);
        TripBuddy.bookingsQueue.enqueue(booking12);
    }


    public void setCountries(AVL<String> countries) {
        String[] country = {
            "Afghanistan",
            "Albania",
            "Algeria",
            "Andorra",
            "Angola",
            "Antigua and Barbuda",
            "Argentina",
            "Armenia",
            "Australia",
            "Austria",
            "Azerbaijan",
            "Bahamas",
            "Bahrain",
            "Bangladesh",
            "Barbados",
            "Belarus",
            "Belgium",
            "Belize",
            "Benin",
            "Bhutan",
            "Bolivia",
            "Bosnia and Herzegovina",
            "Botswana",
            "Brazil",
            "Brunei",
            "Bulgaria",
            "Burkina Faso",
            "Burundi",
            "Cabo Verde",
            "Cambodia",
            "Cameroon",
            "Canada",
            "Central African Republic",
            "Chad",
            "Chile",
            "China",
            "Colombia",
            "Comoros",
            "Congo (Congo-Brazzaville)",
            "Costa Rica",
            "Croatia",
            "Cuba",
            "Cyprus",
            "Czechia (Czech Republic)",
            "Democratic Republic of the Congo (Congo-Kinshasa)",
            "Denmark",
            "Djibouti",
            "Dominica",
            "Dominican Republic",
            "East Timor (Timor-Leste)",
            "Ecuador",
            "Egypt",
            "El Salvador",
            "Equatorial Guinea",
            "Eritrea",
            "Estonia",
            "Eswatini (fmr. Swaziland)",
            "Ethiopia",
            "Fiji",
            "Finland",
            "France",
            "Gabon",
            "Gambia",
            "Georgia",
            "Germany",
            "Ghana",
            "Greece",
            "Grenada",
            "Guatemala",
            "Guinea",
            "Guinea-Bissau",
            "Guyana",
            "Haiti",
            "Holy See",
            "Honduras",
            "Hungary",
            "Iceland",
            "India",
            "Indonesia",
            "Iran",
            "Iraq",
            "Ireland",
            "Israel",
            "Italy",
            "Ivory Coast",
            "Jamaica",
            "Japan",
            "Jordan",
            "Kazakhstan",
            "Kenya",
            "Kiribati",
            "Kuwait",
            "Kyrgyzstan",
            "Laos",
            "Latvia",
            "Lebanon",
            "Lesotho",
            "Liberia",
            "Libya",
            "Liechtenstein",
            "Lithuania",
            "Luxembourg",
            "Madagascar",
            "Malawi",
            "Malaysia",
            "Maldives",
            "Mali",
            "Malta",
            "Marshall Islands",
            "Mauritania",
            "Mauritius",
            "Mexico",
            "Micronesia",
            "Moldova",
            "Monaco",
            "Mongolia",
            "Montenegro",
            "Morocco",
            "Mozambique",
            "Myanmar (formerly Burma)",
            "Namibia",
            "Nauru",
            "Nepal",
            "Netherlands",
            "New Zealand",
            "Nicaragua",
            "Niger",
            "Nigeria",
            "North Korea",
            "North Macedonia (formerly Macedonia)",
            "Norway",
            "Oman",
            "Pakistan",
            "Palau",
            "Palestine State",
            "Panama",
            "Papua New Guinea",
            "Paraguay",
            "Peru",
            "Philippines",
            "Poland",
            "Portugal",
            "Qatar",
            "Romania",
            "Russia",
            "Rwanda",
            "Saint Kitts and Nevis",
            "Saint Lucia",
            "Saint Vincent and the Grenadines",
            "Samoa",
            "San Marino",
            "Sao Tome and Principe",
            "Saudi Arabia",
            "Senegal",
            "Serbia",
            "Seychelles",
            "Sierra Leone",
            "Singapore",
            "Slovakia",
            "Slovenia",
            "Solomon Islands",
            "Somalia",
            "South Africa",
            "South Korea",
            "South Sudan",
            "Spain",
            "Sri Lanka",
            "Sudan",
            "Suriname",
            "Sweden",
            "Switzerland",
            "Syria",
            "Tajikistan",
            "Tanzania",
            "Thailand",
            "Togo",
            "Tonga",
            "Trinidad and Tobago",
            "Tunisia",
            "Turkey",
            "Turkmenistan",
            "Tuvalu",
            "Uganda",
            "Ukraine",
            "United Arab Emirates",
            "United Kingdom",
            "United States of America",
            "Uruguay",
            "Uzbekistan",
            "Vanuatu",
            "Venezuela",
            "Vietnam",
            "Yemen",
            "Zambia",
            "Zimbabwe"
        };
        for (String countryName : country) {
            countries.add(countryName.toUpperCase());
        }
    }
}
