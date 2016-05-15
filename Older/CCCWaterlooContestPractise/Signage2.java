package CCCWaterlooContestPractise;

import java.util.Scanner;

public class Signage2 
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		
		int w = scanner.nextInt();
		
		String sentence = "WELCOME TO CCC GOOD LUCK TODAY";
		
		String part[] = new String[4];
		
		int beg = 0;
		int end = w;
		
		for (int n = 0;n != 10;++n)
		{
			if (end < sentence.length())
			{
				while (true)
				{
					if (sentence.charAt(end+1) == ' ')
					{
						part[n] = sentence.substring(beg, end+1);
					
						beg = end+1;
						end += w;
						
						break;
					}
					else
					{
						--end;
					}
				}
			
				System.out.println(part[n]);
			}
		}
		
		for (int n = 0;n != part.length;++n)
		{
			for (int k = 0;k != part[n-1].length();++k)
			{
				if (sentence.charAt(k) != ' ')
					System.out.print(sentence.charAt(k));
				else
					System.out.print(".");
			}
			
			System.out.print("\n");
		}
	}
}

/*int numEmpty[] = new int[part.length];
int numWords[] = new int[part.length];

for (int n = 0;n != part.length;++n)
{
	++numWords[n];
	
	for (int k = 0;k != part[n].length();++k)
	{
		if ((k-1) != 0 && k != 0 && part[n].charAt(k) != ' ' && part[n].charAt(k-1) == ' ')
			++numWords[n];
		
		if (part[n].charAt(k) != ' ')
			++numEmpty[n];
	}
	
	numEmpty[n] -= w;
	numEmpty[n] *= -1;
	
	System.out.println(numEmpty[n] + " " + numWords[n]);
}*/
