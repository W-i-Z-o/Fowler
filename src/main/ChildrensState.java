package main;

public class ChildrensState extends MovieState {

    @Override
    public AllMovieStates getState() {
        return AllMovieStates.CHILDRENS;
    }

    @Override
    public double getCharge(int daysRented) {
        double result = 0;
        result += 1.5;
        if (daysRented > 3)
            result += (daysRented - 3) * 1.5;
        return result;
    }
}
