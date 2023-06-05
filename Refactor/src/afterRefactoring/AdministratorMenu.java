package afterRefactoring;
import java.util.*;

import java.util.Scanner;

public class AdministratorMenu 
{
	private static int movieCapacity = 20;
	private List<Rental> movies = new ArrayList<Rental>();
	private List<Customer> customers = new ArrayList<Customer>();
	private DataStore dataStore = new DataStore();
	
	public void RestoreData()
	{
		//dataStore.ReadData(); buggy
		
		if (dataStore.movies.size() == 0 && dataStore.customers.size() == 0)
		{
			System.out.println("No data Has Been Found");
			customers.add(new Customer("John"));
			customers.add(new Customer("Bob"));
			customers.add(new Customer("Mary"));
			
			Movie movie1 = new Movie("The Avengers", 1);
			Movie movie2 = new Movie("Tom and Jerry", 2);
			Movie movie3 = new Movie("John Wick 4", 3);
			
			movies.add(new Rental(movie1));
			movies.add(new Rental(movie2));
			movies.add(new Rental(movie3));
			return;
		}
		
		movies.addAll(dataStore.movies);
		customers.addAll(dataStore.customers);
		System.out.println("Administrator Data Successfully Restored");
	}
	public void AccessAdministrator() 
	{
		MainMenu();
	}
	private void MainMenu()
	{
		Scanner scanner = new Scanner(System.in);
		
        while(true) 
        {
            System.out.println("Welcome to the MovieAddict Administrator menu");
            System.out.println("1. Add a Movie to the store");
            System.out.println("2. Remove a Movie from the store");
            System.out.println("3. View all Movies in the store");
            System.out.println("4. View all registered Customer");
            System.out.println("5. Quit");

            System.out.print("Please enter your input: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice)
            {
            	case 1:
            		if(movies.size() >= movieCapacity)
            			System.out.println("Movie Capacity Exceeded");
            		else
            			AddMovieMenu();
            	case 2:
            		RemoveMovieMenu();
            	case 3:
            		ViewAllMovie();
            	case 4:
            		ViewAllCustomer();
            	case 5:
            		dataStore.StoringData(movies, customers);
            		System.exit(0);
            	default:
            		System.out.println("Wrong Input !");
            }
        }
	}
	
	private void AddMovieMenu()
	{
		 Scanner scanner = new Scanner(System.in);
		 System.out.println("Enter the Movie title: ");
		 String title = scanner.nextLine();
		 
         System.out.println("1. Regular Movie");
         System.out.println("2. Children's Movie");
         System.out.println("3. New Release");
         System.out.println("Please enter the Movie Type: ");
         int type = scanner.nextInt();
         while (type > 3 || type < 0)
         {
        	 System.out.println("Wrong Input");
        	 type = scanner.nextInt();
         }
         
         Movie newMovie = new Movie(title, type);
         while (true)
         {
        	 System.out.println("Is this Movie's information correct?");
             System.out.println("Movie Title: " + newMovie.getTitle());
             System.out.println("Movie Type: " + newMovie.getPriceName());
             System.out.println("1. Yes");
             System.out.println("2. No, Reset");
             System.out.println("3. No, Return to main menu");
             int choice = scanner.nextInt();
             switch(choice)
             {
             	 case 1:
             		 Rental newRental = new Rental(newMovie);
             		 movies.add(newRental);
             		 System.out.println(newRental.getMovie().getTitle() + " is added to the store");
             		 scanner.nextLine();
             		 MainMenu();
             		 break;
             	 case 2:         		 
             		 AddMovieMenu();
             		 break;
             	 case 3:
             		 MainMenu();
             		 break;
             	 default:
             		 System.out.println("Wrong Input");
             }
         }
	}
	
	private void MovieList()
	{
		System.out.println("List of All Available Movies");
		for (int i = 0; i < movies.size(); i++)
		{
			System.out.println((i + 1) + ". " + movies.get(i).getMovie().getTitle() + " " + movies.get(i).getMovie().getPriceName());
		}	
	}
	
	private void RemoveMovieMenu()
	{
		Scanner scanner = new Scanner(System.in);
		MovieList();
		
		System.out.println("Enter the movie that needs to be removed");
		int choice = scanner.nextInt();
		
		System.out.println(movies.get(choice - 1).getMovie().getTitle() + " is now removed from the store");
		movies.remove(choice);
		
		MainMenu();
	}
	
	private void ViewAllMovie()
	{
		Scanner scanner = new Scanner(System.in);
		MovieList();
		
		scanner.nextLine();
		MainMenu();
	}
	
	private void ViewAllCustomer()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("List of all Customers");
		for (int i = 0; i < customers.size(); i++)
		{
			System.out.println((i + 1) + ". " + customers.get(i).getName());
		}	
		scanner.nextLine();
		MainMenu();
	}
}
