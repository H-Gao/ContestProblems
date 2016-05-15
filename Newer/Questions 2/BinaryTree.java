package Questions;

public class BinaryTree 
{
	static Node startNode;
	
	public static void main(String args[])
	{
		startNode = new Node(10, null, null);
	}
	
	public static class Node
	{
		int val;
		
		Node left;
		Node right;
		
		public Node(int v, Node l, Node r)
		{
			val = v;
			left = l;
			right = r;
		}
	}
	
	public void AddNode()
	{
		
	}
}
