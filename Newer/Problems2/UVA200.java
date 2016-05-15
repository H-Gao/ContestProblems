package Problems2;

import java.util.LinkedList;
import java.util.Scanner;

public class UVA200 
{
	static byte[][] met = new byte[26][26];
	
	public static void main(String args[])
	{
		LinkedList<String> list = new LinkedList<String>();
		Scanner in = new Scanner(System.in);
		
		for (int a = 0;a < 26;++a)
			for (int b = 0;b < 26;++b)
				met[a][b] = -1;
		
		String input;
		while (!(input = in.nextLine()).equals("#")) list.add(input);
		
		for (int a = 0;a < list.size();++a)
		{
			for (int b = a+1;b < list.size();++b)
			{
				compare(list.get(a).toCharArray(), list.get(b).toCharArray());
			}
		}
		
		for (int a = 0;a < 26;++a)
		{
			for (int b = 0;b < 26;++b)
				System.out.print(met[a][b] + " ");
			
			System.out.println();
		}
	}
	
	public static void compare(char[] a, char[] b)
	{
		if (b.length > a.length)
		{
			char[] temp = b;
			b = a;
			a  = temp;
		}
		
		for (int i = 0;i < b.length;++i)
		{
			if (a[i] > b[i])
			{
				if (met[a[i]-65][b[i]-65] == -1)
					for (int x = 0;x < 26;++x) met[a[i]-65][x] = 0;
						
				System.out.println(a[i] + " > " + b[i]);
				met[a[i]-65][b[i]-65] = 1;
				
				return;
			}
			else if (a[i] < b[i])
			{
				if (met[a[i]-65][b[i]-65] == -1)
					for (int x = 0;x < 26;++x) met[a[i]-65][x] = 0;
				
				System.out.println(a[i] + " < " + b[i]);
				met[b[i]-65][a[i]-65] = 1;
				return;
			}
		}
	}
}
