import java.util.Scanner;


public class FinancialManager 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		String out = "$";
		
		//The total value of the sums.
		double total = 0;
		
		for (int i = 0;i < 12;++i)
			total += in.nextDouble();
		
		//The average value of the inputs.
		double aver = total/12;
		
		String averString = ""+aver;
		int indexOf = averString.indexOf('.');
		
		int decimalLength = averString.substring(indexOf+1, averString.length()).length();
		
		if (decimalLength == 1)
		{
			out += averString + "0";
		}
		else if (decimalLength == 2)
		{
			out += averString;
		}
		else
		{
			double croppedIn = Double.parseDouble(averString.substring(0, indexOf+3));
			int determiner = averString.charAt(indexOf+3) - '0';
			
			//If it would round up.
			if (determiner >= 5)
				croppedIn += 0.01;
			
			//If it would round down, it does nothing. This is because it is already cropped.
			
			out += croppedIn;
		}
		
		System.out.println(out);
	}
}
