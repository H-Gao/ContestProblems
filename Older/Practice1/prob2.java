package Practice1;

import java.util.Scanner;

public class prob2 
{
	public static void main(String[] args)
	{
		System.out.println(isEven());
	}
	
	public static boolean isEven()
	{
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		String catcher = in.nextLine();
		
		String[] s1 = new String[n];
		String[] s2 = new String[n];
		
		String[][] s = {s1, s2};
		
		for (int a = 0;a < 2;++a)
		{
			String[] input = in.nextLine().split(" ");
			if (input.length > n) return false;
				
			for (int i = 0;i < n;++i) s[a][i] = input[i];
		}
		
		for (int i = 0;i < n;++i)
		{
			String name = s1[i];
			String name2 = s2[i];
			
			for (int k = 0;k < n;++k) if (s2[k].equals(name)) 
				if (!s1[k].equals(name2)) return false;
		}
		
		return true;
	}
}
