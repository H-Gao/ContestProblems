package Questions;

import java.util.LinkedList;

public class TrieTree 
{
	char val;
	LinkedList<TrieTree> child;
	
	public TrieTree(char v, TrieTree c)
	{
		val = v;
		child = new LinkedList<TrieTree>();
	}
	
	public void add(char v, TrieTree c)
	{
		child.add(new TrieTree(v, null));
	}
	
	public static void main(String args[])
	{
		TrieTree base = new TrieTree('1', null);
	}
}
