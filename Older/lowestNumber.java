import java.util.Scanner;

import java.util.Random;

public class lowestNumber 
{
	public static void main(String[] args)
	{	
		int lowest[] = new int[5000];
		int number[] = new int[5000];
		int lowestNum = 1000;
		int counter = 0;
		
		for (int n = 0;n != 5000;++n)
		{
			Random random = new Random();
			
			number[n] = random.nextInt(100) + 1;
			
			if (number[n] < lowestNum)
			{
				lowestNum = number[n];
			}
			
			if (n%5==0)
			{
				lowest[n] = number[counter];
				lowestNum = 1000;
				++counter;
				
				if (lowest[n] > 0)
				{
					System.out.println("The lowest number is " + lowest[n]);
				}
			}
		}		
	}
}
