package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import main.Movie;
import main.Rental;

public class PriceTest {

    private static final String MOVIE_NAME = "Fight Club";
    private static final int PRICE_CODE = Movie.NEW_RELEASE;
    private static final int DAYS_RENTED = 3;

    private Rental rental;
    private Movie movie;

    @Before
    public void resetRental() {
        movie = new Movie(MOVIE_NAME, PRICE_CODE);
        rental = new Rental(movie, DAYS_RENTED);
    }

    @Test
    public void testPriceCode() {
        assertEquals(Movie.NEW_RELEASE, movie.getPriceCode());

        movie.setPriceCode(Movie.CHILDRENS);
        assertEquals(Movie.CHILDRENS, movie.getPriceCode());

        movie.setPriceCode(Movie.REGULAR);
        assertEquals(Movie.REGULAR, movie.getPriceCode());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalPriceCode() {
        movie.setPriceCode(99);
    }

    @Test
    public void testFrequentRenterPoints() {
        assertEquals(2, rental.getFrequentRenterPoints());

        rental = new Rental(movie, 1);
        assertEquals(1, rental.getFrequentRenterPoints());

        resetRental();
        movie.setPriceCode(Movie.CHILDRENS);
        assertEquals(1, rental.getFrequentRenterPoints());

        resetRental();
        movie.setPriceCode(Movie.REGULAR);
        assertEquals(1, rental.getFrequentRenterPoints());
    }
}
