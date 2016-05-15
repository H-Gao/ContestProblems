package Problems3;

import java.util.Scanner;

public class threenplusone 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		long n = in.nextLong();
		
		int num = 0;
		
		while (n != 1)
		{
			++num;
			
			if (n%2==0) n = n/2;
			else n = n*3+1;
		}
		
		System.out.println(num);
	}
}
