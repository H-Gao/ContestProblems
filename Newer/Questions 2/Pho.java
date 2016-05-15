package Questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Pho 
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		int M = in.nextInt();
		
		int[] pho = new int[M];
		int[] timeToGet = new int[N];
		
		for (int i = 0;i < M;++i)
		{
			pho[i] = in.nextInt();
		}
		
		ArrayList<ArrayList<Integer>> roads = new ArrayList<ArrayList<Integer>>();
		boolean[] visited = new boolean[N];
		
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
		
		for (int a = 0;a < pho.length;++a)
		{
			Queue<Integer> s = new LinkedList<Integer>();
			Queue<Integer> distance = new LinkedList<Integer>();
			
			visited = new boolean[N];
			
			for (int i = 0;i < N;++i)
			{
				timeToGet[i] = Integer.MAX_VALUE;
			}
			
			//DO THIS FOR ALL.
			s.add(pho[a]);
			distance.add(0); //-1?
			visited[pho[a]] = true;
			
			while (!s.isEmpty())
			{
				int v = s.poll();
				int d = distance.poll();
				
				if (d < timeToGet[v]) timeToGet[v] = d;
				
				if (!roads.get(v).isEmpty())
				{
					for (int i = 0;i < roads.get(v).size();++i)
					{
						int visiting = roads.get(v).get(i);
						
						if (!visited[visiting])
						{
							s.add(visiting);
							distance.add(d+1);
							visited[visiting] = true;
						}
					}
				}
			}
			
			int sum = 0;
			
			for (int i = 0;i < pho.length;++i)
			{
				System.out.println(timeToGet[pho[i]]);
				if (timeToGet[pho[i]] != Integer.MAX_VALUE)
				sum += timeToGet[pho[i]];
			}
			
			min = Math.min(sum, min);
			System.out.println();
		}
		
		System.out.println(min);
	}
}
