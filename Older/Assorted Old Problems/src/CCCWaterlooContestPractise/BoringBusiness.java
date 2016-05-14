package CCCWaterlooContestPractise;

import java.util.Scanner;

public class BoringBusiness 
{
	static int ID = 28;
	
	static boolean isWorking = true;
	
	static int holeX[] = new int[400];
	static int holeY[] = new int[400];
	
	static int x = -1;
	static int y = -5;
	
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		
		createHoles(holeX, holeY);
		
		while (true)
		{
			String input = scanner.nextLine();
			
			if (input.split(" ")[0].charAt(0) == 'q')
				break;
			
			if (input.split(" ")[0].charAt(0) == 'r')
			{
				for (int n = 0;n != Integer.parseInt(input.split(" ")[1]);++n)
				{
					++x;
					
					if (!checkHoles(x, y, holeX, holeY))
						isWorking = false;
				}
			}
			
			if (input.split(" ")[0].charAt(0) == 'd')
			{
				for (int n = 0;n != Integer.parseInt(input.split(" ")[1]);++n)
				{
					--y;
					
					if (!checkHoles(x, y, holeX, holeY))
						isWorking = false;
				}
			}
			
			if (input.split(" ")[0].charAt(0) == 'l')
			{
				for (int n = 0;n != Integer.parseInt(input.split(" ")[1]);++n)
				{
					--x;
					
					if (!checkHoles(x, y, holeX, holeY))
						isWorking = false;
				}
			}
			
			if (input.split(" ")[0].charAt(0) == 'u')
			{
				for (int n = 0;n != Integer.parseInt(input.split(" ")[1]);++n)
				{
					++y;
					if (!checkHoles(x, y, holeX, holeY))
						isWorking = false;
				}
			}
			
			if (!isWorking)
			{
				System.out.println(x + " " + y + " " + "DANGER");
				break;
			}
			else
			{
				++ID;
				
				System.out.println(x + " " + y + " " + "safe");
				holeX[ID] = x;
				holeY[ID] = y;
			}
		}
	}
	
	public static boolean checkHoles(int x, int y, int holeX[], int holeY[])
	{
		boolean isWorking = true;
		
		for (int n = 0;n != holeX.length;++n)
		{
			if (x == holeX[n] && y == holeY[n])
			{
				isWorking = false;
				break;
			}
		}
		
		return isWorking;
	}
	
	public static void createHoles(int holeX[], int holeY[])
	{
		for (int n = 0;n != 28;++n)
		{
			if (n < 3)
				holeX[n] = 0;
			
			else if (n < 5)
				holeX[n] = n-2;
			
			else if (n < 8)
				holeX[n] = 3;
			
			else if (n == 8)
				holeX[n] = 4;
			
			else if (n < 12)
				holeX[n] = 5;
			
			else if (n == 12)
				holeX[n] = 6;
			
			else if (n < 18)
				holeX[n] = 7;
			
			else if (n < 25)
				holeX[n] = 7-(n-17);
			
			else if (n < 28)
				holeX[n] = -1;
			
			if (n < 2)
				holeY[n] = -1*(n+1);
			
			else if (n < 6)
				holeY[n] = -3;
			
			else if (n == 6)
				holeY[n] = -4;
			
			else if (n < 10)
				holeY[n] = -5;
			
			else if (n == 10)
				holeY[n] = -4;
			
			else if (n < 14)
				holeY[n] = -3;
			
			else if (n < 17)
				holeY[n] = -3 - (n - 13);
			
			else if (n < 26)
				holeY[n] = -7;
			
			else if (n < 28)
				holeY[n] = -7 + (n - 25);
		}
	}
}
