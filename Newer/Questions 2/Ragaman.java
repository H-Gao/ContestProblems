package Questions;

import java.util.Scanner;

public class Ragaman 
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		String a = in.nextLine();
		String b = in.nextLine();
		
		if (a.length() != b.length()) System.out.println("N");
		else
		{
			for (int i = 0;i < a.length();++i)
			{
				b = b.replaceFirst(""+a.charAt(i), "*");
			}
			
			for (int i = 0;i < b.length();++i)
			{
				if (b.charAt(i) != '*')
				{
					System.out.println("N");
					break;
				}
				else if (i == b.length()-1)
				{
					System.out.println("A");
				}
			}
		}
	}
}
