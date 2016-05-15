import java.util.ArrayList;
import java.util.Scanner;


public class RoadmapTracking 
{
	static ArrayList<ArrayList<Integer>> r = new ArrayList<ArrayList<Integer>>();
	static boolean[] hasFound;
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		String[] input = in.nextLine().split(" ");
		int n = Integer.parseInt(input[0]), m = Integer.parseInt(input[1]);
		
		hasFound = new boolean[n];
		
		for (int i = 0;i < n;++i) r.add(new ArrayList<Integer>());
			
		for (int c = 0;c < m;++c)
		{
			input = in.nextLine().split(" ");
			int a = Integer.parseInt(input[0])-1, b = Integer.parseInt(input[1])-1;
			
			r.get(a).add(b);
			r.get(b).add(a);
		}	
		
		//Finds 1 from n.
		findTarget(0, -1, n-1);
	
		System.out.println("No.");
	}
	
	public static void findTarget(int a, int last, int en)
	{
		if (hasFound[a] == true)
		{
			System.out.println("Yes.");
			System.exit(0);
		}
		else if (a == en)
			hasFound[en] = true;
		else
		{
			hasFound[a] = true;
			ArrayList<Integer> currentR = r.get(a);
			
			for (int i = 0;i < currentR.size();++i)
				if (currentR.get(i) != last)
					findTarget(currentR.get(i), a, en);
		}
	}
}
