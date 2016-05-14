package CCCWaterlooContestPractise;

import java.util.Scanner;

public class whoHasSeenTheWind 
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		
		int input[] = new int[2];
		
		for (int n = 0;n != 2;++n)
			input[n] = scanner.nextInt();
		
		for (int t = 1;t != input[1];++t)
		{
			int altitude = (-6*toPower(t, 4)) + (input[0]*toPower(t, 3)) + (2*toPower(t, 2)) + t;
			
			if (altitude < 0)
			{
				System.out.print("The balloon first touches ground at hour:\n"+t);
				break;
			}
			else if (t == input[1]-1)
			{
				System.out.print("The balloon does not touch ground in the given time.");
			}
		}
	}
	
	public static int toPower(int n, int exponent)
	{
		int output = n;
		
		for (int k = 0;k != exponent-1;++k)
			output *= n;
		
		return output;
	}
}
