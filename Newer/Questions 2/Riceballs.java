package Questions;

import java.util.LinkedList;
import java.util.Scanner;

public class Riceballs 
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		
		LinkedList<Integer> a = new LinkedList<Integer>();
		
		for (int i = 0;i < N;++i)
		{
			a.add(in.nextInt());
		}
		
		int max = 0;
		int loc = 0;
		int num = 0;
		
		for (int i = 0;i < a.size()-1;++i)
		{
			int current = a.get(i);
			int next1 = a.get(i+1);
			int next2 = -2;
			
			if (i+2 < a.size()-1) next2 = a.get(i+2);
			
			System.out.println(next1 + " " + current);
			
			if (current == next1 && current + next1 > loc)
			{
				System.out.println("***" + max);
				
				max = current + next1;
				loc = i;
				num = 2;
			}
			
			if (current == next2 && current + next1 + next2 > loc)
			{
				max = current + next1 + next2;
				loc = i;
				num = 3;
			}
		}
		
		System.out.println(max);
	}
}
