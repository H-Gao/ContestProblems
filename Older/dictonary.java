import java.util.HashMap;
import java.util.Scanner;


public class dictonary 
{
	static HashMap<String, Integer> dictonary = new HashMap<String, Integer>();
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int numCases = Integer.parseInt(in.nextLine());
		
		for (int i = 0;i < numCases;++i)
		{
			String input = in.nextLine();
			
			while (!input.equals(""))
			{
				String out = "";
				String[] splitedInput = input.split(" ");
				
				for (int n = 0;n < splitedInput.length;++n)
				{
					String currentVal = splitedInput[n];
					
					if (dictonary.get(currentVal) == null)
					{
						out += currentVal + " ";
						dictonary.put(currentVal, dictonary.size()+1);
					}
					else
					{
						out += dictonary.get(currentVal) + " ";
					}
				}
				
				System.out.println(out);
				
				input = in.nextLine();
			}
			
			dictonary.clear();
		}
	}
}
