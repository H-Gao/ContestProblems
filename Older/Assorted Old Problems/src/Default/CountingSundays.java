package Default;

import java.util.Scanner;

public class CountingSundays 
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		
		int input[] = new int[2];
		
		for (int n = 0;n != 2;++n)
		{
			input[n] = scanner.nextInt();
		}
		
		int dayOfTheWeek = 2;
		
		int numberOfSundays = 0;
		
		for (int n = input[0];n <= input[1];++n)
		{
			++dayOfTheWeek;
			
			if (dayOfTheWeek > 7)
			{
				dayOfTheWeek = 1;
			}
			
			if (n%4==0 && n%100!=0 || n%400==0)
			{
				++dayOfTheWeek;
			}
			
			if (dayOfTheWeek < 5)
			{
				numberOfSundays += 4;
			}
			else
			{
				numberOfSundays += 5;
			}
		}
		
		System.out.println(numberOfSundays);
	}
}
