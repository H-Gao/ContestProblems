import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;


public class Friends 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int numInteractions = Integer.parseInt(in.nextLine());
		
		ArrayList<ArrayList<Integer>> inter = new ArrayList<ArrayList<Integer>>();
		
		HashMap<String, Integer> conv = new HashMap<String, Integer>();
		
		int flag = 0;
		for (int i = 0;i < numInteractions;++i)
		{
			String input = in.nextLine();
			
			//Extracts the input.
			int indexOf = input.indexOf(' ')+1;
			String[] nums = { input.substring(0, indexOf-1), input.substring(indexOf, input.length()) };
			
			//Gets a unique number.
			for (int n = 0;n < 2;++n) if (conv.get(nums[n]) == null)
			{
				conv.put(nums[n], flag);
				++flag;
			}
			
			//Puts the corresponding amount of ArrayLists.
			while (inter.size() < flag)
				inter.add(new ArrayList<Integer>());
			
			//Makes the interaction.
			inter.get(conv.get(nums[0])).add(conv.get(nums[1]));
		}
		
		String input;
		while (!(input = in.nextLine()).equals("0 0"))
		{
			//Extracts the input.
			int indexOf = input.indexOf(' ')+1;
			int[] nums = { Integer.parseInt(input.substring(0, indexOf-1))-1, Integer.parseInt(input.substring(indexOf, input.length()))-1 };
			
			System.out.println(getCircle(in, nums, inter));
		}
	}
	
	public static String getCircle(Scanner in, int[] nums, ArrayList<ArrayList<Integer>> inter)
	{
		Stack<Integer[]> dps = new Stack<Integer[]>();
			
		dps.add(new Integer[]{ nums[0], 0 });
		while (!dps.isEmpty())
		{
			Integer[] popped = dps.pop();
				
			if (popped[0] == nums[1])
				return "Yes " + (popped[1]-1);
				
			else if (popped[0] == nums[0] && popped[1] != 0) break;
				
			ArrayList<Integer> getInter = inter.get(popped[0]);
			int currentNum = popped[1];
				
			for (Integer i : getInter)
				dps.add(new Integer[]{ i, currentNum+1 });
		}
		
		return "No";
	}
}
