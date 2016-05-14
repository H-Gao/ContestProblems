package CCCWaterlooContestPractise;

import java.util.Scanner;

public class BridgeTrans 
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		
		int input2[] = new int[2];
		
		for (int n = 0;n != 2;++n)
			input2[n] = scanner.nextInt();
		
		int input[] = new int[input2[1]];
		
		for (int n = 0;n != input2[1];++n)
			input[n] = scanner.nextInt();
		
		int totalCrossed = 0;
		int weight = 0;
		
		for (int n = 0;n != input2[1]+3;++n)
		{
			if (n < 3)
			{
				if (n == 0)
					weight = input[0];
				else if (n == 1)
					weight = input[0] + input[1];
				else if (n == 2)
					weight = input[0] + input[1] + input[2];
				
				if (weight > input2[0])
					break;
				else
					++totalCrossed;
			}
			else
			{
				weight = input[0+n-3] + input[1+n-3] + input[2+n-3] + input[3+n-3];
		
				if (weight > input2[0])
					break;
				else
					++totalCrossed;
			}
		}
		
		System.out.println(totalCrossed);
	}
}
