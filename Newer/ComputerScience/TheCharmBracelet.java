package ComputerScience;

import java.util.Scanner;

public class CharmBracelet 
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		int M = in.nextInt();
		
		int[] W = new int[N+1];
		int[] V = new int[N+1];
		
		int[][] dp = new int[N+1][M+1];
		
		for (int i = 0;i < N;++i)
		{
			W[i+1] = in.nextInt();
			V[i+1] = in.nextInt();
		}
		
		
	}
}
