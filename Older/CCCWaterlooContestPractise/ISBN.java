package CCCWaterlooContestPractise;

import java.util.Scanner;

public class ISBN 
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		
		int input[] = new int[3];
		
		for (int n = 0;n != 3;++n)
		{
			if (n == 0)
				System.out.print("Digit 11? ");
			
			else if (n == 1)
				System.out.print("Digit 12? ");
			
			else if (n == 2)
				System.out.print("Digit 13? ");
			
			input[n] = scanner.nextInt();
		}
		
		int sum = 91 + ((input[0]+input[2]) + (input[1]*3));
		
		System.out.println("The 1-3-sum is " + sum);
	}
}
