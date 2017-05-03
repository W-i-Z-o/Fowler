package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import main.Movie;

public class MovieTest {

    private static final String MOVIE_NAME = "Fight Club";
    private static final int PRICE_CODE = 1;

    private Movie movie;

    @Before
    public void resetMovie() {
        movie = new Movie(MOVIE_NAME, PRICE_CODE);
    }

    @Test
    public void testNewMovie() {
        assertEquals(MOVIE_NAME, movie.getTitle());
        assertEquals(PRICE_CODE, movie.getPriceCode());
    }

    @Test
    public void changePriceCode() {
        movie.setPriceCode(2);
        assertEquals(2, movie.getPriceCode());
    }

}
