package CCCWaterlooContestPractise;

import java.util.Scanner;

public class WaterlooContest5 
{
	public static void main(String[] args)
	{
		boolean isBad = false;
		
		Scanner scanner = new Scanner(System.in);
		
		int students = scanner.nextInt();
		
		//IGNORE THIS BLOCKER.
		String blocker = scanner.nextLine();
		
		String line1 = scanner.nextLine();
		String line2 = scanner.nextLine();
		
		if (students%2==0)
		{
			
			String students1[] = line1.split(" ");
			String students2[] = line2.split(" ");
			
			for (int n = 0;n != students;++n)
			{
				
				String partner1 = students1[n];
				String partner2 = students2[n];
				
				if (line2.contains(partner1) && line1.contains(partner2))
				for (int k = 0;k != students;++k)
				{
					
					if (students2[k].equals(partner1))
					{
						
						if (!students1[k].equals(partner2))
							isBad = true;
						
						break;
					}
				}
				else
					isBad = true;
				
				if (isBad)
				{
					
					System.out.println("bad");
					break;
				}
				else if (n == students-1)
					System.out.println("good");
			}
		}
		else 
		{
			
			System.out.println("bad");
		}
	}
}