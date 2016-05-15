import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/*
ID: roadtop1
LANG: JAVA
TASK: friday
*/
public class friday 
{
	//What day was the thirteenth on?
	static int[] onDate = new int[7];
	
	//Monday is one, Tuesday is two... Saturday is six, Sunday is zero.
	static int whatDay = 13;
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{	
		BufferedReader in = new BufferedReader(new FileReader("friday.in"));
		PrintWriter out = new PrintWriter("friday.out");
		
		int numberOfYears = Integer.parseInt(in.readLine());
		
		for (int years = 1900;years != 1900+numberOfYears;++years)
		{
			for (int months = 0;months != 12;++months)
			{
				//January
				checkMonth(0, 31, months, onDate);
				
				//If it is a leap year.
				if (years%4==0 && years%100!=0 || years%400==0)
				{
					//Febuary
					checkMonth(1, 29, months, onDate);
				}
				else
				{
					//Febuary
					checkMonth(1, 28, months, onDate);
				}
				
				//March
				checkMonth(2, 31, months, onDate);
				
				//April
				checkMonth(3, 30, months, onDate);
				
				//May
				checkMonth(4, 31, months, onDate);
				
				//June
				checkMonth(5, 30, months, onDate);
				
				//July
				checkMonth(6, 31, months, onDate);
				
				//August
				checkMonth(7, 31, months, onDate);
				
				//September
				checkMonth(8, 30, months, onDate);
				
				//October
				checkMonth(9, 31, months, onDate);
				
				//November
				checkMonth(10, 30, months, onDate);
				
				//December
				checkMonth(11, 31, months, onDate);
			}
		}
		
		out.println(onDate[6] + " " + onDate[0] + " " + onDate[1] + " " + onDate[2] + " " + onDate[3] + " " + onDate[4] + " " + onDate[5]);
		out.close();
		
		System.exit(0);
	}
	
	public static void checkMonth(int checkFor, int numDays, int months, int[] onDate)
	{
		if (months == checkFor)
		{
				//If it is the thirteenth day...
				++onDate[whatDay%7];
				
				whatDay += numDays;
		}
	}
}
