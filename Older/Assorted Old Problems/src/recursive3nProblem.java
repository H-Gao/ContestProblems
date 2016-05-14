import java.util.Scanner;

public class recursive3nProblem 
{
	static int maxNum;
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		while (true)
		{
			maxNum = 0;
			
			String n = in.nextLine();
				
			int b = Integer.parseInt(n.split(" ")[0]);
			int e = Integer.parseInt(n.split(" ")[1]);
		
			for (int i = b;i <= e;++i)
				solve(i, 1);
		
			System.out.println(b + " " + e + " " + maxNum);
		}
	}
	
	public static void solve(int in, int x)
	{
		//If it is equal to 1, it will stop.
		if (in != 1)
		{
			int n;
			
			//If it is odd.
			if (in%2!=0)
			{
				n = 3*in+1;
			}
			//If it is even.
			else
			{
				n = in/2;
			}
			
			solve(n, x+1);
		}
		else
		{
			if (x > maxNum)
				maxNum = x;
		}
	}
}
