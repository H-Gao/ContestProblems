package CCC2015;

import java.util.HashMap;
import java.util.Scanner;

public class prob7 
{
	static HashMap<Integer[], Boolean> d = new HashMap<Integer[], Boolean>();
	static int numPie;
	static int numPeople;
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		numPie = in.nextInt();
		numPeople = in.nextInt();
		
		String str = "";
		int[] pie = new int[numPeople];
		
		for (int i = 0;i < numPeople-1;++i)
			pie[i] = 1;
		
		pie[numPeople-1] = numPie - numPeople;
		
		//doPie(pie);
		
		System.out.println(d.size());
	}
	
	public static void doPie(String k, int[] p)
	{
		//if (!compare()) return;
		
		for (int a = 1;a < numPie/numPeople+1;++a)
		{
			for (int b = 0;b < p.length;++b)
			{
				for (int c = 0;c < p.length;++c)
				{
					if (isIncreasing(p))
					{
						int[] temp = p.clone();
						temp[b] += a;
						temp[c] -= a;
						
						//doPie(temp);
					}
				}
			}
		}
	}
	
	public static boolean isIncreasing(int[] p)
	{
		for (int i = 0;i < p.length-1;++i) if (p[i] > p[i+1]) return false;
		
		return true;
	}
	
	public static boolean compare(int[] a, int[] b)
	{
		for (int i = 0;i < a.length-1;++i)
			if (a[i] != b[i+1]) return false;
		
		return true;
	}
}
