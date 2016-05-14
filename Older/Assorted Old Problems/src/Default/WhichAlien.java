package Default;

import java.util.Scanner;

public class WhichAlien 
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		
		int input[] = new int[2];
		
		System.out.println("How many antennas?");
		
		for (int n = 0;n != 2;++n)
		{
			if (n == 1)
			{
				System.out.println("How many eyes?");
			}
			
			input[n] = scanner.nextInt();
		}
		
		if (input[0] >= 3 && input[1] <= 4) 
			System.out.println("TroyMartin");
		
		if (input[0] <= 6 && input[1] >= 2) 
			System.out.println("VladSaturnian");
		
		if (input[0] <= 2 && input[1] <= 3) 
			System.out.println("GraemeMercurian");
	}
}
