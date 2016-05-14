package Default;

public class exceptionExample
{
	public static void main(String args[])
	{
		int[] num = new int[20];

		try
		{
			num[20] = 100;
		}
		catch(ArrayIndexOutOfBoundsException ex)
		{
			System.out.println("A Exception");
		}
	}
}
