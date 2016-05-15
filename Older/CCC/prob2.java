package CCC;

import java.util.HashMap;
import java.util.Scanner;

public class prob2 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		String catcher = in.nextLine();
		
		HashMap<String, String> names = new HashMap<String, String>();
		
		String[] a = new String[n];
		String[] b = new String[n];
		
		String[] input = in.nextLine().split(" ");
		
		for (int i = 0;i < 7;++i)
		{
			a[i] = input[i];
		}
		
		input = in.nextLine().split(" ");
		
		for (int i = 0;i < 7;++i)
		{
			b[i] = input[i];
			names.put(a[i], b[i]);
		}
		
		for (int i = 0;i < n;++i)
		{
			if (names.get(a[i]) != b[i])
			{
				System.out.println("Bad.");
				System.exit(0);
			}
		}
		
		System.out.println("Good.");
	}
}
