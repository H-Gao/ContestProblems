import java.util.ArrayList;
import java.util.Arrays;


public class LargeSums 
{
	public static void main(String[] args)
	{
		System.out.println(findLargeSum("421532532532223523532532532", "123523625623"));
	}
	
	public static String findLargeSum(String a, String b)
	{
		//The char array forms of a and b.
		char[] aChar = a.toCharArray();
		char[] bChar = b.toCharArray();
		
		//Finds the max lengths.
		int[] lengths = { aChar.length, bChar.length };
		Arrays.sort(lengths);
		
		//The largest and smallest lengths.
		int minLength = lengths[0];
		int maxLength = lengths[1];
		
		String total = "";
		int leftOver = 0;
		
		for (int i = 0;i < minLength;++i)
		{
			int sum  = (aChar[i] + bChar[i] - (int)('0'*2))%10 + leftOver;
			leftOver = sum/10;
			
			total += sum;
		}
		
		for (int i = 0;i < maxLength - minLength;++i)
		{
			if (i < aChar.length)
				total = (aChar[i] - '0' + leftOver) + total;
			else if (i < bChar.length)
				total = (bChar[i]  - '0' + leftOver) + total;
			
			leftOver = 0;
		}
		
		return total;
	}
}
