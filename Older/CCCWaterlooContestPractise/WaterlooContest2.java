package CCCWaterlooContestPractise;

import java.util.Scanner;

public class WaterlooContest2
{
	public static void main(String[] args)
	{
		int votesA = 0;
		int votesB = 0;
		
		Scanner scanner = new Scanner(System.in);
		
		String votes[] = new String[2];
		
		for (int n = 0;n != 2;++n)
			votes[n] = scanner.nextLine();
		
		for (int n = 0;n != Integer.parseInt(votes[0]);++n)
		{
			if (votes[1].charAt(n) == 'A')
				++votesA;
			
			else if (votes[1].charAt(n) == 'B')
				++votesB;
		}
		
		if (votesA > votesB)
			System.out.println("A");
		else if (votesA < votesB)
			System.out.println("B");
		else if (votesA == votesB)
			System.out.println("Tie");
	}
}