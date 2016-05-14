package Default;

import java.util.Scanner;

public class SoundsFishy 
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		
		String direction = "";
		
		int input[] = new int[4];
		
		for (int n = 0;n != 4;++n)
		{
			input[n] = scanner.nextInt();
		}
		
		for (int n = 0;n != 4;++n)
		{
			if (n != 0 && input[n] > input[n - 1])
			{
				if (!direction.equals("Fish Rising") && n != 1)
				{
					direction = "No Fish";
				}
				
				if (!direction.equals("No Fish"))
				{
					direction = "Fish Rising";
				}
			}
			
			if (n != 0 && input[n] < input[n - 1])
			{
				if (!direction.equals("Fish Diving") && n != 1)
				{
					direction = "No Fish";
				}
				
				if (!direction.equals("No Fish"))
				{
					direction = "Fish Diving";
				}
			}
			
			if (n != 0 && input[n] == input[n - 1])
			{
				if (!direction.equals("Fish At Constant Depth") && n != 1)
				{
					direction = "No Fish";
				}
				
				if (!direction.equals("No Fish"))
				{
					direction = "Fish At Constant Depth";
				}
			}
		}
		
		System.out.println(direction);
	}
}
