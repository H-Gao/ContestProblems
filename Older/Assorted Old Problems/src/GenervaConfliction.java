import java.util.Scanner;
import java.util.Stack;

public class GenervaConfliction 
{
	public static void main(String[] args)
	{
		//Creates a scanner object to read the input form the keyboard.
		Scanner scanner = new Scanner(System.in);
		
		//Creates a stack object, it represents the branch.
		Stack<Integer> branch = new Stack<Integer>();
		
		//The number of tests to preform.
		int numTests = scanner.nextInt();
		
		//Returns true if all cars are in the lake.
		boolean allCarsAreInLake[] = new boolean[numTests];
		
		for (int i = 0;i != numTests;++i)
		{
			//The number of cars to be put into the lake or the branch.
			int numCars = scanner.nextInt();
			
			//The cars that will be put into the lake or the branch.
			int[] cars = new int[numCars];
			
			//Pushes the cars into the right order.
			for (int n = 0;n != numCars;++n)
			{
				cars[n] = scanner.nextInt();
			}
			
			//Keeps track of the cars.
			int tracker = 1;
			
			//Pushes the cars into either the branch or the lake.
			for (int n = cars.length-1;n != -1;--n)
			{
				//If the car number is equal to the tracker it will go into the lake.
				if (cars[n] == tracker)
					++tracker;
				//If it is not the right car, it will go onto the branch.
				else
					branch.push(cars[n]);
			}
			
			//If the cars are all successfully put into the lake, it will return true.
			allCarsAreInLake[i] = true;
			
			//Pushes the cars from the branch into the lake.
			for (int n = 0;!branch.isEmpty();++n)
			{
				//The pushed car.
				int pushedCar = branch.pop();
				
				if (pushedCar != tracker)
				{
					allCarsAreInLake[i] = false;
					break;
				}
				
				++tracker;
			}
		}
		
		for (int i = 0;i != numTests;++i)
		{
			if (allCarsAreInLake[i])
				System.out.println("Y");
			else
				System.out.println("N");
		}
	}
}
