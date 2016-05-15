package ComputerScience;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Stack;

public class PartyInvitation 
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		int numEmployees = in.nextInt()+1;
		
		int[] rankings = new int[numEmployees];
		
		//Puts rankings into array.
		for (int i = 1;i < numEmployees;++i)
		{
			rankings[i] = in.nextInt();
		}
		
		HashMap<Integer, LinkedList<Integer>> tree = new HashMap<Integer, LinkedList<Integer>>();
		
		//Inits all employee branches/leaves.
		for (int i = 1;i < numEmployees;++i)
		{
			tree.put(i, new LinkedList<Integer>());
		}
		
		int a, b;
		
		boolean[] isEmployee = new boolean[numEmployees];
		
		//Forms the tree.
		while ((a = in.nextInt()) != 0 && ((b = in.nextInt()) != 0))
		{
			isEmployee[a] = true;
			tree.get(b).add(a);
		}
		
		int starting = 0;
		
		//Finds the first node.
		for (int i = 1;i < numEmployees;++i)
		{
			if (!isEmployee[i])
			{
				starting = i;
			}
		}
		
		System.out.println("Starting at " + starting);
		
		HashMap<Integer, LinkedList<Integer>> job = (HashMap<Integer, LinkedList<Integer>>)tree.clone();
		
		Pair[] value = new Pair[numEmployees];
		Stack<Integer> dfs = new Stack<Integer>();
		
		dfs.add(starting);
		
		while (!dfs.isEmpty())
		{
			int i = dfs.peek();
			
			//Can solve.
			if (tree.get(i).isEmpty())
			{
				//No other employees.
				if (job.get(i).isEmpty())
				{
					value[i] = new Pair(0, rankings[i]);
				}
				
				//If there are other employees.
				else
				{
					LinkedList<Integer> children = job.get(i);
					
					if (rankings[i] > 0)
					{
						value[i] = new Pair(0, 2);
					}
					else
					{
						value[i] = new Pair(0, 0);
					}
					
					for (int x = 0;x < children.size();++x)
					{
						int childValueL = value[children.get(x)].left;
						
						if (childValueL > 0)
						{
							value[i].right += childValueL;
						}
					}
					
					for (int y = 0;y < children.size();++y)
					{
						int childValueL = value[children.get(y)].left;
						int childValueR = value[children.get(y)].right;
						
						int largest = Math.max(childValueL, childValueR);
						
						if (largest > 0)
						{
							value[i].left += largest;
						}
					}
				}
				
				System.out.println("Executing " + i);
				dfs.pop();
			}
			
			//Move down one employee.
			else
			{
				System.out.println("Moving down to " + tree.get(i).peek());
				dfs.add(tree.get(i).poll());
			}
		}
	}
	
	static class Pair
	{
		int left;
	    int right;

	    public Pair(int left, int right) 
	    {
			this.left = left;
			this.right = right;
	    }
	}
}
