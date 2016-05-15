package CCCWaterlooContestPractise;

import java.util.Scanner;

public class WaterlooContest1 
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		
		int input[] = new int[3];
		
		for (int n = 0;n != 3;++n)
			input[n] = scanner.nextInt();
		
		if ((input[0]+input[1]+input[2]) != 180)
			System.out.println("Error");
		else
		{
			if (input[0] == 60 && input[1] == 60 && input[2] == 60)
				System.out.println("Equilateral");
				
			else if (input[0] == input[1] || input[0] == input[2] || input[1] == input[2])
			{
				System.out.println("Isosceles");
			}
			else if (input[0] != input[1] && input[0] != input[2] && input[1] != input[2])
			{
				System.out.println("Scalene");
			}
		}
			
	}
}