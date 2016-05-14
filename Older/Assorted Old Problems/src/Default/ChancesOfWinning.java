package Default;

import java.util.Scanner;

public class ChancesOfWinning 
{
	public static void main(String args[])
	{
		Scanner scanner = new Scanner(System.in);
	
		int input[] = new int[2];
		
		int points[] = new int[4];
		
		int highest = 0;
		int highestNumber = 0;
		int tied = 0;
	
		for (int n = 0;n != 2;++n)
		{
			input[n] = scanner.nextInt();
		}
	
		String resultsOfPlayedGames[] = new String[input[1]];
		String i[];
		
		int gamesPlayed[] = new int[24];
	
		for (int n = 0;n != input[1];++n)
		{
			resultsOfPlayedGames[n] = scanner.nextLine();
			i = resultsOfPlayedGames[n].split(" ");
			
			for (int k = 0;k != 4;++k)
			{
				gamesPlayed[n] = i[n].charAt(0);
			}
		}
		
		//n is number of games played.
		for (int n = 0;n != gamesPlayed.length/4;++n)
		{
			for (int k = 0;k != 4;++k)
			{
				if (gamesPlayed[k*n] != 0 && gamesPlayed[k] > highest)
				{
					highest = gamesPlayed[n];
					highestNumber = k;
				}
				
				else if (gamesPlayed[k*n] != 0 && gamesPlayed[n] == highest)
				{
					tied = k;
				}
			}
			
			if (tied != 0)
			{
				++points[tied];
			}
			
			else
			{
				++points[highestNumber];
			}
		}
		
		for (int n = 0;n != 4;++n)
		{
			System.out.println(points[n]);
		}
	}
}
