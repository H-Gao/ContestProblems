import java.util.Scanner;


public class LongestWord 
{
	static final int EMPTY = -1;
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		System.out.println(LongestWord(in.nextLine()));
	}
	  
	public static String LongestWord(String sen) 
	{
		char[] senChar = sen.toCharArray();
		sen = "";
		    
		String word = "";
		int maxLength = EMPTY;
		    
		for (int i = 0;i < senChar.length;++i)
		{
		  char currentChar = senChar[i];
		      
		  if (currentChar >= 'a' && currentChar <= 'z') 
			  word += currentChar;
		  else
		  {
			  if (word.length() > maxLength)
			  {
				  maxLength = word.length();
				  sen = word;
			  }
			  
			  word = "";
		  }
		}
	    
	    return sen;  
	}
}
