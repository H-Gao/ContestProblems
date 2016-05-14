package Default;

import java.util.Scanner;

public class DontPassMeTheBall 
{
	public static void main(String args[])
	{
		Scanner scanner = new Scanner(System.in);
		
		int input = scanner.nextInt();
		
		int goals = 0;
		
		for (int n = 0;n != input;++n)
		{
			for (int k = 0;k != input;++k)
			{
				for (int i = 0;i != input;++i)
				{
					for (int nk = 0;nk != input;++nk)
					{
						if (n < k && k < i && i < nk)
						{
							if (isUnique(n, k, i, nk))
							{
								++goals;
							}
						}
					}
				}
			}
		}
		
		System.out.println(goals);
	}
	
	public static boolean isUnique(int n, int k, int i, int nk)
	{
		if (n != k && n != i && n != nk && k != i && k != nk && i != nk)
		{
			return true;
		}
		
		else
		{
			return false;
		}
	}
}
