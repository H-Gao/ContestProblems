package CCCWaterlooContestPractise;

import java.util.Scanner;

public class ISpeakMessage 
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter Phrase> ");
		
		String input = scanner.nextLine();
		
		System.out.println(decode(input));
	}
	
	public static String decode(String input)
	{
		if (input.equalsIgnoreCase("CU"))
			return "see you";
		
		else if (input.equalsIgnoreCase(":-)"))
			return "I'm happy";
		
		else if (input.equalsIgnoreCase(":-("))
			return "I'm unhappy";
		
		else if (input.equalsIgnoreCase(";-)"))
			return "wink";
		
		else if (input.equalsIgnoreCase(":-P"))
			return "stick out my tongue";
		
		else if (input.equalsIgnoreCase("(~.~)"))
			return "sleepy";
		
		else if (input.equalsIgnoreCase("TA"))
			return "totally awesome";
		
		else if (input.equalsIgnoreCase("CCC"))
			return "Canadian Computing Competition";
		
		else if (input.equalsIgnoreCase("CUZ"))
			return "because";
		
		else if (input.equalsIgnoreCase("TY"))
			return "thank-you";
		
		else if (input.equalsIgnoreCase("YW"))
			return "you’re welcome";
		
		else if (input.equalsIgnoreCase("TTYL"))
			return "talk to you later";
		
		else
			return input;
	}
}
