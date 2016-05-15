package CCC2010;

import java.util.ArrayList;
import java.util.Scanner;

public class ComputerPurchase 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		String catcher = in.nextLine();
		
		int f = -1;
		int s = -1;
		
		String first = "";
		String second = "";
		
		for (int i = 0;i < N;++i)
		{
			String[] input = in.nextLine().split(" ");
			int[] num = {0, 2, 3, 1};
			
			int val = 0;
			
			for (int n = 1;n < 4;++n) val += num[n] * Integer.parseInt(input[n]);
			
			if (val > f || (val == f && first.compareTo(input[0]) > 0))
			{
				s = f;
				second = first;
				
				f = val;
				first = input[0];
			}
			else if (val > s || (val == s && second.compareTo(input[0]) > 0))
			{
				s = val;
				second = input[0];
			}
		}
		
		System.out.println(first);
		System.out.println(second);
	}
}
