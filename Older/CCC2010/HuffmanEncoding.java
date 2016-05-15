package CCC2010;

import java.util.HashMap;
import java.util.Scanner;

public class HuffmanEncoding 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		String catcher = in.nextLine();
		
		HashMap<String, String> digits = new HashMap<String, String>();
		
		for (int i = 0;i < N;++i)
		{
			String[] input = in.nextLine().split(" ");
			
			digits.put(input[1], input[0]);
		}
		
		char[] message = in.nextLine().toCharArray();
		
		String finding = "";
		for (int i = 0;i < message.length;++i)
		{
			finding += message[i];
			
			if (digits.get(finding) != null)
			{
				System.out.print(digits.get(finding));
				finding = "";
			}
		}
	}
}
