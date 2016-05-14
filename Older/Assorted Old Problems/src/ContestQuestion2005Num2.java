import java.util.Scanner;

public class ContestQuestion2005Num2 
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		
		int total = 0;
		int num = 0;
		
		int input[] = new int[2];
		
		for (int n = 0;n != 2;++n)
		{
			if (n == 0)
				System.out.println("Enter the lower limit of range");
			else
				System.out.println("Enter the higher limit of range");
			
			input[n] = scanner.nextInt();
		}
		
		for (int n = input[0];n != input[1]+1;++n)
		{
			for (int k = 1;k != n+1;++k)
			{
				if (n%k==0)
					++num;	
			}
			
			if (num == 4)
				++total;
			
			num = 0;
		}
		
		System.out.println("The number of RSA Numbers between " + input[0] + " and " + input[1] + " is " + total);
	}
}
