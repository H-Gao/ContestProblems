package CS2016;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class RandomGenerations 
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		int N = 9;
		
		ArrayList<ArrayList<Integer>> noStore = new ArrayList<ArrayList<Integer>>();
		
		for (int i = 0;i < N;++i)
		{
			noStore.add(new ArrayList<Integer>());
		}
		
		noStore.get(1).add(3);
		noStore.get(1).add(4);
		
		noStore.get(3).add(1);
		noStore.get(3).add(4);
		
		noStore.get(4).add(3);
		noStore.get(4).add(1);
		
		int num = 0;
		
		boolean[] hasUsed = new boolean[N];
		
		Stack<Integer> comb = new Stack<Integer>();
		Stack<Integer> pos = new Stack<Integer>();
		
		for (int a = 0;a < N;++a)
		{
			comb.add(a);
			
			while (!comb.isEmpty())
			{
				int current = comb.peek();
				
				if (!hasUsed[current])
				{
					pos.add(current);
					hasUsed[current] = true;
					
					int flag = 0;
					
					if (pos.size() >= 3)
					for (int i = 0;i < 2;++i)
					{
						int index = pos.size() - i - 2;
						
						if (noStore.get(pos.get(index)).contains(pos.get(index+1)))
						{
							++flag;
						}
					}
					
					if (flag != 2)
					for (int i = 0;i < hasUsed.length;++i)
						if (!hasUsed[i]) comb.add(i);
				}
				else
				{
					int popped = comb.pop();
					hasUsed[popped] = false;
					
					if (pos.size() == N)
					{
						/*for (int i = 0;i < pos.size();++i)
						{
							System.out.print(pos.get(i));
						}
						
						System.out.println();*/
						
						++num;
					}
					
					pos.pop();
				}
			}
		}
		
		System.out.println(num);
	}
}
