package Default;

import java.io.*;
import java.util.Scanner;

public class FileReaderException 
{
	public static void main(String args[])
	{
		try
		{
			String filename = "someFile.txt";
			FileReader reader = new FileReader(filename);
			Scanner in = new Scanner(reader);
			String input = in.next();
			int value = Integer.parseInt(input);
			System.out.println(value);
		}
		catch (IOException e)
		{
			System.out.println(e.getMessage());
		}
		catch (NumberFormatException e)
		{
			System.out.println("Input was not a number");
		}
		finally
		{
			System.out.println("Good Bye.");
		}
	}
}
