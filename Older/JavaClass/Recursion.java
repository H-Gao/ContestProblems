package JavaClass;

import java.util.Scanner;

public class Recursion 
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter a number");
		
		System.out.println(sum(scanner.nextInt()));
	}
	
	public static int sum(int n)
	{
		if (n == 1) return 1;
		else
		{
			int sum;
			sum = sum(n - 1) + n;
			System.out.println(sum);
			return sum;
		}
	}
}
