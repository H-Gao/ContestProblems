package Questions;

import java.util.Scanner;

public class CircleOfLife 
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		String[] input = in.nextLine().split(" ");
		
		int N = Integer.parseInt(input[0]);
		long T = Long.parseLong(input[1]);
		
		String state = in.nextLine();
		
		String r = "";
		String prev = "";
		
		for (long i = 0;i < T;++i)
		{
			String newState = "";
			
			for (int a = 0;a < N;++a)
			{
				char left = ' ';
				char right = ' ';
				
				if (a == 0) left = state.charAt(N - 1);
				else left = state.charAt(a - 1);
				
				if (a == N-1) right = state.charAt(0);
				else right = state.charAt(a + 1);
				
				if ((left == '1' && right == '0') || (left == '0' && right == '1'))
				{
					newState += '1';
				}
				else
				{
					newState += '0';
				}
			}
			
			state = newState;
		}
		
		System.out.println(state);
	}
}
