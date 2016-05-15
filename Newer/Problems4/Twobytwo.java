package Problems4;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Twobytwo 
{
	static HashMap<String, Boolean> reoccur = new HashMap<String, Boolean>();
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		HashMap<Integer, LinkedList<Integer>> results = new HashMap<Integer, LinkedList<Integer>>();
		
		//The square is a x a.
		int a = in.nextInt();
		
		generateStart(a);
	}
	
	public static void generateStart(int a)
	{
		String start = "";
		
		for (int i = 0;i < a;++i)
		{
			start += "1";
		}
		
		//f (start);
	}
	
	public static boolean isValid(LinkedList<Integer> s)
	{
		int numZeroes = 0;
		
		for (int i = 0;i < s.size();++i)
		{
			if (s.get(i) == 0)
			{
				++numZeroes;
			}
			else if (s.get(i) == 1)
			{
				if (numZeroes%2==0) numZeroes = 0;
				
				else return false;
			}
		}
		
		return true;
	}
}
