import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;


public class poj1003 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		//The numbers.
		Queue<Double> findNum = new PriorityQueue<Double>();
		ArrayList<Double> unsortedInput = new ArrayList<Double>();
		
		//The answers.
		HashMap<Double, Integer> ans = new HashMap<Double, Integer>();
		
		//The number of each.
		HashMap<Double, Integer> numEach = new HashMap<Double, Integer>();
		
		//Finds the input.
		double input;
		while ((input = in.nextDouble()) != 0)
		{
			if (numEach.get(input) == null)
				numEach.put(input, 1);
			else
				numEach.put(input, numEach.get(input) + 1);
			
			findNum.add(input);
			unsortedInput.add(input);
		}
		
		//The total amount.
		double total = 0;
		
		int denom = 2;
		
		while ((findNum.peek()) != null)
		{
			double finding = findNum.peek();
			
			if (total >= finding)
			{
				if (findNum.peek() != null)
				{
					int numRepeats = numEach.get(findNum.peek());
					
					for (int i = 0;i < numRepeats;++i)
						ans.put(findNum.poll(), denom-2);
				}
			}
			
			total += (double)1/denom;
			
			++denom;
		}
		
		//Prints the answers.
		for (Double key : unsortedInput)
			System.out.println(ans.get(key));
	}
}
