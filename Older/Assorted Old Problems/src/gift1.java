import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/*
ID: roadtop1
LANG: JAVA
TASK: gift1
*/
public class gift1 
{
	public static void main(String[] args) throws Exception
	{
		//Creates a Scanner object.
		FileReader reader = new FileReader("gift1.in");
		Scanner in = new Scanner(reader);
		
		int amountOfPeople = Integer.parseInt(in.nextLine());
		
		String[] person = new String[amountOfPeople];
		int[] gives = new int[amountOfPeople];
		int[] receives = new int[amountOfPeople];
		
		for (int n = 0;n != amountOfPeople;++n)
			person[n] = in.nextLine();
		
		for (int n = 0;n != amountOfPeople;++n)
		{
			int ID = toID(person, in.nextLine());
			
			String givenInformation = in.nextLine();
			
			int amountGiven = Integer.parseInt(givenInformation.split(" ")[0]);
			
			int dividedAmong = Integer.parseInt(givenInformation.split(" ")[1]);
			
			if (amountGiven != 0)
			{
				gives[ID] = amountGiven - amountGiven%dividedAmong;
			
				for (int i = 0;i != dividedAmong;++i)
				{
					int ReceiverID = toID(person, in.nextLine());
				
					receives[ReceiverID] += amountGiven/dividedAmong;
				}
			}
			else
			{
				//This line of code only moves the file along.
				for (int i = 0;i != dividedAmong;++i) in.nextLine();
			}
		}
		
		PrintWriter out = new PrintWriter("gift1.out");
		
		for (int n = 0;n != amountOfPeople;++n)
			out.println(person[n] + " " + (receives[n] - gives[n]));
		
		out.close();
		System.exit(0);
	}
	
	public static int toID(String[] person, String searchFor)
	{
		//Linear search for "Search For"
		for (int n = 0;n != person.length;++n)
			if (person[n].equals(searchFor))
				return n;
		
		//If nothing is returned
		return -1;
	}
}
