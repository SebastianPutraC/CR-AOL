package afterRefactoring;
import java.util.Scanner;

import javax.swing.*;

public class CustomerMenu 
{
	private Customer customer;
	private Main main;
	private AdministratorMenu admin;
	
	public void InitializeData(Main main, AdministratorMenu admin)
	{
		this.main = main;
		this.admin = admin;
	}

	public void PickCustomer(Customer customer)
	{
		this.customer = customer;
	}
	public void MainMenu()
	{
		 Scanner scanner = new Scanner(System.in);
		 while(true)
		 {
			 MainMenuUI();
	         int choice = scanner.nextInt();
	         scanner.nextLine();
	         MainMenuChoice(choice);
		 }
	}
	private void MainMenuChoice(int choice)
	{
		switch (choice) 
        {
        	case 1:
        		int watchInput = CheckInput();
        		Rental watchRental = customer.getRental(watchInput);
        		WatchMovie(watchRental);
        		break;
            case 2:
                ViewAvailableMovie();
                break;
            case 3:
            	Rental subsInput = SubscribeMovieInput();
            	customer.addRental(subsInput);
                break;
            case 4:
            	int delRental = CheckInput();
            	customer.deleteRental(delRental);
            	break;
            case 5:
                ViewSubscribedMovie();
                break;
            case 6:
            	NextDay();
            	break;
            case 7:
                System.out.println("Thank you for using the Movie Subscription!");
                main.ChooseAccess();
            default:
           	 System.out.println("Wrong Input");
        }
	}
	private void MainMenuUI()
	{
		System.out.println("Welcome " + customer.getName() + ", to MovieAddict Custoemr Menu");
        System.out.println("Your Balance is : " + customer.getMoney());
        System.out.println("================================================================");
        System.out.println(customer.statement());
        System.out.println("================================================================");
        System.out.println("1. Watch Movie");
        System.out.println("2. View available Movie");
        System.out.println("3. Subscribe to a Movie"); 
        System.out.println("4. Unsubscribe to a movie");
        System.out.println("5. View subscribed Movies");
        System.out.println("6. Go to Next day");
        System.out.println("7. Quit");
        System.out.println("Please enter your choice: ");
	}
	private int CheckInput()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println(customer.ViewRental());
		int input = scanner.nextInt();
        scanner.nextLine();
		while (customer.getRental(input) == null)
        {
			System.out.println("Wrong Input");
        	input = scanner.nextInt();
            scanner.nextLine();
        }
		return input;
	}
	private void WatchMovie(Rental movie) //Additional Feature
	{
		Scanner scanner = new Scanner(System.in);
		JLabel label = new JLabel(new ImageIcon(movie.getMovie().getMoviePath()));
		JFrame frame = new JFrame(movie.getMovie().getTitle());
		
		frame.getContentPane().add(label);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		System.out.println("Enjoy the Movie :)");
		System.out.println("Press Enter to return");
		scanner.nextLine();
	}
	private Rental SubscribeMovieInput()
	{
		 Scanner scanner = new Scanner(System.in);
		 System.out.print("Enter the title of the movie to subscribe: ");
         admin.MovieList();
         int movieTitle = scanner.nextInt();
         scanner.nextLine();
         while (admin.getRental(movieTitle) == null)
         {
         	System.out.println("Wrong Input");
         	movieTitle = scanner.nextInt();
            scanner.nextLine();
         }
         return admin.getRental(movieTitle);
	}
	private void ViewAvailableMovie()
	{
		 Scanner scanner = new Scanner(System.in);
		 System.out.println("Available Movies:");
         admin.MovieList();
         System.out.println("Press Enter to return");
         scanner.nextLine();
	}
	private void ViewSubscribedMovie()
	{
		Scanner scanner = new Scanner(System.in);
		 System.out.println("Subscribed Movies:");
         System.out.println(customer.ViewRental());
         System.out.println("Press Enter to return");
         scanner.nextLine();
	}
	private void NextDay()
	{
		Scanner scanner = new Scanner(System.in);
		NextDayUI();
		
		int choice = scanner.nextInt();
        scanner.nextLine();
        while (choice < 0 || choice > 4)
        {
        	System.out.println("Wrong Input");
        	choice = scanner.nextInt();
        	scanner.nextLine();
        }
        NextDayChoice(choice);
        
		customer.setMoney(- customer.getTotalCharge());
		customer.addDaysRented();
		
		System.out.println(customer.getTotalCharge() + " dollars was paid to pay for the subscription service");
		System.out.println("Press Enter to continue");
		scanner.nextLine();
	}
	
	private void NextDayUI()
	{
		System.out.println("What will you do before the next day?");
		System.out.println("1. Work");
		System.out.println("2. Work Harder");
		System.out.println("3. Burn all of your money");
		System.out.println("4. Nothing");
	}
	private void NextDayChoice(int choice)
	{
		 switch(choice)
	     {
	         case 1:
	        	customer.setMoney(20);
	        	System.out.println("You've gained 20 dollar for your work");
	        	break;
	        case 2:
	        	customer.setMoney(50);
	        	System.out.println("Your boss is impressed with your hard work!, You've gained 50 dollar");
	        	break;
	        case 3:
	        	customer.setMoney(-customer.getMoney());
	        	System.out.println("All your money are turned into ashes");
	        	break;
	        case 4:
	        	System.out.println("Why bother working? zzz...");
	        	break;
	    }
		 
	}
}
