package afterRefactoring;

import java.util.Scanner;
import javax.swing.*;

import java.awt.event.ActionListener;
import java.net.*; 

public class Main 
{
	private AdministratorMenu adminMenu = new AdministratorMenu();
	private CustomerMenu customerMenu = new CustomerMenu();
	public static void main(String[] args) 
	{
		Main mainClass = new Main();
		// mainClass.RestoreData(); buggy
		mainClass.ChooseAccess();
	}
	private void RestoreData() // buggy
	{
		adminMenu.RestoreData();
	}
	private void ChooseAccess()
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
	        		break;
	        	case 2:
	        		adminMenu.AccessAdministrator();
	        		break;
	        	case 3:
	        		System.exit(0);
	        	case 4:
	        		WatchMovieTest();
	        		break;
	        	default:
	        		System.out.println("Wrong Input");
	        }
		}
	}
	private void WatchMovieTest() // Customer Watch Movie Test 
	{
		JLabel label = new JLabel(new ImageIcon("src/IndianaJones.gif"));
		JFrame frame = new JFrame("Movie");
		
		frame.getContentPane().add(label);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
