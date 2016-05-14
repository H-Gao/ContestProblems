import java.util.Scanner;


public class LifeTheUniverseEverything 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int input;
		while ((input = in.nextInt()) != 42) System.out.println(input);
	}
}
