import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;


public class BarkingDogs 
{
	static HashMap<Integer, ArrayList<Integer>> willBark = new HashMap<Integer, ArrayList<Integer>>();
	static Queue<Integer> willStopBarking = new LinkedList<Integer>();
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int numDogs = in.nextInt();
		
		int[] numBarks = new int[numDogs];
		
		boolean[] isBarking = new boolean[numDogs];
		int[] waitTime = new int[numDogs];
		
		for (int i = 0;i < numDogs;++i)
			waitTime[i] = in.nextInt();
		
		int numInteractions = in.nextInt();
		
		ArrayList<ArrayList<Integer>> interactions = new ArrayList<ArrayList<Integer>>();
		
		in.nextLine();
		
		for (int i = 0;i < numDogs;++i)
			interactions.add(new ArrayList<Integer>());
		
		for (int i = 0;i < numDogs;++i)
		{
			String[] input = in.nextLine().split(" ");
			
			int barkingDog = Integer.parseInt(input[0])-1;
			int hearingDog = Integer.parseInt(input[1])-1;
			
			interactions.get(barkingDog).add(hearingDog);
		}
		
		int maxTime = in.nextInt();
		
		ArrayList<Integer> temp = new ArrayList<Integer>();
		temp.add(0);
		
		//Sets the first dog to bark when T = 0.
		willBark.put(0, temp);
		isBarking[0] = true;
		
		for (int T = 0;T <= maxTime;++T)
		{
			if (!willBark.isEmpty())
			{
				//Gets the dogs that will bark when time = T.
				ArrayList<Integer> dogs = willBark.get(T);
				
				if (dogs != null)
				{
					for (int i = 0;i < dogs.size();++i)
					{
						int currentDog = dogs.get(i);
						
						++numBarks[currentDog];
						
						//The dogs will stop barking after the wait time, but they bark during the wait time.
						while (!willStopBarking.isEmpty())
							isBarking[willStopBarking.poll()] = false;
						
						willStopBarking.add(currentDog);
						
						for (int n = 0;n < interactions.get(currentDog).size();++n)
						{
							int hearingDog = interactions.get(currentDog).get(n);
							
							if (!isBarking[hearingDog])
							{
								temp = willBark.get(T+waitTime[hearingDog]);
								
								if (temp == null)
								{
									willBark.put(T+waitTime[hearingDog], new ArrayList<Integer>());
									temp = willBark.get(T+waitTime[hearingDog]);
								}
								
								temp.add(hearingDog);
								
								willBark.put(T+waitTime[hearingDog], temp);
								isBarking[hearingDog] = true;
							}
						}
					}
				}
			}
			
			else break;
		}
		
		for (int i = 0;i < numBarks.length;++i)
		{
			System.out.println(numBarks[i]);
		}
	}
}
