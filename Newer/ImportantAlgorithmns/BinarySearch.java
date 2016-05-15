package ImportantAlgorithmns;

import java.util.Arrays;

public class BinarySearch 
{
	public static void main(String args[])
	{
		int[] arr = { 29, 2, 45, 35, 32, 66, 2, 4, 6, 3242, 2, 13, 4124, 41 };
		Arrays.sort(arr);
		
		System.out.println(binarySearch(arr, 4123));
	}
	
	public static int binarySearch(int[] arr, int i)
	{
		int length = arr.length;
		int index = arr.length/2;
		
		while (true)
		{	
			int mid = arr[index];
			
			if (mid == i) return index;
			else 
			{
				if (index-1 <= 0 || index+1 >= length) return -1;
			
				int left = arr[index-1];
				int right = arr[index+1];
				
				if (left < i && right > i)
				{
					return -1;
				}
				else if (i > mid)
				{
					index = index + (length-index)/2;
				}
				else if (i < mid)
				{
					index = index/2;
				}
			}
		}
	}
}
