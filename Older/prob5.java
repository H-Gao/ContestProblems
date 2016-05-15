import java.util.Scanner;


public class prob5 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int num = in.nextInt();
		
		int[] a = new int[num];
		int[] b = new int[num];
		
		a[0] = 0; b[0] = in.nextInt();
		
		for (int i = 1;i < num;++i)
		{
			int n = in.nextInt();
			
			b[i] = n + a[i-1];
			
			if (a[i-1] > b[i-1]) a[i] = a[i-1];
			else a[i] = b[i-1];
		}
		
		for (int i = 0;i < num;++i) System.out.print(a[i] + " ");
		
		System.out.println();
		
		for (int i = 0;i < num;++i) System.out.print(b[i] + " ");
	}
}
