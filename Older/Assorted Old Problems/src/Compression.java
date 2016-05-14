import java.util.Scanner;


public class Compression 
{
	public static void main(String[] args)
	{
		for (int c = 0;c < 5;++c)
		{
			Scanner in = new Scanner(System.in);
		
			String[] dimens = in.nextLine().split(" ");
			int a = Integer.parseInt(dimens[0]), b = Integer.parseInt(dimens[1]);
			
			char[] input = in.nextLine().toCharArray();
			String decomped = "";
			
			int compNum = 1;
			
			//Decompression.
			for (int i = 0;i < input.length;++i)
			{
				char currentChar = input[i];
				
				if (currentChar >= '0' && currentChar <= '9')
					compNum = currentChar-'0';
				else
				{ 
					for (int n = 0;n < compNum;++n)
						decomped += input[i];
					
					compNum = 1;
				}
			}
			
			//Recompression.
			char[] decompedChar = decomped.toCharArray();
			
			if (b == 1) for (int i = 0;i < a;++i) 
				for (int n = 0;n < b;++n) 
					System.out.println(decompedChar[(n*a) + i]);
			else
			for (int i = 0;i < a;++i)
			{	
				int flag = 1;
				
				for (int n = 0;n < b;++n)
				{
					char currentChar = decompedChar[(n*a) + i];
					
					if (n < b-1 && decompedChar[((n+1)*a) + i] == currentChar)
						++flag;
					else
					{
						if (flag > 1) System.out.print(flag + "" + (char)currentChar);
							else System.out.print(currentChar);
						
						flag = 1;
					}
				}
			}
		}
	}
}
