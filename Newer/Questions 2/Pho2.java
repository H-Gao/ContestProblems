package Questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Pho2
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		int M = in.nextInt();
		
		int[] pho = new int[M];
		isPho = new boolean[N];
		
		for (int i = 0;i < M;++i)
		{
			pho[i] = in.nextInt();
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
		
		for (int i = 0;i < pho.length;++i)
		{
			visited = new boolean[N];
			min = Math.min(dfs(pho[1], 0, false).val, min);
		}
		
		System.out.println(min);
	}
	
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> roads = new ArrayList<ArrayList<Integer>>();
	static boolean[] isPho;
	
	public static x dfs(int c, int total, boolean thisFound)
	{
		if (isPho[c])
		{
			thisFound = true;
		}
		
		visited[c] = true;
		
		int done = 0;
		
		for (int i = 0;i < roads.get(c).size();++i)
		{
			if (!visited[roads.get(c).get(i)])
			{
				x a = dfs(roads.get(c).get(i), 1, false);
				
				int val = a.val;
				boolean found = a.found;
				
				if (found)
				{
					++done;
					total += val;
					thisFound = true;
				}
			}
		}
		
		if (done > 1)
		{
			total += done-1;
		}
		
		visited[c] = false;
		
		return new x(total, thisFound);
	}
	
	static public class x
	{
		int val;
		boolean found;
		
		public x(int v, boolean f)
		{
			val = v;
			found = f;
		}
	}
}
