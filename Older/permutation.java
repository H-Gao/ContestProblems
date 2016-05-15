import java.util.ArrayList;


public class permutation 
{
	public static void main(String[] args)
	{
		int[] in =
		{
			1,2,3,4,5,6,7,8
		};
		
		permute(in);
	}
	
	public static void permute(int[] num)
	{
		int k = 0;
		
		for (int i = 0;i < (num.length*2);++i)
		{		
			//If it is the first half.
			if (i/num.length == 0)
			{
				for (int n = i;k < num.length;++n)
				{
					++k;
					
					if (n >= num.length)
					{
						System.out.print(num[num.length-n]);
						n = 0;
					}
					else
					{
						System.out.print(num[n]);
					}
				}
				
				k = 0;
				System.out.print("\n");
			}
			//If it is the second half.
			else
			{
				for (int n = i%3;k < num.length;--n)
				{
					++k;
					
					if (n < 0)
					{
						System.out.print(num[num.length-1]);
						n = num.length-1;
					}
					else
					{
						System.out.print(num[n]);
					}
				}
				
				k = 0;
				System.out.print("\n");
			}
		}
	}
}
