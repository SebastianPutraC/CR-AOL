package afterRefactoring.price;

import afterRefactoring.Movie;

public class RegularPrice extends Price
{
    public int getPriceCode() 
    {
        return Movie.REGULAR;
    }
    public String getPriceName()
    {
    	return "Regular Movie";
    }
    public double getCharge (int daysRented)
    {
        double result = 0;
                result += 2;
                if (daysRented > 2)
                    result += (daysRented - 2) * 1.5;
        return result;
    }
}
