package afterRefactoring;

import java.io.Serializable;
import java.util.Enumeration;
import java.util.Vector;

class Customer implements Serializable
{
    private String _name;
    Vector<Rental> _rentals = new Vector<Rental>(); //Sementara public

    public Customer(String name) 
    {
        _name = name;
    }

    public void addRental(Rental arg)  //Nambah rental film kustomer
    {
        _rentals.addElement(arg);
    }
    
    public String getName() 
    {
        return _name;
    }

    public String statement() //display rental dari data kustomer
    {
        Enumeration rentals = _rentals.elements();
        String result = "Rental Record for " + getName() + "\n";
        while (rentals.hasMoreElements())
        {
            Rental each = (Rental) rentals.nextElement();

            result += "\t" + String.valueOf(each.getCharge()) + "\n";
        }
        //add footer lines
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + "frequent renter points";
        return result;
    }

    private double getTotalCharge()
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

}