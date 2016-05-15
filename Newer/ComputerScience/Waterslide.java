package ComputerScience;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

public class Waterslide 
{
	static Stack<Integer> current = new Stack<Integer>();
	static HashMap<Integer, LinkedList<Integer>> slides = new HashMap<Integer, LinkedList<Integer>>();
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int[] values = new int[n+1];
		boolean[] isFinished = new boolean[n+1];
		
		
		int a, b;
		
		for (int i = 1;i <= n;++i)
		{
			slides.put(i, new LinkedList<Integer>());
		}
		
		//Stops when a = 0 && b = 0.
		while ((a = in.nextInt()) != 0 && (b = in.nextInt()) != 0)
		{
			slides.get(b).add(a);
		}
		
		isFinished[1] = true;
		values[1] = 1;
		current.add(n);
		
		while (!current.isEmpty())
		{
			Integer curr = current.peek();
			
			if (isFinished[curr] || slides.get(curr).isEmpty())
			{
				if (curr == n)
				{
					System.out.println(values[curr]);
					break;
				}
				
				isFinished[curr] = true;
				
				current.pop();				
				values[current.peek()] += values[curr];
			}
			else
			{
				current.add(slides.get(curr).poll());
			}
		}
	}
	
/*
Test Case:
10
1 2
1 4
2 3
4 3
3 7
3 6
3 5
2 9
9 10
7 8
6 8
8 10
0 0
*/
}
