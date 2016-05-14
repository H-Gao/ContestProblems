import java.util.Scanner;


public class WhenInRome 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int numCases = Integer.parseInt(in.nextLine());
		
		for (int i = 0;i < numCases;++i)
		{
			String input = in.nextLine();
			
			char[] inputString = input.toCharArray();
			String[] num = new String[2];
			
			int flag = 0;
			
			//Initalizes the array.
			num[0] = "";
			num[1]= "";
			
			for (int n = 0;n < inputString.length;++n)
			{
				if (inputString[n] == '+')
					++flag;
				else if (inputString[n] != '=')
					num[flag] += inputString[n];
			}
			
			int sum = toInt(num[0]) + toInt(num[1]);
			
			if (sum > 1000)
				System.out.println("CONCORDIA CUM VERITATE");
			else
				System.out.println(input+toRomanNumerals(sum));
		}
	}
	
	public static int toInt(String in)
	{
		char[] inChar = in.toCharArray();
		
		int total = 0;
		
		for (int i = 0;i < in.length();++i)
		{
			char currentChar = inChar[i];
			
			char nextChar = ' '; 
			
			if (i+1 < in.length())
				nextChar = inChar[i+1];
				
			if ((currentChar == 'I' && (nextChar == 'V' || nextChar == 'X')) 
			|| (currentChar == 'X' && (nextChar == 'L' || nextChar == 'C'))
			|| (currentChar == 'C' && (nextChar == 'D' || nextChar == 'M')))
			{
				++i;
				total += getValue(nextChar) - getValue(currentChar);
			}
			//If it is not a special case.
			else
			{
				total += getValue(currentChar);
			}
		}
		
		return total;
	}
	
	public static String toRomanNumerals(int in)
	{
		String out = "";
		
		char[] inChar = (""+in).toCharArray();
		
		char[] numerals = { 'I', 'V', 'X', 'X', 'L', 'C', 'C', 'D', 'M', 'M', ' ', ' '};
		
		//Makes the output.
		for (int i = 0;i < inChar.length;++i)
		{
			//Finds the last array value, to the first.
			int currentValue = inChar[inChar.length-i-1]-'0';
			
			//Puts the numeral at the back.
			out = getNumeral(currentValue, numerals[(i+1)*3-3], numerals[(i+1)*3-2], numerals[(i+1)*3-1]) + out;
		}
		
		return out;
	}
	
	public static String getNumeral(int in, char a, char b, char c)
	{
		String out = "";
		
		switch (in)
		{
			case 1:
				return ""+a;
			case 2:
				return a + "" + a;
			case 3:
				return a + "" + a + "" + a;
			case 4:
				return a + "" + b;
			case 5:
				return ""+b;
			case 6:
				return b + "" + a;
			case 7:
				return b + "" + a + "" + a;
			case 8:
				return b + "" + a + "" + a + "" + a;
			case 9:
				return a + "" + c;
		}
		
		return out;
	}
	
	//Gets the int value of a roman decimal.
	public static int getValue(char in)
	{
		//It will return the int value of the roman decimal.
		switch (in)
		{
			case 'I': return 1;
			case 'V': return 5;
			case 'X': return 10;
			case 'L': return 50;
			case 'C': return 100;
			case 'D': return 500;
			case 'M': return 1000;
		}
		
		//If the code gets to here, there is an error.
		return -1;
	}
}
