import java.util.Scanner;


public class Censorship 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int numLines = Integer.parseInt(in.nextLine());
		
		for (int i = 0;i < numLines;++i)
		{
			String input = in.nextLine();
			int a = 0, b = input.indexOf(' ');
			
			while (b > -1)
			{
				String word = input.substring(a, b+1);
				
				if (word.length() == 5)
					System.out.print("**** ");
				else
					System.out.print(word);
				
				input = input.substring(b+1, input.length());
				
				b = input.indexOf(' ');
			}
			
			System.out.println(input + "\n");
		}
	}
}
