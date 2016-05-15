package ComputerScience;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class PatternGenerator 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int n = 5;
		int k = 3;
	}
	
	public static void output(int prev, int n)
	{
		String out = "";
		
		for (int i = 0;i < n;++i)
		{
			out += (prev>>i) & 1;
		}
		
		System.out.println(out);
	}
}
