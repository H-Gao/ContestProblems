import java.util.Scanner;

public class TimeOnTask 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int input[] = new int[40];
		int lowest = 99999;
		int expiredNumber = 0;
		int counter = 0;
		int choresDone = 0;
		
		System.out.println("Enter how many tasks you have");
		
		int x = sc.nextInt() + 1;
		
		System.out.println("Enter the amount of time you have");
		
		input[0] = sc.nextInt();
		
		System.out.println("Enter the time it takes to complete each task");
		
		for (int n = 1;n != x;++n)
		{
			input[n] = sc.nextInt();
			
			if (input[n] == 0)
			{
				input[n] = 99999999;
			}
		}
		
		int time = input[0];
		
		for (int m = 0;m != x-1;++m)
		{
			lowest = 99999;
			
			for (int n = 0; n != x-1;++n)
			{
				//System.out.println(lowest + " " + input[n + 1]);
				if (input[n + 1] < lowest)
				{
					lowest = input[n + 1];
					expiredNumber = n + 1;
					
					//System.out.println(lowest + " " + expiredNumber);
				}
			}
			
			if ((time - lowest) >= 0 && lowest != 0)
			{
				++choresDone;
				time -= lowest;
				input[expiredNumber] = 9999999;
			}
		}
		
		System.out.println("You can complete a maximum of " + choresDone + " Complete Tasks");
		
	}
}
