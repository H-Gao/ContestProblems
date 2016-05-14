import java.util.Scanner;


public class ACarefulReply 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int numReplies = Integer.parseInt(in.nextLine());
		
		for (int i = 0;i < numReplies;++i)
		{
			String input = in.nextLine();
			
			char[] replyChar = input.toCharArray();
			
			int numHearts = 0;
			
			for (int n = 0;n < input.length()-1;++n)
				if (replyChar[n] == '<' && replyChar[n+1] == '3')
					++numHearts;
			
			System.out.print("<3");
				
			for (int n = 0;n < numHearts;++n)
				System.out.print(" <3");
				
			System.out.println();
		}
	}
}
