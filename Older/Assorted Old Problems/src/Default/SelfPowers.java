package Default;

public class SelfPowers 
{
	public static void main(String[] args)
	{
		String total[] = new String[1000];
		long number;
		
		for (long n = 1;n != 1001;++n)
		{
			number = n;
			
			for (long k = 1;k != n;++k)
			{
				number *= n;
			}
			
			total[(int)n-1] += number;
			System.out.println(total[(int)n-1]);
		}
	}
}
