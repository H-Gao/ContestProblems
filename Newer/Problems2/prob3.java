package Problems2;

import java.util.Scanner;

public class prob3 
{
	static int[] diff1;
	static int[] diff2;
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		char[] encrypted = in.nextLine().toCharArray();
		char[] word = in.nextLine().toCharArray();
		
		diff1 = new int[encrypted.length-1];
		diff2 = new int[encrypted.length-1];
		
		for (int i = 0;i < encrypted.length-1;++i) diff1[i] = encrypted[i] + encrypted[i+1];
		for (int i = 0;i < word.length-1;++i) diff2[i] = word[i] + word[i+1];
	}
	
	public static boolean hasWord(String input, int index)
	{
		boolean isWord = false;
		
		if (index+diff2.length >= diff1.length) return false;
		else
		{
			for (int i = 0;i < diff2.length;++i)
			{
				
			}
		}
			
		
		return isWord;
	}
}
