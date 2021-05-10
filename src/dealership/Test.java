package dealership;

import java.util.Scanner;

public class Test {
	  private static Scanner input = new Scanner(System.in);


	    public static void main(String[] args) 
	    {
	    	char choice = ' ';	// to intialise the variable
	    	while (choice != 'X' || choice !='x')  // A menu loop to stop premature program termination
	    	{
		      	displayMenu();
		    	choice = getChoice();
		    	processChoice(choice);
	    	}
	    }

	    public static void displayMenu()
	    //------------------------------
	    // Displays menu: (A) Prime Number Checker
	    //                (B) Select Account 2
	    //                (C) Deposit to selected account
	    //                (X) Exit
	    //                Please enter your selection  >>

		{
	        System.out.println ( " ----------------------------------");
			System.out.println ( " (A) Prime Number Checker.");
			System.out.println ( " (B) Stamp Duty Calculator.");
			System.out.println ( " (C) Vowel Counter.");
			System.out.println ( " (X) Exit  " );
			System.out.println ( " ----------------------------------");
		}

	    public static char getChoice()
		//----------------------------
		// Return the first character of the user's keyboard entry.
	    {
		System.out.print ("Please enter your selection  >>  ");
		String choice = input.next();
		char getChoice = ' ';
		if( choice.length() > 0 )
		{
			getChoice = choice.charAt(0);
		}
			return getChoice;
	    }

	    public static void processChoice(char choice)
	    // Performs the required function.
	    // Does nothing if the choice_ is invalid.
	  
	    {
		switch (choice)
		{
	    	case 'A':
	        case 'a':
	        			 System.out.println ("A"); // Calls Prime Number Method
	                     break;

	            case 'B':
	            case 'b':
	            		 System.out.println ("B");  // Calls Stamp Duty Method
	                     break;

	            case 'C':
	            case 'c':
	            	System.out.println ("c");  // Calls Vowel Counting Method
	                     break;

	            case 'X':
	            case 'x':
	                     System.out.println ("Exiting the program... thankyou");
	                     System.exit(0);	// Exits the program
	                     break;

	            default:	// Default message for invalid char
	                    System.out.println("Error! " + choice +
	                                       " is not a valid menu option");
	        }
	    }
	}
