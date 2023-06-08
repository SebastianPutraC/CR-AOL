package afterRefactoring;

import java.io.Serializable;
import java.util.Enumeration;
import java.util.Vector;

class Customer implements Serializable
{
    private String _name;
    private double _money;
    private Vector<Rental> _rentals = new Vector<Rental>();

    public Customer(String name, int money) 
    {
        _name = name;
        _money = money;
    }
    public void addRental(Rental arg) 
    {
        _rentals.addElement(arg);
    }
    public void deleteRental(int rental)
    {
    	_rentals.remove(rental - 1);
    }
    public String getName() 
    {
        return _name;
    }
    public double getMoney()
    {
    	return _money;
    }
    public void setMoney(double money)
    {
    	_money += money;
    }
    public Rental getRental(int movie)
    {
    	if ( (movie - 1) < 0 || (movie - 1) > _rentals.size())
    	{
    		return null;
    	}
    	return _rentals.get(movie - 1);
    }
    public String statement()
    {
        Enumeration rentals = _rentals.elements();
        String result = "Rental Record for " + getName() + "\n";
        while (rentals.hasMoreElements())
        {
            Rental each = (Rental) rentals.nextElement();
        }
        //add footer lines
        result += "Amount owed for next day payment is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";
        return result;
    }
    public String ViewRental()
    {
    	Enumeration rentals = _rentals.elements();
    	String result = "";
    	int i = 0;
    	while (rentals.hasMoreElements())
    	{
    		Rental each = (Rental) rentals.nextElement();
    		i++;
    		result += i + ". " + each.getMovie().getTitle() + " " + each.getMovie().getPriceName() + "\n";
    	}
    	return result;
    }
    public double getTotalCharge()
    { 
    	double result = 0;
        Enumeration rentals = _rentals.elements(); 
        while (rentals.hasMoreElements()) 
        {
            Rental each = (Rental) rentals.nextElement();
            result += each.getCharge(); 
        }
        return result;
    }

    private int getTotalFrequentRenterPoints()
    { 
    	int result = 0;
        Enumeration rentals = _rentals.elements(); 
        while (rentals.hasMoreElements()) 
        {
            Rental each = (Rental) rentals.nextElement();
            result += each.getFrequentRenterPoints(); 
        }
        return result; 
    }
    public void addDaysRented()
    {
    	for (int i = 0; i < _rentals.size(); i++)
		{
			_rentals.get(i).addDaysRented();
		}
    }
}