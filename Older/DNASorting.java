import java.util.ArrayList;
import java.util.Scanner;


public class DNASorting 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		String[] dataFields = in.nextLine().split(" ");
		
		//The length of each String.
		int length = Integer.parseInt(dataFields[0]);
		//The number of Strings.
		int numStr = Integer.parseInt(dataFields[1]);
		
		String[] storedVal = new String[length+1];
		
		//Goes throuigh all of the test cases.
		for (int a = 0;a < numStr;++a)
		{		
			//The amount of imperfections.
			int val = 0;
			
			String inputStr = in.nextLine();
			
			//The input.
			char[] input = inputStr.toCharArray();
			
			//Goes through the String.
			for (int i = 0;i < input.length-1;++i)
			{
				char currentChar = input[i];
				
				if (input[i+1] < currentChar)
				{
					for (int n = i+1;n < input.length;++n)
					{
						char foundChar = input[n];
						
						if (foundChar <= currentChar)
						{
							val += n - i;
							break;
						}
					}
				}
			}
			
			if (storedVal[val] == null)
				storedVal[val] = inputStr;
			else
				storedVal[val] += " " + inputStr;
			
			System.out.println(val);
		}
		
		for (int i = 0;i < length;++i)
		{
			if (storedVal[i] != null)
			{
				char[] orderedInputs = storedVal[i].toCharArray();
				
				if (i != 0)
					System.out.println();
				
				for (int n = 0;n < orderedInputs.length;++n)
				{
					char currentChar = orderedInputs[n];
					
					if (currentChar == ' ')
						System.out.println();
					else
						System.out.print(currentChar);
				}
			}
		}
	}
	
	public static int toInt(char in)
	{
		if (in == 'A')
			return 0;
		else if (in == 'C')
			return 1;
		else if (in == 'G')
			return 2;
		else if (in == 'T')
			return 3;
		
		else
			return -1;
	}
	
	/*
	 * for (int i = 0;i < input.length-1;++i)
			{
				char currentChar = input[i];
				
				if (input[i+1] < currentChar)
				{
					if (nearest[toInt(currentChar)] > i)
					{
						val += nearest[toInt(currentChar)] - i;
					}
					else
					{
						for (int n = i+1;n < input.length;++n)
						{
							char foundChar = input[n];
							
							if (foundChar <= currentChar)
							{
								nearest[toInt(currentChar)] = n;
								
								val += n - i;
								break;
							}
						}
					}
				}
			}
	 */
}
