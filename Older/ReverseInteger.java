
public class ReverseInteger 
{
	public static void main(String[] args)
	{
		System.out.println(reverseInt(-234));
	}
	
	public static int reverseInt(int in)
	{
		int valIn = in;
		
		int reversed = 0;
		
		if (in < 0)
			in *= -1;
		
		while (in > 0)
		{
			int polledNum = in%10;
			
			reversed = reversed*10 + polledNum;
			
			in /= 10;
		}
		
		if (valIn < 0)
			return -reversed;
		else
			return reversed;
	}
}
