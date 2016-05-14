package RPGGame;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.Scanner;

public class Stats 
{
	int strength;
	int intelligence;
	int dexterity;
	int charisma;
	
	public Stats()
	{
		try 
		{
			FileReader reader = new FileReader("C:\\RPG\\PlayerData\\Stats.txt");
			Scanner in = new Scanner(reader);
			
			String output[] = in.next().split("_");
			
			for (int n = 0;n != output.length;++n)
				setVariable(n, Short.parseShort(output[n]));
			
			System.out.println(outputType(0) + strength + " " + outputType(1) + intelligence + " " + outputType(2) + dexterity + " " + outputType(3) + charisma);
		}
		 catch (FileNotFoundException exception){}
	}
	
	public int setVariable(int n, int amount)
	{
		if (n == 0)
		 return strength = amount;
		else if (n == 1)
			 return intelligence = amount;
		else if (n == 2)
			 return dexterity = amount;
		else
			 return charisma = amount;
	}
	
	public String outputType(int n)
	{
		if (n == 0)
		 return "Stength: ";
		else if (n == 1)
			 return "Intelligence: ";
		else if (n == 2)
			 return "Dexterity: ";
		else
			 return "Charisma: ";
	}
	
	public static void main(String[] args)
	{
		Stats stats = new Stats();
	}
}
