import java.util.Scanner;

public class RockPaperFox 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int numCases = Integer.parseInt(in.nextLine());
		
		for (int i = 0;i < numCases;++i)
		{
			String out = decideMove(in.nextLine());
			
			if (out != null)
			{
				System.out.println(out);
			}
			else
			{
				for (int n = i+1;n < numCases;++n)
				{
					String notStored = in.nextLine();
				}
				
				break;
			}
		}
	}
	
	public static String decideMove(String in)
	{
		if (in.equals("Rock"))
				return "Paper";
		
		else if (in.equals("Paper"))
				return "Scissor";
		
		else if (in.equals("Scissors"))
				return "Rock";
			
		else if (in.equals("Fox"))
				return "Foxen";
		
		else if (in.equals("Foxen"))
			return null;
			
		else
			return "Fox";
	}
	
	public static String decideMove2(String in)
	{
		switch (in)
		{
			case "Rock":
				return "Paper";
			case "Paper":
				return "Scissor";
			case "Scissors":
				return "Rock";
			case "Fox":
				return "Foxen";
		}
		
		System.exit(0);
		return null;
	}
}
