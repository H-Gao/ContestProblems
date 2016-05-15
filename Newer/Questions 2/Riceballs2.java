package Questions;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Riceballs2 
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		HashMap<String, Boolean> visited = new HashMap<String, Boolean>();
		
		int N = in.nextInt();
		
		LinkedList<Integer> a = new LinkedList<Integer>();
		
		for (int i = 0;i < N;++i)
		{
			a.add(in.nextInt());
		}
		
		Stack<LinkedList<Integer>> dfs = new Stack<LinkedList<Integer>>();
		
		dfs.add(a);
		
		int max = -1;
		
		while (!dfs.isEmpty())
		{
			LinkedList<Integer> popped = dfs.pop();
			
			String str = "";
			
			for (int i = 0;i < popped.size();++i)
			{
				str += popped.get(i) + " ";
			}
			
			if (visited.get(str) == null)
			{
				LinkedList<Integer> temp = (LinkedList) popped.clone();
				
				for (int i = 0;i < popped.size();++i)
				{
					if (popped.get(i) > max)
					{
						max = popped.get(i);
					}
					
					if (i+1 < popped.size() && popped.get(i) == popped.get(i+1))
					{
						temp.remove(i);
						temp.remove(i);
						
						temp.add(i, popped.get(i) + popped.get(i+1));
						dfs.add(temp);
						
						temp = (LinkedList) popped.clone();
					}
					
					if (i+2 < popped.size() && popped.get(i) == popped.get(i+2))
					{
						temp.remove(i);
						temp.remove(i);
						temp.remove(i);
						
						temp.add(i, popped.get(i) + popped.get(i+1) + popped.get(i+2));
						dfs.add(temp);
						
						temp = (LinkedList) popped.clone();
					}
				}
				
				visited.put(str, true);
			}
		}
		
		System.out.println(max);
	}
}
