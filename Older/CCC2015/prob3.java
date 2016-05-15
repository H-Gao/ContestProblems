package CCC2015;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class prob3 
{
	static int max = 0;
	
	static int cut = -1;
	static int G;
	static int P;
	static int[] inputs;
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		G = in.nextInt();
		P = in.nextInt();
		
		//boolean[] used = new boolean[G];
		
		inputs = new int[P];
		
		ArrayList<Integer> used	= new ArrayList<Integer>();
		
		for (int i = 0;i < P;++i)
		{	
			inputs[i] = in.nextInt();
			int numBetween = 0;
			
			for (int n = 0;n < used.size();++n)
			{
				if (used.get(n) <= inputs[i]) ++numBetween;
				else break;
				
				if (numBetween == inputs[i]) break;
			}
			
			if (numBetween == inputs[i])
			{
				cut = i;
				break;
			}
			
			used.add(inputs[i]);
			Collections.sort(used);
		}
		
		System.out.println(cut);
	}
}
