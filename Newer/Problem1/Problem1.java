package Problem1;

import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Problem1 
{
	public static void main(String[] args)
	{
		try
		{
			Scanner in = new Scanner(new FileReader(new File("DATA11.txt")));
			
			for (int i = 0;i < 10;++i)
			{
				String input = "";
				HashMap<String, Integer> colours = new HashMap<String, Integer>();
				
				while (!(input = in.nextLine()).equals("end of box"))
				{
					String identifier = input.charAt(0) + "" + input.charAt(1);
					
					if (colours.get(identifier) == null) colours.put(identifier, 0);
					colours.put(identifier, colours.get(identifier)+1);
				}
				
				Object[] keys = colours.keySet().toArray();
				
				int total = 0;
				
				for (int n = 0;n < keys.length;++n)
				{
					int val = colours.get(keys[n]);
					
					if (keys[n].equals("re")) total += val*16;
					else total += getSmarties(val) * 13;
				}
				
				System.out.println(total);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static int getSmarties(int i)
	{
		int k = 0;
		
		if (i%7 != 0) k = 1;
		return i/7 + k;
	}
}
