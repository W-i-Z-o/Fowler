package main;

public class NewReleaseState extends MovieState {

    @Override
    AllMovieStates getState() {
        return AllMovieStates.NEW_RELEASE;
    }

    @Override
    public double getCharge(int daysRented) {
        double result = 0;
        result += daysRented * 3;
        return result;
    }

    @Override
    public int getFrequentRenterPoints(int daysRented) {
        return (daysRented > 1) ? 2 : 1;
    }
}
