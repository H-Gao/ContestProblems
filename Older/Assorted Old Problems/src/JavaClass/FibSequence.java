package JavaClass;

import java.util.Scanner;

public class FibSequence 
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println(sum(scanner.nextInt()));
	}
	
	public static int sum(int n)
	{
		if (n == 1 || n == 2) return 1;
		else
		{
			int sum;
			sum = sum(n - 1) + sum(n - 2);
			return sum;
		}
	}
	
	/*
	 * sum(10) ===> sum(9) + sum(8) ====> sum(8) + sum(7), sum(7) + sum(6) ===> sum(7) + sum(6), sum(6) + sum(5), sum(5) + sum(4), sum(3) + sum(2)
	 * 1 + 1 + 3 +
	 */
}
