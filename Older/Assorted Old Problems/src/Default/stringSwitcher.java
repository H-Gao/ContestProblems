package Default;

import java.util.Scanner;

public class stringSwitcher 
{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		
		String n = scanner.nextLine();
		
		if (n.length()%2==0)
		{
			System.out.println(n.substring(n.length()/2, n.length()));
			System.out.println(n.substring(0, n.length()/2));
		}
		
		else
		{
			System.out.println(n.charAt((n.length()/2)));
			System.out.println(n.substring(n.length()/2+1, n.length()));
			System.out.println(n.substring(0, n.length()/2));
		}
	}
}
