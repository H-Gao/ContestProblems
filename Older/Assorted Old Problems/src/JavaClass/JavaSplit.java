package JavaClass;

import java.util.Scanner;

public class JavaSplit 
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		
		String input = scanner.nextLine();
		
		String[] data = input.split(",");
		
		for (int n = 0;n != data.length;++n)
		{
			try
			{
				if (data[n].charAt(0) != ' ')
					System.out.println(data[n]);
			}catch (Exception exception) {}
		}
	}
}
