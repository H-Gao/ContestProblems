package Default;

import java.util.Scanner;

public class IconScaling 
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		
		int input = scanner.nextInt();
		
		String line = "";
		
		for (int k = 0;k != input;++k)
		{
			for (int n = 0;n != input*3;++n)
			{
				if (n >= 0 && n < input || n >= input*2)
				{
					line += '*'; 
				}
				
				else
				{
					line += 'x'; 
				}
			}
		
			System.out.println(line);
			line = "";
		}
		
		for (int k = 0;k != input;++k)
		{
			for (int n = 0;n != input*3;++n)
			{
				if (n >= input)
				{
					line += 'x'; 
				}
				
				else
				{
					line += ' ';
				}
			}
		
			System.out.println(line);
			line = "";
		}
		
		for (int k = 0;k != input;++k)
		{
			for (int n = 0;n != input*3;++n)
			{
				if (n >= 0 && n < input || n >= input*2)
				{
					line += '*';
				}
				
				else
				{
					line += ' ';
				}
			}
		
			System.out.println(line);
			line = "";
		}
	}
}
