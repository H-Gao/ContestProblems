package ComputerScience;

import java.util.Scanner;

public class FibSequence 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		long a = 1;
		long b = 1;
		long c = 1;
		
		for (int i = 2;i < n;++i)
		{
			c = a + b;
			a = b;
			b = c;
		}
		
		System.out.println(c);
	}
}
