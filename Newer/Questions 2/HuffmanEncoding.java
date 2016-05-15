package Questions;

import java.util.Scanner;

public class HuffmanEncoding 
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		Tree t = new Tree(null, null, ' ');
		
		int N = Integer.parseInt(in.nextLine());
		
		for (int i = 0;i < N;++i)
		{
			String[] input = in.nextLine().split(" ");
			
			String binary = input[1];
			
			Tree curr = t;
			
			for (int a = 0;a < binary.length();++a)
			{
				if (binary.charAt(a) == '1')
				{
					if (curr.left == null) 
					{
						curr.left = new Tree(null, null, ' ');
					}
					
					curr = curr.left;
				}
				else if (binary.charAt(a) == '0')
				{
					if (curr.right == null) 
					{
						curr.right = new Tree(null, null, ' ');
					}
					
					curr = curr.right;
				}
			}
			
			curr.val = input[0].charAt(0);
		}
		
		String search = in.nextLine();
		
		Tree curr = t;
		
		for (int i = 0;i < search.length();++i)
		{
			if (search.charAt(i) == '1')
			{
				curr = curr.left;
			}
			else
			{
				curr = curr.right;
			}
			
			if (curr.val != ' ')
			{
				System.out.print(curr.val);
				curr = t;
			}
		}
	}
	
	public static class Tree
	{
		Tree left = null;
		Tree right = null;
		
		char val = ' ';
		
		public Tree(Tree l, Tree r, char v)
		{
			left = l;
			right = r;
			val = v;
		}
	}
}
