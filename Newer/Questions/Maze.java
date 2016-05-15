package Questions;

import java.util.ArrayList;
import java.util.Scanner;

public class Maze 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
		
		int N = in.nextInt();
		
		for (int i = 0;i < N;++i)
		{
			arr.add(new ArrayList<Integer>());
			
			int numGates = in.nextInt();
			
			for (int a = 0;a < numGates;++a)
			{
				arr.get(i).add(in.nextInt());
			}
		}
	}
}
