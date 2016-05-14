import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class KingDefense 
{
	static int numFound = 0;
	
	static HashMap<Integer, Boolean> finishedPaths = new HashMap<Integer, Boolean>();
	static ArrayList<ArrayList<Integer>> path = new ArrayList<ArrayList<Integer>>();
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		String[] input = in.nextLine().split(" ");
		
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		
		for (int i = 0;i < n;++i)
			path.add(new ArrayList<Integer>());
		
		for (int i = 0;i < m;++i)
		{
			input = in.nextLine().split(" ");
			
			int a = Integer.parseInt(input[0])-1;
			int b = Integer.parseInt(input[1])-1;
			
			path.get(a).add(b);
			path.get(b).add(a);
		}
		
		findPath(1, 2);
		
		System.out.println(numFound);
	}
	
	public static void findPath(int currentVal, int findVal)
	{
		if (currentVal == findVal)
		{
			++numFound;
		}
		else
		{
			if (finishedPaths.get(currentVal) == null)
			{
				finishedPaths.put(currentVal, true);
				
				for (int i : path.get(currentVal))
				{
					findPath(i, findVal);
				}
			}
		}
	}
}
