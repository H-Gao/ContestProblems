package Problem1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Queue;
import java.util.Scanner;

public class Problem4 
{
	static int total = 0;
	static HashMap<String, Boolean> done = new HashMap<String, Boolean>();
	
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner in = new Scanner(new FileReader(new File("DATA41.txt")));
		
		for (int i = 0;i < 10;++i) recurse("", in.nextLine(), "");
		System.out.println(total);
	}
	
	public static void recurse(String n, String l, String se)
	{
		String check = n;
		
		for (int i = 0;i < l.length();++i)
		{
			check += l.charAt(i);
			
			if (match(check) != 0) //If it matches.
			{
				recurse(check, l.substring(i+1, l.length()), se);
				recurse("", l.substring(i+1, l.length()), se + " " + match(check));
				break;
			}
		}
		
		if (n.equals("") && l.equals("") && done.get(se) == null)
		{
			++total;
		}
	}
	
	public static int match(String str)
	{
		switch (str)
		{
		case "ook": return 1;
		case "ookook": return 2;
		case "oog": return 3;
		case "ooga": return 4;
		case "ug": return 5;
		case "mook": return 6;
		case "mookmook": return 7;
		case "oogam": return 8;
		case "oogum": return 9;
		case "ugug": return 10;
		}
		
		return 0;
	}
}
