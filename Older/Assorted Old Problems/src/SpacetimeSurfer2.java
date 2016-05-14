import java.util.Scanner;
import java.util.Stack;


public class SpacetimeSurfer2 
{
	public static void main(String[] args)
	{
		//The scanner that is able to read the user input.
		Scanner in = new Scanner(System.in);
		
		//The data that has been collected in the format X Y Z.
		String[] input = in.nextLine().split(" ");
		
		//The data that was extracted from the input, it is turned to a int from the metho; toInt(String in).
		int numRow = toInt(input[0]), numColumn = toInt(input[1]), numTime = toInt(input[2]);
		
		//The 3D world.
		char[][][] w = new char[numTime][numColumn][numRow];
		
		//The input will be placed into world.
		for (int i = 0;i < numColumn*numTime;++i)
			w[i/numColumn][i%numColumn] = in.nextLine().toCharArray();
		
		//The 2D world.
		char[][] world = new char[numColumn][numRow];
		
		//The x, y, numSteps and the direction is is facing.
		Stack<Integer[]> pathData = new Stack<Integer[]>();
		
		//Finds the location of A.
		for (int col = 0;col < numColumn;++col)
			for (int row = 0;row < numRow;++row)
				if (world[col][row] == 'A')
					pathData.add(new Integer[]{ row, col, 0});
		
		//Depth-first search.
		
		//Outputs the 2D world.
		for (int col = 0;col < numColumn;++col)
		{
			for (int row = 0;row < numRow;++row)
				System.out.print(world[col][row]);
			
			System.out.println();
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
