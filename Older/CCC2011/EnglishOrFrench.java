package CCC2011;

import java.util.Scanner;

public class EnglishOrFrench 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		String catcher = in.nextLine();
		
		int numT = 0;
		int numS = 0;
		
		for (int i = 0;i < N;++i)
		{
			char[] input = in.nextLine().toCharArray();
			
			for (int n = 0;n < input.length;++n)
			{
				if (input[n] == 't' || input[n] == 'T') ++numT;
				else if (input[n] == 's' || input[n] == 'S') ++numS;
			}
		}
		
		if (numT > numS) System.out.println("English");
		else System.out.println("French.");
	}
}
