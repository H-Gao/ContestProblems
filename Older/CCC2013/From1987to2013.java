package CCC2013;

import java.util.Scanner;

public class From1987to2013 
{
	public static void main(String[] args)
	{
		System.out.println(getNextNum());
	}
	
	public static int getNextNum()
	{
		Scanner in = new Scanner(System.in);
		
		int d = in.nextInt()+1;
		
		while (true)
		{
			char[] digits = (""+d).toCharArray();
			
			boolean works = true;
			
			for (int a = 0;a < digits.length;++a)
				for (int b = 0;b < digits.length;++b)
					if (a != b && digits[a] == (int)digits[b]){
						works = false;
						break;
							}
			
			if (works) return d;
			
			++d;
		}
	}
}
