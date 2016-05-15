package Problems1;

import java.util.Scanner;

public class p79ex5 
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		if (in.nextInt() % in.nextInt() == 0) System.out.println("yes");
		else System.out.println("no");
	}
}
