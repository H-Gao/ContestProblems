package Default;

public class SpecialPythagoreanTriplet 
{
	public static void main(String[] args)
	{
		int c;
		
		for (int a = 0;a != 100000;++a)
		{
			for (int b = 0;b != 100000;++b)
			{
				c = a*a+b*b;
				
				if ((a*a) < (b*b) && (b*b) < c && Math.sqrt(a*a)+Math.sqrt(b*b)+Math.sqrt(c)==1000)
				{
					System.out.println(Math.sqrt(a*a) * Math.sqrt(b*b) * Math.sqrt(c));
					break;
				}
			}
		}
	}
}
