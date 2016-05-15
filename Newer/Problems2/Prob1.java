package Problems2;

import java.util.Scanner;

public class Prob1 
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		int N = Integer.parseInt(in.nextLine());
		
		String name = "";
		double max = -1.0;
		
		for (int i = 0;i < N;++i)
		{
			String[] input = in.nextLine().split(" ");
			
			String currName = input[0];
			double currMax = Double.parseDouble(input[1]);
			
			if (currMax > max)
			{
				name = currName;
				max = currMax;
			}
		}
		
		System.out.println(name);
	}
}
