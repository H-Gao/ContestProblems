package Default;

public class The1001stPrime 
{
	public static void main(String[] args)
	{
		boolean isPrime = false;
		int primeNumber = 0;
		int n = 1;
		
		while (primeNumber != 10001 - 1)
		{
			++n;
			for (int k  = 2;k != n;++k)
			{
				if (n%k==0 && n != k)
				{
					isPrime = false;
					break;
				}
				else
				{
					isPrime = true;
				}
			}
			
			if (isPrime)
			{
				++primeNumber;
				System.out.println(n);
			}
		}
		
		System.out.println(n);
	}
}
