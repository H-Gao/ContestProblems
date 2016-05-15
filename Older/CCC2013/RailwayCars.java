package CCC2013;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RailwayCars 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int w = in.nextInt();
		int n = in.nextInt();
		
		int c = 0;
		int tot = 0;
		
		Queue<Integer> cars = new LinkedList<Integer>();
		
		for (int i = 0;i < n;++i)
		{
			if (cars.size() == 4)
				tot -= cars.poll();
			
			if (i != 0)
				++c;
			
			int car = in.nextInt();
			
			cars.add(car);
			tot += car;
			
			if (tot > w) break;
		}
		
		System.out.println(c);
	}
}
