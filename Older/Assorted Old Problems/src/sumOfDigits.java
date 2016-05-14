
public class sumOfDigits 
{
	public static void main(String[] args)
	{
		System.out.println(sumOfDigits("12463462352"));
	}
	
	public static int sumOfDigits(String x)
	{
		if (x.length() > 0)
		{
			int out = Integer.parseInt(""+x.charAt(0));
			
			x = x.substring(1, x.length());
			out += sumOfDigits(x);
			
			return out;
		}
		else
			return 0;
	}
}
