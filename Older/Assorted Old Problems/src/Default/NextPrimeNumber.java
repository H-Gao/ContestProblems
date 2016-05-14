package Default;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NextPrimeNumber 
{
	public static void main(String args[])
	{
		Scanner scanner = new Scanner(System.in);
		
		String keepGoing = "yes";
		boolean isPrime = false;
		int input;
		
		try
		{
			input = scanner.nextInt();
		}
		catch (InputMismatchException e)
		{
			input = -1;
			System.out.println("Only enter a number");
		}
		
		while (keepGoing.equalsIgnoreCase("yes"))
		{	
			while (!isPrime)
			{
				++input;
				
				for (int n = 2;n != input-1;++n)
				{
					if (input%n!=0)
					{
						isPrime = true;
					}
					
					else
					{
						isPrime = false;
						break;
					}
				}
			}
			
			isPrime = false;
			
			System.out.println(input);
			
			keepGoing = scanner.next();
		}
		
			System.out.println("Good Bye.");
	}
}
