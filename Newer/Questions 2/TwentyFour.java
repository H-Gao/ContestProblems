package Questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class TwentyFour 
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		int numHands = in.nextInt();
		
		for (int i = 0;i < numHands;++i)
		{
			int[] num = new int[4];
			boolean[] visited = new boolean[4];
			
			for (int a = 0;a < 4;++a)
			{
				num[a] = in.nextInt();
			}
			
			Stack<Integer> total = new Stack<Integer>();
			Stack<Integer> numbers = new Stack<Integer>();
			Stack<Character> operators = new Stack<Character>();
			Stack<Boolean> backtracked = new Stack<Boolean>();
			
			total.add(0);
			numbers.add(0);
			operators.add('+');
			backtracked.add(false);
			
			while (!numbers.isEmpty())
			{
				int currentTotal = total.peek();
				int currentNum = numbers.peek();
				char currentOperator = operators.peek();
				boolean hasBack = backtracked.peek();
				
				if (!hasBack)
				{
					for (int a = 0;a < 4;++a)
					{
						if (!visited[a])
						{
							
						}
					}
				}
				else
				{
					
				}
			}
		}
	}
}
