import java.util.LinkedList;
import java.util.Queue;

public class queue 
{
	public static void main(String[] args)
	{
		Queue<Integer> q = new LinkedList<Integer>();
		
		for (int i = 0;i != 100;++i)
		{
			q.add(i);
		}
		
		while (!q.isEmpty())
			System.out.println(q.poll());
	}
}
