import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;


public class depthfirstsearch 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int num = Integer.parseInt(in.nextLine());
		int numberList = Integer.parseInt(in.nextLine());
		
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		
		for (int i = 0;i < numberList;++i)
		{
			String[] a = in.nextLine().split(" ");
			
			list.get(Integer.parseInt(a[0])).add(Integer.parseInt(a[1]));
			list.get(Integer.parseInt(a[1])).add(Integer.parseInt(a[0]));
		}
		
		Stack<Integer> st = new Stack<Integer>();
	}
}
