import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Stack;

public class TotalLineScanner 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		Stack<File> files = new Stack<File>();
		files.add(new File(in.nextLine()));
		
		int numFiles = 0;
		int numLines = 0;
		
		while (!files.isEmpty())
		{
			File file = files.pop();
			
			File[] subFolders = file.listFiles();
			
			if (subFolders != null)
			for (int i = 0;i < subFolders.length;++i)
			{
				String subFile = subFolders[i].toString();
				
				if (!subFile.contains("."))
				{
					files.add(new File(subFile));
					System.out.println(subFile);
				}
				else
				{
					String extension = (subFile.substring(subFile.lastIndexOf('.'), subFile.length()));
					
					if (extension.equals(".java"))
					{
						numLines += getLines(subFile);	
						
						++numFiles;
						System.out.println(subFile);
					}
				}
			}
		}
		
		System.out.println(numFiles);
		System.out.println(numLines);
	}
	
	public static int getLines(String in)
	{
		int totalLines = 0;
		
		try
		{
			Scanner reader = new Scanner(new FileReader(new File(in)));
		
			while (reader.hasNextLine())
			{
				String str = reader.nextLine();
				char[] strChar = str.toCharArray();
				
				str = clearSpace(str);
				
				if (!str.startsWith("~") && !str.startsWith("//"))
				{
					int indexComment = str.indexOf("/*");
					
					if (indexComment != 0) ++totalLines;
					
					if (indexComment > -1)
					{
						String newStr;
						while ((newStr = clearSpace(reader.nextLine())).indexOf("*/") == -1) {}
						
						if (newStr.indexOf("*/") != 0) ++totalLines;
					}
				}
			}
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
		}
		
		return totalLines;
	}
	
	public static String clearSpace(String in)
	{
		char[] strChar = in.toCharArray();
		int lineStart = -1;
		
		for (int i = 0;i < strChar.length;++i)
		{
			if (strChar[i] != ' ' && strChar[i] != (char)(9))
			{
				lineStart = i;
				break;
			}
		}
		
		if (lineStart > -1) return in.substring(lineStart, in.length());
		else return "~";
	}
}
