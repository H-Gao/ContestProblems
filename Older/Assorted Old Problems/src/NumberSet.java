
public class NumberSet 
{
	static String foundSubsets = "";
	
	public static void main(String[] args)
	{
		run("1234");
	}
	
	public static void findSubset(String s)
	{
		if (s.length() > 0)
		{
			for (int i = 0;i != s.length();++i)
			{
				String output = "";
				
				for (int n = 0;n != s.length();++n)
					if (n != i)
						output += s.charAt(n);
			
				if (!output.equals("") && !foundSubsets.contains(output))
				{
					findSubset(output);
					
					foundSubsets += output;
					System.out.println(output);
				}
			}
		}
	}
	
	public static void run(String s)
	{
		findSubset(s);
		
		System.out.println(s);
	}
}
