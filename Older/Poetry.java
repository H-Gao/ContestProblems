import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;


public class Poetry 
{
	public static void main(String[] args)
	{
		System.out.println(getRhyme());
	}
	
	public static String getRhyme()
	{
		Scanner in = new Scanner(System.in);
		
		int numPoems = getInteger(in);
		
		boolean[] isVowel = { true, false, false, false, true, false, false, false, true, false,
				false, false, false, false, true, false, false, false, false, 
				false, true, false, false, false, false };
		
		for (int ver = 0;ver < numPoems;++ver)
		{
			HashMap<String, String> foundRhymes = new HashMap<String, String>();
			
			//Does this for each verse.
			for (int i = 0;i < 4;++i)
			{			
				//Extracts the word from the sentence.
				String verse = in.nextLine();
				
				String word = verse.substring(verse.lastIndexOf(' ')+1, verse.length()).toLowerCase();
				char[] wordChar = word.toCharArray();
				
				String substr = null;
				
				for (int n = wordChar.length-1;n >= 0;--n)
				{
					int currentChar = wordChar[n]-'a';
					
					if (isVowel[currentChar])
					{
						substr = word.substring(n, word.length());
						n = -1;
					}
				}
				
				if (substr == null)
					substr = word;
				
				if (foundRhymes.get(substr) == null)
					foundRhymes.put(substr, ""+(i+1));
				else
					foundRhymes.put(substr, foundRhymes.get(substr) + " " + (i+1));
			}
			
			if (foundRhymes.size() == 1)
			{
				System.out.println("perfect");
			}
			else if (foundRhymes.size() == 2)
			{
				System.out.println(getRules(foundRhymes));
			}
		}
		
		return "";
	}
	
	public static String getRules(HashMap<String, String> foundRhymes)
	{
		Object[] rhymesKeys = foundRhymes.keySet().toArray();
		
		String[] rhymes = new String[2];
		rhymes[0] = foundRhymes.get(rhymesKeys[0]);
		rhymes[1] = foundRhymes.get(rhymesKeys[1]);
		
		if (rhymes[0].equals("1 2") && rhymes[1].equals("3 4") ||
				rhymes[1].equals("1 2") && rhymes[0].equals("3 4"))
			return "even";
		else if (rhymes[0].equals("1 3") && rhymes[1].equals("2 4") ||
				rhymes[1].equals("1 3") && rhymes[0].equals("2 4"))
			return "cross";
		else if (rhymes[0].equals("1 4") && rhymes[1].equals("2 3") ||
				rhymes[1].equals("1 4") && rhymes[0].equals("2 3"))
			return "shell";
		
		return "free";
	}
	
	public static int getInteger(Scanner in) 
	{
		int out = in.nextInt();
		in.nextLine();
		
		return out;
	}
}
