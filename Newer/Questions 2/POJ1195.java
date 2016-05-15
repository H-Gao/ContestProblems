package Questions;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.awt.Point;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class POJ1195 
{
	public static int getInput(BufferedReader in) throws IOException
	{
		String input;
		
		while ((input = in.readLine()).equals(""));
		
		return Integer.parseInt(input);
	}
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int testCases = getInput(reader);
		
		for (int tCase = 0;tCase < testCases;++tCase)
		{
			int start = getInput(reader);
			int end = getInput(reader);
			
			boolean[] visited = new boolean[10000];
			Queue<Point> bfs = new LinkedList<Point>();
			
			bfs.add(new Point(start, 0));
			
			boolean finished = false;
			
			while (!bfs.isEmpty() && !finished)
			{
				Point out = bfs.poll();
				
				int val = out.x;
				int num = out.y;
				
				if (val == end)
				{
					System.out.println(num);
					finished = true;
				}
				
				int[] digits = new int[4];
				
				for (int a = 0;a < 4;++a)
				{
					for (int i = 0;i < 4;++i) digits[i] = (int)((val/Math.pow(10, i))%10);
					if ((digits[a] += 1) > 9) digits[a] = 1;
					
					int output = 0;
					
					for (int i = 0;i < 4;++i)
					{
						output += digits[i] * Math.pow(10, i);
					}
					
					if (!visited[output])
					{
						bfs.add(new Point(output, num+1));
						visited[output] = true;
					}
				}
				
				for (int a = 0;a < 4;++a)
				{
					for (int i = 0;i < 4;++i) digits[i] = (int)((val/Math.pow(10, i))%10);
					if ((digits[a] -= 1) < 1) digits[a] = 9;
					
					int output = 0;
					
					for (int i = 0;i < 4;++i) output += digits[i] * Math.pow(10, i);
					
					if (!visited[output])
					{
						bfs.add(new Point(output, num+1));
						visited[output] = true;
					}
				}
				
				for (int a = 0;a < 4;++a)
				{
					for (int i = 0;i < 4;++i) digits[i] = (int)((val/Math.pow(10, i))%10);
					
					if (a != 0)
					{
						int temp = digits[a];
						
						digits[a] = digits[a-1];
						digits[a-1] = temp;
					}
					
					int output = 0;
					
					for (int i = 0;i < 4;++i) output += digits[i] * Math.pow(10, i);
					
					if (!visited[output])
					{
						bfs.add(new Point(output, num+1));
						visited[output] = true;
					}
				}
				
				for (int a = 0;a < 4;++a)
				{
					for (int i = 0;i < 4;++i) digits[i] = (int)((val/Math.pow(10, i))%10);
					
					if (a != 3)
					{
						int temp = digits[a];
						
						digits[a] = digits[a+1];
						digits[a+1] = temp;
					}
					
					int output = 0;
					
					for (int i = 0;i < 4;++i) output += digits[i] * Math.pow(10, i);
					
					if (!visited[output])
					{
						bfs.add(new Point(output, num+1));
						visited[output] = true;
					}
				}
			}
		}
	}
	
	
}
