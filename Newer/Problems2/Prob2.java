package Problems2;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Prob2 
{
	public static void main(String args[])
	{
		LinkedList<Integer> p = new LinkedList<Integer>();
		
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		int L = in.nextInt();
		int R = in.nextInt();
		
		for (int i = 0;i < N;++i) p.add(in.nextInt());
		
		int total = 0;
		
		Collections.sort(p);
		
		System.out.println(p.get(0));
		
		while (!p.isEmpty())
		{
			for (int i = 0;i < L;++i)
			{
				if (p.isEmpty()) break;
				
				if (i == R-1) 
				{
					total += p.get(p.size()-1);
				}
				
				p.remove(p.size()-1);
			}
		}
		
		System.out.println(total);
	}
}

/*
 * 8
2
1
33
18
2
4
2
5
3
5*/
