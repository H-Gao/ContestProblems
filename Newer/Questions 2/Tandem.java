package Questions;

import java.util.Arrays;
import java.util.Scanner;

public class Tandem 
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		int question = in.nextInt();
		
		int N = in.nextInt();
		
		int[] a = new int[N];
		int[] b = new int[N];
		
		for (int i = 0;i < N;++i)
		{
			a[i] = in.nextInt();
		}
		
		for (int i = 0;i < N;++i)
		{
			b[i] = in.nextInt();
		}
		
		Arrays.sort(a);
		Arrays.sort(b);
		
		if (question == 1)
		{
			int sum = 0;
			
			for (int i = 0;i < N;++i)
			{
				sum += Math.max(a[i], b[i]);
			}
			
			System.out.println(sum);
		}
		else if (question == 2)
		{
			int sum = 0;
			
			for (int i = 0;i < N;++i)
			{
				sum += Math.max(a[i], b[N-i-1]);
			}
			
			System.out.println(sum);
		}
	}
}
