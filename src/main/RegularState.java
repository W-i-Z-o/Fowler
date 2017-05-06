package main;

public class RegularState extends MovieState {

    @Override
    AllMovieStates getState() {
        return AllMovieStates.REGULAR;
    }

    @Override
    public double getCharge(int daysRented) {
        double result = 0;
        result += 2;
        if (daysRented > 2)
            result += (daysRented - 2) * 1.5;

        return result;
    }
}
