package CCCWaterlooContestPractise;

import java.util.Scanner;

public class OldFishingPole 
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		
		int input[] = new int[4];
		int t = 0;
		
		for (int n = 0;n != 4;++n)
			input[n] = scanner.nextInt();
		
		for (int a = 0;a != input[3]+1;++a)
		{
			for (int b = 0;b != input[3]+1;++b)
			{
					for (int c = 0;c != input[3]+1;++c)
					{
						if (a > 0 || b > 0 || c > 0)
							if (((a*input[0]) + (b*input[1]) + (c*input[2])) <= input[3])
							{
								++t;
								System.out.println(a + " Brown Trout, " + b + " Northern Pike, " + c + " Yellow Pickerel");
							}
					}
			}
		}
		
		System.out.println("Number of ways to catch fish: " + t);
	}
}
