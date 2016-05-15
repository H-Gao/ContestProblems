package CCCWaterlooContestPractise;

import java.util.Scanner;

public class SpeedFinesAreNotFine 
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the speed limit: ");
		int speedLimit = scanner.nextInt();
		
		System.out.println("Enter the recorded speed of the car: ");
		int speed = scanner.nextInt();
		
		int amountOver = speed - speedLimit;
		
		if (amountOver <= 0)
			System.out.println("Congratulations, you are within the speed limit!");
		else if (amountOver >= 1 && amountOver <= 20)
			System.out.println("You are speeding and your fine is $100.");
		else if (amountOver >= 21 && amountOver <= 30)
			System.out.println("You are speeding and your fine is $270.");
		else if (amountOver >= 31)
			System.out.println("You are speeding and your fine is $500.");
	}
}
