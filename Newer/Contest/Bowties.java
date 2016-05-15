package Contest;

import java.util.ArrayList;
import java.util.Scanner;

public class Bowties 
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		ArrayList<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();
		
		int N = in.nextInt();
		
		int[][] max = new int[N][N];
		
		for (int i = 0;i < N;++i)
		{
			int k = in.nextInt();
			
			paths.add(new ArrayList<Integer>());
			
			for (int a = 0;a < k;++a)
			{
				paths.get(i).add(in.nextInt());
			}
		}
	}
}
