package Default;

import java.util.Scanner;

public class rotatingLetters 
{
	public static void main(String args[])
	{
		Scanner scanner = new Scanner(System.in);
		
		char numbers[] = new char[7];
		
		setNumbers(numbers);
		
		String input = scanner.next();
		
		boolean isWorking = false;
		boolean hasWorked = true;
		
		for (int n = 0;n != input.length();++n)
		{
			for (int x = 0;x != 7;++x)
			{
				if (input.charAt(n) == numbers[x])
				{
					isWorking = true;
				}
			}
			
			if (!isWorking)
			{
				hasWorked = false;
				break;
			}
			
			isWorking = false;
			hasWorked = true;
		}
		
		if (hasWorked)
		{
			System.out.println("Yes.");
		}
		
		else
		{
			System.out.println("No.");
		}
	}
	
	public static void setNumbers(char numbers[])
	{
		numbers[0] = 'I';
		numbers[1] = 'O';
		numbers[2] = 'S';
		numbers[3] = 'H';
		numbers[4] = 'Z';
		numbers[5] = 'X';
		numbers[6] = 'N';
	}
}
