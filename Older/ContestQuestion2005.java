import java.text.DecimalFormat;
import java.util.Scanner;

public class ContestQuestion2005 
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		
		double priceA = 0;
		double priceB = 0;
		
		int input[] = new int[3];
		
		for (int n = 0;n != 3;++n)
		{
			if (n == 0)
				System.out.println("How many daytime minutes");
			else if (n == 1)
				System.out.println("How many evening minutes");
			else
				System.out.println("How many weekend minutes");
			
			input[n] = scanner.nextInt();
		}
		
		if (input[0] > 100)
			priceA += (input[0]-100)*0.25;
		
		priceA += input[1]*0.15;
		priceA += input[2]*0.20;
		
		if (input[0] > 250)
			priceB += (input[0]-250)*0.45;
		
		priceB += input[1]*0.35;
		priceB += input[2]*0.25;
		
		DecimalFormat formatedPrice = new DecimalFormat("0.00");
		
		System.out.println("Plan A costs " + formatedPrice.format(priceA));
		System.out.println("Plan B costs " + formatedPrice.format(priceB));
		
		if (Double.parseDouble(formatedPrice.format(priceA)) > Double.parseDouble(formatedPrice.format(priceB)))
			System.out.println("Plan B is cheapest");
			if (Double.parseDouble(formatedPrice.format(priceA)) < Double.parseDouble(formatedPrice.format(priceB)))
				System.out.println("Plan A is cheapest");
			if (Double.parseDouble(formatedPrice.format(priceA)) == Double.parseDouble(formatedPrice.format(priceB)))
				System.out.println("Plan B and Plan A is the same");
	}
}
