package CCC2015;

import java.util.Scanner;
import java.util.Stack;

public class prob1 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		Stack<Integer> num = new Stack<Integer>();
		
		int K = in.nextInt();
		
		for (int i = 0;i < K;++i)
		{
			int n = in.nextInt();
			
			if (n == 0)
			{
				int popped = num.pop();
				//System.out.println("removed " + popped);
			}
			else
			{
				num.add(n);
				//System.out.println("added " + n);
			}
		}
		
		int total = 0;
		
		while (!num.isEmpty())
		{
			int popped = num.pop();
			total += popped;
			//System.out.println(popped);
		}
		System.out.println(total);
	}
}
