import java.util.Scanner;

public class IntToBinaryConverter 
{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		
		int x = 0;
		int m;
		int n;
		int r[] = new int[1000];
		
		System.out.println("Please enter the base, from 2 - 20.");
		
		m = scanner.nextInt();
		
		if (m < 2 || m > 20)
		{
			n = -1;
			System.out.println("Invalid Base.");
		}
	
		System.out.println("Please enter a integer.");
		
		n = scanner.nextInt();
		
		while (n != 0)
		{
			++x;
			r[x] = n%m;
			n/=m;
		}
		
		for (int k = x;k != 0;--k)
		{
			System.out.println(r[k]);
		}
	}
}
