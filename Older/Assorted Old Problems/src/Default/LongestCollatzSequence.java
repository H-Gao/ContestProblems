package Default;

public class LongestCollatzSequence 
{
	public static void main(String[] args)
	{
		long number = 0;
		int length = 0;
		int longest = 0;
		long biggest = 0;
		int max = 1000000;
		
		for (int n = 1;n != max+1;++n)
		{
			number = n;
			
			++length;
			
			while (number!=1)
			{
				++length;
				
				if (number%2==0)
				{
					number /= 2;
				}
				else
				{
					number *= 3;
					++number;
				}
			}
			
			if (length > longest)
			{
				biggest = n;
				longest = length;
			}
			
			showProgress(n, max, longest);
			
			length = 0;
		}
		
		System.out.println(biggest);
	}
	
	public static void showProgress(int n, int max, int length)
	{
		if (n%20000==0)
		{
			System.out.println("We have completed... " + Math.round(((double)n/max)*100) + "%");
		}
	}
}
