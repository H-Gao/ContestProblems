import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;


public class BeadsQuestion 
{
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner in = new Scanner(new FileReader("bead.in"));
		
		String str = in.nextLine();
		
		String[] values = new String[str.length()-1];
		
		for (int i = 1;i != str.length();++i)
		{
			String firstPart = str.substring(0, i);
			String secondPart = str.substring(i, str.length());
			
			values[i-1] = (int)(countA(i, firstPart) + countB(i, secondPart)) + " " + i;
		}
		
		/*for (int i = 0;i != values.length;++i)
		{
			int value = Integer.parseInt(values[i].split(" ")[0]);
			int ID = Integer.parseInt(values[i].split(" ")[1]);
			
			System.out.println(value + " " + ID);
		}*/
		
		int maximumValue = 0;
		
		for (int i = 0;i != values.length;++i)
		{
			int value = Integer.parseInt(values[i].split(" ")[0]);
			
			if (value > maximumValue)
				maximumValue = value;
		}
		
		PrintWriter out = new PrintWriter("bead.out");
		out.println(maximumValue);
		out.close();
		
		System.exit(0);
	}
	
	public static int countA(int i, String firstPart)
	{
		int length = firstPart.length();
		
		char lastA = firstPart.charAt(length-1);
		
		String a = ""+lastA;
		
		if (lastA == 'w')
		{
			a = "w";
			
			for (int n = length-1;lastA == 'w';--n)
			{
				lastA = firstPart.charAt(n);
				
				if (n == -1)
				{
					lastA = 'w';
					break;
				}
			}
		}
		
		if (i > 1)
		{
			for (int n = firstPart.length()-2;n != -1;--n)
			{
				if (firstPart.charAt(n) == lastA || firstPart.charAt(n) == 'w')
					a += firstPart.charAt(n);
				else
					break;
			}
		}
		
		return a.length();
	}
	
	public static int countB(int i, String firstPart)
	{
		char lastA = firstPart.charAt(0);
		
		String a = ""+lastA;
		
		if (lastA == 'w')
		{
			a = "w";
			
			for (int n = 0;lastA == 'w';++n)
			{
				lastA = firstPart.charAt(n);
				
				if (n == firstPart.length())
				{
					lastA = 'w';
					break;
				}
			}
		}
		
		if (i > 1)
		{
			for (int n = 1;n != firstPart.length();++n)
			{
				if (firstPart.charAt(n) == lastA || firstPart.charAt(n) == 'w')
					a += firstPart.charAt(n);
				else
					break;
			}
		}
		
		return a.length();
	}
}
