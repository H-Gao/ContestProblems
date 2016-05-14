package CCCWaterlooContestPractise;

import java.util.Scanner;

public class phoneLetterConverter 
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
	
		String input = scanner.nextLine();
	
		for (int n = 0;n != input.length();++n)
			System.out.print(convertedNumber(input.charAt(n)));
	}
	
	public static char convertedNumber(char n)
	{
		if (n >= 'A' && n <= 'C')
			return '2';
		
		else if (n >= 'D' && n <= 'F')
			return '3';
		
		else if (n >= 'G' && n <= 'I')
			return '4';
		
		else if (n >= 'J' && n <= 'L')
			return '5';
		
		else if (n >= 'M' && n <= 'O')
			return '6';
		
		else if (n >= 'P' && n <= 'S')
			return '7';
		
		else if (n >= 'T' && n <= 'V')
			return '8';
		
		else if (n >= 'W' && n <= 'Z')
			return '9';
		
		else
			return n;
	}
}
