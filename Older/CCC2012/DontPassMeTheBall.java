package CCC2012;

import java.util.HashMap;
import java.util.Scanner;

public class DontPassMeTheBall 
{
	static HashMap<String, Boolean> exists = new HashMap<String, Boolean>();
	
	static int mult = 1;
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int d  = in.nextInt();
		
		if (d > 3)
			countAccending(1, 2, 3, d);
		else mult = 0;
		
		System.out.println(mult);
	}
	
	public static void countAccending(int d1, int d2, int d3, int d4)
	{
		int[] d = {d1, d2, d3, d4};
		
		for (int i = 0;i < 3;++i)
		{
			int diff = d[i+1] - d[i];
			
			if (diff > 1)
				for (int n = 1;n < diff;++n)
				{
					int[] inc = new int[3];
					inc[i] = n;
					
					String str = (d1 + inc[0]) + " " + (d2 + inc[1]) + " " + (d3 + inc[2]) + " " + d4;
					
					if (exists.get(str) == null)
					{
						countAccending(d1 + inc[0], d2+ inc[1], d3+ inc[2], d4);
						exists.put(str, true);
						
						++mult;
					}
					else break;
				}
		}
	}
}
