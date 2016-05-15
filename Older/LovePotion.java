import java.util.Scanner;


public class LovePotion 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		double a = in.nextInt(), b = in.nextInt(), c = in.nextInt();
		
		if (a > c)
			System.out.println("Bob overdoses on day 1.");
		else if ((a/2)+b > c)
			System.out.println("Bob overdoses on day 2.");
		else
			System.out.println("Bob never overdoses.");
	}
}
