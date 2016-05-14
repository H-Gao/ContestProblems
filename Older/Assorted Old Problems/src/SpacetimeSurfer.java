import java.util.Scanner;


public class SpacetimeSurfer 
{
	/*
	 * The program will travel through the possible paths.
	 * It will look in the other time frames.
	 * It will move in only a single direction; up, down, left or right.
	 * If it comes across two or more paths, it will log the path's location.
	 * Once it reaches the target, or it cannot move in any other direction, it will go to another path.
	 * This countinues until the list of different paths is empty, and the last path finishes.
	 */
	
	static char[][][] world;
	
	static int numRow, numColumn, numTime;
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		String[] numDimensions = in.nextLine().split(" ");
		
		numRow = toInt(numDimensions[0]);
		numColumn = toInt(numDimensions[1]); 
		numTime = toInt(numDimensions[2]);
		
		world = new char[numTime][numColumn][numRow];
		
		//The input will be placed into world.
		for (int i = 0;i < numColumn*numTime;++i)
			world[i/numColumn][i%numColumn] = in.nextLine().toCharArray();
		
		//Finds the location of Alice.
		for (int time = 0;time < numTime;++time)
		{
			for (int col = 0;col < numColumn;++col)
			{
				for (int row = 0;row < numColumn;++row)
				{
					if (world[time][col][row] == 'A')
						findPath(time, col, row, 0, 0);
				}
			}
		}
	}
	
	public static void findPath(int numDimension, int numCol, int numRows, int numSteps, int lastStep)
	{
		//If it does not reach Bob.
		if (world[numDimension][numCol][numRows] != 'B' || numSteps > 20)
		{
			//If it is not null, it will make the function again.
			if (numCol+1 < numColumn && world[numDimension][numCol+1][numRows] != 'X' && lastStep != 2)
			{
				System.out.println("Moved up.");
				findPath(numDimension, numCol+1, numRows, numSteps+1, 1);
			}
				
			if (numCol-1 >= 0 && world[numDimension][numCol-1][numRows] != 'X' && lastStep != 1)
			{
				System.out.println("Moved down.");
				findPath(numDimension, numCol-1, numRows, numSteps+1, 2);
			}
				
			if (numRows+1 < numRow && world[numDimension][numCol][numRows+1] != 'X' && lastStep != 4)
			{
				System.out.println("Moved right.");
				findPath(numDimension, numCol, numRows+1, numSteps+1, 3);
			}
				
			if (numRows-1 >= 0 && world[numDimension][numCol][numRows-1] != 'X' && lastStep != 3)
			{
				System.out.println("Moved left.");
				findPath(numDimension, numCol, numRows-1, numSteps+1, 4);
			}
			else if (lastStep != 5)
			{
				for (int i = 0;i < numTime;++i)
				{
					if (world[i][numCol][numRows] != 'X')
					{
						System.out.println("Changed time.");
						findPath(i, numCol, numRows, numSteps, 5);
					}
				}
			}
			
			System.out.println("Done.");
		}
		//If it reaches Bob.
		else
		{
			System.out.println(numSteps);
		}
	}
	
	public static int toInt(String in)
	{
		int out = 0;
		
		char[] input = in.toCharArray();
		
		for (int i = 0;i < input.length;++i)
		{
			out += (input[i]-'0') * Math.pow(10, input.length - i - 1);
		}
		
		return out;
	}
}
