package RandomList;

import java.io.File;

import java.util.Random;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RandomList 
{
	Random random = new Random();
	
	int numPeople = 0;
	
	List<String> people = new ArrayList<String>();
	List<String> list = new ArrayList<String>();
	List<String> avaliableSlots = new ArrayList<String>();
	
	public RandomList()
	{
		getAvaliableSlots();
	}
	
	public static void main(String[] args)
	{
		RandomList randomList = new RandomList();
	}
	
	//Assigns each person with a avaliable slot.
	public void getAvaliableSlots()
	{
		try
		{		
			//Creates a scanner object that reads the file.
			Scanner in = new Scanner(new FileReader("List.txt"));
			
			//If the file has a next line.
			if (in.hasNextLine())
			{
				String line = in.nextLine();
				
				while (!line.contains("======"))
				{
					people.add(line);
					line = in.nextLine();
				}
				
				line = in.nextLine();
				
				while (!line.contains("======"))
				{
					avaliableSlots.add(line);
					line = in.nextLine();
				}
				
				boolean readFile = false;
				
				if (readFile)
				{
					String currentPerson = in.nextLine();
				
					for (int i = 1;in.hasNextLine();++i)
					{
						line = in.nextLine();
					
						if (i%6==0)
							currentPerson = line;
						else
						{
							list.add(currentPerson + " " + line);
						}
					}
				}
				else
				{
					
					while (!people.isEmpty())
					{
						in = new Scanner(new FileReader("List.txt"));
						
						if (in.hasNextLine())
						{
							line = in.nextLine();
							
							while (!line.contains("======"))
								line = in.nextLine();
							
							line = in.nextLine();
							
							while (!line.contains("======"))
								line = in.nextLine();
						}
						
						int randomNumber = random.nextInt(people.size());
						
						String person = people.get(randomNumber);
						
						line = in.nextLine();
						
						if (line.equals(person))
						{
							for (int n = 0;n != 5;++n)
							{
								line = in.nextLine();
								list.add(person + " " + line);
							}
							
							people.remove(randomNumber);
						}
						else
						{
							while (in.hasNextLine())
							{
								line = in.nextLine();
							
								if (line.equals(people.get(randomNumber)))
								{
									for (int n = 0;n != 5;++n)
									{
										line = in.nextLine();
										list.add(person + " " + line);
									}
									
									people.remove(randomNumber);
									break;
								}
							}
						}
					}
				}
			
				for (int i = 0;!list.isEmpty();)
				{
					String name = list.get(i).split(" ")[0];
					String wantedItem = list.get(i).split(" ")[1];
				
					for (int n = 0;n != avaliableSlots.size();++n)
					{
						//If it finds a match to the wanted slot, it will remove the match from the list of avaliable matches.
						//It will then find and remove all remaining entries in the list with the same name.
						if (wantedItem.equals(avaliableSlots.get(n)))
						{
							System.out.println(name + " " + wantedItem);
						
							avaliableSlots.remove(n);
						
							while (list.get(i).split(" ")[0].equals(name))
							{
								//Removes the entry from the list.
								list.remove(i);
							
								//If the list is empty, it will exit.
								if (list.isEmpty())
									break;
							}
						
							break;
						}
						//If it doesn't find a match on the last one, it will remove the entry from the list.
						else if (n == avaliableSlots.size()-1)
						{
							list.remove(i);
						
							//If the list is empty, it will exit.
							if (list.isEmpty())
								break;
						}
					}
				}
			}
			else
			{
				System.out.println("The file is empty...");
			}
		}
		catch (FileNotFoundException exception)
		{
			System.out.println("The file could not be found.");
		}
	}
}
