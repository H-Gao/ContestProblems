package Problem1;

import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Problem2 
{
	static int size;
	static String out;
	
	public static void main(String[] args)
	{		
		try
		{
			//Change back.
			Scanner in = new Scanner(new FileReader(new File("DATAA.txt")));
			
			//change to 10.
			for (int i = 0;i < 10;++i)
			{
				int cutOff = in.nextInt();
				String holder = in.nextLine(); //STOPS the Integer.
				
				out = "";
				String[] text = in.nextLine().split(" ");
				size = 0;
				
				for (int n = 0;n < text.length;++n)
				{
					String word = removePunc(text[n]);
					
					if (word.length() > cutOff)
					{
						//int spaceLeft = cutOff - size;
						System.out.println(out);
						outBounds(word, cutOff);
						//System.out.println(out);
						//System.out.println(word.substring(0, cutOff));
						//outBounds(word, cutOff);
						//out = word.substring(cutOff, word.length()) + " ";
						//size = word.substring(cutOff, word.length()).length()+1;
					}
					else if (size + word.length() <= cutOff)
					{
						out += word + " ";
						size += word.length()+1;
					}
					else
					{
						System.out.println(out);
						out = word + " ";
						size = word.length()+1;
					}
				}
				
				System.out.println(out);
				System.out.println("=====");
			}
		}
		catch (Exception e)
		{
			
		}
	}
	
	public static String removePunc(String str)
	{
		char[] p = { ',', '.', '"', "'".charAt(0), '?', '!', ';', ':'};
		
		char[] strChar = str.toCharArray();
		String out = "";
		
		for (int i = 0;i < str.length();++i)
		{
			for (int n = 0;n < p.length;++n)
			{
				if (strChar[i] == p[n]) break;
				else if (n == p.length-1) out += strChar[i];
			}
		}
		
		return out;
	}
	
	public static void outBounds(String str, int cutOff)
	{
		char[] strChar = str.toCharArray();
		
		String out = "";
		for (int i = 0;i < strChar.length/cutOff;++i)
		{
			for (int n = 0;n < cutOff;++n)
			{
				out += strChar[i];
			}
		}
		
		for (int i = 0;i < strChar.length/cutOff;++i)
		{
			
		}
	}
}
