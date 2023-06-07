package afterRefactoring;

import java.io.Serializable;

import afterRefactoring.price.ChildrensPrice;
import afterRefactoring.price.NewReleasePrice;
import afterRefactoring.price.Price;
import afterRefactoring.price.RegularPrice;

public class Movie implements Serializable
{
	public static final int REGULAR = 0;
    public static final int CHILDRENS = 1;
    public static final int NEW_RELEASE = 2;
    private String _title;
    private Price _price;
    
    private String _moviePath; //iseng

    public Movie(String title, int priceCode, String moviePath) 
    {
        _title = title;
        setPriceCode(priceCode);
        _moviePath = moviePath;
    }

    public int getPriceCode()
    { 
    	return _price.getPriceCode();
    }
    public String getPriceName()
    { 
    	return _price.getPriceName();
    }

    public void setPriceCode(int arg) 
    {
        switch (arg - 1) 
        {
            case REGULAR:
                _price = new RegularPrice(); 
                break;
            case CHILDRENS:
                _price = new ChildrensPrice(); 
                break;
            case NEW_RELEASE:
                _price = new NewReleasePrice();
                break;
            default:
                throw new IllegalArgumentException("Incorrect Price Code");
        }
    }

    public String getTitle()
    {
        return _title;
    }

    double getCharge (int daysRented)
    {
        return _price.getCharge(daysRented);
    }
    int getFrequentRenterPoints(int daysRented) 
    {
      return _price.getFrequentRenterPoints(daysRented);
    }
    
    public String getMoviePath() // iseng
    {
    	return "src/" + _moviePath + ".gif";
    }
}
