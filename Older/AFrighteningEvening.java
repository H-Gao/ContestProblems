import java.util.Arrays;
import java.util.Scanner;


public class AFrighteningEvening 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int numCases = Integer.parseInt(in.nextLine());
		
		for (int i = 0;i < numCases;++i)
		{
			String[] input = in.nextLine().split(" ");
			
			int movieTime = Integer.parseInt(input[0]), numKeyMoments = Integer.parseInt(input[1]), scaredThreshold = Integer.parseInt(input[2]), exitThreshold = Integer.parseInt(input[3]);
			
			//A temp value to hold the times of the time of the last input.
			int lastTime = 0;
			int[] timeBetween = new int[numKeyMoments], values = new int[numKeyMoments];
			
			//Seperates and stores the times in between the key moments
			for (int n = 0;n < numKeyMoments;++n)
			{
				String inputs = in.nextLine();
				
				int currentTime = Integer.parseInt(inputs.substring(0, inputs.indexOf(" ")));
				
				if (n > 0)
					timeBetween[n-1] = currentTime - lastTime;
				
				lastTime = currentTime;
				
				values[n] = Integer.parseInt(inputs.substring(inputs.indexOf(" ")+1, inputs.length()));
			}
			
			timeBetween[numKeyMoments-1] = movieTime - lastTime;
			
			int minimumHoldingTime = 1000000;
			
			for (int y = 0;y < numKeyMoments;++y)
			{
				int minutesHolding = 0;
				int currentFear = 0;
				
				for (int x = 0;x < numKeyMoments;++x)
				{
					if (x != y)
						currentFear += values[x];
					
					if (currentFear < 0)
						currentFear = 0;
					
					if (currentFear >= exitThreshold)
						break;
					
					if (currentFear >= scaredThreshold)
						minutesHolding += timeBetween[x];
				}
				
				if (minutesHolding < minimumHoldingTime)
					minimumHoldingTime = minutesHolding;
			}
			
			System.out.println(minimumHoldingTime);
		}
	}
}
