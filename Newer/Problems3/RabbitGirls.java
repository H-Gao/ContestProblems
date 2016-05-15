package Problems3;

import java.util.Scanner;

public class RabbitGirls 
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		int a = in.nextInt();
		int b = in.nextInt();
		
		if (a < b)
		{
			System.out.println(b-a);
			return;
		}
		
		int c = a - (a/b)*b;
		int d = (a/b+1)*b - a;
		
		if (c < d)
			System.out.println(c);
		else
			System.out.println(d);
	}
}
