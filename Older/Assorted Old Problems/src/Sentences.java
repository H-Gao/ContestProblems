import java.util.ArrayList;
import java.util.Scanner;


public class Sentences 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int numCases = in.nextInt();
		
		for (int i = 0;i < numCases;++i)
		{
			int numA = in.nextInt();
			int numB = in.nextInt();
			int numC = in.nextInt();
			
			//An input which prevents in.nextInt() from causing the next line from being dupicated.
			String nullInput = in.nextLine();
			
			ArrayList<ArrayList<String>> words = new ArrayList<ArrayList<String>>();
			
			for (int x = 0;x < 3;++x)
			{
				int lastVal = 0;
				
				if (x == 0)
					lastVal = numA;
				else if (x == 1)
					lastVal = numB;
				else if (x == 2)
					lastVal = numC;
				
				ArrayList<String> temp = new ArrayList<String>();
				
				for (int n = 0;n < lastVal;++n)
					temp.add(in.nextLine());
				
				words.add(temp);
			}
			
			//Nested loop to find all possibilities.
			for (int a = 0;a < numA;++a)
			{
				for (int b = 0;b < numB;++b)
				{
					for (int c = 0;c < numC;++c)
					{
						System.out.println(words.get(0).get(a) + " " + words.get(1).get(b) + " " +  words.get(2).get(c));
					}
				}
			}
		}
	}
}
