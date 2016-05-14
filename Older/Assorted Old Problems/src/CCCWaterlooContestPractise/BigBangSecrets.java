package CCCWaterlooContestPractise;

import java.util.Scanner;

public class BigBangSecrets 
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
	
		int k = scanner.nextInt();
		String input = scanner.next();
	
		for (int n = 0;n != input.length();++n)
		{
			int s = 3*(n+1)+k;
			
			if ((input.charAt(n) - s) < 65)
				System.out.print((char)((input.charAt(n)-s)+26));
			else
				System.out.print((char)(input.charAt(n)-s));
		}
	}
}
