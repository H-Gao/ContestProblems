package Default;

import java.util.Scanner;

public class addingStrings 
{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		
		String input[] = new String[2];
		
		char destInput[];
		
		boolean hasNumbers = true;
		
		for (int n = 0;n != 2;++n)
		{
			input[n] = scanner.nextLine();
		}
		
		char[] i = input[0].toCharArray();
		
		char[] k = input[1].toCharArray();
		
		if (i.length >= k.length)
		{
			char total[] = new char[k.length];
			
			for (int n = 0;n != k.length;++n)
			{
				total[n] = (char) (i[n] + k[n]);
			}
			
			System.out.println(total[4]);
		}
	}
}
