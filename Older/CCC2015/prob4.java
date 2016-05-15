package CCC2015;

import java.util.Scanner;

public class prob4
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int m = in.nextInt();
		int d = in.nextInt();
		
		if (m == 2 && d == 18) System.out.println("Special");
		else if (m < 2 || (m == 2 && d < 18)) System.out.println("Before");
		else if (m > 2 || (m == 2 && d > 18)) System.out.println("After");
	}
}
