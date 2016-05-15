package Questions;

import java.util.Scanner;

public class FractionAction 
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		int num = in.nextInt();
		int den = in.nextInt();
		
		int whole = num/den;
		
		num = num - whole * den;
		
		if (num > 0)
		{
			for (int i = num;i > 1;--i)
			{
				if (num%i == 0 && den%i == 0)
				{
					num /= i;
					den /= i;
				}
			}
			
			if (whole > 0) System.out.print(whole + " ");
			System.out.println(num + "/" + den);
		}
		else
		{
			System.out.println(whole);
		}
	}
}
