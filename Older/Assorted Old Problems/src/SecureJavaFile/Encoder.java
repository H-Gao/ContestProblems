package SecureJavaFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Encoder 
{
	public static String directory = "C:\\Judo Workspace\\Default\\src";
	
	public static int key1 = 3;
	public static int key2 = 4;
	public static int key3 = 2;
	public static int key4 = 6;
	
	public static void main(String[] args) throws InterruptedException
	{
		while (true)
		{
			Scanner in = new Scanner(System.in);
			
			checkCommand(in.nextLine());
		}
	}
	
	public static void checkCommand(String in) throws InterruptedException
	{
		try
		{
			String[] command = null;
			
			if (in.contains(" "))
			{
				command = in.split(" ");
			}
			else
			{
				command = new String[1]; 
				command[0] = in;
			}
			
			if (command[0].equalsIgnoreCase("exit"))
			{
				System.exit(0);
			}
			else if (command[0].equalsIgnoreCase("encrypt"))
			{
				String selectedFile = directory + "\\" + command[1];
				String targetFile = selectedFile.substring(0, selectedFile.lastIndexOf("."));
				
				FileReader reader = new FileReader(selectedFile);
				Scanner input = new Scanner(reader);
				
				System.out.println(targetFile);
				
				PrintWriter out = new PrintWriter(targetFile + ".javenc");
				
				if (input.hasNextLine())
				{
					String text = input.nextLine();
					out.println(encode(text));
				}
				
				while (input.hasNextLine())
				{
					String text = input.nextLine();
					
					out.println(encode(text));
				}
				
				out.flush();
			}
			else if (command[0].equalsIgnoreCase("decrypt"))
			{
				String selectedFile = directory + "\\" + command[1];
				String targetFile = selectedFile.substring(0, selectedFile.lastIndexOf("."));
				
				FileReader reader = new FileReader(selectedFile);
				Scanner input = new Scanner(reader);
				
				PrintWriter out = new PrintWriter(targetFile + ".javdec");
				
				if (input.hasNextLine())
				{
					String text = input.nextLine();
					out.println(decode(text, text.length()-1));
				}
				
				while (input.hasNextLine())
				{
					String text = input.nextLine();
					
					out.println(decode(text, text.length()-1));
				}
				
				out.flush();
			}
			
			else if (command[0].equalsIgnoreCase("changedirectory"))
			{
				directory = command[1];
			}
			else
			{
				System.out.println("Invalid command.");
			}
		}
		catch (FileNotFoundException exception)
		{
			System.out.println("The file could not be saved");
			exception.printStackTrace();
		} 
		catch (IOException IOexception) 
		{
			IOexception.printStackTrace();
		}
	}

	public static String encode2(String str, int n)
	{
		String out = "";
		
		if (n == 0)
			out = str.charAt(0)+"";
		else if (n+1 < str.length())
			out = encode2(str, n-1) + (char)(str.charAt(n) + (key1 * key1) - key2 + n + n%key3);
		else
			out = encode2(str, n-1) + (char)(str.charAt(n) + (key1 * key1) - key2 - n%key4);
			
		return out;
			
	}
	
	public static String encode(String str)
	{
		String out = "";
		
		for (int n = 0;n != str.length();++n)
		{
			if (n == 0)
				out = str.charAt(0)+"";
			else if (n+1 < str.length())
				out += (char)(str.charAt(n) + (key1 * key1) - key2 + n + n%key3);
			else
				out += (char)(str.charAt(n) + (key1 * key1) - key2 - n%key4);
		}
			
		return out;
			
	}
	
	public static String decode(String str, int n)
	{
		String out = "";
		
		if (n == 0)
			out = str.charAt(0)+"";
		else if (n+1 < str.length())
			out = decode(str, n-1) + (char)(str.charAt(n) - (key1 * key1) + key2 - n - n%key3);
		else
			out = decode(str, n-1) + (char)(str.charAt(n) - (key1 * key1) + key2 + n%key4);
			
		return out;
	}
}
