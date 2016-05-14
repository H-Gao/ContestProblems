package JavaClass;

import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;

public class OneMillionIntegers 
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		
		int amount = 1000000;
		
		System.out.println("Enter a number");
		int input = scanner.nextInt();
		
		int arrays[] = new int[amount];
		
		for (int n = 0;n != amount;++n)
			arrays[n] = (random.nextInt(10000)-5000);
		
		int n = 0;
		
		for (;n != arrays.length;++n)
			if (arrays[n] == input)
				break;
	
		System.out.println("Linear Search " + n);
		
		Arrays.sort(arrays);
		
		System.out.println(arrays[0] + " " + arrays[arrays.length-1]);
		
		int occurances = 0;
		
		int b = 0; 
		int e = arrays.length-1;
		
		n = 0;
		
		while (e>=b)
		{
			++n;
			int middleNumber = (b+e)/2;
			
			if (arrays[middleNumber] < input)
			{
				b = middleNumber + 1;
			}
			else if (arrays[middleNumber] > input)
			{
				e = middleNumber - 1;
			}
			else if (arrays[middleNumber] == input)
			{
				for (int i = 0;arrays[middleNumber+i]==input;++i)
					++occurances;
				
				break;
			}
		}
		
		System.out.println("Binary Search " + n);
		System.out.println("Occurances " + occurances);
	}
	
	public static void getTime()
	{
		System.out.println(System.currentTimeMillis());
	}
}
