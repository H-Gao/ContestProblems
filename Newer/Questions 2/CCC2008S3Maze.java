package Questions;

import java.util.Scanner;

public class CCC2008S3Maze
{
    static char[] [] maze;
    static int[] [] grid;
    static int row, col;
    
    static int num = 0;

    public static void traverse (int r, int c, int x)
    {
    	++num;
    	
	if (r >= 0 && r < row && c >= 0 && c < col)
	    if (grid [r] [c] >= 0 && x < grid [r] [c])
		if (maze [r] [c] == '*')
		    grid [r] [c] = -1;
	
		else if (maze [r] [c] == '+')
		{
		    grid [r] [c] = x;
		    traverse (r - 1, c, x + 1);
		    traverse (r + 1, c, x + 1);
		    traverse (r, c - 1, x + 1);
		    traverse (r, c + 1, x + 1);
		}
		else if (maze [r] [c] == '|')
		{
		    grid [r] [c] = x;
		    traverse (r - 1, c, x + 1);
		    traverse (r + 1, c, x + 1);
		}
		else if (maze [r] [c] == '-')
		{
		    grid [r] [c] = x;
		    traverse (r, c - 1, x + 1);
		    traverse (r, c + 1, x + 1);
		}
    }


    public static void main (String[] args)
    {
       Scanner in = new Scanner(System.in);
        
		int t;
		t = Integer.parseInt(in.nextLine());
		
		for (int k = 0 ; k < t ; k++)
		{
		    row = Integer.parseInt(in.nextLine());
		    col = Integer.parseInt(in.nextLine());
		    maze = new char [row] [col];
		    grid = new int [row] [col];
		    
		    for (int i = 0 ; i < row ; i++)
			    maze [i] = in.nextLine().toCharArray();
		    
		    for (int i = 0 ; i < row ; i++)
			for (int j = 0 ; j < col ; j++)
			    grid [i] [j] = 99999;
		    traverse (0, 0, 1);
		    
		    if (grid [row - 1] [col - 1] > 0 && grid [row - 1] [col - 1] < 99999)
		    	System.out.println (grid [row - 1] [col - 1]);
		    else
		    	System.out.println (-1);
		    
		    System.out.println("******" + num);
		}
    }
}


