package CCC;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Prob1 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int k = in.nextInt();
		int m = in.nextInt();
		
		Queue<Integer> p = new LinkedList<Integer>();
		
		for (int a = 1;a <= k;++a) 
		{
			p.add(a);
		}
		
		for (int a = 0;a < m;++a) 
		{
			int curM = in.nextInt();
			
			for (int b = 1;b <= k;++b) 
			{
				int polled = p.poll();
				
				if (b%curM != 0) p.add(polled);
			}
			
			k = p.size();
		}
		
		while (!p.isEmpty())
			System.out.println(p.poll());
	}
}

