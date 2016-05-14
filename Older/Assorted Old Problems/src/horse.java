import java.util.Scanner;


public class horse 
{
	static int[][] t;
	static int m, n;
			
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		m = in.nextInt();
		n = in.nextInt();
		
		t = new int[m][n];
		
		t[m-1][0] = 1;
		
		jump(2, m-2);
		jump(1, m-3);
		
		print();
	}
	
	public static void jump(int x, int y)
	{
		if (x < n && x >= 0 && y < m && y >= 0)
		{
			int a = 0;
			int b = 0;
			
			if ((x-2) < n && (x-2) >= 0 && (y+1) < m && (y+1) >= 0)
				a = t[y+1][x-2];
			
			if ((x-1) < n && (x-1) >= 0 && (y+2) < m && (y+2) >= 0)
				b = t[y+2][x-1];
			
			//System.out.println(a + " " + b);
			
			t[y][x] = a+b;
			
			jump(x+1, y-2);
			jump(x+2, y-1);
		}
	}
	
	public static void print()
	{
		for (int a = 0;a < t.length;++a)
		{
			for (int b = 0;b < t[0].length;++b)
			{
				if (a == 19 && b == 19)
				{
					System.out.print("B");
				}
				else
				{
					System.out.print(t[a][b]);
				}
			}
			
			System.out.println();
		}
	}
}
