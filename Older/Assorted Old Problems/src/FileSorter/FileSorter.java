package FileSorter;

import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileSorter 
{
	public static void main(String[] args)
	{
		try
		{
			String output = "";
			
			FileReader reader = new FileReader("C:\\FileSorter\\SortMe.txt");
			Scanner scanner = new Scanner(reader);
			
			output += scanner.nextLine() + ",";
			
			while (scanner.hasNextLine())
			{
				output += scanner.nextLine() + ",";
			}
			
			String k = "";
			
			for (int n = 0;n != output.length();++n)
				if (output.charAt(n) != ' ' && output.charAt(n) != '*')
					k += output.charAt(n);
			
			output = k;
			
			k = "";
			
			String[] data = output.split(",");
			
			for (int n = 0;n != data.length;++n)
			{
				k += data[n];
				k += ", ";
			}
			
			output = k;
			
			PrintWriter writer = new PrintWriter("C:\\FileSorter\\Output.txt");
			
			writer.print(output.substring(0, output.length()-2) + "\n\n - sorted by Henry's program.");
			writer.close();
		}
		catch (Exception exception)
		{
			System.out.println("Something broke.");
			exception.printStackTrace();
		}
	}
}
