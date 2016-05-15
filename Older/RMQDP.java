import java.util.Random;
import java.util.Scanner;


public class RMQDP 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		Random r = new Random();
		
		int num = r.nextInt(8);
		int[] input =  new int[num];
		
		for (int i = 0;i < num;++i) input[i] = r.nextInt(100);
		
		//Prints the a[start] to a[end].
		for (int a = 0;a < num;++a) System.out.print(input[a] + " ");
		System.out.println();
		
		int[][] min = new int[num][num];
		
		for (int a = 0;a < num;++a)
		{
			min[a][a] = input[a];
			
			for (int b = a+1;b < num;++b)
			{
				int curr = input[b];
				int prev = min[a][b-1];
				
				if (curr < prev) min[a][b] = curr;
				else min[a][b] = prev;
			}
		}
		
		//Prints the table.
		for (int a = 0;a < num;++a)
		{
			for (int b = 0;b < num;++b)
			{
				System.out.print(min[a][b] + " ");
			}
			
			System.out.println();
		}
		
		//One million random queries.
		for (int a = 0;a < r.nextInt(1000000);++a)
		{
			int start = r.nextInt(num);
			int end = start + r.nextInt(num-start);
			
			System.out.println(start + " to " + end + " " + min[start][end]);
		}
	}
}
