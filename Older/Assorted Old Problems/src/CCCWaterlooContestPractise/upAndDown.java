package CCCWaterlooContestPractise;

import java.util.Scanner;

public class upAndDown 
{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		
		int input[] = new int[5];
		
		for (int n = 0;n != 5;++n)
			input[n] = scanner.nextInt();
		
		int numSteps = input[4];
		
		String distanceString = "";
		
		int generatedNumber = (input[4]/(input[0]+input[1]))+1;
		
		for (;generatedNumber > 0;--generatedNumber)
		{
			for (int n = 0;n < input[0];++n)
				distanceString += "+";
			
			for (int n = 0;n < input[1];++n)
				distanceString += "-";
		}
		
		int output1 = 0;
		
		String distance1 = distanceString.substring(0, input[4]);
		
		for (int n = 0;n != distance1.length();++n)
		{
			if (distance1.charAt(n) == '+')
				++output1;
			
			else if (distance1.charAt(n) == '-')
				--output1;
		}
		
		String distanceString2 = "";
		
		int generatedNumber2 = (input[4]/(input[2]+input[3]))+1;
		
		for (;generatedNumber2 > 0;--generatedNumber2)
		{
			for (int n = 0;n < input[2];++n)
				distanceString2 += "+";
			
			for (int n = 0;n < input[3];++n)
				distanceString2 += "-";
		}
		
		int output2 = 0;
		
		String distance2 = distanceString2.substring(0, input[4]);
		
		for (int n = 0;n != distance2.length();++n)
		{
			if (distance2.charAt(n) == '+')
				++output2;
			
			else if (distance2.charAt(n) == '-')
				--output2;
		}
		
		if (output1 > output2)
			System.out.println("Nikki");
		
		else if (output2 > output1)
			System.out.println("Byron");
		
		else if (output1 == output2)
			System.out.println("Tied");
	}
}
