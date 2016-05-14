package Default;

public class EulerProject 
{
	public static void main(String[] args)
	{
		int index = 1;
		long currTriangleNum = 1;

		while (numDivisors(currTriangleNum) <= 500) {
		    index++;
		    currTriangleNum += index;
		}
		
		System.out.println(currTriangleNum);
	}
	
	public static int numDivisors(long num) {  
	    int numTotal = 0;

	    if (num > 1)
	        if (num % 2 == 0) 
	        {
	            for (long i = 1; i * i <= num; i++)
	                if (num % i == 0)
	                    numTotal+=2;
	        } 
	        else 
	        {
	            // halves the time for odd numbers
	            for (long i = 1; i * i <= num; i+=2)
	                if (num % i == 0)
	                    numTotal+=2;
	        }
	    else if (num == 0)
	        return 0;
	    else if (num == 1)
	        return 1;
	    else if (num < 0)
	        return numDivisors(num *= -1);

	    return numTotal;
	 }
}
