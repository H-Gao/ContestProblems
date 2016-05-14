package CCCWaterlooContestPractise;

import java.util.Scanner;

public class ReadingChars 
{
	public static void main(String[] args)
	{
		boolean isRight = true;
		
		int t = 0;
		
		Scanner scanner = new Scanner(System.in);
		
		char inputChar[] = new char[2];
		int inputInt[] = new int[2];
		
		for (int n = 0;n != 2;++n)
			inputChar[n] = scanner.next().charAt(0);
		
		for (int n = 0;n != 2;++n)
			inputInt[n] = scanner.nextInt();
			
		for (int k = 0;k != inputInt[1];++k)
		{
			for (int n  = 0;n != inputInt[0];++n)
			{
				if (n == t)
					System.out.print(inputChar[1]);
			
				else if (k == 0 || k == inputInt[1]-1|| n == 0 || n == inputInt[0]-1)
					System.out.print(inputChar[0]);
				
				else
					System.out.print(' ');
			}
			
			System.out.print("\n");
			
			if (t == inputInt[0]-1)
				isRight = false;
			
			if (t == 0)
				isRight = true;
			
			if (isRight)
				++t;
			else
				--t;
		}
	}
}
