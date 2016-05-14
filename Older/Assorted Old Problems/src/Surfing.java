import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Surfing 
{
	static boolean canLink;
	
	//Returns whether or not the String has been used before.
	static HashMap<String, Boolean> finishedStrings = new HashMap<String, Boolean>();
	
	static HashMap<String, Integer> intValue = new HashMap<String, Integer>();
	static ArrayList<ArrayList<String>> linkPath = new ArrayList<ArrayList<String>>();
	
	//This program includes spaces.
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int numWebsites = toInt(in.nextLine());
		
		String input;
		
		//Does this (numWebsites) times.
		for (int i = 0;i < numWebsites;++i)
		{
			ArrayList<String> temp = new ArrayList<String>();
			
			//The name of the website.
			String websiteName = in.nextLine();
			
			//Removes the empty space in the back.
			
			//Keeps looping until the end of the HTML file is reached, which is denotated with </HTML>.
			while (!(input = in.nextLine()).equals("</HTML> "))
			{
				//It will start at 0.
				int startOfIndex = input.indexOf("<A HREF=");
				
				//-If it does not appear, it will return -1.
				while (startOfIndex != -1)
				{
					//Removes the useless portion.
					input = input.substring(startOfIndex+8, input.length());
					
					//Finds the end of the link.
					int endOfIndex = input.indexOf(">");
					
					//Extracts the name.
					String linkedName = input.substring(0, endOfIndex);
					
					System.out.println("Link from " + websiteName + " to " + linkedName);
					
					temp.add(linkedName);
					
					//Resets it.
					input = input.substring(endOfIndex, input.length());
					startOfIndex = input.indexOf("<A HREF=");
				}
			}
			
			intValue.put(websiteName, i);
			linkPath.add(temp);
		}
		
		while (!(input = in.nextLine()).equals("The End"))
		{
			String dest = in.nextLine();
			
			input = input.substring(0, input.length()-1);
			dest = dest.substring(0, dest.length()-1);
			
			canLink = false;
			
			//Will make canLink true, if it finds a path.
			findPath(input, dest);
			
			if (canLink)
				System.out.println("Can surf from " + input + " to " + dest);
			else
				System.out.println("Can't surf from " + input + " to " + dest);
		}
	}
	
	public static void findPath(String current, String dest)
	{
		if (current.equals(dest))
		{
			canLink = true;
		}
		else if (finishedStrings.get(current) == null)
		{
			int val = getValue(current);
			
			if (val > -1)
			{
				ArrayList<String> currentPaths = linkPath.get(val);
				
				finishedStrings.put(current, true);
				
				for (int i = 0;i < currentPaths.size();++i)
					findPath(currentPaths.get(i), dest);
			}
		}
	}
	
	//Gets the int value of a string.
	public static int toInt(String in)
	{
		char[] inChar = in.toCharArray();
		
		int out = 0;
		
		for (int i = 0;i < inChar.length;++i)
		{
			if (inChar[i] != ' ')
			{
				out += inChar[i] - '0';
			}
		}
		
		return out;
	}
	
	public static int getValue(String in)
	{
		if (intValue.get(in) != null)
			return intValue.get(in);
		else
			return -1;
	}
}
