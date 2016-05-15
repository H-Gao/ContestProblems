import java.util.Arrays;
import java.util.Scanner;


public class CountingTriangles
{
	//The grid accessable by all methods.
	static char[][] grid;
	
	//Dictates whether or not to erase the line.
	static boolean willReplace = false;
	
	//The amount of triangles.
	static int amountTriangles = 0;
	
	public static void main(String[] args)
	{
		//The scanner object, capable of getting input from the keyboard.
		Scanner in = new Scanner(System.in);
		
		//The length of the square grid.
		int gridLength = Integer.parseInt(in.nextLine());
		
		//The grid containing . and #.
		grid = new char[gridLength][gridLength];
		
		//The input.
		for (int i = 0;i < gridLength;++i)
			grid[i] = in.nextLine().toCharArray();
		
		for (int i = 0;i < gridLength;++i)
		{
			//Will be used to replace the line, after it has all been turned into .
			char[] temp = grid[i].clone();
			
			char[] currentGrid = grid[i];
			
			System.out.println("****" + i);
			
			while (containsTriangles(currentGrid))
			{
				//Counts the maximum number of #, to establish a upper limit.
				int maxLength = getMaxLength(currentGrid);
				
				//Searches for the different lengths.
				for (int n = maxLength;n >= 1;n -= 2)
				{
					String searchFor = "";
					
					for (int a = 0;a < n;++a)
						searchFor += "#";
					
					int start = getIndexOf(currentGrid, searchFor);
					
					//If there is such a String.
					if (start != -1)
					{
						willReplace = false;
						
						findTriangle(n, n, start, i, 1);
						findTriangle(n, n, start, i, -1);
						
						//Using will replace means it can calculate both directions.
						if (willReplace)
						{
							//Sets the first row of the triangle to .
							for (int a = 0;a < maxLength;++a)
								grid[i][start+a] = '.';
						}
					}
				}
			}
			
			grid[i] = temp;
		}
		
		for (int x = 0;x < gridLength;++x)
		{
			for (int y = 0;y < gridLength;++y)
			{
				System.out.print(grid[x][y]);
			}
			
			System.out.println();
		}
	}
	
	public static void findTriangle(int initLength, int length, int x, int y, int direction)
	{
		//Checks to see if it is in bounds.
		if (grid[y][x] == '#' && x >= 0 && x < grid.length && y >= 0 && y < grid.length)
		{
			boolean canPass = true;
			
			for (int i = 0;i < length;++i)
				if (grid[y][x+i] != '#')
					canPass = false;
			
			//If it is part of the triangle.
			if (canPass)
			{
				if (length == 1)
				{
					willReplace = true;
					System.out.println(initLength);
				}
				else
				{
					//Finds a triangle either on top or below this triangle, according to it's length.
					findTriangle(initLength, length-2, x+1, y+direction, direction);
				}
			}
		}
	}
	
	public static int getIndexOf(char[] grid, String find)
	{
		String gridString = "";
		
		for (int i = 0;i < grid.length;++i)
			gridString += grid[i];
		
		return gridString.indexOf(find);
	}
	
	//Needed to make a temp version of grid[].
	//Gets the upper limit of # in a line.
	public static int getMaxLength(char[] grid)
	{
		char[] temp = grid.clone();
		
		int maxLength = 0;
		int gridLength = temp.length;
		
		Arrays.sort(temp);
		
		for (int n = 0;n < gridLength;++n)
		{
			if (temp[n] == '#')
				++maxLength;
			else
				break;
		}
		
		if (maxLength == 1)
			maxLength = 1;
		
		else if ((maxLength-1)%2 != 0)
			--maxLength;
		
		return maxLength;
	}
	
	public static boolean containsTriangles(char[] grid)
	{
		char[] temp = grid.clone();
		Arrays.sort(temp);
		
		if (temp[0] == '#')
			return true;
		else
			return false;
	}
}
