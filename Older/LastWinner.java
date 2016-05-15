import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class LastWinner 
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		int numTeams = scanner.nextInt();
		
		for (int i = 1;i != numTeams+1;++i)
		{
			queue.add(i);
		}
		
		for (int i = 0;!queue.isEmpty();++i)
		{
			if (queue.size() == 1)
			{
				System.out.println(queue.poll());
			}
			else
			{
				int optionOne = queue.poll();
				int optionTwo = queue.poll();
				
				System.out.println(optionOne + " " + optionTwo);
				
				int input = scanner.nextInt();
				
				while (input != optionOne && input != optionTwo)
				{
					System.out.println("Enter a valid number.");
					
					input = scanner.nextInt();
				}
				
				queue.add(input);
			}
		}
	}
}
