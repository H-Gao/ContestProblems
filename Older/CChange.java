import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class CChange 
{
	static int valueCoins;
	
	static int numDenom;
	
	static int[] denom;
	
	static int maxNum = 0;
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		valueCoins = in.nextInt();
		
		numDenom = in.nextInt();
		
		denom = new int[numDenom];
		
		for (int i = 0;i < numDenom;++i)
			denom[i] = in.nextInt();
		
		solve(0, 0, 0);
		
		System.out.println(maxNum);
	}
	
	public static void solve(int sum, int n, int num)
	{
		if (sum < valueCoins)
		{
			for (int i = num;i < denom.length;++i)
			{
				solve(sum + denom[i], n+1, i);
			}
		}
		else if (sum == valueCoins)
		{
			if (n < maxNum || maxNum == 0)
			{
				maxNum = n;
			}
		}
	}
}
