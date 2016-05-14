package Default;

import java.util.Scanner;

public class NameSwitch 
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter your name.");
		
		String name = scanner.nextLine();
		
		char names[] = new char[name.length()];
		char lastNames[] = new char[name.length()];
		
		boolean secondHalf = false;
		
		for (int n = 0;n != name.length();++n)
		{
			if (name.charAt(n) == ' ')
			{
				secondHalf = true;
			}
			
			if (!secondHalf)
			{
				if (name.charAt(n) != ' ')
				{
					names[n] = name.charAt(n);
				}
			}
			
			if (secondHalf)
			{
				if (name.charAt(n) != ' ')
				{
					lastNames[n] = name.charAt(n);
				}
			}
		}
		
		String formatedNames = "";
		
		for (int n = 0;n != lastNames.length;++n)
		{
			formatedNames = formatedNames + lastNames[n];
		}
		
		formatedNames = formatedNames + " ";
		
		for (int n = 0;n != names.length;++n)
		{
			formatedNames = formatedNames + names[n];
		}
		
		System.out.print(formatedNames);
	}
}
