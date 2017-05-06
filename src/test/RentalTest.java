package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import main.Movie;
import main.Rental;
import main.AllMovieStates;

public class RentalTest {

    private static final String MOVIE_NAME = "Fight Club";
    private static final AllMovieStates STATE_CODE = AllMovieStates.NEW_RELEASE;
    private static final int DAYS_RENTED = 3;

    private Rental rental;
    private Movie movie;

    @Before
    public void resetRental() {
        movie = new Movie(MOVIE_NAME, STATE_CODE);
        rental = new Rental(movie, DAYS_RENTED);
    }

    @Test
    public void testNewRental() {
        assertEquals(DAYS_RENTED, rental.getDaysRented());
        assertEquals(movie, rental.getMovie());
    }

    @Test
    public void testGetCharge() {
        assertEquals(9.0, rental.getCharge(), 0);
    }

    @Test
    public void testGetFrequentRenterPoints() {
        assertEquals(2, rental.getFrequentRenterPoints());

        movie.setState(AllMovieStates.REGULAR);
        assertEquals(1, rental.getFrequentRenterPoints());
    }
}
