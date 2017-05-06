package main;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Rental> rentals;

    public Customer(String name) {
        this.name = name;
        rentals = new ArrayList<>();
    };

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    public String getName() {
        return name;
    };

    public String statement() {
        String result = "Rental Record for " + getName() + "\n";
        for (Rental each : rentals) {
            // show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
    }
        // add footer lines
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";
        return result;
    }
    
    private double getTotalCharge(){
        return rentals.stream().mapToDouble(rental -> rental.getCharge()).sum();
    }

    private int getTotalFrequentRenterPoints() {
        return rentals.stream().mapToInt(rental -> rental.getFrequentRenterPoints()).sum();
    }
}
    
