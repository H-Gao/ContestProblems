package Questions;

import java.util.Scanner;

public class Spreadsheet 
{
	static String[][] spreadsheet = new String[10][9];
	static int[][] out = new int[10][9];
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		for (int y = 0;y < 10;++y)
		{
			spreadsheet[y] = in.nextLine().split(" ");
		}
		
		for (int y = 0;y < 10;++y)
		{
			for (int x = 0;x < 9;++x)
			{
				out[y][x] = -1;
			}
		}
		
		for (int y = 0;y < 10;++y)
		{
			for (int x = 0;x < 9;++x)
			{
				out[y][x] = f(spreadsheet[y][x], 0);
				
				for (int a = 0;a < 10;++a)
				{
					for (int b = 0;b < 9;++b)
					{
						String output = out[a][b] + "";				
						if (out[a][b] < 0) output = "*";
						
						if (x != 9) System.out.print(output + " ");
						else System.out.print(output);
					}
					
					System.out.println();
				}
			}
		}
		
		for (int y = 0;y < 10;++y)
		{
			for (int x = 0;x < 9;++x)
			{
				String output = out[y][x] + "";				
				if (out[y][x] < 0) output = "*";
				
				if (x != 9) System.out.print(output + " ");
				else System.out.print(output);
			}
			
			System.out.println();
		}
	}
	
	public static int f(String in, int expire)
	{
		++expire;
		
		if (expire > 120)
		{
			return -99999;
		}
		
		try
		{
			return Integer.parseInt(in);
		}
		catch (Exception e)
		{
			String[] cells = in.split("\\+");
			
			if (cells.length == 1)
			{
				int y = -1;
				int x = Integer.parseInt(cells[0].substring(1, cells[0].length()))-1;
				
				switch (cells[0].charAt(0))
				{
					case 'A': y = 0; break;
					case 'B': y = 1; break;
					case 'C': y = 2; break;
					case 'D': y = 3; break;
					case 'E': y = 4; break;
					case 'F': y = 5; break;
					case 'G': y = 6; break;
					case 'H': y = 7; break;
					case 'I': y = 8; break;
					case 'J': y = 9; break;
				}
				
				if (out[y][x] != -1) return out[y][x];
				return f(spreadsheet[y][x], expire);
			}
			else
			{
				int output = 0;
				
				for (int i = 0;i < cells.length;++i)
				{
					output += f(cells[i], expire);
				}
				
				return output;
			}
		}
	}
}
