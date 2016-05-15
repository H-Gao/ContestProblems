import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;


public class HuffermanTree 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		char[] input = in.nextLine().toCharArray();
		Arrays.sort(input);
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		//Finds amount of unique Chars.
		int numNumber = 0;
		for (int i = 0;i < input.length;++i)
		{
			int numCur = input[i];
			
			++numNumber;
			if (i+1 >= input.length || input[i+1] != numCur)
			{
				pq.add(numNumber);
				numNumber = 0;
			}
		}
		
		while (!pq.isEmpty())
			System.out.println(pq.poll());
	}
}
