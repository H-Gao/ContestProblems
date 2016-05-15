import java.util.Stack;
import java.util.Scanner;

public class Matching 
{
	public static void main(String[] args)
	{
		//Creates a stack object
		Stack<Character> searchingFor = new Stack<Character>();
		
		//Creates the input from the command line.
		Scanner in = new Scanner(System.in);
		
		//Allows the user to input a String.
		String str = in.nextLine();
		//The length of the string that the user inputed.
		int length = str.length();
		
		//String outputs valid or invalid.
		boolean isValid = true;
		
		//If the length is a odd number, then it won't work.
		if (length%2 != 0)
			isValid = false;
		//If the length is a even number, then it works.
		else
		{
			//Runs a loop, until it searches for all numbers, or if proven invalid.
			for (int i = 0;i != str.length();++i)
			{
				//The character in the index of i.
				char n = str.charAt(i);
			
				//If it is the beginning characters.
				if (n == '{' || n == '<' || n == '[' || n == '(')
				{
					//It adds the cooresponding character to the stack.
					if (n == '{')
						searchingFor.push('}');
					else if (n == '<')
						searchingFor.push('>');
					else if (n == '[')
						searchingFor.push(']');
					else if (n == '(')
						searchingFor.push(')');
				}
				//If it is the ending characters.
				else if (n == '}' || n == '>' || n == ']' || n == ')')
				{
					//If the current character matches the character in the stack.
					if (n == searchingFor.pop())
					{
						isValid = true;
					}
					//If the current character does not match the current character in the stack, it will be invalid.
					else
					{
						isValid = false;
						break;
					}
				}
			}
		}
		
		if (isValid)
			System.out.println("Valid");
		else
			System.out.println("Invalid");
	}
}
