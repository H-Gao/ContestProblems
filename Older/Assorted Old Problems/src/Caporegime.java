import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Caporegime 
{
	static ArrayList<ArrayList<Integer>> s = new ArrayList<ArrayList<Integer>>();
	static Queue<Integer> remaining = new LinkedList<Integer>();
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		//The number of recruits and the number of grudges among them.
		String[] basicInformation = in.nextLine().split(" ");
		
		//While decoding the input, the input must be used as i-1.
		int numRecruits = Integer.parseInt(basicInformation[0]);
		int numGrudges = Integer.parseInt(basicInformation[1]);
		
		for (int i = 0;i < numRecruits;++i)
		{
			s.add(new ArrayList<Integer>());
		}
		
		for (int i = 0;i<numGrudges;++i)
		{
			String[] input = in.nextLine().split(" ");
			
			int x = Integer.parseInt(input[0])-1;
			int y = Integer.parseInt(input[1])-1;
			
			s.get(x).add(y);
			s.get(y).add(x);
		}
		
		int[] sizes = new int[numRecruits];
		
		for (int i = 0;i < numRecruits;++i)
		{
			sizes[i] = s.get(i).size();
		}
		
		Arrays.sort(sizes);
		
		String alreadyDone = "";
		
		for (int i = numRecruits-1;i >= 0;--i)
		{
			for (int n = 0;n < numRecruits;++n)
			{
				if (s.get(n).size() == sizes[i] && !alreadyDone.contains(n+""))
				{
					remaining.add(n);
					alreadyDone += n + " ";
					break;
				}
			}
		}
		
		ArrayList<ArrayList<Integer>> groupHolder = new ArrayList<ArrayList<Integer>>();
		
		//Runs until there is noone left in remaining.
		while (!remaining.isEmpty())
		{
			//The group.
			ArrayList<Integer> group = new ArrayList<Integer>();
			
			//Adds a new member to a group, so it will always work.
			group.add(remaining.poll());
			
			//The amount of number that must be gone through.
			int size = remaining.size();
			
			//Checks which remaining numbers can be put into a group.
			for (int i = 0;i < size;++i)
			{
				//The new soldier.
				int soldier = remaining.poll();
				
				//Stores whether or not the new soldier can join.
				boolean canBeWith = true;
				
				//Checks if any of the members inside a group, has a grudge against the new soldier.
				for (int n = 0;n < group.size();++n)
				{
					//If one or more cannot be with them, they cannot be in that group.
					if (!canBeWith(group.get(n), soldier))
					{
						//System.out.println((n+1) + " cannot be with " + (soldier+1));
						
						canBeWith = false;
						break;
					}
				}
				
				//If none of the members already inside that group has no grudge, then the soldier can join.
				if (canBeWith)
				{
					group.add(soldier);
				}
				else
				{
					remaining.add(soldier);
				}
			}
			
			//Holds this group for further use.
			groupHolder.add(group);
		}
		
		//Outputs the number of groups needed.
		System.out.print(groupHolder.size());
		
		//Goes through all the groups, which are stored in the groupHolder.
		for (ArrayList<Integer> gh : groupHolder)
		{
			System.out.print("\n");
			
			//Goes through all the integers, inside the groupHolder.
			for (int i = 0;i < gh.size();++i)
			{
				//Outputs one without the space, if it is the last one.
				if (i == gh.size()-1)
					System.out.print((int)(gh.get(i)+1));
				//Outputs one with the space, if it is not the last one.
				else
					System.out.print((int)(gh.get(i)+1) + " ");
			}
		}
	}
	
	public static boolean canBeWith(int a, int b)
	{
		if (s.get(a).contains(b))
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	public static void outputAll(ArrayList<ArrayList<Integer>> s)
	{
		for (int i = 0;i<s.size();++i)
		{
			System.out.println(s.get(i));
		}
	}
}
