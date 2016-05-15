package Java;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class spojMCOINS 
{
	public static void main(String[] args)
	{
		//int turn = 0;
		Queue<Integer> extras = new LinkedList<Integer>();
		Queue<Integer> turn = new LinkedList<Integer>();
		
		Scanner in = new Scanner(System.in);
		
		int[] k = {in.nextInt(), in.nextInt()};
	    int m = in.nextInt();
		
		for (int i = 0;i < m;++i)
		{
			extras.add(in.nextInt());
			turn.add(0);
			turn.add(0);
			
			boolean isDone = false;
			
			while (!isDone)
			{
				//++turn;
				int polled = extras.poll();
				int turns = turn.poll();
				
				for (int b = 0;b < 2;++b)
				{
					int a = polled%k[b];
					turns += polled/k[b];
					
					System.out.println(b);
					System.out.println(polled);
					System.out.println(a);
					System.out.println(turns);
					
					if (a == 0) 
					{
						if (turns%2 != 0) System.out.print("A");
						else System.out.print("B");
						
						isDone = true;
						break;
					}
					else
					{
						extras.add(a);
						turn.add(turns);
					}
				}
			}
		}
	}
}
