package Questions;

import java.util.Scanner;

public class Bitwise 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		long a = in.nextLong();
		
		int n = in.nextInt();
		int m = in.nextInt();
		
		int b = (int)(a>>n)&1;
		int c = (int)(a>>m)&1;
		
		if (b != c)
		{
			a = a^(long)Math.pow(2, n);
			a = a^(long)Math.pow(2, m);
		}
		
		System.out.println(a);
	}
}
