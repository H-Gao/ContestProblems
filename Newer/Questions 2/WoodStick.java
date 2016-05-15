package Questions;

import java.util.PriorityQueue;
import java.util.Scanner;

public class WoodStick 
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		
		PriorityQueue<Integer> a = new PriorityQueue<Integer>();
		
		for (int i = 0;i < N;++i)
		{
			a.add(in.nextInt());
		}
		
		int total = 0;
		
		while (a.size() != 1)
		{
			int merged = a.poll() + a.poll();
			total += merged;
			
			a.add(merged);
		}
		
		if (N == 1)
		{
			System.out.println(a.poll());
		}
		else
		{
			System.out.println(total);
		}
	}
}
