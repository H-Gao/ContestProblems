package Default;

public class LargeNumbers 
{
	public static void main(String[] args)
	{
		System.out.println(addNumber("10", "9"));
	}
	
	public static String addNumber(String number, String value)
	{
		String output = "";
		String newNumber = "";
		char k = 0;
		int nextValue = 0;
		
		for (int n = number.length()-1;n!=-1;--n)
		{
			k = number.charAt(n);
			
			k += value.charAt(0)- 48 + nextValue;
			
				
			if (k > 57)
			{
				k += 48;
			}
			
			while (k > 57) {++nextValue; k -= 58;}
			
			newNumber += k;
		}
		
		if (nextValue > 0) newNumber += nextValue;
		
		for (int n = newNumber.length()-1;n != -1;--n)
		{
			output += newNumber.charAt(n);
		}
		
		return output;
	}
}
