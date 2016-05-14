import java.util.PriorityQueue;


public class HFTreeNode implements Comparable<HFTreeNode>
{
	int weight;
	int parent = -1;
	int leftKid = -1;
	int rightKid = -1;
	int ind;
	
	String str = "ABCDE";
	int[] freq = { 15, 7, 6, 6, 5 };
	int m = freq.length;
	
	PriorityQueue<HFTreeNode> pq = new PriorityQueue<HFTreeNode>();
	int root = 2*m-2;
	
	HFTreeNode[] hf = new HFTreeNode[2*m-1];
	
	public int compareTo(HFTreeNode o) 
	{
		return this.weight - o.weight;
	}
	
	public HFTreeNode(int w, int in)
	{
		weight = w;
		ind = in;
	}
	
	public HFTreeNode() {}
	
	public void buildTree()
	{
		int index = 0;
		
		for (;index < m;++index)
		{
			hf[index] = new HFTreeNode(freq[index], index);
			pq.add(hf[index]);
		}
		
		index = 0;
		
		while (pq.size() > 1)
		{
			HFTreeNode hf1 = pq.poll();
			HFTreeNode hf2 = pq.poll();
			
			hf[index] = new HFTreeNode(hf[index].weight + hf2.weight, index);
			hf[index].leftKid = hf1.ind;
			hf[index].rightKid = hf2.ind;
			hf1.parent = index;
			hf2.parent = index;
			pq.add(hf[index]);
			++index;
		}
	}
	
	String path = "";
	
	public void traverseTree(HFTreeNode tn)
	{
		if (tn.leftKid == 1 && tn.rightKid == 1)
		{
			System.out.println(path);
			return;
		}
		
		path += "0";
		traverseTree(hf[tn.leftKid]);
		path = path.substring(0, path.length()-1) + "1";
		
		traverseTree(hf[tn.rightKid]);
		path = path.substring(0, path.length()-1);
	}
	
	public static void main(String[] args)
	{
		HFTreeNode hfn = new HFTreeNode();
		
		hfn.buildTree();
		hfn.traverseTree(hfn.hf[hfn.root]);
	}
}
