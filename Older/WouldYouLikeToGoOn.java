import java.util.Scanner;

public class WouldYouLikeToGoOn 
{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		
		String input = "";
		
		while (!input.equalsIgnoreCase("quit"))
		{
			System.out.println("Would you like to go on? Enter 'yes' to go on, or Enter 'Quit' to exit");
			
			input = scanner.nextLine();
			
			if (input.equalsIgnoreCase("yes"))
			{
				System.out.println("You have chosen to go on.");
			}
			
			else if (!input.equalsIgnoreCase("quit"))
			{
				System.out.println("You can only enter Yes or Quit... Don't enter " + input);
			}
		}
		
		System.out.println("You have chosen to quit, Good Bye.");
	}
}
