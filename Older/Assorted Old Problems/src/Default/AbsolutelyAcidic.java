package Default;

import java.util.Scanner;

public class AbsolutelyAcidic 
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		
		int numberOfSensors = scanner.nextInt();
		
		String number;
		String uniqueNumbers[] = new String[numberOfSensors];
		int numberOfTimes[] = new int[numberOfSensors];
		int input[] = new int[numberOfSensors];
		
		boolean isUnique = false;
		
		for (int n = 0;n != numberOfSensors;++n)
		{
			input[n] = scanner.nextInt();
			
			number = "" + input[n];
			
			for (int k = 0;k != uniqueNumbers.length;++k)
			{
				if (number.equalsIgnoreCase(uniqueNumbers[k]))
				{
					++numberOfTimes[k];
					isUnique = false;
					break;
				}
				else
				{
					isUnique = true;
				}
			}
			
			if (isUnique)
			{
				uniqueNumbers[n] = number;
				isUnique = false;
			}
		}
		
		int largest = 0;
		int secondLargest = 0;
		int tied = -1;
		int secondTied = -1;
		
		for (int n = 0;n != uniqueNumbers.length;++n)
		{
			if (largest > numberOfTimes[n])
			{
				largest = n;
			}
			
			else if (secondLargest > numberOfTimes[n])
			{
				secondLargest = n;
			}
			
			else if (largest == numberOfTimes[n])
			{
				tied = largest;
				largest = n;
			}
			
			else if (secondLargest == numberOfTimes[n])
			{
				secondTied = secondLargest;
				secondLargest = n;
			}
		}
		
		System.out.println(largest + " " + tied + " " + secondLargest + " " + secondTied);
	}
}
