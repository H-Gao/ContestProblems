package Java;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class spojSPAR 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int numTrucks;
		
		while ((numTrucks = in.nextInt()) != 0) //Checks if it will stop, when numTrucks == 0.
		{
			int lookingFor = 1;
			
			Queue<Integer> lStreet = new LinkedList<Integer>();
			Stack<Integer> sStreet = new Stack<Integer>();
			
			while (!sStreet.isEmpty())
			{
				String blocker = in.nextLine(); //Blocks.
				
				String input[] = in.nextLine().split(" ");
				
				for (int i = 0;i < input.length;++i)
					lStreet.add(Integer.parseInt(input[i]));
				
				if (sStreet.peek() == lookingFor) //If it is the right one.
				{
					sStreet.pop();
					++lookingFor;
				}
				else
				{
					int polled = lStreet.poll();
					
					if (polled == lookingFor)
						++lookingFor;
					else
						sStreet.add(polled);
				}
			}
			
			for (int i = 0;i < sStreet.size();++i)
				if (sStreet.pop() != lookingFor)
				{
					System.out.println("No.");
				}
				
			System.out.println("Yes.");
		}
	}
}
