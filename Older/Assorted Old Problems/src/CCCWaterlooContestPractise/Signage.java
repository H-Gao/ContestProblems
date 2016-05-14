package CCCWaterlooContestPractise;

import java.util.Scanner;

public class Signage 
{
	static boolean isDone = false;
	
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter w: ");
		
		int input = scanner.nextInt();
		
		while (true)
		{
			formatNumber(input);
			
			if (isDone)
				break;
		}
	}
	
	public static void formatNumber(int input)
	{
		int maxNumbers = 0;
		//6, 8, 11, 15, 19, 24
		
		if (input/29 > 0)
			maxNumbers = 6;
		else if (input/23 > 0)
			maxNumbers = 5;
		else if (input/18 > 0)
			maxNumbers = 4;
		else if (input/12 > 0)
			maxNumbers = 3;
		else if (input/9 > 0)
			maxNumbers = 2;
		else if (input/7 > 0)
			maxNumbers = 1;
		
		int spacesLeft = input-maxNumbers;
		
		for (int n = 0;n != maxNumbers;++n)
		{
			createWords(n);
			
			if (spacesLeft > 0)
			{
				--spacesLeft;
				System.out.print(".");
			}
			
			++n;
		}
		
		isDone = true;
	}
	
	public static void createWords(int maxNumbers)
	{
		if (maxNumbers == 0)
			System.out.print("WELCOME");
		
		else if (maxNumbers == 1)
			System.out.print("TO");
		
		else if (maxNumbers == 2)
			System.out.print("CCC");
		
		else if (maxNumbers == 3)
			System.out.print("GOOD");
		
		else if (maxNumbers == 4)
			System.out.print("LUCK");
		
		else if (maxNumbers == 5)
			System.out.print("TODAY");
		
		System.out.print(".");
	}
}
