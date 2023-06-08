package afterRefactoring;

import java.util.Scanner;

public class Main 
{
	private AdministratorMenu adminMenu = new AdministratorMenu();
	private CustomerMenu customerMenu = new CustomerMenu();
	public static void main(String[] args) 
	{
		Main mainClass = new Main();
		mainClass.InitializeData();
		mainClass.ChooseAccess();
	}
	private void InitializeData() // ONLY DO ONCE AT START
	{
		adminMenu.InitializeData(this);
		customerMenu.InitializeData(this, adminMenu);
	}
	public void ChooseAccess()
	{
		while(true)
		{
			Scanner scanner = new Scanner(System.in);
			System.out.println("Welcome to MovieAddict online subscription service");
			System.out.println("Are you a customer or an Administrator");
	        System.out.println("1. Customer");
	        System.out.println("2. Administrator");
	        System.out.println("3. Exit");
	        
	        int choice = scanner.nextInt();
	        scanner.nextLine(); 
	        
	        switch (choice)
	        {
	        	case 1:
	        		ChooseCustomer();
	        		break;
	        	case 2:
	        		adminMenu.MainMenu();
	        		break;
	        	case 3:
	        		System.exit(0);
	        	default:
	        		System.out.println("Wrong Input");
	        }
		}
	}
	private void ChooseCustomer()
	{
		Scanner scanner = new Scanner(System.in);
		adminMenu.CustomerList();
		
		System.out.println("Which customer are you?");
		int choice = scanner.nextInt();
		
		customerMenu.PickCustomer(adminMenu.getCustomer(choice));
		customerMenu.MainMenu();
	}
}
