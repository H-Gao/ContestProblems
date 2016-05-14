package JavaClass;

import java.util.Arrays;

public class JavaSorting 
{
	public static void main(String[] args)
	{
		int sort[] = new int[100];
	
		for (int n = 0;n != 100;++n)
			sort[n] = (int)((Math.random()*Math.random())*10) - 100;
	
		Arrays.sort(sort);
		
		for (int n = 0;n != 100;++n)
			System.out.println(sort[n] + " " + ((int)((Math.random()*Math.random())*10) - 100));
	}
}
