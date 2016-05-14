package Default;

import java.util.Scanner;

public class nextInLine 
{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		
		int input[] = new int[2];
		
		for (int n = 0;n != 2;++n)
		{
			input[n] = scanner.nextInt();
		}
		
		int output = input[1] + (input[1] - input[0]);
		
		System.out.println(output);
	}
}
