package CCCWaterlooContestPractise;

import java.util.Scanner;

public class WhatisnDaddy extends WaterlooContestQuestion
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		
		int input = scanner.nextInt();
		
		int output = 0;
		
		for (int n = 1;n != input+1;++n)
		{
			for (int k = 0;k != n+1;++k)
			{
				if (k+n==input)
					++output;
			}
		}
		
		say(output);
	}
}
