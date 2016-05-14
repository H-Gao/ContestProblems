import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class adjacencyMatrix 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		//The amount of rows and columns. (numRows == numColumns).
		int n = Integer.parseInt(in.nextLine());
		
		//The amount of entries by the user.
		int m = Integer.parseInt(in.nextLine());
		
		/*int[][] mat = new int[n+1][n+1];
		
		for (int i = 0;i < m;++i)
		{
			String input = in.nextLine();
			
			int x = Integer.parseInt(input.split(" ")[0]);
			int y = Integer.parseInt(input.split(" ")[1]);
			
			mat[x][y] = 1; 
			mat[y][x] = 1; 
		}*/
		
		ArrayList<ArrayList<Integer>> hm = new ArrayList<ArrayList<Integer>>();
		
		for (int i = 0;i < n+1;++i)
			hm.add(new ArrayList<Integer>());
		
		for (int i = 0;i < m;++i)
		{
			String input = in.nextLine();
			
			int x = Integer.parseInt(input.split(" ")[0]);
			int y = Integer.parseInt(input.split(" ")[1]);
			
			hm.get(x).add(y);
			hm.get(y).add(x);
		}
		
		/*//Displays the graph.
		System.out.print(" ");
		
		for (int i = 0;i < n+1;++i)
		{
			System.out.print(i);
		}
		
		for (int y = 0;y < n+1;++y)
		{
			System.out.print("\n" + y);
			
			for (int x = 0;x < n+1;++x)
			{
				System.out.print(mat[x][y]);
			}
		}*/
		
		for (int y = 0;y < hm.size();++y)
		{
			System.out.println(hm.get(y));
		}
	}
}
