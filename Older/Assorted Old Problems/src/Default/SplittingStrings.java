package Default;

import java.util.Scanner;

public class SplittingStrings 
{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		
		String k[];
		String n = scanner.nextLine();
		
		k = n.split(",");
		
		for (int x = 0;x != k.length;++x)
		{
			System.out.println(k[x]);
		}
	}
}
