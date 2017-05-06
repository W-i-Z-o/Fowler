package main;
public class Movie {
    private String title;
    private MovieState state;

    public Movie(String title, AllMovieStates state) {
        this.title = title;
        setState(state);
    }

    public AllMovieStates getState() {
        return state.getState();
    }

    public void setState(AllMovieStates state) {
        switch (state) {
        case REGULAR:
            this.state = new RegularState();
            break;
        case CHILDRENS:
            this.state = new ChildrensState();
            break;
        case NEW_RELEASE:
            this.state = new NewReleaseState();
            break;
        }
    }

    public String getTitle() {
        return title;
    }

    public double getCharge(int daysRented) {
        return state.getCharge(daysRented);
    }

    public int getFrequentRenterPoints(int daysRented) {
        return state.getFrequentRenterPoints(daysRented);
    }
}