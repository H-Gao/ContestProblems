package CCC2015;

import java.util.HashMap;
import java.util.Scanner;

public class prob6 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		char[] input = in.nextLine().toCharArray();
		
		char[] vowels = {'a', 'e', 'i', 'o', 'u'};
		
		String newStr = "";
		for (int i = 0;i < input.length;++i)
		{
			int l = input[i];
			System.out.print((char)l);
			
			boolean isVowel = false;
			
			for (int n = 0;n < vowels.length;++n)
			if (vowels[n] == l)
			{
				isVowel = true;
				break;
			}
			
			if (!isVowel)
			{
				int c = 10000;
				char c2 = ' ';
				
				for (int n = 0;n < vowels.length;++n)
				{
					int d = Math.abs(l - vowels[n]);
					
					if (d < c)
					{
						c = d;
						c2 = vowels[n];
					}
				}
				
				System.out.print(c2);
				
				if (l == 'z') System.out.print('z');
				else
				{
					for (int n = 1;n < vowels.length;++n)
					{
						isVowel = false;
						
						for (int a = 0;a < vowels.length;++a)
							if (vowels[a] == l+n) isVowel = true;
						
						if (!isVowel)
						{
							System.out.print((char)(l+n));
							break;
						}
					}
				}
			}
		}
	}
}
