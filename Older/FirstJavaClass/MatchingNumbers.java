package FirstJavaClass;
import java.util.Scanner;

public class MatchingNumbers 
{

	public static void main(String[] args) 
	{
	    Scanner scanner = new Scanner(System.in);
	    
	    //n means number of times.
		int n = 0;
		int p = 0;
		System.out.println("How many numbers in total do you want?");
		//user inputs how many times in total it will run.
		p = scanner.nextInt();
		n = p*2;
		
		boolean isFirst = true;
		int a[] = new int[n];
		int b[] = new int[n];
		String chooseAorB = "none";
		String theOutput = "";
		
		System.out.println("Type A or B.");
		System.out.println("Repeat this " + (n/2) + " Times.");
		
		for (int x = 0;x!=n;++x)
		{
			chooseAorB = scanner.nextLine();
			
			if (chooseAorB.equals("a"))
			{
				System.out.println("Please type a number");
				a[x] = scanner.nextInt();
			}
			
			if (chooseAorB.equals("b"))
			{
				System.out.println("Please type a number");
				b[x] = scanner.nextInt();
			}	
			
			chooseAorB = "";
		}
		
		for (int k = 0;k!=n;++k)
		{
			for (int x = 0;x!=n;++x)
			{
				if (a[x] == b[0+k])
				{
					if (a[x] != 0)
					{
						if (!isFirst)
						{
							theOutput += ", ";
						}
						
						theOutput += a[x];
						isFirst = false;
					}
				}
			}
		}
		
		System.out.println("The numbers that are in both are:");
		System.out.println(theOutput);
	}

}
