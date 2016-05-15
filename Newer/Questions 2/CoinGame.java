package Questions;

import java.util.Scanner;

public class CoinGame 
{
	static int original = 0;
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		
		findWinner(N, (++original)%2);
		
		System.out.println(orgVal + " " + othVal);
	}
	
	static int orgVal = 0;
	static int othVal = 0;
	
	public static int findWinner(int val, int turn)
	{
		System.out.println(val + " " + turn);
		
		if (val == 0)
		{
			if (turn == original)
			{
				++orgVal;
			}
			else
			{
				++othVal;
			}
			
			return turn;
		}
		else
		{
			int a = -1, b = -1, c = -1;
			
			if (val >= 1)
			{
				System.out.println("Subtracting one from " + val);
				a = findWinner(val-1, (++turn)%2);
			}
			if (val >= 2)
			{
				System.out.println("Subtracting two from " + val);
				b = findWinner(val-2, (++turn)%2);
			}
			if (val >= 4)
			{
				System.out.println("Subtracting four from " + val);
				c = findWinner(val-4, (++turn)%2);
			}
			
			if (a == original || b == original || c == original)
			{
				return original;
			}
			else
			{
				return (++original)%2;
			}
		}
	}
}
