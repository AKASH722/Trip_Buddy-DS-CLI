package TripBuddy.Utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Validator {
    /**
     * Validates the email address
     * Format: <username>@<domain>.<extension>
     *
     * @param email email address to be validated
     * @return true if valid, false otherwise
     */
    public static boolean email(String email) {
        String[] parts = email.split("@");
        if (parts.length == 2 && !parts[0].isEmpty() && !parts[1].isEmpty()) {
            String[] part = parts[1].split("\\.");
            return part.length == 2 && !part[0].isEmpty() && !part[1].isEmpty();
        } else {
            return false;
        }
    }

    /**
     * Validates the contact number
     * Format: 10 digits starting with 6, 7, 8 or 9
     *
     * @param contact contact number to be validated
     * @return true if valid, false otherwise
     */
    public static boolean contact(String contact) {
        return (contact.charAt(0) == '6' || contact.charAt(0) == '7' || contact.charAt(0) == '8' || contact.charAt(0) == '9') && (contact.length() == 10);
    }

    /**
     * Validates the password
     * Format: At least 8 characters long, contains at least 1 digit, 1 lowercase, 1 uppercase and 1 special character
     *
     * @param password password to be validated
     * @return true if valid, false otherwise
     */
    public static boolean password(String password) {
        int countDigit = 0, countSpecial = 0, countLowercase = 0, countUppercase = 0;
        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) >= '0' && password.charAt(i) <= '9') {
                countDigit++;
            } else if (password.charAt(i) >= 'a' && password.charAt(i) <= 'z') {
                countLowercase++;
            } else if (password.charAt(i) >= 'A' && password.charAt(i) <= 'Z') {
                countUppercase++;
            } else {
                countSpecial++;
            }
        }
        return (password.length() >= 8 && countDigit >= 1 && countLowercase >= 1 && countUppercase >= 1 && countSpecial >= 1);
    }

    /**
     * Validates the date
     * Format: dd MM yyyy
     *
     * @param inputDate date to be validated
     * @return Date object if valid, null otherwise
     */
    public static Date getDate(String inputDate) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd MM yyyy");
            Date dates = dateFormat.parse(inputDate);
            String[] date = inputDate.split(" ");
            int day = Integer.parseInt(date[0]);//day
            int month = Integer.parseInt(date[1]);//month
            int year = Integer.parseInt(date[2]);//year
            if (year <= 1000 || month <= 0 || month > 12 || day <= 0 || day > 31 || inputDate.length() != 10) {
                return null;
            } else {
                return dates;
            }
        } catch (ParseException e) {
            return null;
        }
    }
}
