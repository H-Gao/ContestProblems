package CCCWaterlooContestPractise;

import java.util.Scanner;

public class Punchy 
{
	static boolean isDone = false;
	static int A = 0;
	static int B = 0;
	
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		
		while (true)
		{
			try
			{
				String command = scanner.nextLine();
				String[] commandList = command.split(" ");
			
				int commandID = Integer.parseInt(commandList[0]);
			
				doCommand(commandID, commandList);
			
				if (isDone)
					break;
			}
			catch (Exception exception)
			{
				System.out.println("Synthax Error");
				isDone = true;
			}
		}
	}
	
	public static void doCommand(int commandID, String[] commandList)
	{
		if (commandID == 1)
		{
			if (commandList[1].equals("A"))
				A = Integer.parseInt(commandList[2]);
			
			else if (commandList[1].equals("B"))
				B = Integer.parseInt(commandList[2]);
			
			else
			{
				System.out.println("Synthax Error");
				isDone = true;
			}
		}
		
		if (commandID == 2)
		{
			if (commandList[1].equals("A"))
				System.out.println(A);
			
			else if (commandList[1].equals("B"))
				System.out.println(B);
			
			else
			{
				System.out.println("Synthax Error");
				isDone = true;
			}
		}
		
		if (commandID == 3)
		{
			if (commandList[1].equals("A"))
			{
				if (commandList[2].equals("A"))
					A += A;
				
				if (commandList[2].equals("B"))
					A += B;
			}
			
			else if (commandList[1].equals("B"))
			{
				if (commandList[2].equals("A"))
					B += A;
				
				if (commandList[2].equals("B"))
					B += B;
			}
			
			else
			{
				System.out.println("Synthax Error");
				isDone = true;
			}
		}
		
		if (commandID == 4)
		{
			if (commandList[1].equals("A"))
			{
				if (commandList[2].equals("A"))
					A *= A;
				
				if (commandList[2].equals("B"))
					A *= B;
			}
			
			else if (commandList[1].equals("B"))
			{
				if (commandList[2].equals("A"))
					B *= A;
				
				if (commandList[2].equals("B"))
					B *= B;
			}
			
			else
			{
				System.out.println("Synthax Error");
				isDone = true;
			}
		}
		
		if (commandID == 5)
		{
			if (commandList[1].equals("A"))
			{
				if (commandList[2].equals("A"))
					A -= A;
					
				if (commandList[2].equals("B"))
					A -= B;
			}
				
			else if (commandList[1].equals("B"))
			{
				if (commandList[2].equals("A"))
					B -= A;
					
				if (commandList[2].equals("B"))
					B -= B;
				}
				
			else
			{
				System.out.println("Synthax Error");
				isDone = true;
			}
		}
		
		if (commandID == 6)
		{
			if (commandList[1].equals("A"))
			{
				if (commandList[2].equals("A"))
					A /= A;
				
				if (commandList[2].equals("B"))
					A /= B;
			}
			
			else if (commandList[1].equals("B"))
			{
				if (commandList[2].equals("A"))
					B /= A;
				
				if (commandList[2].equals("B"))
					B /= B;
			}
			
			else
			{
				System.out.println("Synthax Error");
				isDone = true;
			}
		}
		
		if (commandID == 7)
		{
			isDone = true;
		}
	}
}
