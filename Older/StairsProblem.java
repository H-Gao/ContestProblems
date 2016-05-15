import java.util.Scanner;


public class StairsProblem 
{
	static int log = 0;
	static int numSteps;
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		numSteps = in.nextInt();
				
		solution(0);
		System.out.println(log);
	}
	
	//N == total.
	public static void solution(int n)
	{
		if (n == numSteps)
			++log;
		else if (n < numSteps)
		{
			solution(n+1);
			solution(n+2);
			solution(n+3);
		}
	}
}
