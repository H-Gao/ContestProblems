package Java;

import java.util.Scanner;

public class binaryIProb 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int i = in.nextInt();
		int length = getLength(i);
		
		for (int x = 0;x < length;++x)
		{
			int a = i>>x;
			if (a%1==0)
			System.out.println(a);
		}
	}
	
	public static int getLength(int x)
	{
		int num = 1;
		
		for (int i = 0;true;++i)
		{		
			if (num > x)
				return i;
			
			num *= 2;
		}
	}
}
