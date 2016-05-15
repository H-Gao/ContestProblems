import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

/*
ID: roadtop1
LANG: JAVA
TASK: friday
*/
public class friday2 
{
	public static void main(String[] args) throws Exception
	{
		//BufferedReader in = new BufferedReader(new FileReader("friday.in"));
		
		int[] date = new int[7];
		
		PrintWriter out = new PrintWriter("friday.out");
		
		int year = 168;//Integer.parseInt(in.readLine());
		
		String[] data = new String[year+1];
		
		findDay(data, 1900 + year, 1900);
		
		for (int n  = 0;n != year;++n)
		{
			char[] arr = data[n].toCharArray();
			
			Arrays.sort(arr);
			
			System.out.println((1900+n) + " " + data[n]);
			
			for (int i = 10;i != arr.length;++i)
			{
				if (arr[i] == '1')
					++date[1];
				else if (arr[i] == '2') 
					++date[2];
				else if (arr[i] == '3') 
					++date[3];
				else if (arr[i] == '4') 
					++date[4];
				else if (arr[i] == '5') 
					++date[5];
				else if (arr[i] == '6') 
					++date[6];
				else if (arr[i] == '0') 
					++date[0];
			}
		}
		
		System.out.println(date[6]);
		System.out.println(date[0]);
		System.out.println(date[1]);
		System.out.println(date[2]);
		System.out.println(date[3]);
		System.out.println(date[4]);
		System.out.println(date[5]);
	}
	
	public static String findDay(String[] data, int year, int target)
	{
		String dates;
		
		//Will keep looping until it reaches the target year.
		if (year != target)
		{
			String lastYear = findDay(data, year-1, target);
			
			int dayOne = Integer.parseInt(lastYear.split(" ")[0]), dayTwo = Integer.parseInt(lastYear.split(" ")[1]), 
					dayThree = Integer.parseInt(lastYear.split(" ")[2]), dayFour = Integer.parseInt(lastYear.split(" ")[3]), 
					dayFive = Integer.parseInt(lastYear.split(" ")[4]), daySix = Integer.parseInt(lastYear.split(" ")[5]), 
					daySeven = Integer.parseInt(lastYear.split(" ")[6]), dayEight = Integer.parseInt(lastYear.split(" ")[7]),
					dayNine = Integer.parseInt(lastYear.split(" ")[8]), dayTen = Integer.parseInt(lastYear.split(" ")[9]),
					dayEleven = Integer.parseInt(lastYear.split(" ")[10]), dayTwelve = Integer.parseInt(lastYear.split(" ")[11]);
			
			//If it is a leap year...
			if (year%4==0)
			{
				dates = (dayOne+1)%7 + " " + (dayTwo+1)%7  + " " + (dayThree+1)%7+ " " + (dayFour+1)%7 + 
						" " + (dayFive+1)%7 + " " + (daySix+1)%7 + " " + (daySeven+1)%7 + " " + (dayEight+1)%7 + " " + (dayNine+1)%7
						 + " " + (dayTen+1)%7  + " " + (dayEleven+1)%7  + " " + (dayTwelve+1)%7;
			}
			//If the leap year after is is a leap year...
			if ((year-1)%4==0)
			{
				dates = (dayOne+2)%7 + " " + (dayTwo+2)%7  + " " + (dayThree+2)%7+ " " + (dayFour+2)%7 + 
						" " + (dayFive+2)%7 + " " + (daySix+2)%7 + " " + (daySeven+2)%7 + " " + (dayEight+2)%7 + " " + (dayNine+2)%7
						 + " " + (dayTen+2)%7  + " " + (dayEleven+2)%7  + " " + (dayTwelve+2)%7;
			}
			//Otherwise...
			else
			{
				dates = (dayOne+1)%7 + " " + (dayTwo+1)%7  + " " + (dayThree+1)%7+ " " + (dayFour+1)%7 + 
						" " + (dayFive+1)%7 + " " + (daySix+1)%7 + " " + (daySeven+1)%7 + " " + (dayEight+1)%7 + " " + (dayNine+1)%7
						 + " " + (dayTen+1)%7  + " " + (dayEleven+1)%7  + " " + (dayTwelve+1)%7;
			}
		}
		else
		{
			dates = "6 2 2 5 0 3 5 1 4 6 2 4";
		}
		
		data[year-1900] = dates;
		return dates;
	}
}
