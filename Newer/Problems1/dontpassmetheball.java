package Problems1;

import java.util.HashMap;
import java.util.Scanner;

public class dontpassmetheball 
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		int answers = 0;
		int numPeople = in.nextInt();
		
		for (int c = 2;c < numPeople-1;++c)
			for (int b = 1;b < c;++b)
				for (int a = 0;a < b;++a)
					++answers;
		
		System.out.println(answers);
	}
}
