package Questions;

import java.awt.Point;
import java.util.Scanner;
import java.util.Stack;

public class Maze2
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		int t = Integer.parseInt(in.nextLine());
		
		for (int i = 0;i < t;++i)
		{
			int numRows = Integer.parseInt(in.nextLine());
			int numColumns = Integer.parseInt(in.nextLine());
			
			char[][] original = new char[numRows][numColumns];
			int[][] val = new int[numRows][numColumns];
			
			for (int y = 0;y < numRows;++y)
			{
				original[y] = in.nextLine().toCharArray();
			}
			
			for (int y = 0;y < numRows;++y)
			{
				for (int x = 0;x < numColumns;++x)
				{
					val[y][x] = Integer.MAX_VALUE;
				}
			}
			
			Stack<Point> dfs = new Stack<Point>();
			Stack<Integer> vals = new Stack<Integer>();
			
			dfs.add(new Point(0, 0));
			vals.add(1);
			
			while (!dfs.isEmpty())
			{
				Point popped = dfs.pop();
				int value = vals.pop();
				
				int x = popped.x;
				int y = popped.y;
				
				if (x >= 0 && x < numColumns && y >= 0 && y < numRows)
				{
					if (value < val[y][x])
					{
						if (original[y][x] == '+')
						{
							dfs.add(new Point(x + 1, y));
							dfs.add(new Point(x - 1, y));
							dfs.add(new Point(x, y + 1));
							dfs.add(new Point(x, y - 1));
							
							for (int n = 0;n < 4;++n)
							vals.add(value + 1);
							
							val[y][x] = value;
						}
						else if (original[y][x] == '-')
						{
							dfs.add(new Point(x + 1, y));
							dfs.add(new Point(x - 1, y));
							
							for (int n = 0;n < 2;++n)
							vals.add(value + 1);
							
							val[y][x] = value;
						}
						else if (original[y][x] == '|')
						{
							dfs.add(new Point(x, y + 1));
							dfs.add(new Point(x, y - 1));
							
							for (int n = 0;n < 2;++n)
							vals.add(value + 1);
							
							val[y][x] = value;
						}
					}
				}
			}
			
			if (val[numRows-1][numColumns-1] == Integer.MAX_VALUE)
			{
				System.out.println(-1);
			}
			else
			{
				System.out.println(val[numRows-1][numColumns-1]);
			}
		}
	}
	
	public static class Point
	{
		int x;
		int y;
		
		public Point (int x, int y)
		{
			this.x = x;
			this.y = y;
		}
	}
}
