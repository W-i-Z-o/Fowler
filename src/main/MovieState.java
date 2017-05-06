package main;

public abstract class MovieState {

    abstract AllMovieStates getState();

    abstract public double getCharge(int daysRented);

    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
