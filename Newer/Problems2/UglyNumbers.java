package Problems2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class UglyNumbers 
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		HashMap<Long, Boolean> h = new HashMap<Long, Boolean>();
		Queue<Long> q = new LinkedList<Long>();
		
		long[] k = { 2, 3, 5 };
		
		q.add((long)1);
		h.put((long)1, true);
		
		for (int i = 0;i < 5000;++i)
		{
			long a = q.poll();
			
			for (int x = 0;x < 3;++x)
			{
				long b = a*k[x];
				
				if (h.get(b) == null && b > 0)
				{
					h.put(b, true);
					q.add(b);
				}
			}
		}
		
		Object[] l = h.keySet().toArray();
		Arrays.sort(l);
		
		System.out.println("The 1500'th ugly number is " + l[1499] + ".");
	}
}
