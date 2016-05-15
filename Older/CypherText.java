import java.util.HashMap;
import java.util.Scanner;


public class CypherText 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		HashMap<Character, Character> mappedChar = new HashMap<Character, Character>();
		
		char[] plainText = in.nextLine().toCharArray();
		char[] cypherText = in.nextLine().toCharArray();
		
		for (int i = 0;i < plainText.length;++i)
		{
			char currentPlainChar = plainText[i];
			char currentCypherChar = cypherText[i];
			
			if (mappedChar.get(currentCypherChar) == null)
				mappedChar.put(currentCypherChar, currentPlainChar);
		}
		
		char[] input = in.nextLine().toCharArray();
		
		for (int i = 0;i < input.length;++i)
		{
			char currentChar = input[i];
			
			if (mappedChar.get(currentChar) != null)
				System.out.print(mappedChar.get(currentChar));
			else
				System.out.print('.');
		}
	}
}
