package ComputerScience;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Dimethylbenzene 
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		HashMap<Integer, LinkedList<Integer>> molecule = new HashMap<Integer, LinkedList<Integer>>();
		
		int N = in.nextInt();
		int M = in.nextInt();
		
		boolean[] visited = new boolean[N+1];
		
		for (int i = 0;i < N;++i)
		{
			molecule.put(i+1, new LinkedList<Integer>());
		}
		
		for (int i = 0;i < M;++i)
		{
			int a = in.nextInt();
			int b = in.nextInt();
			
			molecule.get(a).add(b);
		}
		
		for (int s = 1;s <= N;++s)
		{
			HashMap<Integer, LinkedList<Integer>> m = new HashMap<Integer, LinkedList<Integer>>();
			
			for (int i = 0;i < N;++i)
			{
				m.put(i+1, new LinkedList<Integer>());
			}
			
			for (int i = 1;i <= N;++i)
			{
				LinkedList<Integer> temp = new LinkedList<Integer>();
				
				for (int a = 0;a < molecule.get(i).size();++a)
				{
					temp.add(molecule.get(i).get(a));
				}
				
				m.put(i, temp);
			}
			
			int steps = 0;
			
			boolean flag = false;
			Stack<Integer> dfs = new Stack<Integer>();
			
			dfs.add(s);
			visited[s] = true;
			
			while (!dfs.isEmpty())
			{
				int i = dfs.peek();
				
				LinkedList<Integer> children = m.get(i);
				
				if (visited[i])
				{
					if (steps == 6)
					{
						flag = true;
						break;
					}
				}
				
				visited[i] = true;
				
				if (children.isEmpty())
				{
					dfs.pop();
					visited[i] = false;
					--steps;
				}
				else
				{
					dfs.add(children.poll());
					++steps;
				}
			}
			
			if (flag)
			{
				System.out.println("YES");
			}
		}
		
		System.out.println("NO");
	}
}
