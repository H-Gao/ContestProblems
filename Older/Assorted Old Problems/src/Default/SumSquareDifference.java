package Default;

public class SumSquareDifference 
{
	public static void main(String[] args)
	{
		int sumOfSquares = 0;
		int squareOfSums = 0;
		int numbers = 0;
		
		for (int n = 0;n != 101;++n)
		{
			sumOfSquares += n * n;
		}
		
		for (int n = 0;n != 101;++n)
		{
			numbers += n;
		}
		
		squareOfSums = numbers * numbers;
		
		System.out.println(squareOfSums - sumOfSquares);
	}
}
