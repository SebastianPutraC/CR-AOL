package afterRefactoring.price;

import afterRefactoring.Movie;

abstract public class Price {
    public abstract  int getPriceCode();

    public abstract double getCharge (int daysRented);

    public  int getFrequentRenterPoints(int daysRented){
        return 1;
    }
}