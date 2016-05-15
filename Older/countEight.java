
public class countEight 
{
	public static void main(String[] args)
	{
		//System.out.println(countEight("8818", 0));
		System.out.println(countEars(8));
	}
	
	public static int countEight(String str, int n)
	{
		int num = 0;
		
		if (n < str.length())
		{
			if (str.charAt(n) == '8')
			{
				++num;
				
				if (n+1 < str.length() && str.charAt(n+1) == '8')
					++num;
			}
			
			num += countEight(str, n+1);
		}
		
		return num;
	}
	
	public static int countEars(int n)
	{
		if (n > 0)
			return 2 + countEars(n-1);
		else
			return 0;
	}
}
