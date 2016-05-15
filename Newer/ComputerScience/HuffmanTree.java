package ComputerScience;

import java.util.PriorityQueue;

public class HuffmanTree 
{
	public static void main(String args[])
	{
		String input = "ABCJAWDNIABCUAWBUVBAWCUBAUWWBCUCBIUWBACBUWABUFBOWBNDFOW";
		
		//Frequency for each char.
		int[] freq = new int[200];
		
		char[] in = input.toCharArray();
		
		for (int i = 0;i < in.length;++i)
		{
			int val = in[i];
			++freq[val];
		}
		
		PriorityQueue<TreeNode> q = new PriorityQueue<TreeNode>();
		
		for (int i = 0;i < freq.length;++i)
		{
			if (freq[i] != 0)
			{
				q.add(new TreeNode(null, null, freq[i]));
			}
		}
		
		while (!q.isEmpty())
		{
			TreeNode s1 = q.poll();
			TreeNode s2 = q.poll();
			
			TreeNode s3 = new TreeNode(s2, s1, s1.value + s2.value);
		}
	}
	
	public static class TreeNode implements Comparable<TreeNode>
	{
		int value;
		
		TreeNode left;
		TreeNode right;
		
		public TreeNode(TreeNode l, TreeNode r, int val)
		{
			value = val;
			
			left = l;
			right = r;
		}

		public int compareTo(TreeNode o) 
		{
			if (o.value > value)
			{
				return -1;
			}
			else if (o.value < value)
			{
				return 1;
			}
			else
			{
				return 0;
			}
		}
	}
}
