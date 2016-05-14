import java.util.Scanner;


public class longestIncreasingSubsequence 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		
		int[] input = new int[N];
		
		for (int i = 0;i < N;++i)
			input[i] = in.nextInt();
		
		System.out.println(findLongest(input));
	}
	
	public static int findLongest(int[] n)
	{
		int out = 0;
		
		int lastValidNum = 0;
		
		for (int i = 0;i < n.length;++i)
		{
			if (n[i] > lastValidNum)
			{
				++out;
				lastValidNum = n[i];
			}
		}
		
		return out;
	}
}
