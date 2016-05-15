package ComputerScience;

import java.util.Scanner;

public class Cheesecake 
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		long timeTaken = 0;
		
		long totalCake = 0;
		int N = in.nextInt();
		
		long[] friends = new long[N];
		
		for (int i = 0;i < N;++i)
		{
			friends[i] = in.nextLong();
			totalCake += friends[i];
		}
		
		if (totalCake % N != 0)
		{
			System.out.println("Impossible");
			return;
		}
		
		long perFriend = totalCake/N;
		
		for (int i = 0;i < N;++i)
		{
			if (friends[i] > perFriend)
			{
				timeTaken += friends[i] - perFriend;
			}
		}
		
		System.out.println(timeTaken);
	}
}
