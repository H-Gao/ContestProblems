package JavaClass;

import java.util.Scanner;

public class StaircaseProblem 
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		
		System.out.println(f(scanner.nextInt()));
	}
	
	public static int f(int n)
	{
		if (n <= 3) return n;
		else
		{
			int f;
			f = f(n - 1) + f(n - 2) + f(n - 3);
			return f;
		}
	}
}
