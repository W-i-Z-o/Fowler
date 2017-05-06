package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import main.Movie;
import main.AllMovieStates;

public class MovieTest {

    private static final String MOVIE_NAME = "Fight Club";
    private static final AllMovieStates STATE_CODE = AllMovieStates.NEW_RELEASE;

    private Movie movie;

    @Before
    public void resetMovie() {
        movie = new Movie(MOVIE_NAME, STATE_CODE);
    }

    @Test
    public void testNewMovie() {
        assertEquals(MOVIE_NAME, movie.getTitle());
        assertEquals(STATE_CODE, movie.getState());
    }

    @Test
    public void changePriceCode() {
        movie.setState(AllMovieStates.REGULAR);
        assertEquals(AllMovieStates.REGULAR, movie.getState());
    }

}
