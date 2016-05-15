import java.util.Scanner;

public class TheMap 
{	
	public static void main(String[] args) 
	{
		//this will working using points. Not lines.
		
		Scanner scanner = new Scanner(System.in);
		
		//This is rectangle one's X and Y points.
		int x[] = new int[1000];
		int y[] = new int[1000];
		//This is rectangle two's X and Y points.
		int secondX[] = new int[1000];
		int secondY[] = new int[1000];
		//Stores the side locations of rectangle one
		int sideX[] = new int[1000];
		int sideY[] = new int[1000];
		//Stores the side locations of rectangle two
		int secondSideX[] = new int[1000];
		int secondSideY[] = new int[1000];
		//The area, determined by counting all of the possible outcomes.
		int area = 0;
		//The perimeter
		int perimeter = 0;
		//These will help you set values X and Y.
		//They revert back to 0, when finished.
		int setX;
		int setY;
		//to Count to a certain number.
		int counter = 0;
		int counterTwo = 0;
		
		//Created a object called rectangleOne.
		Rectangle rectangleOne = new Rectangle();
		
		//Setting the coordinates.
		System.out.println("Please set rectangle one's X coordinate.");
		setX = scanner.nextInt();
		System.out.println("Please set rectangle one's Y coordinate.");
		setY = scanner.nextInt();
		rectangleOne.setPointOne(setX, setY);
		//Set SetX and SetY to 0, so I can use them agian.
		setX = 0;
		setY = 0;
		
		System.out.println("Once More Please.");
		
		//This is the second point, in the bottom-right.
		//I can use this to find the other two points.
		System.out.println("Please set rectangle one's X coordinate.");
		setX = scanner.nextInt();
		System.out.println("Please set rectangle one's Y coordinate.");
		setY = scanner.nextInt();
		rectangleOne.setPointFour(setX, setY);
		setX = 0;
		setY = 0;
		
		//Using the two points set by the user,
		//I can find the other two points.
		rectangleOne.setPointTwo(rectangleOne.getXOne(), rectangleOne.getYFour());
		rectangleOne.setPointTwo(rectangleOne.getXFour(), rectangleOne.getYOne());
		
		//Now that I have all four points I can create a triangle.
		//However I need to find all the Space that it takes up.
		//Note that the array number, is the Index number.
		//The stored number in the array, is the value to show if it
		//has been used or not.
		
		//For every time the X adds one, the Y adds more or equal in the case of One.
		//Therefore, it will generate all of the spaces inside.
		
		//To find the area, it counts all of the points, and deducts one if both 
		//rectangle's points are on the same point.
		for (int theX = rectangleOne.getXOne();theX != rectangleOne.getXFour()+1;++theX)
		{
			for (int theY = rectangleOne.getYOne();theY != rectangleOne.getYFour()+1;++theY)
			{
				++counter;
				++area;
				x[counter] = theX;
				y[counter] = theY;
			}
		}
		
		//To find the parameter it finds the location of the sides, and counts them.
		//One will be deducted if both rectangles have a point at the same place.
		for (int n = rectangleOne.getXOne();n != rectangleOne.getXFour();++n)
		{
			sideX[counterTwo] = n;
			sideY[counterTwo] = rectangleOne.getYOne();
			++counterTwo;
		}
		
		for (int n = rectangleOne.getYOne();n != rectangleOne.getYFour();++n)
		{
			sideX[counterTwo] = rectangleOne.getXFour();
			sideY[counterTwo] = n;
			++counterTwo;
		}
		
		for (int n = rectangleOne.getXOne();n != rectangleOne.getXFour();++n)
		{
			sideX[counterTwo] = n;
			sideY[counterTwo] = rectangleOne.getYFour();
			++counterTwo;
		}
		
		for (int n = rectangleOne.getYOne();n != rectangleOne.getYFour();++n)
		{
			sideX[counterTwo] = rectangleOne.getXOne();
			sideY[counterTwo] = n;
			++counterTwo;
		}
		
		counter = 0;
		
	   /*\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
		* |\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
		* |\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
		* |Now the same will be done for the second Rectangle|||
		* |/////////////////////////////////////////////////////
		* |////////////////////////////////////////////////////
		*/////////////////////////////////////////////////////
		
		//Created a object called rectangleTwo.
		Rectangle rectangleTwo = new Rectangle();
		
		//Setting the coordinates.
		System.out.println("Please set rectangle two's X coordinate.");
		setX = scanner.nextInt();
		System.out.println("Please set rectangle two's Y coordinate.");
		setY = scanner.nextInt();
		rectangleTwo.setPointOne(setX, setY);
		//Set SetX and SetY to 0, so I can use them agian.
		setX = 0;
		setY = 0;
		
		System.out.println("Once More Please.");
		
		//This is the second point, in the bottom-right.
		//I can use this to find the other two points.
		System.out.println("Please set rectangle two's X coordinate.");
		setX = scanner.nextInt();
		System.out.println("Please set rectangle two's Y coordinate.");
		setY = scanner.nextInt();
		rectangleTwo.setPointFour(setX, setY);
		setX = 0;
		setY = 0;
		
		//Using the two points set by the user,
		//I can find the other two points.
		rectangleTwo.setPointTwo(rectangleTwo.getXOne(), rectangleTwo.getYFour());
		rectangleTwo.setPointTwo(rectangleTwo.getXFour(), rectangleTwo.getYOne());
		
		//Now that I have all four points I can create a triangle.
		//However I need to find all the Space that it takes up.
		//Note that the array number, is the Index number.
		//The stored number in the array, is the value to show if it
		//has been used or not.
		
		//For every time the X adds one, the Y adds more or equal in the case of One.
		//Therefore, it will generate all of the spaces inside.
		for (int theX = rectangleTwo.getXOne();theX != rectangleTwo.getXFour()+1;++theX)
		{
			for (int theY = rectangleTwo.getYOne();theY != rectangleTwo.getYFour()+1;++theY)
			{
				++counter;
				++area;
				secondX[counter] = theX;
				secondY[counter] = theY;
			}
		}
		
		//To find the parameter it finds the location of the sides, and counts them.
		//One will be deducted if both rectangles have a point at the same place.
		for (int n = rectangleOne.getXOne();n != rectangleOne.getXFour();++n)
		{
			sideX[counterTwo] = n;
			sideY[counterTwo] = rectangleOne.getYOne();
			++counterTwo;
		}
				
		for (int n = rectangleOne.getYOne();n != rectangleOne.getYFour();++n)
		{
			sideX[counterTwo] = rectangleOne.getXFour();
			sideY[counterTwo] = n;
			++counterTwo;
		}
				
		for (int n = rectangleOne.getXOne();n != rectangleOne.getXFour();++n)
		{
			sideX[counterTwo] = n;
			sideY[counterTwo] = rectangleOne.getYFour();
			++counterTwo;
		}
				
		for (int n = rectangleOne.getYOne();n != rectangleOne.getYFour();++n)
		{
			sideX[counterTwo] = rectangleOne.getXOne();
			sideY[counterTwo] = n;
			++counterTwo;
		}
		
		for (int n = 0;n != 1000;++n)
		{
			for (int i = 0;i != 1000;++i)
			{
				if (x[n] == secondX[i] && y[n] == secondY[i] && noneAreZero(x[n], y[n], secondX[i], secondY[i]))
				{
					--area;
				}
			}
		}
		
		//Counts all of the sides, then adds it to the perimeter.
		for (int n = 0;n != 1000;++n)
		{
			if (sideX[n] != 0)
			{
				++perimeter;
			}
		}
		
		for (int n = 0;n != 1000;++n)
		{
			if (secondSideX[n] != 0)
			{
				++perimeter;
			}
		}
		
		for (int n = 0;n != 1000;++n)
		{
			for (int i = 0;i != 1000;++i)
			{
				if (sideX[n] == secondSideX[i] && sideY[n] == secondSideY[i] && noneAreZero(sideX[n], sideY[n], secondSideX[i], secondSideY[i]))
				{
					--perimeter;
				}
			}
		}
		
		//This is for testing purposes, This will be removed.
		System.out.println("This is triangle one's results");
		
		for(int counterTest = 0;counterTest != 100;++counterTest)
		{
			if (x[counterTest] > 0)
			{
				System.out.println("Point " + counterTest);
				System.out.println(x[counterTest] + ", " + y[counterTest]);
				System.out.println(" ");
				System.out.println(secondX[counterTest] + ", " + secondY[counterTest]);
			}
		}
		
		System.out.println("The area is " + area);
		//Needs testing
		//System.out.println("The perimeter is " + perimeter);
		
		System.out.println("Done.");
			
	}
	
	public static boolean noneAreZero(int num1, int num2, int num3, int num4)
	{
		if (num1 != 0 && num2 != 0 && num3 != 0 && num4 != 0)
		{
			return true;
		}
		
		else
		{
			return false;
		}
	}

}
