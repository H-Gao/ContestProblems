package CCCWaterlooContestPractise;

import java.util.Scanner;
import java.util.Arrays;

public class DealorNoDealCalculator 
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
	
		int amount = scanner.nextInt();
		
		int input[] = new int[amount+1];
	
		for (int n = 0;n != amount+1;++n)
			input[n] = scanner.nextInt();
		
		if (findAverage(input, amount) > input[amount])
			System.out.println("Deal");
		
		else if (findAverage(input, amount) <= input[amount])
			System.out.println("No Deal");
	}
	
	public static int findAverage(int input[], int amount)
	{
		int output = 0;
		
		for (int n = 0;n != 10;++n)
		{
			for (int k = 0;k != amount;++k)
			{
				if (input[k] == n)
					break;
				
				else if (k == amount-1)
				{
					if (n == 0)
						output += 100;
					
					else if (n == 1)
						output += 500;
					
					else if (n == 2)
						output += 1000;
					
					else if (n == 3)
						output += 5000;
					
					else if (n == 4)
						output += 10000;
					
					else if (n == 5)
						output += 25000;
					
					else if (n == 6)
						output += 50000;
					
					else if (n == 7)
						output += 100000;
					
					else if (n == 8)
						output += 500000;
					
					else if (n == 9)
						output += 1000000;
				}
			}
		}
		
		return output/(10-amount);
	}
}
