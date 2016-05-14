import java.util.ArrayList;


public class Multiplier 
{
	public static void main(String args[])
	{
		String input = "56354656.4555 486768";
		
		String[] in = input.split(" ");
		
		String num1 = in[0];
		String num2 = null;
		
		for (int i = 0;i != in.length;++i)
		{
			if (!in[i].equals(" "))
			{
				num2 = in[i];
			}
		}
		
		System.out.println(num1 + " " + num2);
		
		System.out.println(add(num1, num2));
		System.out.println(multiply(num1, num2));
	}
	
	public static String add(String num1, String num2)
	{
		String out = "";
		
		//Adds zeros to the number with the lesser length;
		while (num1.length() != num2.length())
		{
			if (num1.length() > num2.length())
			{
				num2 = "0" + num2;
			}
			else
			{
				num1 = "0" + num1;
			}
		}
		
		int remainder = 0;
		
		for (int i = num1.length()-1;i >= 0;--i)
		{
			int sum = num1.charAt(i) + num2.charAt(i) - 96 + remainder;
			
			if (remainder > 0)
				remainder = 0;
			
			if (sum >= 10)
			{
				sum -= 10;
				++remainder;
			}
			
			out += sum;
		}
		
		if (remainder > 0)
			out += 1;
		
		for (int i = out.length()-1;i >= 0;--i)
		{
			out = out + out.charAt(i);
		}
		
		out = out.substring(out.length()/2, out.length());
		
		return out;
	}
	
	public static String multiply(String num1, String num2)
	{
		String out = "0";
		
		//[0] = totalDecimalPlace, [1] = num1 without a ., [2] = num2 without a .
		Object[] decimalInformation = getDecimalInformation(num1, num2);
		
		int decimalLocation = (int)decimalInformation[0];
		
		num1 = (String)decimalInformation[1];
		num2 = (String)decimalInformation[2];
		
		System.out.println(decimalLocation);
		
		//Saves time, by switching the number, if the number being added is smaller, thus making it run less times.
		if (num2.length() > num1.length())
		{
			String n = num1;
			
			num1 = num2;
			num2 = n;
		}
		
		for (String i = "0";!i.equals(num2);i = add(i, "1"))
		{
			out = add(out, num1);
		}
		
		if (decimalLocation > 0)
		{
			out = out.substring(0, out.length()-decimalLocation) + "." + out.substring(out.length()-decimalLocation, out.length());
		}
		
		return out;
	}
	
	public static Object[] getDecimalInformation(String num1, String num2)
	{
		Object[] information = new Object[3];
		
		int decimalLocation = 0;
		
		//Removes the .
		if (num1.contains("."))
		{
			decimalLocation += num1.length()-num1.indexOf(".")-1;
			num1 = num1.substring(0, num1.indexOf(".")) + num1.substring(num1.indexOf(".")+1, num1.length());
		}
		
		if (num2.contains("."))
		{
			decimalLocation += num2.length()-num2.indexOf(".")-1;
			num2 = num2.substring(0, num2.indexOf(".")) + num2.substring(num2.indexOf(".")+1, num2.length());
		}
		
		information[0] = decimalLocation;
		information[1] = num1;
		information[2] = num2;
		
		return information;
	}
}
