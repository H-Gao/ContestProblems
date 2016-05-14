import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;


public class poj1200 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
	
		int N = Integer.parseInt(in.nextLine().split(" ")[0]);
		
		String input = in.nextLine();
		
		solve2(N, input);
	}
	
	public static int solve(int N, String input)
	{	
		long currentTime = System.nanoTime();
		
		int length = input.length();
		
		int result = input.length() - (N-1);
		
		System.out.println((double)((System.nanoTime() - currentTime)/10000)/100 + " milliseconds");
		
		if (result > 0)

			return result;
		else
			return 0;
	}
	
	public static void solve2(int N, String input)
	{
		long currentTime = System.nanoTime();
		
		HashMap<String, String> prevResults = new HashMap<String, String>();
		
		int length = input.length();
		
		long numRepeats = 0;
		
		//Length-3+1 = Length-2.
		for (int i = 0;i < length-(N-1);++i)
		{
			String result = "";
			
			for (int n = 0;n < N;++n)
			{
				result += input.charAt(i+n);
			}
			
			if (!prevResults.containsKey(result))
			{
				prevResults.put(result, result);
			}
			else
			{
				++numRepeats;
			}
		}
		
		long results = (input.length() - (N-1)) - numRepeats;
		
		if (results > 0)
			System.out.println(results);
		else
			System.out.println(0);
	}
}
