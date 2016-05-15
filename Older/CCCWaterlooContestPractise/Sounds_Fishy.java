package CCCWaterlooContestPractise;

import java.util.Scanner;

public class Sounds_Fishy 
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		
		boolean isWorking = false;
		String depth = "";
		
		int input[] = new int[4];
		
		for (int n = 0;n != 4;++n)
		{
			input[n] = scanner.nextInt();
			
			if (n != 0)
			{
				if (input[n] > input[n-1])
					depth += "+";
				
				else if (input[n] < input[n-1])
					depth += "-";
				
				else if (input[n] == input[n-1])
					depth += "=";
			}
			
			if (n == 3)
			{
				for (int k = 0;k != 3;++k)
				{
					if (k != 0)
					{
						if (depth.charAt(k) == depth.charAt(k-1))
							isWorking = true;
						else
						{
							isWorking = false;
							break;
						}
					}
				}
			}
		}
		
		if (isWorking)
		{
			if (depth.charAt(0) == '+')
				System.out.println("Fish Rising");
			
			else if (depth.charAt(0) == '-')
				System.out.println("Fish Diving");
			
			else if (depth.charAt(0) == '=')
				System.out.println("Fish At Constant Depth");
		}
		else
		{
			System.out.println("No Fish");
		}
	}
}
