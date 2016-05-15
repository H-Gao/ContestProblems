import java.math.BigDecimal;
import java.util.Scanner;


public class prob1 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		while (in.hasNextLine())
		{
			String input = in.nextLine();
			
			String baseString = "";
			String exponentString = "";
			
			for (int i = 0;i != input.length();++i)
			{				
				if (i > 0 && input.charAt(i) != ' ' && input.charAt(i-1) == ' ' )
				{
					for (int n = i;n < input.length();++n)
					{
						if (input.charAt(n) != ' ')
						{
							exponentString += input.charAt(n);
						}
					}
					
					break;
				}
				else if (input.charAt(i) != ' ')
				{
					baseString += input.charAt(i);
				}
			}
			
			System.out.println(solution(Double.parseDouble(baseString), Integer.parseInt(exponentString)));
		}
	}
	
	public static String solution(double base, int exp)
	{
		if (exp == 0)
			return ""+base;
		else
		{
			BigDecimal s = new BigDecimal(base);
			
			for (int i = 0;i < (exp-1);++i)
			{
				s = s.multiply(new BigDecimal(base));
			}
			
			String outString = "";
			
			if (outString.lastIndexOf(".") == outString.length()-2 && outString.charAt(outString.length()-1) == '0')
			{
				return ""+s.intValueExact();
			}
			else
			{
				return ""+s;
			}
		}
	}
}
