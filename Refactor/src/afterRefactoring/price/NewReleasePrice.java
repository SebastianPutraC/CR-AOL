package afterRefactoring.price;

import afterRefactoring.Movie;

public class NewReleasePrice extends Price 
{
    public int getPriceCode() 
    {
        return Movie.NEW_RELEASE;
    }
    public String getPriceName()
    {
    	return "New Release";
    }

    public double getCharge(int daysRented) 
    {
        return daysRented * 3;

    }
    public  int getFrequentRenterPoints(int daysRented)
    {
        return daysRented > 1 ? 2 : 1;
    }
}
