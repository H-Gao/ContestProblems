package CCCWaterlooContestPractise;

import java.util.Scanner;
import java.util.Arrays;

public class AnagramChecker 
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter first phrase> ");
		char[] input = scanner.nextLine().toCharArray();
		
		System.out.print("Enter second phrase> ");
		char[] input2 = scanner.nextLine().toCharArray();
		
		Arrays.sort(input);
		Arrays.sort(input2);
		
		String output[] = new String[2];
		
		for (int amount = 0;amount != 2;++amount)
		{
			output[amount] = "";
			
			for (int n = 0;n != input.length;++n)
				if (input[n] != ' ')
					output[amount] += input[n];
		}
			
		if (output[0].equalsIgnoreCase(output[1]))
			System.out.println("Is an anagram.");
		else
			System.out.println("Is not an anagram.");
	}
}
