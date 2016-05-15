import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class SudokuChallenge 
{
	static char[][] SudokuGrid;
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		//SudokuGrid in the format char[y][x].
		SudokuGrid = new char[9][9];
		
		//Assumes there will be nine lines, at first.
		for (int i = 0;i < 9;++i)
		{
			//The input.
			String input = in.nextLine();
			
			//If there is only one line.
			if (input.length() > 9)
			{
				int start = 0;
				int end = 9;
				
				//Puts the one line format into the char[][].
				while (end < input.length())
				{
					SudokuGrid[i] = input.substring(start, end).toCharArray();
					
					start += 9;
					end += 9;
					++i;
				}
				
				break;
			}
			//If there is nine lines.
			else
			{
				SudokuGrid[i] = input.toCharArray();
			}
		}
		
		//Gets the subgrids.
		for (int n = 0;n < 1000;++n)
		{
		for (int a = 0;a < 9;a+=3)
			for (int b = 0;b < 9;b+=3)
				subgrid(a, b);
		}
		
		for (int i = 0;i < 9;++i)
		{
			for (int n = 0;n < 9;++n)
			{
				System.out.print(SudokuGrid[i][n]);
			}
			
			System.out.println();
		}
	}
	
	public static void subgrid(int startX, int startY)
	{
		int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		
		Queue<Integer[]> missingLoc = new LinkedList<Integer[]>();
		
		for (int a = startY;a < startY+3;++a)
		{
			//Finds the region nums.
			for (int b = startX;b < startX+3;++b)
			{
				char currentChar = SudokuGrid[a][b];
				
				if (currentChar > '0')
					nums[currentChar - '1'] = -1;
				else
				{
					missingLoc.add(new Integer[]{ a, b });
				}
			}
		}
		
		//Finds all the possible answers for the missing spaces.
		while (!missingLoc.isEmpty())
		{
			Integer[] currentLoc = missingLoc.poll();
			int[] currentNums = nums;
			
			for (int i = 0;i < 9;++i)
			{
				int row = SudokuGrid[currentLoc[0]][i];
				int column = SudokuGrid[i][currentLoc[1]];
				
				if (row > '0')
					currentNums[row - '1'] = -1;
				
				if (column > '0')
					currentNums[column - '1'] = -1;
			}
			
			int flag = 0;
			char num = ' ';
			
			//Checks the row and column.
			for (int i = 0;i < 9;++i)
			{
				if (currentNums[i] != -1)
				{
					++flag;
					
					if (flag > 1)
					{
						break;
					}
					
					num = (char)(currentNums[i]+'0');
				}
			}
			
			if (flag == 1)
			{
				if (currentLoc[0] == 2 && currentLoc[1] == 2)
				{
					System.out.println(num);
				}
				
				SudokuGrid[currentLoc[0]][currentLoc[1]] = num;
			}
		}
	}
}
