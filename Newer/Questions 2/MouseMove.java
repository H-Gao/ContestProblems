package Questions;

import java.util.Scanner;

public class MouseMove 
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		int xBounds = in.nextInt();
		int yBounds = in.nextInt();
		
		int x = 0;
		int y = 0;
		
		int xInc;
		int yInc;
		
		while (true)
		{
			xInc = in.nextInt();
			yInc = in.nextInt();
			
			if (xInc == 0 && yInc == 0) break;
			
			x += xInc;
			y += yInc;
			
			if (x > xBounds) x = xBounds;
			else if (x < 0) x = 0;
			
			if (y > yBounds) y = yBounds;
			else if (y < 0) y = 0;
			
			System.out.println(x + " " + y);
		}
	}
}
