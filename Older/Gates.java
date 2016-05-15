import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;


public class Gates 
{
	static ArrayList<Integer[]> sub = new ArrayList<Integer[]>();
	
	static HashMap<String, Integer> finished = new HashMap<String, Integer>();
	
	public static void main(String[] args)
	{
		//Stores the key and values for fast searching, and to match ascending and descending.
		SortedMap<String, Integer> ascending = new TreeMap<String, Integer>();
		SortedMap<String, Integer> descending = new TreeMap<String, Integer>();
		
		//The scanner object that reads the user input.
		Scanner in = new Scanner(System.in);
		
		//The user input.
		String[] input = in.nextLine().split(" ");
		
		//The extracted data.
		int numGates = Integer.parseInt(input[0]);
		int walkSpeed = Integer.parseInt(input[1]);
		int numWalkways = Integer.parseInt(input[2]);
		int numQueries = Integer.parseInt(input[3]);
		
		for (int i = 0;i < numWalkways;++i)
		{
			//The user input.
			String[] walkwayInput = in.nextLine().split(" ");
			
			//The start and end of the walkway.
			int start = Integer.parseInt(walkwayInput[0]), end = Integer.parseInt(walkwayInput[1]);
			
			//If it is ascending.
			if (start < end)
				ascending.put(start + " " + end, Integer.parseInt(walkwayInput[2]));
			//If it is descending.
			else
				descending.put(start + " " + end, Integer.parseInt(walkwayInput[2]));
		}
		
		for (int i = 0;i < numQueries;++i)
		{
			//The user input.
			String[] querieInput = in.nextLine().split(" ");
			
			//The starting and ending gates.
			int startGate = Integer.parseInt(querieInput[0]);
			int endGate = Integer.parseInt(querieInput[1]);
			
			//If it is ascending.
			if (startGate < endGate)
			{
				ArrayList<String> keys = new ArrayList<String>(ascending.keySet());
				
				int keySize = keys.size();
				
				Integer[] substringInput = new Integer[keySize];
				
				//The possible values.
				ArrayList<Integer[]> values = new ArrayList<Integer[]>();
				
				//Finds and adds the values that are within the range of the gate, and adds it to a list.
				for (int x = 0;x < keySize;++x)
				{
					//The current key, which is taken from the ascending list, keyset.
					String[] key = keys.get(x).split(" ");
					
					//The start and end of the walkway, taken from the current key.
					int st = Integer.parseInt(key[0]), end = Integer.parseInt(key[1]);
					
					//It must be within the values of the startGate and the endGate, if not it will not be added to a list.
					if (st >= startGate && end <= endGate)
					{
						//The start and end of the walkway.
						Integer[] add = new Integer[2];
						
						//Adds the start and end to the array.
						add[0] = st; add[1] = end;
						
						//Adds the array to the list.
						values.add(add);
					}
				}
				
				String combinations = "";

				Integer[] currentKeys;
				
				int firstInteger = 0;
				int lastInteger = 0;
				
				int lastIntegerValue = 0;
				
				for (int x = 0;x < values.size();++x)
				{
					currentKeys = values.get(x);
					
					firstInteger = currentKeys[0];
					
					if (x == 0 || lastInteger == firstInteger && lastIntegerValue != x)
					{
						//The last integer of a key.
						lastInteger = currentKeys[1];
						
						lastIntegerValue = x;
						
						combinations += currentKeys[0] + " " + currentKeys[1];
						
						x = 0;
					}
				}
				
				System.out.println(combinations);
				
				while (keySize != 1000000);
				
				//Recursive and Loop version.
				for (int x = 0;x < keySize;++x)
				{
					substringInput[x] = x;
				}
				
				//Adds the input, since the substring algorithm does not add the input, itself.
				sub.add(substringInput);
				
				//Puts all the substrings into a list holding all the substrings.
				substring(substringInput);
				
				//Holds all the integers that are is not part of the range.
				ArrayList<Integer> unacceptedList = new ArrayList<Integer>();
				
				for (int x = 0;x < 10;++x)
				{
					
				}
				
				for (Integer[] x : sub)
				{
					int totalGatesPassed = 0;
					
					double timeTaken = 0;
					
					for (Integer y : x)
					{
						String currentKey = keys.get(y);
						
						int rate = ascending.get(currentKey);
						
						String[] splitedGate = currentKey.split(" ");
								
						int gatesPassed = Integer.parseInt(splitedGate[1]) - Integer.parseInt(splitedGate[0]);
						
						totalGatesPassed += gatesPassed;
						
						timeTaken += (double)(gatesPassed*100)/(double)rate;
						
						System.out.println(rate + " " + gatesPassed + " " + totalGatesPassed + " " + (double)(gatesPassed*100)/(double)rate);
					}
					
					//The remainder of the time is calculated.
					timeTaken += (endGate-startGate)*100/walkSpeed;
					
					System.out.println(timeTaken);
				}
			}
		}
	}
	
	//Gets all the non-repeating substrings.
	public static void substring(Integer[] in)
	{
		if (in.length > 1)
			for (int i = 0;i < in.length;++i)
			{
				int flag = 0;
			
				String outString = "";
				
				Integer[] out = new Integer[in.length-1];
			
				for (int n = 0;n < in.length;++n)
				{
					if (i != n)
					{
						outString += in[n];
						
						out[flag] = in[n];
						++flag;
					}
				}
				
				if (finished.get(outString) == null)
				{
					finished.put(outString, 1);
					
					sub.add(out);	
					substring(out);
				}
			}
	}
}
