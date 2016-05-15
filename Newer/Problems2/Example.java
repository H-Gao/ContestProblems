package Problems2;

import java.util.Scanner;

public class Example 
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		int input = in.nextInt();
		
		if (input == 1)
		{
			System.out.println(1);
			return;
		}
		else if (input == 2)
		{
			System.out.println(2);
			return;
		}
		
		while (true)
		{
			boolean f = true;
			
			for (int i = 2;i <= (int)Math.sqrt(input)+1;++i)
			{
				if ((input%i)==0)
				{
					f = false;
					break;
				}
			}
			
			if (f)
			{
				System.out.println(input);
				break;
			}
			
			++input;
		}
	}
}
