package Default;

import java.util.Scanner;

public class BigBangTheory 
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		
		int k = scanner.nextInt();
		String input = scanner.next();
		boolean hasCrossed = false;
		
		for (int n = 0;n != input.length();++n)
		{
			char output = (char) ((input.charAt(n))+((3*(n + 1)+k)));
			
			while (output > 90)
			{
				hasCrossed = true;
				output = (char) (65 + (output - 90));
			}
			
			if (hasCrossed)
			{
				System.out.print((char)(output-1));
			}
			
			else
			{
				System.out.print((char)(output));
			}
			
			hasCrossed = false;
		}
	}
}
