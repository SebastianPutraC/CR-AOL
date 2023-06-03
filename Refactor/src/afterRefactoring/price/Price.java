package afterRefactoring.price;

import afterRefactoring.Movie;

abstract public class Price 
{
    public abstract int getPriceCode(); //Price code to determine Price child
    
    public abstract String getPriceName();

    public abstract double getCharge (int daysRented); // Amount of money to pay per day for a single movie

    public int getFrequentRenterPoints(int daysRented) 
    {
        return 1;
    }
}