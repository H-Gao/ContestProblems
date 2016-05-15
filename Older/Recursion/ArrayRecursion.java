package Recursion;

import java.util.Scanner;
import java.util.Random;

public class ArrayRecursion 
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		
		int[] a = new int[100];
		
		for (int n = 0;n != 100;++n)
			a[n] = random.nextInt(10);
		
		int b = scanner.nextInt();
		
		System.out.println(recursion(a, a.length-1, b));
	}
	
	public static int recursion(int[] a, int n, int b)
	{
		if (n == 0)
		{
			if (a[n] == b)
				return 1;
			else
				return 0;
		}
		else
		{
			int lastAnswer = recursion(a, n-1, b);
			
			if (a[n] == b)
				return lastAnswer + 1;
			else
				return lastAnswer;
		}
	}
}
