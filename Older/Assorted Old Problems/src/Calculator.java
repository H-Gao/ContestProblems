import java.util.Scanner;


public class Calculator 
{
	final int BRACKETS = 0;
	final int SQUARE = 1;
	final int MULTIPLICATION = 2;
	final int ADDITION = 3;
	
	public Double calculate(String in)
	{
		//To find char do S*2, S*2+1. S = 0, 0:1. S = 1, 2:3.
		char[] lookingFor = { ' ', ' ', '^', '^', '*', '/', '+', '-' };
		
		int stage = BRACKETS;
		
		char[] inChar = in.toCharArray();
		
		while (stage <= ADDITION)
		{
			for (int i = 0;i < in.length();++i)
			{
				char currentChar = inChar[i];
				
				char lookingFor1 = lookingFor[stage*2], lookingFor2 = lookingFor[stage*2+1];
				
				if (currentChar == lookingFor1 || currentChar == lookingFor2)
				{
					int index1 = in.length(), index2 = 0;
					
					for (int n = i+1;n < in.length();++n) if ((inChar[n] < '0' || inChar[n] > '9') && inChar[n] != '.')
					{
						index1 = n;
						break;
					}
					
					for (int n = i-1;n >= 0;--n) if ((inChar[n] < '0' || inChar[n] > '9') && inChar[n] != '.')
					{
						index2 = n+1;
						break;
					}
					
					double num_1 = Double.parseDouble(in.substring(i+1, index1)),
							num_2 = Double.parseDouble(in.substring(index2, i));
					
					in = in.substring(0, index2) + sum(num_1, num_2, currentChar) + in.substring(index1, in.length());
					inChar = in.toCharArray();
						
					i = 0;
				}
				else if (currentChar == '(')
				{
					int val = 1;
					int indexOf = i;
					
					for (int n = i+1;n < in.length();++n)
					{
						if (inChar[n] == '(')
							++val;
						else if (inChar[n] == ')')
							--val;
						
						if (val == 0)
							indexOf = n;
					}
					
					double sum = calculate(in.substring(i+1, indexOf));
					
					in = in.substring(0, i-1) + in.charAt(i-1) + sum + in.substring(indexOf+1, in.length());
					inChar = in.toCharArray();
					
					i = 0;
				}
			}
			
			++stage;
		}
		
		return Double.parseDouble(in);
	}
	
	public double sum(double num_2, double num_1, char stage)
	{
		double out = 0;
		
		if (stage == '^')
			out = Math.pow(num_1, num_2);
		
		else if (stage == '*')
			out = num_1 * num_2;
		
		else if (stage == '/')
			out = num_1 / num_2;
		
		else if (stage == '+')
			out = num_1 + num_2;
		
		else if (stage == '-')
			out = num_1 - num_2;
		
		return out;
	}
	
	public static void main(String[] args)
	{
		//Makes a calculator object.
		Calculator calc = new Calculator();
		
		Scanner in = new Scanner(System.in);
		
		//Enters a input into the method.
		System.out.println(calc.calculate(in.nextLine()));
		in.close();
	}
}
