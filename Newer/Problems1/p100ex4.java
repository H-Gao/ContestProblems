package Problems1;

import java.util.Scanner;

public class p100ex4 
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		char[] input = in.nextLine().toCharArray();
		
		if (input[0] == 'M') System.out.print("midget");
		else if (input[0] == 'J') System.out.print("junior");
		else if (input[0] == 'S') System.out.print("senior");
		
		if (input[1] == 'B') System.out.println(" boys");
		else if (input[1] == 'G') System.out.println(" girls");
	}
}
