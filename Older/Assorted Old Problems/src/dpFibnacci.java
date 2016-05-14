import java.util.Scanner;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;


public class dpFibnacci 
{
	public static void main(String[] args)
	{
		int in = (new Scanner(System.in)).nextInt();
		
		f(in-2); //Calculates the fib sequence (-2, because a and b is already shown).
	}
	
	public static void f(int n)
	{
		int a = 1;
		int b = 1;
		
		int x = a+b;
		
		for (int i = 0;i < n;++i)
		{
			x = a+b;
			
			b = a;
			a = x;
		}
		
		System.out.println(x);
	}
}
