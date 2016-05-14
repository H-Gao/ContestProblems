import java.util.Random;
import java.util.Scanner;


public class reversedSum 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int numTimes = Integer.parseInt(in.nextLine());
		
		for (int i = 0;i < numTimes;++i)
		{
			String[] input = in.nextLine().split(" ");
			
			int sum = reverse(""+(int)(reverse(input[0]) + reverse(input[1])));
			
			System.out.println(sum);
		}
	}
	
	//Runs at ~40ms, as opposed to ~60ms.
	public static int reverse(String n)
	{
		int out = 0;
		
		for (int i = 0;i < n.length();++i)
		{
			out += (n.charAt(i)-48)*(int)Math.pow(10, i);
		}
		
		return out;
	}
}
