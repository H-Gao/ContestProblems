package CCCWaterlooContestPractise;

import java.util.Scanner;

public class IconScaling 
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		
		int input = scanner.nextInt();
		
		for (int n = 0;n != 3*input;++n)
		{
			for (int k = 0;k != 3*input;++k)
			{
				if (n < input)
				{
					if (k >= input && k < 2*input)
						System.out.print("x");
					else if (k < 3*input)
						System.out.print("*");
				}
				
				else if (n >= input && n < 2*input)
				{
					if (k < input)
						System.out.print(" ");
					else if (k < 3*input)
						System.out.print("x");
				}
				
				else if (n >= 2*input && n < 3*input)
				{
					if (k >= input && k < 2*input)
						System.out.print(" ");
					else if (k < 3*input)
						System.out.print("*");
				}
			}
			
			if (n != ((3*input)-1))
				System.out.print("\n");
		}
	}
}
