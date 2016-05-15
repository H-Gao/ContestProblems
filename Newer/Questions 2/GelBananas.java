package Questions;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class GelBananas 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		long A = in.nextLong();
		long B = in.nextLong();
		
		long max = in.nextLong();
		
		long num = 0;
		
		long higher = Math.max(A, B);
		
		for (long i = 0;i < max;i += higher)
		{
			if (i%A == 0 && i%B == 0)
			{
				++num;
				//System.out.println(i);
			}
		}
		
		System.out.println(num);
	}
}
