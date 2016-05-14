import java.util.Arrays;
import java.util.Scanner;


public class GolfStrokes 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int total = in.nextInt();
		
		int numGolfClubs = in.nextInt();
		
		int[] golfClubValues = new int[numGolfClubs];
		
		for (int i = 0;i < numGolfClubs;++i)
			golfClubValues[i] = in.nextInt();
		
		Arrays.sort(golfClubValues);
		
		findStrokes(total, golfClubValues[0], 0, 0);
	}
	
	public static void findStrokes(int A, int B, int startI, int numStrokes)
	{
		int strokes = A/B;
		int numLeft = A%B;
		
		numStrokes += strokes;
	}
}
