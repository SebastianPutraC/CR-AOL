package afterRefactoring;

import java.io.*;
import java.util.*;

public class DataStore
{
	public List<Rental> movies = new ArrayList<Rental>();
	public List<Customer> customers = new ArrayList<Customer>();
	
	public void StoringData(List<Rental> adminMovies, List<Customer> customerData)
	{
		this.movies.addAll(adminMovies);
		this.customers.addAll(customerData);
		WriteData();
	}
	public void WriteData()
	{
		try 
		{
		    FileOutputStream fosMovies = new FileOutputStream("movies.ser");
		    ObjectOutputStream oosMovies = new ObjectOutputStream(fosMovies);
		    oosMovies.writeObject(movies);
		    oosMovies.close();
		    fosMovies.close();
		    
		    FileOutputStream fosCustomer = new FileOutputStream("customers.ser");
		    ObjectOutputStream oosCustomer = new ObjectOutputStream(fosCustomer);
		    oosCustomer.writeObject(customers);
		    oosCustomer.close();
		    fosCustomer.close();
		}
		catch (FileNotFoundException e) 
		{
		    e.printStackTrace();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void ReadData()
	{
		try 
		{
			CheckData();
		    FileInputStream fisMovies = new FileInputStream("movies.ser");
		    
		    if (fisMovies.available() == 0)
		    	return;
		    
		    ObjectInputStream oisMovies = new ObjectInputStream(fisMovies);
		    movies = (List<Rental>) oisMovies.readObject();
		    oisMovies.close();
		    fisMovies.close();
		    
		    FileInputStream fisCustomer = new FileInputStream("customers.ser");
		    
		    if (fisCustomer.available() == 0)
		    	return;
		    
		    ObjectInputStream oisCustomer = new ObjectInputStream(fisCustomer);
		    customers = (List<Customer>) oisCustomer.readObject();
		    oisCustomer.close();
		    fisCustomer.close();
		    
		    CheckData();
		}
		catch (FileNotFoundException e) 
		{
		    e.printStackTrace();
		}
		catch (IOException e) 
		{
		    e.printStackTrace();
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
	public void CheckData()
	{
		System.out.println("Movies Data = " + movies.size());
	}
}
