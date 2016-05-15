import java.util.Scanner;

public class Main1 
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		
		String topName[] = new String[2];
		int topValue[] = new int[2];
	
		String input = scanner.nextLine();
		
		String inputs[] = new String[Integer.parseInt(input)];
		
		for (int n = 0;n != Integer.parseInt(input);++n)
		{
			inputs[n] = scanner.nextLine();
			
			String[] data = inputs[n].split(" ");
			
			int value = 2* Integer.parseInt(data[1]) + 3 + Integer.parseInt(data[2]) + Integer.parseInt(data[3]);
			
			if (value > topValue[0])
			{
				if (topValue[0] > topValue[1] && topValue[1] > 0)
				{
					topValue[1] = topValue[0];
					topName[1] = topName[0];
				}
				else if (topValue[0] == topValue[1] && topValue[1] > 0)
				{
					if (topName[1].compareTo(topName[0]) < 0)
						topName[1] = topName[0];
				}
				
				topValue[0] = value;
				topName[0] = data[0];
			}
			else if (value == topValue[0])
			{
				if (topValue[0] > topValue[1] && topValue[0] > 0)
				{
					topValue[1] = topValue[0];
					topName[1] = topName[0];
				}
				else if (topValue[0] == topValue[1] && topValue[0] > 0)
				{
					if (topName[1].compareTo(topName[0]) < 0)
						topName[1] = topName[0];
				}
				
				if (topName[0].compareTo(data[n]) < 0)
					topName[0] = data[0];
			}
			else if (value > topValue[1])
			{
				topValue[1] = value;
				topName[1] = data[0];
			}
			else if (value == topValue[1])
			{
				if (topName[1].compareTo(data[0]) < 0)
					topName[1] = data[0];
			}
		}
		
		System.out.println(topName[0]);
		
		if (topName != null)
			System.out.println(topName[1]);
	}
}
