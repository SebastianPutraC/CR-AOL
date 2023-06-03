package afterRefactoring;
import java.util.ArrayList;
import java.util.Scanner;

public class AdministratorMenu 
{
	private static int movieCapacity = 20;
	public ArrayList<Rental> movies = new ArrayList<Rental>();
	public ArrayList<Customer> customers = new ArrayList<Customer>();
	
	/*public static void main(String[] args) 
	{
		AdministratorMenu menu = new AdministratorMenu();
		menu.MainMenu();
		
	}*/
	
	private void MainMenu()
	{
		Scanner scanner = new Scanner(System.in);
		
        while (true) 
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
         
         Movie newMovie = new Movie(title, type);
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
         }
	}
	
	private void MovieList()
	{
		System.out.println("List of All Available Movies");
		for (int i = 0; i < movies.size(); i++)
		{
			System.out.println(i + ". " + movies.get(i).getMovie().getTitle());
		}	
	}
	
	private void RemoveMovieMenu()
	{
		Scanner scanner = new Scanner(System.in);
		MovieList();
		
		System.out.println("Enter the movie that needs to be removed");
		int choice = scanner.nextInt();
		
		System.out.println(movies.get(choice).getMovie().getTitle() + " is now removed from the store");
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
		
	}
}
