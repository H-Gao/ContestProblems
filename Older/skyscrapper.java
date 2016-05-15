import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class skyscrapper 
{
	public static void main(String[] args)
	{
		int fastest = Integer.MAX_VALUE;
		
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt(), k = in.nextInt();
		
		int[] speeds = new int[n];
		
		for (int i = 0;i < n;++i)
			speeds[i] = in.nextInt();
		
		ArrayList<HashMap<Integer, Boolean>> floors = new ArrayList<HashMap<Integer, Boolean>>();
		in.nextLine();
		
		for (int i = 0;i < n;++i)
		{
			String[] a = in.nextLine().split(" ");
			
			for (int b = 0;b < a.length;++b)
				floors.get(i).put(Integer.parseInt(a[b]), true); //Puts the information into a hashmap, for each elevator.
		}
	}
}
