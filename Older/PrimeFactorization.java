import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;


public class PrimeFactorization 
{
	static HashMap<Integer, Boolean> storedVal = new HashMap<Integer, Boolean>();
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int A = in.nextInt();
		int B = in.nextInt();
		
		for (int i = A;i < B+1;++i)
		{
			factorize(i);
			
			System.out.println(storedVal.size());
			storedVal.clear();
		}
	}
	
	public static void factorize(int in)
	{
		int denom = 0;
		boolean isPrime = false;
		
		if (in != 2)
			for (int i = (int)Math.sqrt((double)in)+1;i >= 2;--i)
				if (in%i==0)
				{
					denom = i;
					isPrime = true;
				}
		
		if (isPrime)
		{
			factorize(denom);
			factorize(in/denom);
		}
		else
		{
			storedVal.put(in, true);
		}
	}
}
