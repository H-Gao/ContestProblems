package Default;

public class HighlyDivisableTriangularNumber 
{
	public static void main(String[] args) 
	{
		int numbers = 0;
		int divisors = 0;
		int max = 500;
		
		for (int n = 1;divisors <= max;++n)
		{
			numbers += n;
			
			for (long k = 1;k != numbers+1;++k)
			{
				if (numbers%k==0)
				{
					++divisors;
				}
				
				search(k, numbers, divisors);
			}
			
			System.out.println(numbers + " " + divisors);
			
			if (divisors <= max)
			{
				divisors = 0;
			}
		}
		
		System.out.println(numbers);
	}
	
	public static void search(long k, int numbers, int divisors)
	{
		searchK(k, numbers, divisors);
	}
	
	public static void searchK(long k, int numbers, int divisors)
	{
		++k;
		
		if (numbers%k==0 && k<=numbers)
		{
			++k;
			++divisors;
		}
	}
}
