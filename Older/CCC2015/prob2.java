package CCC2015;

import java.util.HashMap;
import java.util.Scanner;

public class prob2 
{
	static HashMap<String, Integer> conv = new HashMap<String, Integer>();
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int J = in.nextInt();
		int A = in.nextInt();
		
		String catcher = in.nextLine();
		
		int[] size = new int[J];
		int given = 0;
		
		doConv();
		
		for (int i = 0;i < J;++i)
		{
			size[i] = conv.get(in.nextLine());
		}
		
		for (int i = 0;i < A;++i)
		{
			String[] input = in.nextLine().split(" ");
			
			int wantedSize = conv.get(input[0]);
			int realSize = size[Integer.parseInt(input[1])-1];
			
			if (wantedSize <= realSize)
			{
				++given;
				size[Integer.parseInt(input[1])-1] = -1;
			}
		}
		
		System.out.println(given);
	}
	
	public static void doConv()
	{
		conv.put("S", 0);
		conv.put("M", 1);
		conv.put("L", 2);
	}
}
