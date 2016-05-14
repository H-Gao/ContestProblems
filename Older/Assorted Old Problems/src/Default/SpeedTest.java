package Default;

public class SpeedTest 
{
	public static void main(String[] args) 
	{
		for (int k = 0;k != 100000000;++k)
		{
			for (int n = 0;n != 1000000000;++n)
			{
				for (int i = 0;i != 3;++i)
				{
					System.out.println("I am currently at the number" + k + " " + n + " " + i);
				}
			}
		}
		
		System.out.println("Done");
	}
}
