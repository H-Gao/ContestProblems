package ComputerScience;

import java.util.Scanner;

public class MaximumSum 
{
	static int[] num;
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		num = new int[N];
		
		for (int i = 0;i < N;++i)
		{
			num[i] = in.nextInt();
		}
		
		System.out.println(f(0));
	}
	
	public static int f(int index)
	{
		int value = 0;
		
		for (int i = index;i < num.length;++i)
		{
			if (i >= num.length) return 0;
			
			if (i+2 < num.length && (num[i] + 1 == num[i+1] || 
			num[i] - 1 == num[i+1]) && (num[i+1] + 1 == num[i+2] || num[i+1] - 1 == num[i+2]))
			{
				return Math.max(num[i+1], f(index+2) + num[i]) + value;
			}
			else if (i+1 < num.length && (num[i] + 1 == num[i+1] || num[i] - 1 == num[i+1]))
			{
				return Math.max(num[i], f(index+2) + num[i+1]) + value;
			}
			else if (i < num.length)
			{
				value += num[i];
			}
		}
		
		return 0;
	}
}
