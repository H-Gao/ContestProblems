package Questions;

import java.util.Scanner;

public class AliceThroughLookingGlass 
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		
		for (int i = 0;i < T;++i)
		{
			int m = in.nextInt(), mVal = (int)Math.pow(5, m), x = in.nextInt(), y = in.nextInt();
			
			while (m > 0)
			{
				mVal /= 5;
				
				int xQuad = x/mVal, yQuad = y/mVal;
				
				if ((xQuad == 1 && yQuad == 0) || (xQuad == 2 && yQuad == 0) || (xQuad == 3 && yQuad == 0) || (xQuad == 2 && yQuad == 1))
				{
					System.out.println("crystal");
					break;
				}
				
				else if (m > 1 && ((xQuad == 1 && yQuad == 1) || (xQuad == 2 && yQuad == 2) || (xQuad == 3 && yQuad == 1)))
				{		
					x -= mVal * xQuad;
					y -= mVal * yQuad;
					
					--m;
				}
				
				else
				{
					System.out.println("empty");
					break;
				}
			}
		}
	}
}
