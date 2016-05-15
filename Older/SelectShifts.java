import java.util.Scanner;


public class SelectShifts 
{
	static int wantedStartShift;
	static int wantedEndShift;
	
	static int startTime;
	static int endTime;
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int mostTimeSpent = 0;
		String bestChoice = "";
		
		extractTime(in.nextLine(), wantedStartShift, wantedEndShift, 0);
		
		int numShifts = Integer.parseInt(in.nextLine());
		
		for (int i = 0;i < numShifts;++i)
		{
			String input = in.nextLine();
			
			extractTime(input, startTime, endTime, 1);
			
			int missedStartMinutes = startTime - wantedStartShift;
			int missedEndMinutes = endTime - wantedEndShift;
			
			if (missedStartMinutes < 0)
				missedStartMinutes = 0;
			
			if (missedEndMinutes > 0)
				missedEndMinutes = 0;
			
			int timeSpent = (wantedEndShift - wantedStartShift) - missedStartMinutes + missedEndMinutes;
			
			if (timeSpent > mostTimeSpent)
			{
				mostTimeSpent = timeSpent;
				bestChoice = input;
			}
		}
		
		if (mostTimeSpent == 0)
			System.out.println("Call in a sick day.");
		
		System.out.println(bestChoice);
	}
	
	//Puts the time in minutes, into the start and end arrays.
	public static void extractTime(String in, int start, int end, int n)
	{
		char[] time = in.toCharArray();
		
		for (int i = 0;i < 10;i += 8)
		{
			//The first time in the format xx:yyNN, meaning xx.
			int hours = (time[i] - 48)*10 + (time[i + 1] - 48);
			
			//The second time in the format xx:yyNN, meaning yy.
			int minutes = (time[i + 3] - 48)*10 + (time[i + 4] - 48);
			
			String amPm = (char)time[i + 5] + "" + (char)time[i + 6];
			
			if (amPm.equals("PM"))
				hours += 12;
			
			if (i == 0)
				start = hours*60 + minutes;
			else
				end = hours*60 + minutes;

		}
		
		if (n == 0)
		{
			wantedStartShift = start;
			wantedEndShift = end;
		}
		else
		{
			startTime = start;
			endTime = end;
		}
	}
}
