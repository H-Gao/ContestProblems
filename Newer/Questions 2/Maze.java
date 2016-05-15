package Questions;

import java.awt.Point;
import java.util.Scanner;
import java.util.Stack;

public class Maze 
{
	static boolean[][] visited;
	
	static int numRows;
	static int numColumns;
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		int t = Integer.parseInt(in.nextLine());
		
		for (int i = 0;i < t;++i)
		{
			numRows = Integer.parseInt(in.nextLine());
			numColumns = Integer.parseInt(in.nextLine());
			
			char[][] original = new char[numRows][numColumns];
			visited = new boolean[numRows][numColumns];
			
			for (int y = 0;y < numRows;++y)
			{
				original[y] = in.nextLine().toCharArray();
			}
			
			Stack<PointX> dfs = new Stack<PointX>();
			
			dfs.add(new PointX(0, 0, false));
			
			int minimum = Integer.MAX_VALUE;
			
			int num = 0;
			
			while (!dfs.isEmpty())
			{
				PointX point = dfs.peek();
				
				int x = point.x;
				int y = point.y;
				boolean used = point.used;
				
				if (used)
				{
					--num;
					
					dfs.pop();
					visited[y][x] = false;
				}
				else
				{
					if (!(x == numColumns-1 && y == numRows-1))
					{
						if (inBounds(x+1, y) && original[y][x+1] != '*' && original[y][x] != '|')
						{
							dfs.add(new PointX(x+1, y, false));
						}
						if (inBounds(x-1, y) && original[y][x-1] != '*' && original[y][x] != '|')
						{
							dfs.add(new PointX(x-1, y, false));
						}
						if (inBounds(x, y+1) && original[y+1][x] != '*' && original[y][x] != '-') 
						{
							dfs.add(new PointX(x, y+1, false));
						}
						if (inBounds(x, y-1) && original[y-1][x] != '*' && original[y][x] != '-')
						{
							dfs.add(new PointX(x, y-1, false));
						}
					}
					
					++num;
					point.used = true;
					visited[y][x] = true;
				}
				
				if (x == numColumns-1 && y == numRows-1)
				{
					if (minimum > num) minimum = num;
					
					--num;
					dfs.pop();
					visited[y][x] = false;
				}
				
				if (num > minimum)
				{
					--num;
					dfs.pop();
					visited[y][x] = false;
				}
			}
			
			if (minimum == Integer.MAX_VALUE) System.out.println(-1);
			else System.out.println(minimum);
		}
	}
	
	public static boolean inBounds(int x, int y)
	{
		if (x >= 0 && x < numColumns && y >= 0 && y < numRows && !visited[y][x])
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static class PointX
	{
		int x;
		int y;
		boolean used;
		
		public PointX (int x, int y, boolean used)
		{
			this.x = x;
			this.y = y;
			this.used = used;
		}
	}
}
