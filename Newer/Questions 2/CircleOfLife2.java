/*
* Finish: By next tuesday.
* 
* Ideas:
* - period?
* - use the rabbit and the turtle solution to find collision.
*
* FINISHED: On WCIPEG.
*/

package Questions;

import java.util.Scanner;

public class CircleOfLife2 
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		String[] input = in.nextLine().split(" ");
		
		int N = Integer.parseInt(input[0]);
		long T = Long.parseLong(input[1]);
		
		String state = in.nextLine();
		
		System.out.println(state);
	}
}

