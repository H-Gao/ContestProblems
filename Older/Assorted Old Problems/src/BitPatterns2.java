import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

import CommandLineIOTools.TimeChecker;

//Make the Bit Patterns shift the ones from one location to the next.

public class BitPatterns2
{
	static TimeChecker tc = new TimeChecker();
	
	static int requiredOnes = 0;
	
	static SortedMap<String, String> uniqueBitPatterns = new TreeMap<String, String>();
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int numLines = Integer.parseInt(in.nextLine());
		
		for (int i = 0;i < numLines;++i)
		{
			String[] input = in.nextLine().split(" ");
			
			uniqueBitPatterns.clear();
			
			System.out.println("The bit patterns are ");
			
			requiredOnes = Integer.parseInt(input[1]);
			
			String originalBitPattern = "";
			
			for (int n = 0;n < Integer.parseInt(input[0]);++n)
			{
				if (n < requiredOnes)
					originalBitPattern += "1";
				else
					originalBitPattern += "0";
			}
			
			findBitPatterns(originalBitPattern);
			
			for (String val : uniqueBitPatterns.values())
			{
				System.out.println(val);
			}
		}
		
		tc.checkTime();
	}
	
	//Finds the possible bit patterns using recursion. This method takes the first possibility and moves the ones around to make all the possibilities.
	public static void findBitPatterns(String in)
	{
		//The string, in, when turned into a char[].
		char[] inChar = in.toCharArray();
		
		//Puts the uniqueBitPattern into the list.
		uniqueBitPatterns.put(in, in);
		
		//The char that will be shifted to other characters that are 0.
		for (int a = 0;a < inChar.length;++a)
		{
			//It will only work if it is 1, since only '1' is being shifted.
			if (inChar[a] == '1')
			{
				//The character that is 0, that will be what a will be shifted into.
				for (int b = 0;b < inChar.length;++b)
				{
					//It will only be shifted if it is '0', since a can only shift into a 0.
					if (inChar[b] == '0')
					{
						//The new bit pattern.
						String newBitPattern = "";
						
						//The current character.
						for (int c = 0;c < inChar.length;++c)
						{
							//When the current character is equal to the number being shifted.
							if (a == c)
							{
								newBitPattern += "0";
							}
							//When it reaches the shifted number.
							else if (b == c)
							{
								newBitPattern += "1";
							}
							//If it is a number not being shifted.
							else
							{
								newBitPattern += inChar[c];
							}
						}
						
						//If it is a unique bit pattern, it will make another method with it.
						if (uniqueBitPatterns.get(newBitPattern) == null)
							findBitPatterns(newBitPattern);
					}
				}
			}
		}
	}
}
