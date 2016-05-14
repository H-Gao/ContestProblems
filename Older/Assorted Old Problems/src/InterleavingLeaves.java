import java.util.Scanner;
import java.util.Stack;


public class InterleavingLeaves 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int numCases = Integer.parseInt(in.nextLine());
		
		for (int i = 0;i < numCases;++i)
		{
			int numLeaves = 2*Integer.parseInt(in.nextLine());
			
			String[] leavePile = new String[2];
			
			for (int n = 0;n < 2;++n)
				leavePile[n] = in.nextLine();
			
			Stack<Character> pile = new Stack<Character>();
			
			for (int n = 0;n < numLeaves;++n)
			{
				pile.add(leavePile[n%2].charAt(n/2));
			}
			
			for (int n = 0;n < numLeaves;++n)
			{
				System.out.print(pile.pop());
			}
			
			System.out.print("\n");
		}
	}
}
