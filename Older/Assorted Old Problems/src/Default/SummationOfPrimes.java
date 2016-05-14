package Default;

public class SummationOfPrimes 
{
	public static void main(String[] args)
	{
		long total = 2;
		
		for (int n = 0;n != 2000000;++n)
		{
			showProgress(n, 2000000, total);
			
			for (int k = 2;k != n;++k)
			{
				if(n%k==0)
				{
					break;
				}
				else if (k == n-1 && n!=k)
				{
					total += n;
					break;
				}
			}
		}
		
		System.out.println(total);
	}
	
	public static void showProgress(int n, int searchUpTo, long total)
	{
		if ((n%(searchUpTo/100))==0)
		{
			System.out.println("Current Progress " + Math.round(((double)n/searchUpTo*100)) + "%");
		}
		
		if ((n%(searchUpTo/10))==0 && n != 0)
		{
			System.out.println("Threshold reached " + Math.round(((double)n/searchUpTo*100)) + "%");
			System.out.println("We have found " + total + " Thus far.");
		}
	}
}
