package CCCWaterlooContestPractise;

import java.util.Scanner;

public class WaterlooContest3 
{
	public static void main(String[] args)
	{
		int pointsA = 100;
		int pointsB = 100;
		
		Scanner scanner = new Scanner(System.in);
		
		int rounds = scanner.nextInt();
		
		String roll[] = new String[rounds+1];
		
		for (int n = 0;n != rounds+1;++n)
		{
			roll[n] = scanner.nextLine();
			
			if (n > 0)
			{
				int playerA = Integer.parseInt(roll[n].split(" ")[0]);
				int playerB = Integer.parseInt(roll[n].split(" ")[1]);
				
				if (playerA > playerB)
				{
					pointsB -= playerA;
				}
				else if (playerA < playerB)
				{
					pointsA -= playerB;
				}
			}
		}
		
		System.out.println(pointsA);
		System.out.println(pointsB);
	}
}
