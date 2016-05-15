import java.util.PriorityQueue;
import java.util.Scanner;


public class HFTree 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		int n = in.nextInt();
		int tot = 0;
		
		for (int i = 0;i < n;++i) pq.add(in.nextInt());
		
		while (pq.size() > 1)
		{
			int po1 = pq.poll(), po2 = pq.poll();
			int sum = po1 + po2;
			
			tot += sum;
			pq.add(sum);
		}
		
		System.out.println(tot);
		
		//2469, 3083
	}
}
