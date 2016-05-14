package Default;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FindingPiToTheNthTerm 
{
	public static void main(String args[])
	{
		boolean isWorking = true;
		
		String pi = "3.141592653589793238462643383279502884197169399375105820974944592";
		
		Scanner scanner = new Scanner(System.in);
		
		int input;
		
		try
		{
			input = scanner.nextInt();
		}
		catch (InputMismatchException e)
		{
			System.out.println("You may only enter a Number.");
			input = -1;
		}
		
		String output = "";
		
		for (int n = 0;n != input + 1;++n)
		{		try
				{
					output += pi.charAt(n);
				}
			    catch (StringIndexOutOfBoundsException e)
			    {
			    	System.out.println("That Term is too high.");
			    	System.out.println("You Entered: " + input + " The Limit is 64");
			    	isWorking = false;
			    	break;
			    }
		}
		
		if (isWorking)
		{
			System.out.println(output);
		}
	}
}
