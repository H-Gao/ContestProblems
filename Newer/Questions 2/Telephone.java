package Questions;

import java.util.Scanner;

public class Telephone 
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		int numNumbers = Integer.parseInt(in.nextLine());
		
		for (int i = 0;i < numNumbers;++i)
		{
			String number = in.nextLine();
			String out = "";
			
			for (int n = 0;n < number.length();++n)
			{
				char input = number.charAt(n);
				
				if (input != '-')
				{
					out += convertLetters(input);
				}
				
				if (out.length() == 10) break;
			}
			
			System.out.println(out.substring(0, 3) + "-" + out.substring(3, 6) + "-" + out.substring(6, 10));
		}
	}
	
	public static char convertLetters(char in)
	{
		if (in >= 'A' && in <= 'C')
		{
			return '2';
		}
		else if (in >= 'D' && in <= 'F')
		{
			return '3';
		}
		else if (in >= 'G' && in <= 'I')
		{
			return '4';
		}
		else if (in >= 'J' && in <= 'L')
		{
			return '5';
		}
		else if (in >= 'M' && in <= 'O')
		{
			return '6';
		}
		else if (in >= 'P' && in <= 'S')
		{
			return '7';
		}
		else if (in >= 'T' && in <= 'V')
		{
			return '8';
		}
		else if (in >= 'W' && in <= 'Z')
		{
			return '9';
		}
		else
		{
			return in;
		}
	}
}
