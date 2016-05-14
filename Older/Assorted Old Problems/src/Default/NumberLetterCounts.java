package Default;

public class NumberLetterCounts 
{
	public static void main(String[] args)
	{
		int number = 5;
		int total = 0;
		
		System.out.println(toLetters(number, total));
	}
	
	public static int toLetters(int value, int total)
	{
		String newNumber = "";
		String num = ""+value;
		
		for (int n = newNumber.length()-1;n != -1;--n)
		{
			newNumber += num.charAt(n);
		}
		
		for (int n = 0;n != newNumber.length();++n)
		{
			if (n == 0 && (n + 1) >= newNumber.length())
			{
				findDigit(newNumber.charAt(n), total);
			}
			
			if (n == 1)
			{
				if (findDigit(newNumber.charAt(n)) == '1')
				{
					if (findDigit(newNumber.charAt(n-1)) == '0') total += 3;
					if (findDigit(newNumber.charAt(n-1)) == '1') total += 6;
					if (findDigit(newNumber.charAt(n-1)) == '2') total += 5;
					if (findDigit(newNumber.charAt(n-1)) == '3') total += 8;
					if (findDigit(newNumber.charAt(n-1)) == '4') total += 8;
					if (findDigit(newNumber.charAt(n-1)) == '5') total += 7;
					if (findDigit(newNumber.charAt(n-1)) == '6') total += 7;
					if (findDigit(newNumber.charAt(n-1)) == '7') total += 9;
					if (findDigit(newNumber.charAt(n-1)) == '8') total += 9;
					if (findDigit(newNumber.charAt(n-1)) == '9') total += 8;   
				}
				
				if (findDigit(newNumber.charAt(n)) == '2')
				{
					total += 6;
				}
				
				if (findDigit(newNumber.charAt(n)) == '3')
				{
					total += 6;
				}
				
				if (findDigit(newNumber.charAt(n)) == '4')
				{
					total += 6;
				}
				
				if (findDigit(newNumber.charAt(n)) == '5')
				{
					total += 5;
				}
				
				if (findDigit(newNumber.charAt(n)) == '6')
				{
					total += 5;
				}
				
				if (findDigit(newNumber.charAt(n)) == '7')
				{
					total += 7;
				}
				
				if (findDigit(newNumber.charAt(n)) == '8')
				{
					total += 5;
				}
				
				if (findDigit(newNumber.charAt(n)) == '9')
				{
					total += 6;
				}
			}
		}
		return total;
	}
	
	public static void findDigit(char n, int number)
	{
		if (n == 1) number += 3;
		else if (n == 2) number += 3;
		else if (n == 3) number += 5;
		else if (n == 4) number += 4;
		else if (n == 5) number += 4;
		else if (n == 6) number += 3;
		else if (n == 7) number += 5;
		else if (n == 8) number += 5;
		else if (n == 9) number += 4;
	}
	
	public static char findDigit(char n)
	{
		return n;
	}
}
