import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class TheMissingLink 
{
	//Check for multiples of 2 in the last character.
	//Add all numbers to the String, and see if they are even.
	//If they are not even, then add to list.
	//If they are even, it is not possible. End of algorithm.
	//If the list is empty, it is not possible.
	//End of algorithm.
	
	
	public static void main(String[] args)
	{
		for (int cases = 0;cases < 5;++cases)
		{
			Scanner in = new Scanner(System.in);
			
			String userIn = in.nextLine();
			String[] input = new String[2];
			
			String[] splittedIn = userIn.split("_");
			int loc = userIn.lastIndexOf("_");
			
			if (loc == userIn.length()-1)
			{
				if (userIn.equals("_"))
				{
					input[0] = "";
					input[1] = "";
				}
				else
				{
					input[0] = splittedIn[0];
					input[1] = "";
				}
			}
			else if (loc == 0)
			{
				input[0] = "";
				input[1] = splittedIn[1];
			}
			else
			{
				input[0] = splittedIn[0];
				input[1] = splittedIn[1];
			}
			
			Queue<Integer> possibleInt = new LinkedList<Integer>();
				
			for (int i = 0;i < 10;++i)
			{
				int num = Integer.parseInt(input[0] + i + input[1]);
					
				if (isPrime(num))
				{
					possibleInt.add(i);
				}
			}
				
			if (possibleInt.size() == 0)
			{
				System.out.println("Not possible");
			}
			else
			{
				while (!possibleInt.isEmpty())
				{
					System.out.print(possibleInt.poll());
								
					if (possibleInt.size() != 0)
					{
						System.out.print(" ");
					}
					else
					{
						System.out.print("\n");
					}
				}
			}
		}
	}
	
	public static boolean isPrime(int n)
	{
		if (n == 1)
			return false;
		
		for (int i = 2;i<=Math.sqrt((double)n);++i)
		{
			if (n%i==0)
			{
				return false;
			}
		}
		
		return true;
	}
}
