package Default;

import java.util.Scanner;

public class SpeedingFinesAreNotFine 
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int input[] = new int[2];
		
		for (int n = 0;n != 2;++n)
		{
			if (n == 0)
			{
				System.out.println("Enter the speed limit.");
			}
			
			else
			{
				System.out.println("Enter the recorded speed of the car.");
			}
			
			input[n] = scanner.nextInt();
		}
		
		int speedOverLimit = input[1] - input[0];
		
		if (speedOverLimit < 0)
		{
			System.out.println("Congradulations, you are within the speed limit");
		}
		
		else if (speedOverLimit > 30)
		{
			System.out.println("You are speeding and your fine is $500");
		}
		
		else if (speedOverLimit > 20)
		{
			System.out.println("You are speeding and your fine is $270");
		}
		
		else if (speedOverLimit > 0)
		{
			System.out.println("You are speeding and your fine is $100");
		}
	}
}
