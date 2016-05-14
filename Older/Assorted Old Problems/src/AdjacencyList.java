import java.util.ArrayList;


public class AdjacencyList 
{
	ArrayList<ArrayList<Integer> > v = new ArrayList<ArrayList<Integer>>();
	
	public AdjacencyList()
	{
	}
	
	public static void main(String[] args)
	{
		AdjacencyList list = new AdjacencyList();
	}
	
	public void createVertex()
	{
		ArrayList<Integer> e = new ArrayList<Integer>();
		v.add(e);
	}
	
	public void addEdge(int in, int index)
	{
		v.get(index).add(in);
	}
	
	public void printAll()
	{
		for (int i = 0;i < v.size();++i)
		{
			String t = "";
			
			for (int n = 0;n < v.get(i).size();++n)
			{
				t += v.get(i).get(n) + " ";
			}
			
			System.out.println(v.get(i) + ": " + t);
		}
	}
}
