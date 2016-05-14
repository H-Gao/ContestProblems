import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;


public class LinkedListGraph 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		HashMap<Integer, LinkedList<Integer>> nh = new HashMap<Integer, LinkedList<Integer>>();
		
		int nodes = Integer.parseInt(in.nextLine()), lines = Integer.parseInt(in.nextLine());
		
		for (int i = 0;i < lines;++i)
		{
			String[] input = in.nextLine().split(" ");
			int key = Integer.parseInt(input[0]);
					
			if (nh.get(key) == null) nh.put(key, new LinkedList<Integer>());
			nh.get(key).add(Integer.parseInt(input[1]));
		}
		
		for (int i = 1;i <= nodes;++i)
			for (int n = 1;n <= nodes;++n)
				if (i != n && (nh.get(i) != null && !nh.get(i).contains(n)) || nh.get(i) == null) System.out.println(n);
	}
}
