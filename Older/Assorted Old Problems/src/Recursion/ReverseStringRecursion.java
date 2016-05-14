package Recursion;

import java.util.Scanner;

public class ReverseStringRecursion 
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		
		String input = scanner.nextLine();
		
		String[] str = input.split(" ");
		
		System.out.println(reverseString2(str, 0));
	}
	
	public static String reverseString(String str, int n)
	{
		if (n == str.length()-1)
			return ""+str.charAt(str.length()-1);
		else
		{
			return reverseString(str, n+1) + str.charAt(n);
		}
	}
	
	public static String reverseString2(String[] str, int n)
	{
		if (n == str.length-1)
			return str[n];
		else
			return reverseString2(str, n+1) + " " + str[n];
	}
}
