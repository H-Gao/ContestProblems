package CCCWaterlooContestPractise;

import java.util.Scanner;

public class GoodTimes 
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		
		int input = scanner.nextInt();
		
		for (int n = 0;n != 7;++n)
			System.out.println(convertTime(input, n));
	}
	
	public static String convertTime(int input, int n)
	{
		String name = "";
		int time;
		
		if (n != 6 && n != 0)
			time = input - (300 - (100*(n-1)));
		else if (n == 0)
			time = input;
		else
			time = input + 130;
		
		if (time >= 2400)
			time -= 2400;
		else if (time < 0)
			time += 2400;
		
		if (n == 0)
			name = "Ottawa";
		
		else if (n == 1)
			name = "Victoria";
		
		else if (n == 2)
			name = "Edmonton";
		
		else if (n == 3)
			name = "Winnipeg";
		
		else if (n == 4)
			name = "Toronto";
		
		else if (n == 5)
			name = "Halifax";
		
		else if (n == 6)
			name = "St. John’s";
		
		return (time + " in " + name);
	}
}
