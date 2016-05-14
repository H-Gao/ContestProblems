package Recursion;

import java.util.Arrays;
import java.util.Scanner;

public class RecursionProblems 
{
	public static void main(String[] args)
	{
		doRecursion(3);
	}
	
	public static void doRecursion(int index)
	{
		Scanner scanner = new Scanner(System.in);
		
		if (index == 0)
		{
			String countMe = scanner.nextLine();
			System.out.println(countA(countMe, countMe.length()-1));
		}
		else if (index == 1)
		{
			int amountOfInputs = scanner.nextInt();
			int array[] = new int[amountOfInputs];
			
			for (int n = 0;n != amountOfInputs;++n)
			{
				array[n] = scanner.nextInt();
			}
			
			countIntArray(array, array.length-1);
			
			System.out.println("It is Ascending.");
		}
		else if (index == 2)
		{
			String str = scanner.nextLine();
			System.out.println(palindrome(str, str.length()-1));
		}
		else if (index == 3)
		{
			int amount = scanner.nextInt();
			
			int[] arr = new int[amount];
			
			for (int i = 0;i != amount;++i)
				arr[i] = scanner.nextInt();
					
			Arrays.sort(arr);
			
			System.out.println(LuckyNumbers(arr, arr.length-1));
		}
	}
	
	public static int countA(String a, int n)
	{
		if (n == 0) 
		{
			if (a.charAt(n) == 'a')
				return 1;
			else
				return 0;
		}
		
		else
		{
			int sum;
			sum = countA(a, n-1);
			
			if (a.charAt(n) == 'a') 
				++sum;
			
			return sum;
		}
	}
	
	public static int countIntArray(int[] array, int n)
	{
		if (n == 0)
			return array[n];
		else
		{
			int num;
			num = countIntArray(array, n-1);
			
			if (num < array[n])
				return array[n];
			else
			{
				System.out.println("It is not Ascending.");
				System.exit(0);
				return 0;
			}
		}
	}
	
	public static boolean palindrome(String str, int n)
	{
		if (n == 0)
		 return true;
		else if (str.charAt(n) == str.charAt(str.length()-1-n))
			return palindrome(str, n-1);
		else
			return false;
	}
	
	//Must be sorted
	public static int LuckyNumbers(int[] arr, int n)
	{
		if (n != -1)
			System.out.println(arr[n] + " " + n);
		else
			System.out.println(n);
		
		if (n < 0)
			return 0;
		else if (containsOnlyLuckyNumbers(arr, n))
		{
			int i = 0;
			
			while ((n-i-1) > arr.length && arr[n-i-1] == arr[n])
				++i;
				
			return LuckyNumbers(arr, n-i-1);
		}
		else
		{
			int i = 0;
			
			while ((n-i-1) > arr.length && arr[n-i-1] == arr[n])
				++i;
				
			return LuckyNumbers(arr, n-i-1) + 1;
		}
	}
	
	public static boolean containsOnlyLuckyNumbers(int[] arr, int n)
	{
		if (Integer.toString(arr[n]).contains("1") || Integer.toString(arr[n]).contains("2") 
				|| Integer.toString(arr[n]).contains("3") || Integer.toString(arr[n]).contains("5") 
				|| Integer.toString(arr[n]).contains("6") || Integer.toString(arr[n]).contains("8")
				|| Integer.toString(arr[n]).contains("9") || Integer.toString(arr[n]).contains("0")) 
			{ return true; }
		
		else return false;
	}
}
