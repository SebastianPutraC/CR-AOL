package afterRefactoring;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;


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
		System.out.println(customer.getName());
		Scanner scanner = new Scanner(System.in);
        while (true) 
        {
            System.out.println("Movie Subscription Menu");
            System.out.println("1. View available movies"); // Nyari Film dari admin
            System.out.println("2. Subscribe to a movie"); 
            System.out.println("3. View subscribed movies"); // Nyari film dari customer
            System.out.println("4. Quit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) 
            {
                case 1:
                    System.out.println("Available Movies:");
                    //customer.statement();
                    admin.MovieList();
                    scanner.nextLine();
                    break;
                case 2:
                    System.out.print("Enter the title of the movie to subscribe: ");
                    admin.MovieList();
                    int movieTitle = scanner.nextInt();
                    scanner.nextLine();
                    while (admin.movies.get(movieTitle - 1) == null)
                    {
                    	movieTitle = scanner.nextInt();
                        scanner.nextLine();
                    }
                    customer.addRental(admin.movies.get(movieTitle - 1));
                    System.out.println(admin.movies.get(movieTitle - 1).getMovie().getTitle());
                    break;
                case 3:
                    System.out.println("Subscribed Movies:");
                    ViewCustomerMovie();
                    scanner.nextLine();
                    //String customerInfo = customer.statement();
                    //System.out.println(customerInfo);
                    break;
                case 4:
                    System.out.println("Thank you for using the Movie Subscription!");
                    main.ChooseAccess();
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
	}
	public void ViewCustomerMovie()
	{
		for (int i = 0; i < customer._rentals.size(); i++)
		{
			System.out.println((i + 1) + ". " + customer._rentals.get(i).getMovie().getTitle() + " " + customer._rentals.get(i).getMovie().getPriceName()); // Try to make it shorty
		}
	}
}
