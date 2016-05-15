package Recursion;

import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class BinarySearchRecursion 
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		
		int[] a = {6,6,6,6,6,6,6,6,6,8};
		
		Arrays.sort(a);
		
		System.out.println(binarySearch(a, 0, a.length, 6));
	}
	
	public static int binarySearch(int[] a, int b, int n)
	{
		if (a[n] != b)
			return 0;
		else
			return binarySearch(a, b, n+1) + 1;
	}
	
	public static int binarySearch(int[] a, int b, int e, int s)
	{
		if (b > e)
		{
			return 0;
		}
		else
		{
			int mid = (b+e)/2;
			
			if (s == a[mid])
				return binarySearch(a, s, mid);
			else if (s > a[mid])
				return binarySearch(a, b, mid-1, s);
			else
				return binarySearch(a, b, mid+1, s);
		}
	}
}
