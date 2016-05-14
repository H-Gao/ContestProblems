import java.util.Scanner;


public class MountainPassage 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int numTrips = in.nextInt();
		
		for (int i = 0;i < numTrips;++i)
		{
			int numUnits = in.nextInt();
			
			//The elevations in the form of x, y.
			int[][] elevations = new int[numUnits][numUnits];
			
			for (int n = 0;n < numUnits*numUnits;++n)
				elevations[n/numUnits][n%numUnits] = in.nextInt();
			
			System.out.println();
			
			System.out.println(elevations[0][1]);
			
			for (int x = 0;x < numUnits;++x)
			{
				for (int y = 0;y < numUnits;++y)
				{
					System.out.print(elevations[x][y]);
				}
				
				System.out.println();
			}
		}
	}
}
