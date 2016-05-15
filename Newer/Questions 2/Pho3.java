package Questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Pho3
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		int M = in.nextInt();
		
		ArrayList<ArrayList<Integer>> roads = new ArrayList<ArrayList<Integer>>();
		
		int[] pho = new int[M];
		boolean[] isPho = new boolean[N];
		
		for (int i = 0;i < M;++i)
		{
			pho[i] = in.nextInt();
			//System.out.println(pho[i]);
			isPho[pho[i]] = true;
		}
		
		for (int i = 0;i < N;++i)
		{
			roads.add(new ArrayList<Integer>());
		}
		
		for (int i = 0;i < N-1;++i)
		{
			int a = in.nextInt();
			int b = in.nextInt();
			
			roads.get(a).add(b);
			roads.get(b).add(a);
		}
		
		int min = Integer.MAX_VALUE;
		
		for (int a = 0;a < M;++a)
		{
			boolean[] visited = new boolean[N];
			boolean[] willInc = new boolean[N];
			
			Stack<Integer> dfs = new Stack<Integer>();
			
			dfs.add(pho[a]);
			visited[pho[a]] = true;
			//System.out.println("Added " + pho[a]);
			
			int total = 0;
			boolean notPho = true;
			
			int max = 0;
			int steps = -1;
			
			while (!dfs.isEmpty())
			{
				int num = dfs.peek();
				
				++total;
				++steps;
				
				if (!notPho)
				{
					willInc[num] = true;
				}
				
				boolean finished = true;
				
				for (int i = 0;i < roads.get(num).size();++i)
				{
					int resturant = roads.get(num).get(i);
					
					if (!visited[resturant])
					{
						//System.out.println("Added " + resturant);
						dfs.add(resturant);
						visited[resturant] = true;
						finished = false;
						notPho = true;
						break;
					}
				}
				
				if (finished)
				{
					int popped = dfs.pop();
					
					if (isPho[popped])
					{
						notPho = false;
						willInc[popped] = true;
						
						if (steps > max)
						{
							max = steps;
						}
						
						//System.out.println("****" + popped + " " + steps);
					}
					
					if (!willInc[popped])
					{
						//System.out.println("Removed " + popped + " added.");
						total -= 2;
					}
					else
					{
						//System.out.println("Removed " + popped+ " removed.");
						//++total;
					}
					
					steps -= 2;
				}
				//System.out.println("Current total: " + total);
			}
			
			total -= max + 1;
			
			min = Math.min(total, min);
			//System.out.println(total);
		}
		
		System.out.println(min);
	}
}
