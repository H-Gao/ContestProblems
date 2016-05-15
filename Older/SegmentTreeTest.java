import java.util.Arrays;
import java.util.Scanner;


public class SegmentTreeTest 
{
	public static void main(String[] args)
	{
		long nanoTime = System.nanoTime();
		
		Scanner in = new Scanner(System.in);
		
		String[] input = in.nextLine().split(" ");
		int arrayLength = Integer.parseInt(input[0]), queryLength = Integer.parseInt(input[1]);
		
		int[] arr = new int[arrayLength];
		
		for (int i = 0;i < arrayLength;++i)
			arr[i] = in.nextInt();
		
		//Stops the nextInt() method from "stealing" the next line.
		stopNextInt(in.nextLine());
		
		for (int i = 0;i < queryLength;++i)
		{
			String[] field = in.nextLine().split(" ");
			
			String a = field[0];
			int b = Integer.parseInt(field[1]), c = Integer.parseInt(field[2]);
			
			if (a.equals("M"))
			{
				arr[b] = c;
			}
			else
			{
				int[] temp = new int[c-b+1];
				
				for (int n = b;n <= c;++n)
					temp[n-b] = arr[n];
				
				Arrays.sort(temp);
				System.out.println(temp[0]);
			}
		}
		
		System.out.println((System.nanoTime() - nanoTime)/1000000);
	}
	
	public static void stopNextInt(String in) {}
}
