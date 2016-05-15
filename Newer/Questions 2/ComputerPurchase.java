package Questions;

import java.util.Scanner;

public class ComputerPurchase 
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		int n = Integer.parseInt(in.nextLine());
		
		String name1 = "";
		String name2 = "";
		
		int val1 = 0;
		int val2 = 0;
		
		for (int i = 0;i < n;++i)
		{
			String name = in.nextLine();
			
			int RAM = Integer.parseInt(in.nextLine());
			int CPU = Integer.parseInt(in.nextLine());
			int DISK = Integer.parseInt(in.nextLine());
			
			int score = 2 * RAM + 3 * CPU + DISK;
			
			if (score > val1)
			{
				val1 = score;
				name1 = name;
			}
			else if (score > val2)
			{
				
			}
		}
	}
}
