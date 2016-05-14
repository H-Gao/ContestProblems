import java.util.Scanner;


public class Misspelling 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int numCases = Integer.parseInt(in.nextLine());
		
		for (int i = 0;i < numCases;++i)
		{
			System.out.print((i+1) + " ");
			
			String input = in.nextLine();
			char[] inputChar = input.toCharArray();
			
			//The index starts at 1, as opposed to 0.
			int misspeltIndex = Integer.parseInt(input.substring(0, input.indexOf(' '))) + 1;
			
			//Prints the characters, except for the one that is misspelt.
			for (int n = (""+misspeltIndex).length()+1;n < input.length();++n)
				if (n != misspeltIndex)
					System.out.print(inputChar[n]);
			
			System.out.println();
		}
	}
}
