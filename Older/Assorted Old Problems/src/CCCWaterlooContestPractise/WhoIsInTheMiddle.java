package CCCWaterlooContestPractise;

import java.util.Scanner;
import java.util.Arrays;

public class WhoIsInTheMiddle 
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
	
		int input[] = new int[3];
	
		for (int n = 0;n != 3;++n)
			input[n] = scanner.nextInt();
		
		Arrays.sort(input);
		
		System.out.println(input[1]);
	}
}
