import java.util.Arrays;

/*
 * If the Integers are sorted and there are two different numbers,
 * then the two unique numbers must show up in either the first or last places.
 * If a second number is pulled, then it must be either the first or second unique number.
 * If the number is the same as the first number, the number that shows up three times, must be
 * the last number, because the last number would only show up once, this could also work is if the
 * first number is not equal to the second, the last number must show up three times and the first number is returned.
 */

public class SingleNumber 
{
	public static void main(String[] args)
	{
		int[] A = {
				2, 2, 2, 3, 3, 3, 4
		};
		
		System.out.println(solution2(A));
	}
	
	public static int solution(int[] A)
	{
		//Sorts the integers.
		Arrays.sort(A);
		
		//Finds the first number.
		int f = A[0];
		//Find the last number.
		int l = A[A.length-1];
		
		//Finds the second number.
		int s = A[1];
		
		//If the first number is equal to the second number.
		if (f == s) return l;
		//If the last number is equal to the second number.
		else return f;
	}
	
	public static int solution2(int[] a)
	{
		for (int i = 0;i < a.length;)
		{
			if (i == a.length-1 || a[i] != a[i+1])
				return a[i];
			else
				i += 3;
		}
		
		return 0;
	}
}
