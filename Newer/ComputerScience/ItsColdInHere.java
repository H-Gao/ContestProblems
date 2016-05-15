package ComputerScience;

import java.util.Scanner;

public class ItsColdInHere 
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		String coldest = "";
		int min = Integer.MAX_VALUE;
		
		while (true)
		{
			String[] input = in.nextLine().split(" ");
			
			String name = input[0];
			int value = Integer.parseInt(input[1]);
			
			if (value < min)
			{
				coldest = name;
				min = value;
			}
			
			if (name.equals("Waterloo")) break;
		}
		
		System.out.println(coldest);
	}
}
