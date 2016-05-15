package Practice1;

import java.util.Scanner;
import java.util.Stack;

public class prob3 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int t = in.nextInt();
		
		for (int a = 0;a < t;++a)
		{
			int c = in.nextInt();
			int needed = 1;
			
			Stack<Integer> trucks = new Stack<Integer>();
			Stack<Integer> branch = new Stack<Integer>();
			
			for (int i = 0;i < c;++i) trucks.add(in.nextInt());
			
			while (!trucks.isEmpty() || !branch.isEmpty())
			{
				if (!branch.isEmpty() && branch.peek() == needed)
				{
					branch.pop();
					++needed;
				}
				else if (!trucks.isEmpty() && trucks.peek() == needed)
				{
					trucks.pop();
					++needed;
				}
				else if (!trucks.isEmpty() && trucks.peek() != needed) branch.add(trucks.pop());
				
				else if (trucks.isEmpty() && !branch.isEmpty())
				{
					System.out.println("N.");
					System.exit(0);
				}
			}
			
			System.out.println("Y.");
		}
	}
}
