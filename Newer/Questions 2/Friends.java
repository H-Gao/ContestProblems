package Questions;

import java.util.Scanner;

public class Friends 
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		int numFriends = in.nextInt();
		
		int[] friendships = new int[10000];
		
		for (int i = 0;i < numFriends;++i)
		{
			int friend = in.nextInt();
			int target = in.nextInt();
			
			friendships[friend] = target;
		}
		
		while (true)
		{
			int a = in.nextInt();
			int b = in.nextInt();
			
			boolean[] visited = new boolean[10000];
			
			if (a == 0 && b == 0)
			{
				break;
			}
			
			int prev = a;
			
			for (int i = 0;true;++i)
			{
				visited[prev] = true;
				prev = friendships[prev];
				
				if (visited[prev])
				{
					System.out.println("No");
					break;
				}
				
				if (prev == b)
				{
					System.out.println("Yes " + i);
					break;
				}
			}
		}
	}
}
