import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;


public class Compaction 
{
	static Random random = new Random();
	
	public static void main(String[] args)
	{
		try 
		{
			int closeOperation = 1;
			
			if (closeOperation == 0)
			{
				PrintWriter makeIn = new PrintWriter("in.txt");
				
				int numLines = 20000;
				
				for (int i = 0;i < numLines;++i)
				{
					int length = random.nextInt(40);
					
					for (int n = 0;n < length;++n)
					{
						int currentChar = 65 + random.nextInt(20);
						
						makeIn.print(currentChar);
					}
					
					makeIn.println();
				}
				
				makeIn.close();
			}		
			else if (closeOperation == 1)
			{
				ArrayList<String> text = new ArrayList<String>();
				ArrayList<Integer> val = new ArrayList<Integer>();
				
				Scanner in = new Scanner(new FileReader("in.txt"));
				
				while (in.hasNextLine())
				{
					String input = in.nextLine();
					
					if (!input.equals(""))
					{
						char[] inputChar = input.toCharArray();
					
						Arrays.sort(inputChar);
						val.add((int)inputChar[0]);
					}
					
					text.add(input);
				}
				
				in.close();
				
				Collections.sort(val);
				
				int minNum = val.get(0);
				
				PrintWriter out = new PrintWriter("out.txt");
				
				for (String i : text)
				{
					char[] textChar = i.toCharArray();
					
					for (int n = 0;n < textChar.length;++n)
						out.print((char)(textChar[n]-minNum));
					
					out.println();
				}
				
				out.close();
			}
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
}
