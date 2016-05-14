import java.util.Arrays;
import java.util.Scanner;


public class largestFlow 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int numCases = in.nextInt();
	
		for (int i = 0;i < numCases;++i)
		{
			int numFlows = in.nextInt();
			
			int[] flow = new int[numFlows];
			
			for (int n = 0;n < numFlows;++n)
			{
				flow[n] = in.nextInt();
			}
			
			Arrays.sort(flow);
			
			System.out.println(flow[flow.length-1]);
		}
	}
}
