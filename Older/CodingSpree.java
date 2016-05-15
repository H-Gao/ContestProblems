import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;


public class CodingSpree 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		String input = in.nextLine();
		
		int maxVal = 0;
		
		int numProblems = Integer.parseInt(input.substring(0, input.indexOf(' ')));
		int maxTime = Integer.parseInt(input.substring(input.indexOf(' ')+1, input.length()));
		
		HashMap<Double, Queue<String>> d = new HashMap<Double, Queue<String>>();
		ArrayList<Double> sortedVal = new ArrayList<Double>();
		
		for (int i = 0;i < numProblems;++i)
		{
			input = in.nextLine();
			
			double a = Integer.parseInt(input.substring(0, input.indexOf(' ')));
			double b = Integer.parseInt(input.substring(input.indexOf(' ')+1, input.length()));
			
			//Filters out the irrelevent data.
			if ((int)b <= maxTime)
			{
				double val = a/b;
				
				System.out.println(input + " " + val);
				
				sortedVal.add(val);
				
				if (d.get(val) == null)
				{
					Queue<String> temp = new LinkedList<String>();
					temp.add(input);
					
					d.put(val, temp);
				}
				else
				{
					Queue<String> temp = d.get(val);
					temp.add(input);
					
					d.put(val, temp);
				}
			}
		}
		
		Collections.sort(sortedVal);
		
		boolean isFinished = false;
		
		for (int i = sortedVal.size()-1;!sortedVal.isEmpty();--i)
		{
			double currentVal = sortedVal.get(i);
			
			Queue<String> original = d.get(currentVal);
			
			while (!original.isEmpty())
			{
				String currentOriginal = original.poll();
				
				double val = Integer.parseInt(currentOriginal.substring(0, currentOriginal.indexOf(' ')));
				double time = Integer.parseInt(currentOriginal.substring(currentOriginal.indexOf(' ')+1, currentOriginal.length()));
				
				if ((maxTime - time) < 0)
				{
					isFinished = true;
					break;
				}
				
				maxVal += val;
				maxTime -= time;
			}
			
			if (isFinished)
				break;
			
			sortedVal.remove(i);
		}
		
		System.out.println(maxVal);
	}
}
