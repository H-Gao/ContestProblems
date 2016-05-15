package Questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class FloorPlan 
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		ArrayList<Integer> rooms = new ArrayList<Integer>();
		
		int numTiles = Integer.parseInt(in.nextLine());
		
		int numRows = Integer.parseInt(in.nextLine());
		int numColumns = Integer.parseInt(in.nextLine());
		
		boolean[][] grids = new boolean[numRows][numColumns];
		
		for (int y = 0;y < numRows;++y)
		{
			String line = in.nextLine();
			
			for (int x = 0;x < numColumns;++x)
			{
				if (line.charAt(x) == '.')
				{
					grids[y][x] = true;
				}
			}
		}
		
		for (int y = 0;y < numRows;++y)
		{
			for (int x = 0;x < numColumns;++x)
			{
				int roomTiles = 0;
				
				Point start = new Point(x, y);
				
				Stack<Point> s = new Stack<Point>();
				s.add(start);
				
				while (!s.isEmpty())
				{
					Point popped = s.pop();
					
					if (popped.y >= 0 && popped.y < numRows && popped.x >= 0 && popped.x < numColumns)
					{
						if (grids[popped.y][popped.x])
						{
							grids[popped.y][popped.x] = false;
							++roomTiles;
							
							s.add(new Point(popped.x + 1, popped.y));
							s.add(new Point(popped.x - 1, popped.y));
							s.add(new Point(popped.x, popped.y + 1));
							s.add(new Point(popped.x, popped.y - 1));
						}
					}
				}
				
				if (roomTiles > 0)
				{
					rooms.add(roomTiles);
				}
			}
		}
		
		Collections.sort(rooms);
		
		int filledRooms = 0;
		
		for (int i = rooms.size()-1;i >= 0;--i)
		{
			int roomSize = rooms.get(i);
			
			if (numTiles >= roomSize)
			{
				++filledRooms;
				numTiles -= roomSize;
			}
			else
			{
				break;
			}
		}
		
		System.out.println(filledRooms + " rooms, " + numTiles + " square metre(s) left over");
	}
	
	public static class Point
	{
		int x = 0;
		int y = 0;
		
		public Point(int x, int y)
		{
			this.x = x;
			this.y = y;
		}
	}
}
