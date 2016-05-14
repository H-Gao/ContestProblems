package CCCWaterlooContestPractise;

import java.util.Scanner;

public class caseSwitcher 
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		
		String input = scanner.nextLine();
		String output = "";
		
		for (int n = 0;n != input.length();++n)
		{
			if ((int)input.charAt(n) > 64 && (int)input.charAt(n) < 91)
				output += (char)((int)input.charAt(n) + 32);
			
			else if ((int)input.charAt(n) > 96 && (int)input.charAt(n) < 123)
				output += (char)((int)input.charAt(n) - 32);
			
			else
				output += input.charAt(n);
		}
		
		System.out.println(output);
	}
}
