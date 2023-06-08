package afterRefactoring.price;

import afterRefactoring.Movie;

public class ChildrensPrice extends Price 
{
    public int getPriceCode() 
    {
        return Movie.CHILDRENS;
    }
    public String getPriceName()
    {
    	return "Children's Movie";
    }

    public double getCharge(int daysRented) 
    {
        double result = 0;
        result += 1.5; // Early Price
        if (daysRented > 3)
            result += (daysRented - 3) * 1.5;

        return result;
    }

}
