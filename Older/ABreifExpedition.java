import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;


public class ABreifExpedition 
{
	//The positions that has already been searched.
	static HashMap<String, Boolean> finished = new HashMap<String, Boolean>();
	
	//The unfinished positions.
	static Stack<Integer[]> pos = new Stack<Integer[]>();
	
	static ArrayList<Integer> steps = new ArrayList<Integer>();
	
	static char[][] mall;
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int numMalls = Integer.parseInt(in.nextLine());
		
		//Puts the input into a char[][] that will represent the mall.
		for (int i = 0;i < numMalls;++i)
		{
			//The number of rows and columns in a String, seperated by a space.
			String[] input = in.nextLine().split(" ");
			
			//The rows and columns.
			int r = Integer.parseInt(input[0]), c = Integer.parseInt(input[1]);
			
			//The grid.
			mall = new char[r][c];
			
			boolean foundCar = false;
			
			//Puts the rows of c characters into the grid.
			for (int n = 0;n < r;++n)
			{
				String inputMall = in.nextLine();
				mall[n] = inputMall.toCharArray();
				
				if (!foundCar)
				{
					int indexOf = inputMall.indexOf('C');
					
					if (indexOf != -1)
					{
						foundCar = true;
						find(inputMall.indexOf('C'), n, r, c);
					}
				}
			}
		}
	}
	
	public static void find(int x, int y, int numRows, int numColumns)
	{
		int numSteps = 0;
		
		pos.add(new Integer[]{ y, x, numSteps });
		
		while (!pos.isEmpty())
		{
			Integer[] pulled = pos.pop();
			
			y = pulled[0];
			x = pulled[1];
			numSteps = pulled[2];
			
			char currentChar = mall[y][x];
			
			if (finished.get(x + " " + y) == null && currentChar != '#')
			{
				System.out.println(y + " " + x);
				
				//Searches the surrounding spaces.
				for (int n = -1;n <= 1;n += 2)
				{
					int locX = x+n, locY = y+n;
						
					System.out.println(locY + " " + locX);
						
					if (locX < numColumns && locX >= 0 && locY < numRows && locY > numColumns)
					{
						pos.add(new Integer[]{ locY, x, numSteps+1 });
						pos.add(new Integer[]{ y, locX, numSteps+1 });
					}
				}
				
				if (currentChar == 'S')
				{
					System.out.println(y + " " + x);
					steps.add(numSteps);
				}
				
				finished.put(x + " " + y, true);
			}
		}
	}
}
