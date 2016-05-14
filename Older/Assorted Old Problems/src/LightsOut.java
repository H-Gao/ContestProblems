import java.util.Scanner;


public class LightsOut 
{
	static int numRows;
	static int numCol;
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int numCases = 2;
		
		int[] t = new int[numCases];
		
		for (int cases = 0;cases < numCases;++cases)
		{
			String[] numColRow = in.nextLine().split(" ");
			
			int total = 0;
		
			numRows = Integer.parseInt(numColRow[1]);
			numCol = Integer.parseInt(numColRow[0]);
		
			char[][] table = new char[numCol][numRows];
			
			//Reads the input for the table.
			for (int i = 0;i < numCol;++i)
			{
				String input = in.nextLine();
				
				table[i] = input.toCharArray();
			}
			
			while (true)
			{
				//locOnTable[0] = xPos, locOnTable[1] = yPos.
				int[] locOnTable = new int[2];
		
				//The maximum number of lights, turned off.
				int numHighest = 0;
			
				for (int y = 0;y < numCol;++y)
				{
					for (int x = 0;x < numRows;++x)
					{
						int numTurnedOff = checkTurnOff(table, x, y);
					
						if (numTurnedOff > numHighest)
						{
						locOnTable[0] = x;
						locOnTable[1] = y;
						
						numHighest = numTurnedOff;
						}
					}
				}
		
				if (numHighest == 0)
				{
					break;
				}
				else
				{
					++total;
					table = turnOff(table, locOnTable[0], locOnTable[1]);
				}
			}
		
			t[cases] = total;
		}
		
		for (int i = 0;i < numCases;++i)
		{
			System.out.println(t[i]);
		}
	}
	
	//Checks the number of inputs in a given point.
	public static int checkTurnOff(char[][] table, int x, int y)
	{
		int out = 0;
		
		for (int i = -1;i < 2;++i)
		{
			for (int n = -1;n < 2;++n)
			{
				//Checks to see if there the location is not out of bounds. Ex. x = -20, y = 10000.
				//Also checks to see if the valid location, is a '1'. If so, it turns off.
				if ((i != n && i != (-n) && (y+i) >= 0 && (y+i) < numCol && (x+n) >= 0 && (x+n) < numRows && 
					table[y+i][x+n] == '1') || i == 0 && n == 0 && y >= 0 && y < numCol && x >= 0 && x < numRows &&
					table[y][x] == '1')
				{
					++out;
				}
			}
		}
		
		return out;
	}
	
	public static char[][] turnOff(char[][] t, int x, int y)
	{
		char[][] table = t;
		
		for (int i = -1;i < 2;++i)
		{
			for (int n = -1;n < 2;++n)
			{
				if ((i != n && i != (-n) && (y+i) >= 0 && (y+i) < numCol && (x+n) >= 0 && (x+n) < numRows) 
					|| i == 0 && n == 0 && y >= 0 && y < numCol && x >= 0 && x < numRows)
				{
					table[y+i][x+n] = '0';
				}
			}
		}
		
		return table;
	}
}
