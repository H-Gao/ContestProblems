package Default;

import java.util.Scanner;

public class areaCode 
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		
		String phoneNumber;
		
		phoneNumber = scanner.nextLine();
		
		if (phoneNumber.substring(0, 3).equals("416") || phoneNumber.substring(0, 3).equals("647"))
		{
			System.out.println("This is a toronto phone number");
		}
		
		else if (phoneNumber.substring(0, 3).equals("905"))
		{
			System.out.println("This is a richmond hill phone number");
		}
		
		else if (phoneNumber.substring(0, 3).equals("555"))
		{
			System.out.println("This is a waterloo phone number");
		}
		
		System.out.println("The phone number is " + phoneNumber);
	}
}
