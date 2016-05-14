import java.util.Scanner;

public class BinaryConversion 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		System.out.println(toBinary(41804414));
		
		//System.out.println(toRegularNumerals(in.nextLine()));
	}
	
	//Converts a decimal number to binary.
	public static String toBinary(int num)
	{
		//The number to begin with, and will count down to 0.
		//This is this column number; 2^startingNum.
		int startingNum = 0;
		
		//The output is a string of ones and zeros representing binary.
		String binary = "";
		
		//Finds the starting number.
		for (int i = 0;true;++i)
		{
			//Will search until the 2^i <= the number and 2^(i+1) > num.
			//For example, if the number is 4, it will search until two, because 2^2 == 4, and 2^(2+1) > 4.
			if (doExponent(2, i) <= num && doExponent(2, i+1) > num)
			{
				//Sets the starting number.
				startingNum = i;
				
				//Exits the loop.
				break;
			}
		}
		
		//A simple algorithmn to convert to binary.
		for (int i = startingNum;i != -1;--i)
		{
			//First, add a one or zero depending on the number, divided by 2^i.
			binary += num/doExponent(2, i);
			
			//Then number is equal to num%2^i.
			num = num%doExponent(2, i);
		}
		
		//Returns the calculated binary.
		return binary;
	}
	
	public static int toRegularNumerals(String str)
	{
		int convertedNumber = 0;
		
		//Looks at the numbers right to left.
		for (int i = str.length()-1;i >= 0;--i)
		{
			//The current number.
			char binaryCharacter = str.charAt(str.length()-i-1);
			
			if (binaryCharacter == '1')
			{
				convertedNumber += doExponent(2, i);
			}
		}
		
		return convertedNumber;
	}
	
	//Finds num^exponent.
	public static int doExponent(int num, int exponent)
	{
		if (exponent == 0)
			num = 1;
		else
		{
			int base = num;
		
			for (int i = 1;i != exponent;++i)
			{
				num *= base;
			}
		}
		
		return num;
	}
}
