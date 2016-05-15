package Questions;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class Sequence 
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int N = Integer.parseInt(in.nextLine());
		
		String str = in.nextLine();
		 
		Stack<Character> a = new Stack<Character>();
		
		for (int i = 0;i < N;++i)
		{
			char currChar = str.charAt(i);
			
			if (!a.isEmpty() && a.peek() != null && a.peek() == currChar)
			{
				a.pop();
			}
			else
			{
				a.add(currChar);
			}
		}
		
		for (int i = 0;i < a.size();++i)
		{
			System.out.print(a.get(i));
		}
	}
}
