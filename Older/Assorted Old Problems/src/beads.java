import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

/*
ID: roadtop1
LANG: JAVA
TASK: beads
*/

public class beads 
{
	static int MOVE_FORWARD = 1;
	static int MOVE_BACKWARD = -1;
	
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner input = new Scanner(new FileReader("beads.in"));
		
		String numberOfBeads = input.nextLine();
		String in = input.nextLine();
		
		input.close();
		
		in = in + in;
		
		int sum = 0;
		int prevSum = 0;
		
		for (int i = 0;i != in.length();++i)
		{
			int start = i;
		
			sum = 1;
		
			if (in.equals("") || in.equals(" "))
				sum = 0;
				
			if (start+1 < in.length())
			{
				int secondSum = findOut(in, start+1, start+1, MOVE_FORWARD, 's') + findOut(in, start, start, MOVE_BACKWARD, 's');
			
				if (secondSum > sum)
					sum = secondSum;
			}
		
			if (start-1 >= 0)
			{
				int thirdSum = findOut(in, start, start, MOVE_FORWARD, 's') + findOut(in, start-1, start-1, MOVE_BACKWARD, 's');
			
				if (thirdSum > sum)
					sum = thirdSum;
			}
		
			if (sum > prevSum)
				prevSum = sum;
		}
		
		PrintWriter out = new PrintWriter("beads.out");
		out.println(prevSum);
		out.close();
		
		System.exit(0);
	}
	
	public static int findOut(String in, int i, int start, int direction, char startingChar)
	{
		//The output.
		int out = 0;
		
		//If the algorithm had not detected a starting character.
		if (startingChar == 's')
		{
			//If it starts with a 'w'.
			if (in.charAt(start) == 'w')
			{
				//The piece that will be viewed by the algorithm.
				String selectedPiece = null;
				
				//If it is set to move forward.
				if (direction == MOVE_FORWARD)
					selectedPiece = in.substring(start, in.length());
				// if it is set to move backwards.
				else
					selectedPiece = in.substring(0, start);
					
				//The location of the first 'r'.
				int indexOfRed = selectedPiece.indexOf('r');
				//The location of the first 'b'.
				int indexOfBlue = selectedPiece.indexOf('b');
					
				if (indexOfRed == -1)
					indexOfRed = 100000;
					
				if (indexOfBlue == -1)
					indexOfBlue = 100000;

				//If the location of red is smaller than blue.
				if (direction == MOVE_FORWARD && indexOfRed < indexOfBlue
						|| direction == MOVE_BACKWARD && indexOfRed > indexOfBlue)
					startingChar = 'r';
					
				//If the location of blue is smaller than red.
				else if (direction == MOVE_FORWARD && indexOfRed > indexOfBlue
						|| direction == MOVE_BACKWARD && indexOfRed < indexOfBlue)
					startingChar = 'b';
					
				//If the neither red nor blue is located in the section.
				else if (indexOfRed == -1 && indexOfBlue == -1)
					return in.length();
			}
			//If it starts with a 'r' or a 'b'.
			else
			{
				startingChar = in.charAt(start);
			}
		}
			
		if (direction == MOVE_FORWARD && i < in.length() || direction == MOVE_BACKWARD && i >= 0)
		{
			//The current character.
			char currentChar = in.charAt(i);
			
			if (currentChar == startingChar || currentChar == 'w')
			{
				++out;
				out += findOut(in, i+direction, start, direction, startingChar);
			}
		}
		
		return out;
	}
	
	public static int findNum(String in, int start, int n, int direction)
	{
		char original = in.charAt(start);
		
		int out = 1;
		
		if (in.charAt(start) == 'w')
		{
			for (int i = 0;true;i += direction)
			{
				if (direction == MOVE_FORWARD && i >= in.length()
						|| direction == MOVE_BACKWARD && i < 0)
				{
					return in.length();
				}
				
				else if (in.charAt(i) != 'w')
				{
					original = in.charAt(i);
					break;
				}
			}
		}
		
		if (n == start || lastExists(in, n, -1*direction) && original == in.charAt(n+(-1*direction))
				|| lastExists(in, n, -1*direction) && in.charAt(n) == 'w' || lastExists(in, n, direction) && in.charAt(n+(-1*direction)) == 'w')
		{
			++out;
			out += findNum(in, start, n+direction, direction);
			
			if (in.charAt(n) != original && in.charAt(n) != 'w')
			{
				--out;
			}
		}	
		
		return out;
	}
	
	public static boolean lastExists(String in, int n, int direction)
	{
		boolean out = true;
		
		if (direction == MOVE_FORWARD)
		{
			if (n-1 < 0)
				out = false;
		}
		else if (direction == MOVE_BACKWARD)
		{
			if (n+1 >= in.length())
				out = false;
		}
		
		return out;
	}
}
