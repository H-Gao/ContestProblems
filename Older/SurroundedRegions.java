import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;


public class SurroundedRegions 
{
	static char[][] table = new char[6][6];
	
	public static void main(String[] args)
	{
		char[] t1 = { 'O', 'O', 'X', 'X', 'X', 'X' };
		char[] t2 = { 'X', 'X', 'X', 'O', 'X', 'X' };
		char[] t3 = { 'X', 'O', 'O', 'X', 'X', 'X' };
		char[] t4 = { 'X', 'O', 'X', 'X', 'O', 'X' };
		char[] t5 = { 'X', 'O', 'X', 'X', 'O', 'X' };
		char[] t6 = { 'X', 'O', 'X', 'X', 'X', 'X' };
		
		table[0] = t1;
		table[1] = t2;
		table[2] = t3;
		table[3] = t4;
		table[4] = t5;
		table[5] = t6;
		
		char[][] newTables = regions(table);
		
		for (int x = 0;x < newTables[0].length;++x)
		{
			for (int y = 0;y < newTables.length;++y)
			{
				System.out.print(newTables[y][x]);
			}
			
			System.out.println();
		}
	}
	
	public static char[][] regions(char[][] table)
	{
		int maxWidth = table[0].length-1;
		int maxHeight = table.length-1;
		
		//Finds the edges of the table.
		for (int i = 0;i < maxWidth;++i)
		{
			findSafeAreas(table, i, 0);
			
			findSafeAreas(table, i, maxHeight);
		}
		
		for (int i = 0;i < maxHeight;++i)
		{
			findSafeAreas(table, 0, i);
			
			findSafeAreas(table, maxWidth, i);
		}
			
		return table;
	}
	
	public static void findSafeAreas(char[][] table, int x, int y)
	{
		//Checks if it is in bounds and if the table is a 'O', if not, it will not countinue.
		if (x < table[0].length && x >= 0 && y < table.length && y >= 0 && table[y][x] == 'O')
		{
			table[y][x]= 'X';
			
			//Searches the area around the position.
			findSafeAreas(table, x+1, y);
			findSafeAreas(table, x-1, y);
			findSafeAreas(table, x, y+1);
			findSafeAreas(table, x, y-1);
		}
	}
}
