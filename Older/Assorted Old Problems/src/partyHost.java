import java.util.ArrayList;
import java.util.Scanner;


public class partyHost 
{
	public static void main(String[] args)
	{
		ArrayList<ArrayList<Integer>> people = new ArrayList<ArrayList<Integer>>();
		
		ArrayList<String> input = new ArrayList<String>();
		
		Scanner in = new Scanner(System.in);
		
		int numPeople = 4;
		int numLines = 3;
		
		for (int i = 0;i < numLines;++i)
		{		
			input.add(in.nextLine());
		}
		
		for (int i = 0;i < numPeople;++i)
			people.add(new ArrayList<Integer>());
		
		for (int i = 0;i < numLines;++i)
		{
			String[] splitedInput = input.get(i).split(" ");
			
			int person1 = Integer.parseInt(splitedInput[0]);
			int person2 = Integer.parseInt(splitedInput[1]);
			
			people.get(person1).add(person2);
		}
		
		for (int x = 0;x < people.size();++x)
		{
			for (int y = 0;y < people.size();++y)
			{
				if (!people.get(x).contains(y) && x != y)
				{
					System.out.println(x + " should meet with " + y);
					people.get(y).add(x);
				}
			}
		}
	}
	
	public void scrappedMethods()
	{
		/*//Removes reoccuring elements.
		for (int i = 0;i < people.size();++i)
		{
			for (int n = 0;n < people.get(i).size();++n)
			{
				ArrayList<Integer> person = people.get(i);
				
				if (people.get(person.get(n)).contains(i))
				{
					people.get(person.get(n)).remove(people.get(person.get(n)).indexOf(i));
					System.out.println(people.get(person.get(n)).contains(i));
				}
			}
		}*/
		
		/*for (int x = 0;x < people.size();++x)
		{
			ArrayList<Integer> person = people.get(x);
			
			for (int y = 0;y < person.size();++y)
			{
				int searchingFor = person.get(y);
				
				//Keeps searching until there are no more numbers left.
				for (int i = 0;person.indexOf(searchingFor) != person.lastIndexOf(searchingFor);)
				{
					if (person.get(i) == searchingFor)
					{
						person.remove(i);
					}
				}
			}
		}*/
	}
}
