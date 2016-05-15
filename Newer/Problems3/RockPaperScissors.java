package Problems3;

import java.util.Scanner;

public class RockPaperScissors 
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		int numRounds = Integer.parseInt(in.nextLine());
		
		for (int i = 0;i < numRounds;++i)
		{
			String input = in.nextLine();
			
			if (input.equals("Rock")) System.out.println("Paper");
			else if (input.equals("Paper")) System.out.println("Scissors");
			else if (input.equals("Scissors")) System.out.println("Rock");
			else if (input.equals("Fox")) System.out.println("Foxen");
			else if (input.equals("Foxen")) break;
		}
	}
}
