package ComputerScience;

import java.util.Scanner;

public class QualityScenees 
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();
		int d = in.nextInt();
		
		if (a < c)
		{
			if (b <= c)
			{
				System.out.println("NO");
			}
			else
			{
				System.out.println("YES");
			}
		}
		else if (a > c)
		{
			if (d <= a)
			{
				System.out.println("NO");
			}
			else
			{
				System.out.println("YES");
			}
		}
		else
		{
			System.out.println("YES");
		}
	}
}
