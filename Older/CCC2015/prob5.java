package CCC2015;

import java.util.Scanner;

public class prob5 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int happy = 0;
		int sad = 0;
		
		char[] input = in.nextLine().toCharArray();
		
		for (int i = 0;i < input.length-2;++i)
		{
			if (input[i] == ':' && input[i+1] == '-' )
			{
				if (input[i+2] == ')') ++happy;
				else if (input[i+2] == '(') ++sad;
			}
		}
		
		if (happy == 0 && sad == 0) System.out.println("none");
		else if (happy == sad) System.out.println("unsure");
		else if (happy > sad) System.out.println("happy");
		else if (happy < sad) System.out.println("sad");
	}
}
