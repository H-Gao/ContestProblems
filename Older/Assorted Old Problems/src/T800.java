import java.util.HashMap;
import java.util.Scanner;


public class T800 
{
	static HashMap<String, Boolean> finishedLoc = new HashMap<String, Boolean>();
	
	static int height;
	static int width;
	
	static int maxSteps;
	
	static char[][] grid;
	
	static int minSteps = 1000;
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		String[] input = in.nextLine().split(" ");
		
		height = Integer.parseInt(input[0]);
		width = Integer.parseInt(input[1]);
		
		maxSteps = Integer.parseInt(input[2]);
		
		grid = new char[height][width];
		
		for (int i = 0;i < height;++i)
			grid[i] = in.nextLine().toCharArray();
		
		int[] loc = new int[2];
		
		for (int i = 0;i < height;++i)
		{
			char[] gridChar = grid[i];
			
			for (int n = 0;n < width;++n)
				if (gridChar[n] == 'T') 
				{ 
					loc[0] = i; loc[1] = n;
					
					//Breaks both loops.
					i = height;
					break;
				}
		}
		
		System.out.println(loc[0] + " " + loc[1]);
		
		int minNum = loc[0] - maxSteps;
		int maxNum = loc[0] + maxSteps + 1;
			
		for (int x = 0;x <= maxSteps;++x)
		{
			for (int y = minNum;y < maxNum;++y)
			{
				int yPos = y;
				
				int xPos = loc[1]+x;
				int xPosNeg = loc[1]-x;
				
				//Checks if it is in bounds, and it is a resting station.
				if ((yPos >= 0 && yPos < height &&
						xPos >= 0 && xPos < width) && (grid[yPos][xPos] == 'R' || grid[yPos][xPos] == 'E'))
					System.out.println(xPos + " " + yPos);
				
				if ((yPos >= 0 && yPos < height &&
						xPosNeg >= 0 && xPosNeg < width) && (grid[yPos][xPosNeg] == 'R' || grid[yPos][xPosNeg] == 'E') && x != 0)
					System.out.println(xPosNeg + " " + yPos);
			}
			
			++minNum;
			--maxNum;
		}
	}
	
	public static void find(int x, int y, int objX, int objY, int numSteps)
	{
		if (x >= 0 && x < width && y >= 0 && y < height && grid[y][x] != '#')
		{
			if (x == objX && y == objY && numSteps < minSteps)
			{
				minSteps = numSteps;
			}
			else if (numSteps < maxSteps)
			{
				for (int i = -1;i <= 1;i += 2)
				{
					find(x+i, y, objX, objY, numSteps+1);
					find(x, y+i, objX, objY, numSteps+1);
				}
			}
		}
	}
}
