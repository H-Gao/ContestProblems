package CCCWaterlooContestPractise;

import java.util.Scanner;

public class SumacSequences 
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		
		int input[] = new int[2];
		
		for (int n = 0;n != 2;++n)
			input[n] = scanner.nextInt();
		
		int t1 = input[0];
		int t2 = input[1];
		int t3 = input[0] - input[1];
		
		for (int n = 1;true;++n)
		{
			if (t2 < t3)
			{
				System.out.print(n+2);
				break;
			}
			
			t1 = t2;
			t2 = t3;
			t3 = t1 - t2;
		}
	}
}
