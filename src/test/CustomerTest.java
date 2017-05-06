package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import main.Customer;
import main.Movie;
import main.Rental;
import main.AllMovieStates;

public class CustomerTest {

    private static final String MOVIE_NAME = "Fight Club";
    private static final AllMovieStates STATE_CODE = AllMovieStates.NEW_RELEASE;
    private static final int DAYS_RENTED = 3;
    private static final String CUSTOMER_NAME = "Paul";

    private Movie movie;
    private Rental rental;
    private Customer customer;

    @Before
    public void resetCustomer() {
        movie = new Movie(MOVIE_NAME, STATE_CODE);
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
        String expectedStatement = "Rental Record for Paul\n";
        expectedStatement += "\tFight Club\t9.0\n";
        expectedStatement += "Amount owed is 9.0\n";
        expectedStatement += "You earned 2 frequent renter points";
        assertEquals(expectedStatement, customer.getStatement());

        customer.addRental(new Rental(new Movie("movie1", AllMovieStates.CHILDRENS), 10));
        expectedStatement = "Rental Record for Paul\n";
        expectedStatement += "\tFight Club\t9.0\n";
        expectedStatement += "\tmovie1\t12.0\n";
        expectedStatement += "Amount owed is 21.0\n";
        expectedStatement += "You earned 3 frequent renter points";
        assertEquals(expectedStatement, customer.getStatement());
    }

    @Test
    public void testHtmlStatement() {
        customer.addRental(rental);
        String expectedStatement = "<H1>Rentals for <EM>Paul</EM></H1>\n";
        expectedStatement += "<P>Fight Club: 9.0</BR>\n";
        expectedStatement += "Amount owed is <EM>9.0</EM></P>\n";
        expectedStatement += "<P>You earned <EM>2</EM> frequent renter points</P>";
        assertEquals(expectedStatement, customer.getHtmlStatement());

        customer.addRental(new Rental(new Movie("movie1", AllMovieStates.CHILDRENS), 10));
        expectedStatement = "<H1>Rentals for <EM>Paul</EM></H1>\n";
        expectedStatement += "<P>Fight Club: 9.0</BR>\n";
        expectedStatement += "movie1: 12.0</BR>\n";
        expectedStatement += "Amount owed is <EM>21.0</EM></P>\n";
        expectedStatement += "<P>You earned <EM>3</EM> frequent renter points</P>";
        assertEquals(expectedStatement, customer.getHtmlStatement());
    }

}
