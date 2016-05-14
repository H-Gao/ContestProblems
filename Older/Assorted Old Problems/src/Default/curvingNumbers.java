package Default;

import java.util.Scanner;

public class curvingNumbers 
{
	public static void main(String[] args) 
	{
		//This will work by writing the letters one, by one on 4 lines.
		int timeUntilRotate = 0;
		int number = 0;
		int maxNumber;
		int array = 0;
		int value = 0;
		//This means direction will turn into 0.
		int direction = 4;
		//-2 + 2 = 0, so it starts at -2.
		int finished1 = -2;
		int finished2 = -2;
		int finished3 = -2;
		int finished4 = -2;
		//If true it will switch next time it runs.
		boolean switchNextTime = false;
		
		
		Scanner scanner = new Scanner(System.in);
		
		maxNumber = scanner.nextInt();
		
		int line1[] = new int[maxNumber];
		int line2[] = new int[maxNumber];
		int line3[] = new int[maxNumber];
		int line4[] = new int[maxNumber];
		
		while (number != maxNumber)
		{
			++number;
			
			if (switchNextTime)
			{
				++direction;
				
				switch (direction)
				{
					case 0:
					{
						finished1 += 2;
						timeUntilRotate = 2 - finished1;
					}
					
					case 1:
					{
						finished2 += 2;
						timeUntilRotate = 2 - finished2;
					}
					
					case 2:
					{
						finished3 += 2;
						timeUntilRotate = number/4 - 2 - finished3;
					}
					
					case 3:
					{
						finished4 += 2;
						timeUntilRotate = number/4 - 2 - finished4;
					}
				}
				
				switchNextTime = false;
			}
			
			if (timeUntilRotate == 0)
			{
				switchNextTime = true;
			}
			
			if (direction > 3)
			{
				direction = 0;
			}
			
			switch (direction)
			{
				case 0:
				{
					++array;
				}
				
				case 1:
				{
					--array;
				}
				
				case 2:
				{
					++value;
				}
				
				case 3:
				{
					--value;
				}
			}
			
			switch (array)
			{
				case 1:
				{
					line1[value] = number;
				}
				
				case 2:
				{
					line2[value] = number;
				}
				
				case 3:
				{
					line3[value] = number;
				}
				
				case 4:
				{
					line4[value] = number;
				}
			}
			
			--timeUntilRotate;
		}
		
		for (int n = 0;n != maxNumber;++n)
		{
			System.out.print(line1[n]);
			System.out.print(line2[n]);
			System.out.print(line3[n]);
			System.out.print(line4[n]);
		}
	}
}
