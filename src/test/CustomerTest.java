package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import main.Customer;
import main.Movie;
import main.Rental;

public class CustomerTest {

    private static final String MOVIE_NAME = "Fight Club";
    private static final int PRICE_CODE = 1;
    private static final int DAYS_RENTED = 3;
    private static final String CUSTOMER_NAME = "Paul";

    private Movie movie;
    private Rental rental;
    private Customer customer;

    @Before
    public void resetCustomer() {
        movie = new Movie(MOVIE_NAME, PRICE_CODE);
        rental = new Rental(movie, DAYS_RENTED);
        customer = new Customer(CUSTOMER_NAME);
    }

    @Test
    public void testNewCustomer() {
        assertEquals(CUSTOMER_NAME, customer.getName());
    }

    @Test
    public void testAddRental() {
        customer.addRental(rental);
        assertTrue(customer.getRentals().contains(rental));
    }

    @Test
    public void testStatement() {
        customer.addRental(rental);
        String expectedStatement = "Rental Record for Paul\n" +
                "\tFight Club\t9.0\n" + "Amount owed is 9.0\n" + "You earned 2 frequent renter points";
        assertEquals(expectedStatement, customer.statement());

        customer.addRental(new Rental(new Movie("movie1", 2), 10));
        expectedStatement = "Rental Record for Paul\n" + "\tFight Club\t9.0\n" + "\tmovie1\t12.0\n"
                + "Amount owed is 21.0\n" + "You earned 3 frequent renter points";
        assertEquals(expectedStatement, customer.statement());
    }

}
