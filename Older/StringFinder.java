import java.util.Random;
import java.util.Scanner;


public class StringFinder 
{
	static char[] input;
	static char[][] met;
	static boolean[][] rep;
	
	static int cap = 100;
	
	public static void main(String[] args)
	{
		Random randGen = new Random();
		
		met = new char[cap][cap];
		rep = new boolean[cap][cap];
		
		for (int a = 0;a < cap;++a)
			for (int b = 0;b < cap;++b)
				met[a][b] = (char)(randGen.nextInt(26)+'a');
				
		Scanner in = new Scanner(System.in);
		input = in.nextLine().toCharArray();
		
		for (int a = 0;a < cap;++a)
		{
			for (int b = 0;b < cap;++b)
			{
				System.out.print(met[a][b]);
			}
			
			System.out.println();
		}
		
		for (int a = 0;a < cap;++a)
			for (int b = 0;b < cap;++b)
				findString(a, b, 0);
		
		System.out.println("No.");
	}
	
	public static void findString(int x, int y, int num)
	{
		if (x >= 0 && x < cap && y >= 0 && y < cap && !rep[y][x])
		{
			rep[y][x] = true;
			
			if (num == input.length)
			{
				System.out.println("Yes.");
				System.exit(0);
			}
			else if (met[y][x] == input[num])
			{
				findString(x+1, y, num+1);
				findString(x-1, y, num+1);
				findString(x, y+1, num+1);
				findString(x, y-1, num+1);
			}
		}
	}
}
