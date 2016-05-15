package CCCWaterlooContestPractise;

import java.util.Scanner;

public class ToDoList 
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		
		int input = scanner.nextInt();
		
		for (int n = input+1;n != 10234;++n)
		{
			String year = Integer.toString(n);
			
			if (year.length() == 1)
			{
				System.out.println(n);
				break;
			}
			
			else if (year.length() == 2)
			{
				if (year.charAt(0) != year.charAt(1))
				{
					System.out.println(n);
					break;
				}
			}
			
			else if (year.length() == 3)
			{
				if (year.charAt(0) != year.charAt(1) && year.charAt(0) != year.charAt(2) && year.charAt(1) != year.charAt(2))
				{
					System.out.println(n);
					break;
				}
			}
			
			else if (year.length() == 4)
			{
				if (year.charAt(0) != year.charAt(1) && year.charAt(0) != year.charAt(2) && year.charAt(0) != year.charAt(3) && year.charAt(1) != year.charAt(2)  && year.charAt(1) != year.charAt(3)  && year.charAt(2) != year.charAt(3))
				{
					System.out.println(n);
					break;
				}
			}
			
			else
			{
				System.out.println("10234");
				break;
			}
		}
	}
}
