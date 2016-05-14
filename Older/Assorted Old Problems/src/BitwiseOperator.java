import java.util.Scanner;


public class BitwiseOperator 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int bit = in.nextInt();	
		
		numBits(bit);
		swapBits(in, bit);
		ithBit(in, bit);
	}
	
	public static void numBits(int bit)
	{
		int num = 1;
		
		while (bit != 1)
		{
			int tempBit = bit & 1;
			
			if (tempBit == 1) ++num;
			bit = bit >> 1;
		}
		
		System.out.println(num);
	}
	
	public static void ithBit(Scanner in, int bit)
	{
		int i = in.nextInt();
		
		bit = bit >> (i-1);
		if ((bit & 1) == 1) System.out.println("Yes.");
		else System.out.println("No.");
	}
	
	public static void firstFiveBits()
	{
		for (int i = 0;i < 5;++i)
		{
		}
	}
	
	public static void swapBits(Scanner in, int bit)
	{
		int bit2 = in.nextInt();
		
		bit = bit^bit2;
		bit2 = bit2^bit;
		bit = bit^bit2;
	}
}
