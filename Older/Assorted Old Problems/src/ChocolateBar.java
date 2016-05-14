import java.util.Scanner;


public class ChocolateBar
{
	public static void main(String[] args)
	{
		//The input.
		Scanner in = new Scanner(System.in);
		
		//The number of test cases to run.
		int numTestCases = Integer.parseInt(in.nextLine());
		
		//Runs for all test cases.
		for (int i = 0;i < numTestCases;++i)
		{
			//The input.
			String[] input = in.nextLine().split(" ");
			
			//The first int.
			int a = Integer.parseInt(input[0]);
			//The second int.
			int b = Integer.parseInt(input[1]);
			
			//The smallest int.
			int s;
			//The largest int.
			int l;
			
			//Makes sure that s is equal to the smallest int, among a and b, and that l is the largest.
			if (a < b)
			{
				s = a;
				l = b;
			}
			//If a is larger than b, then a must be equal to l, because it is the largest.
			else
			{
				l = a;
				s = b;
			}
		
			//The equation to find the correct answer.
			System.out.println((s-1) + (s*(l-1)));
		}
	}
}
