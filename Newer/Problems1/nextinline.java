package Problems1;

import java.util.Scanner;

public class nextinline 
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		int fChild = in.nextInt(), sChild = in.nextInt();
		int tChild = sChild + (sChild - fChild);
		
		System.out.println(tChild);
	}
}
