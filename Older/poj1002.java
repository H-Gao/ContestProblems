import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;


public class poj1002 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		SortedMap<String, Integer> m = new TreeMap<String, Integer>();
		
		//0 = non-existant, others are 2, 2, 2, 3, 3, 3, 4...
		char[] map = { '2', '2', '2', '3', '3', '3', '4', '4', '4', '5', '5', '5', '6', '6', '6', '7', '0', '7', '7', '8', '8', '8', '9', '9', '9', '0' };
		
		int numCases = Integer.parseInt(in.nextLine());
		
		for (int i = 0;i < numCases;++i)
		{
			String input = in.nextLine();
			
			String phoneNumber = "";
			
			for (int n = 0;n < input.length();++n)
			{
				char c = input.charAt(n);
				
				if (c >= 'A' && c <= 'Z')
				{
					phoneNumber += map[c-65];
				}
				else if (c >= '0' && c <= '9')
				{
					phoneNumber += c;
				}
			}
			
			phoneNumber = phoneNumber.substring(0, 3) + "-" + phoneNumber.substring(3, 7);
			
			if (!m.containsKey(phoneNumber))
			{
				m.put(phoneNumber, 1);
			}
			else
			{
				m.put(phoneNumber, m.get(phoneNumber)+1);
			}
		}
		
		Object[] values = m.values().toArray();
		Arrays.sort(values);
		
		if ((int)values[values.length-1] <= 1)
		{
			System.out.println("No duplicates.");
		}
		else
		{
			for (String i : m.keySet())
			{
				int numTimesAppeared = m.get(i);
				
				if (numTimesAppeared > 1)
					System.out.println(i + " " + numTimesAppeared);
			}
		}
	}
}
