import java.util.Random;


public class AKnightsJourney 
{
	public static void main(String[] args)
	{
		int numRow = 6;
		int numCol = 6;
		
		int[][] n = new int[numCol][numRow];
		
		for (int i = 0;i < 100;++i)
		{
			n[new Random().nextInt(numCol)][new Random().nextInt(numRow)] = 1;
		}
		
		for (int y = 0;y < numRow;++y)
		{
			for (int x = 0;x < numRow;++x)
			{
				System.out.print(n[y][x]);
			}
			
			System.out.print("\n");
		}
	}
}
