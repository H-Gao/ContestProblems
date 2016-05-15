package Questions;

import java.util.Scanner;

public class EST 
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		int total = 0;
		
		int N = in.nextInt();
		
		int last = 0;
		
		for (int i = 0;i < N;++i)
		{
			int height = in.nextInt();
			
			total += height+1;
			total += Math.max(height, last);
			
			if (i == N-1)
			{
				total += height;
			}
			
			last = height;
		}
		
		System.out.println(total);
	}
}
