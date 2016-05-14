import java.util.Scanner;

public class MarsRover 
{
	static final int MOVE = 1;
	static final int TURNRIGHT = 2;
	static final int TURNLEFT = 3;
	
	static final int UP = 0;
	static final int RIGHT = 1;
	static final int DOWN = 2;
	static final int LEFT = 3;
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int numExcursions = in.nextInt();

		int input;
		
		for (int i = 0;i < numExcursions;++i)
		{
			int x = 0, y = 0;
			int direction = UP;
			
			while ((input = in.nextInt()) != 0)
			{
				if (input == MOVE)
				{
					int moveAmount = in.nextInt();
					
					if (direction == UP) y -= moveAmount;
					else if (direction == RIGHT) x -= moveAmount;
					else if (direction == DOWN) y += moveAmount;
					else if (direction == LEFT) x += moveAmount;
				}
				else if (input == TURNRIGHT) ++direction;
				else if (input == TURNLEFT) --direction;
				
				if (direction < 0) direction = 3;
				else if (direction >= 4) direction = 0;
			}
			
			int tempX = x, tempY = y;
			if (isNegative(x)) tempX *= -1; if (isNegative(y)) tempY *= -1;
			
			int distance = tempX + tempY;
			System.out.println("Distance is " + distance);
			
			printSteps(x, tempX, direction);
			printSteps(y, tempY, direction);
		}
	}
	
	public static void printSteps(int in, int posIn, int direction)
	{
		int equation1 = 0, equation2 = 0;
		
		int needToGetTo = 0;
		
		if (in < 0) needToGetTo = LEFT;
		else if (in >= 0) needToGetTo = RIGHT;
		
		equation1 = (4 + direction) - needToGetTo;
		equation2 = needToGetTo - direction;
		
		char print = 0;
		int minSteps = 0;
		
		if (equation1 < equation2)
		{
			print = '2';
			minSteps = equation1;
		}
		else if (equation1 >= equation2)
		{
			print = '3';
			minSteps = equation2;
		}
		
		System.out.println(equation1 + " " + equation2);
		
		for (int n = 0;n < minSteps;++n)
			System.out.println(print);
			
		if (posIn > 0)
			System.out.println("1" + "\n" + posIn);
	}
	
	public static boolean isNegative(int in)
	{
		if (in < 0) return true;
		else return false;
	}
}
