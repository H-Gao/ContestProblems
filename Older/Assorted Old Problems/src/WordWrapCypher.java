import java.util.ArrayList;
import java.util.Scanner;


public class WordWrapCypher 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		for (int line = 0;line < 5;++line)
		{
			int W = Integer.parseInt(in.nextLine());
			
			char[] enc = in.nextLine().toCharArray();
			
			int numRotate = enc.length/W;
			char[][] aligned = new char[W][numRotate];
			
			for (int i = 0;i < enc.length;++i)
				aligned[i/numRotate][i%numRotate] = enc[i];
			
			String alignedStr = "";
			
			for (int a = 0;a < enc.length/W;++a)
				for (int b = 0;b < W;++b)
					alignedStr += aligned[b][a];
			
			for (int a = 0;a < enc.length/W;++a)
			{
				for (int b = 0;b < W;)
				{
					char currentChar = aligned[b][a];
					
					if (currentChar != '_')
					{
						System.out.print(currentChar);
						++b;
					}
					else
					{
						System.out.print(" ");
						for (int n = b;a < alignedStr.length();++a) if (aligned[n][a] != '_')
						{
							b = n;
							break;
						}
					}
					
				}
			}
			
			System.out.println();
		}
	}
}
