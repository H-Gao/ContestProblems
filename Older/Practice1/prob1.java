package Practice1;

import java.util.Scanner;

public class prob1 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int k = in.nextInt();
		
		int[] guests = new int[k];
		
		for (int i = 0;i < k;++i) guests[i] = i+1;
		
		int m = in.nextInt();
		
		for (int i = 0;i < m;++i)
		{
			int temp = 0;
			int multiple = in.nextInt();
			
			for (int n = 0;n < k;++n)
			{
				if (guests[n] != 0)
				{
					++temp;
				}
				
				if (temp == multiple)
				{
					temp = 0;
					guests[n] = 0;
				}
			}
		}
		
		for (int i = 0;i < k;++i)
		{
			if (guests[i] != 0) System.out.println(guests[i]);
		}
	}
}
