package CostFinder;

import java.io.FileReader;
import java.util.Scanner;

public class CostFinder 
{
	public static void main(String[] args)
	{
		try
		{
			double sum = 0;
			
			FileReader reader = new FileReader("C:\\CostFinder\\Input.txt");
			Scanner scanner = new Scanner(reader);
			
			while (scanner.hasNextLine())
			{
				String line = scanner.nextLine();
				
				if (line.contains(".") && !line.contains("/") && !line.contains("?") && !line.contains("&") && !line.contains("_"))
				{
					String number = "";
					
					for (int n = 0;n != line.length();++n)
					{
						if (line.charAt(n) == '1' || line.charAt(n) == '2' || line.charAt(n) == '3' || line.charAt(n) == '4' || line.charAt(n) == '5' || line.charAt(n) == '6' || line.charAt(n) == '7' || line.charAt(n) == '8' || line.charAt(n) == '9' || line.charAt(n) == '0' || line.charAt(n) == '.')
							number += line.charAt(n);
					}
					
					sum += Double.parseDouble(number);
				}
			}
			
			System.out.println(1.13 * sum);
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
		}
	}
}
