package Default;

import java.util.Scanner;

public class From1987to2013 
{
	public static void main(String args[])
	{
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();
		int x = 0;
		String n = "" + (input + x);
		boolean isDistinctive = false;
		int counter[] = new int[2];
		
		while (!isDistinctive)
		{
			++x;
			
			n = "" + (input + x);
			
			for (int k = 0;k != 2;++k)
			{
				counter[k] = 0;
			}
			
			for (int k = 0;k != n.length();++k)
			{
				for (int i = 0;i != n.length();++i)
				{
					if (n.charAt(k) != n.charAt(i) || k == i)
					{
						++counter[0];
					}
				}
				
				if (counter[0] == n.length())
				{
					++counter[1];
					counter[0] = 0;
				}
			}
			
			if (counter[1] == n.length())
			{
				isDistinctive = true;
			}
		}
		
		if (isDistinctive)
		{
			System.out.println(n);
		}
	}
}
