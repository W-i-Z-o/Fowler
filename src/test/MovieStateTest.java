package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import main.Movie;
import main.Rental;
import main.AllMovieStates;

public class MovieStateTest {

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
    public void testPriceCode() {
        assertEquals(AllMovieStates.NEW_RELEASE, movie.getState());

        movie.setState(AllMovieStates.CHILDRENS);
        assertEquals(AllMovieStates.CHILDRENS, movie.getState());

        movie.setState(AllMovieStates.REGULAR);
        assertEquals(AllMovieStates.REGULAR, movie.getState());
    }

    @Test
    public void testFrequentRenterPoints() {
        assertEquals(2, rental.getFrequentRenterPoints());

        rental = new Rental(movie, 1);
        assertEquals(1, rental.getFrequentRenterPoints());

        resetRental();
        movie.setState(AllMovieStates.CHILDRENS);
        assertEquals(1, rental.getFrequentRenterPoints());

        resetRental();
        movie.setState(AllMovieStates.REGULAR);
        assertEquals(1, rental.getFrequentRenterPoints());
    }
}
