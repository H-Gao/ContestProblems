package CCC2012;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class AbsolutelyAcidic 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int first = -1;
		int second = -1;
		
		Stack<Integer[]> otherDiff = new Stack<Integer[]>();
		
		HashMap<Integer, Integer> freq = new HashMap<Integer, Integer>();
		freq.put(-1, -1);
		
		int N = in.nextInt();
		
		for (int i = 0;i < N;++i)
		{
			int num = in.nextInt();
			
			if (freq.get(num) == null)
			{
				freq.put(num, 1);
			}
			else
			{
				freq.put(num, freq.get(num)+1);
			}
			
			int numFreq = freq.get(num);
			
			if (numFreq > freq.get(first) || (numFreq == freq.get(first) && num >= first))
			{
				if (num != first)
					second = first;
				
				first = num;
			}
			else if (numFreq > freq.get(second))
			{
				second = num;
			}
			else if (numFreq == freq.get(second) && num > second)
			{
				second = numFreq;
			}
		}
		
		System.out.println(Math.abs(first - second));
	}
}
