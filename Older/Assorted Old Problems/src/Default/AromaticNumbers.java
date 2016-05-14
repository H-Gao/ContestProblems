package Default;

import java.util.Scanner;

public class AromaticNumbers 
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		
		int total = 0;
		int numbers[] = new int[2];
		
		String input = scanner.nextLine();
		
		int stored[] = new int[input.length()/2];
		int storedRomanNumeral[] = new int[input.length()/2];
		
		for (int n = 1;n != input.length() + 1;++n)
		{
			if (n%2==0)
			{
				numbers[0] = toNumber(input.charAt(n-1));
				storedRomanNumeral[n/2-1] = numbers[0];
				stored[n/2-1] = numbers[0] * numbers[1];
			}
			
			else
			{
				numbers[1] = charToInt(input.charAt(n-1));
			}
		}
		
		for (int n = 0;n != input.length()/2;++n)
		{
			total += stored[n];
		}
		
			if (input.length()%4==0)
			{
				for (int n = 0;n != input.length()/2;++n)
				{
					try
					{
						if (storedRomanNumeral[n] < storedRomanNumeral[n+1] && (n+1) < input.length()/2)
						{
							total -=  2 * stored[n+1];
						}
					}
					catch(ArrayIndexOutOfBoundsException e)
					{
						break;
					}
				}
			}
			
			else
			{
				for (int n = 0;n != input.length()/2;++n)
				{
					try
					{
						if (storedRomanNumeral[n] < storedRomanNumeral[n+1] && (n+1) < input.length()/2)
						{
							total -=  2 * stored[n+1];
						}
					}
					catch(ArrayIndexOutOfBoundsException e)
					{
						if (storedRomanNumeral[n-1] < storedRomanNumeral[n-2])
						{
							total +=  2 * stored[n];
						}
						break;
					}
				}
			}
		
			System.out.println(total);
	}
	
	public static int toNumber(char n)
	{
		if (n == 73)
		{
			return 1;
		}
		
		else if (n == 86)
		{
			return 5;
		}
		
		else if (n == 88)
		{
			return 10;
		}
		
		else if (n == 76)
		{
			return 50;
		}
		
		else if (n == 67)
		{
			return 100;
		}
		
		else if (n == 68)
		{
			return 500;
		}
		
		else if (n == 77)
		{
			return 1000;
		}
		
		else
		{
			return -1;
		}
	}
	
	public static int charToInt(char n)
	{
		return n - 48;
	}
}
