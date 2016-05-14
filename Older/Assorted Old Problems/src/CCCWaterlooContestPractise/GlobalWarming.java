package CCCWaterlooContestPractise;

import java.util.Scanner;

public class GlobalWarming 
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		
		while (true)
		{
			String input = scanner.nextLine();
			
			String[] inputs = input.split(" ");
			
			if (Integer.parseInt(inputs[0]) == 0)
				break;
			
			else
			{
				int storedResults[] = new int[Integer.parseInt(inputs[0])];
				
				for (int n = 0;n != Integer.parseInt(inputs[0]);++n)
					if (inputs[n] != null && inputs[n+1] != null)
						storedResults[n] = Integer.parseInt(inputs[n+1]) - Integer.parseInt(inputs[n]);
				
				int storedFinalResults[] = new int[storedResults.length];
				
				for (int n = 0;n != storedFinalResults.length;++n)
					storedFinalResults[n] = -1001;
				
				for (int n = 1;n != storedResults.length;++n)
				{
					for (int k = 0;k != storedFinalResults.length;++k)
					{
						if (storedResults[n] == storedFinalResults[k])
							break;
						
						if (k==(storedFinalResults.length - 1))
							storedFinalResults[n] = storedResults[n];
					}
				}
				
				int output = 0;
				
				for (int n = 0;n!=storedFinalResults.length;++n)
					if (storedFinalResults[n] != -1001) ++output;
				
				System.out.println(output);
			}
		}
	}
}
