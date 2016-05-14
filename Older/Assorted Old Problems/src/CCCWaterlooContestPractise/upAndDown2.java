package CCCWaterlooContestPractise;

import java.util.Scanner;

public class upAndDown2 
{
	public static void main(String[] args)
	{
		int firstEquation = 0;
		
		Scanner scanner = new Scanner(System.in);
		
		int input[] = new int[5];
		
		for (int n = 0;n != 5;++n)
			input[n] = scanner.nextInt();
		
		int finalEquation;
		
		for (int n = 0;n <= 2;n+=2)
		{
			if (input[0+n] == 0)
				finalEquation = (-1)*(input[4]);
			
			else if (input[4] <= input[0+n])
				finalEquation = input[4];
			
			else if ((input[0+n]*((input[4]%((input[4]/(input[0+n]+input[1+n]))*(input[0+n]+input[1+n])))/input[0+n])) == 0)
				finalEquation = ((input[4]/(input[0+n]+input[1+n]))*(input[0+n]-input[1+n])) + ((input[4]%((input[4]/(input[0+n]+input[1+n]))*(input[0+n]+input[1+n])))%input[0+n]);
			
			else
				finalEquation = ((input[4]/(input[0+n]+input[1+n]))*(input[0+n]-input[1+n])) + (input[0+n]*((input[4]%((input[4]/(input[0+n]+input[1+n]))*(input[0+n]+input[1+n])))/input[0+n])) - ((input[4]%((input[4]/(input[0+n]+input[1+n]))*(input[0+n]+input[1+n])))%input[0+n]);
			
			if (n == 2)
			{
				if (firstEquation > finalEquation)
					System.out.println("Nikki");
				
				else if (firstEquation > finalEquation)
					System.out.println("Byron");
				
				else
					System.out.println("Tied");
			}
		
			firstEquation = finalEquation;
		}
	}
}

/*
 * 	int equation1 = (20/(5+2))*(5-2);
*	int equation2 = 5*((20%((20/(5+2))*(5+2)))/5);
*	int equation3 = (20%((20/(5+2))*(5+2)))%5;
*		
*	int equation = ((20/(5+2))*(5-2)) + (5*((20%((20/(5+2))*(5+2)))/5)) - ((20%((20/(5+2))*(5+2)))%5);
*int finalEquation = ((input[4]/(input[0]+input[1]))*(input[0]-input[1])) + (input[0]*((input[4]%((input[4]/(input[0]+input[1]))*(input[0]+input[1])))/input[0])) - ((input[4]%((input[4]/(input[0]+input[1]))*(input[0]+input[1])))%input[0]);
*/