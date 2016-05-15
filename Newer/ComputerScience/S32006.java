package ComputerScience;

import java.util.ArrayList;
import java.util.Scanner;

public class S32006 
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		int x1 = in.nextInt();
		int y1 = in.nextInt();
		int x2 = in.nextInt();
		int y2 = in.nextInt();
		
		double m1 = getM(x1, x2, y1, y2);
		double b1 = getB(m1, x1, y1);
		
		System.out.println("*****" + m1 + " " + b1);
		
		int numBuildings = in.nextInt();
		
		for (int a = 0;a < numBuildings;++a)
		{
			int numPoints = in.nextInt();
			
			int[] input = new int[numPoints * 2];
			
			for (int b = 0;b < input.length;++b)
			{
				input[b] = in.nextInt();
			}
			
			for (int b = 0;(b+3) < input.length;b += 2)
			{
				double m2 = getM(input[b], input[b+2], input[b+1], input[b+3]);
				double b2 = getB(m2, input[b], input[b+1]);
				
				System.out.println("*****" + m2 + " " + b2);
				hasCollided(m1, b1, m2, b2);
			}
			
			double m2 = getM(input[0], input[input.length-2], input[1], input[input.length-1]);
			double b2 = getB(m2, input[0], input[1]);
			
			//System.out.println(m2 + " " + b2);
		}
	}
	
	public static void hasCollided(double m1, double b1, double m2, double b2)
	{
		double x = (b2 - b1)/(m1 - m2);
		double y = m1 * x + b1;
		
		System.out.println(x + " " + y);
	}
	
	public static boolean hasCollided(double m1, double b1, double m2, double b2, int xMin, int xMax, int yMin, int yMax)
	{
		double x = (b2 - b1)/(m1 - m2);
		double y = m1 * x + b1;
		
		if (x >= xMin && x <= xMax && y >= yMin && y <= yMax)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static double getM(int x1, int x2, int y1, int y2)
	{
		if ((x2 - x1) == 0)
			return Double.POSITIVE_INFINITY;
		else
			return (y2 - y1)/(x2 - x1);
	}
	
	public static double getB(double m, int x, int y)
	{
		if (m == Double.POSITIVE_INFINITY)
			return Double.POSITIVE_INFINITY;
		else
			return y - m * x;
	}
}
