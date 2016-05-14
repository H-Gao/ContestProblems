package Default;

import java.util.Scanner;

public class WhoHasBeenTheWind 
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		
		int a = 0;
		
		int n = 0;
		int h = scanner.nextInt();
		int m = scanner.nextInt();
		
		while (n < m)
		{
			++n;
			
			a = n + 2*(n*n) + h*(n*n*n) - 6*(n*n*n*n);
			
			if (a <= 0)
			{
				a = -1;
				break;
			}
			
			else
				a = 0;
		}

		if (a == -1)
			System.out.println("The ballon first touches the ground at hour: " + n);
		else
			System.out.println("The ballon does not touch the ground.");
			
	}
}
