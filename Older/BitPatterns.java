import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

import CommandLineIOTools.TimeChecker;

//Make the Bit Patterns shift the ones from one location to the next.

public class BitPatterns 
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
				//if (n < requiredOnes)
					originalBitPattern += "1";
				//else
					//originalBitPattern += "0";
			}
			
			System.out.println(originalBitPattern);
			
			findBitPatterns(originalBitPattern);
			
			for (String val : uniqueBitPatterns.values())
			{
				char[] valueChar = val.toCharArray();
				
				Arrays.sort(valueChar);
				
				int numZero = 0;
				
				for (int n = 0;n < valueChar.length;++n)
				{
					if (valueChar[n] == '0')
						++numZero;
					else

						break;
				}
				
				int numOnes = valueChar.length - numZero;
				
				if (numOnes == requiredOnes)
					System.out.println(val);
			}
		}
		
		tc.checkTime();
	}
	
	public static void findBitPatterns(String in)
	{
		char[] inChar = in.toCharArray();
		
		inChar = in.toCharArray();
			
		uniqueBitPatterns.put(in, in);
			
		if (in.contains("1"))
		{
			for (int i = 0;i < in.length();++i)
			{
				String newBitPattern = "";
					
				for (int n = 0;n < in.length();++n)
				{
					if (i != n)
						newBitPattern += inChar[n];
					else
						newBitPattern += "0";
				}
				
				if (uniqueBitPatterns.get(newBitPattern) == null)
					findBitPatterns(newBitPattern);
			}
		}
	}
}
