package CCC2012;

import java.util.HashMap;
import java.util.Scanner;

public class AromaticNumbers 
{
	static HashMap<Character, Integer> conv = new HashMap<Character, Integer>();
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		conversionNumbers();
		
		char[] input = in.nextLine().toCharArray();
		int[] seq = new int[input.length];
		
		for (int i = 0;i < input.length;++i)
		{
			if (input[i] >= '0' && input[i] <= '9') seq[i] = input[i]-'0';
			else seq[i] = conv.get(input[i]);
		}
		
		int tot = seq[input.length-1] * seq[input.length-2];
		
		for (int i = 0;i < input.length-2;i+=2)
		{
			int a = seq[i];
			int r = seq[i+1];
			
			if (r < seq[i+3]) tot -= a*r;
			else tot += a*r;
		}
		
		System.out.println(tot);
	}
	
	public static void conversionNumbers()
	{
		conv.put('I', 1);
		conv.put('V', 5);
		conv.put('X', 10);
		conv.put('L', 50);
		conv.put('C', 100);
		conv.put('D', 500);
		conv.put('M', 1000);
	}
}
