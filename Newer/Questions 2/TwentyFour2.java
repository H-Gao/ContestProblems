package Questions;

import java.util.Scanner;

public class TwentyFour2 
{
	static int[] num;
	static boolean[] visited;
	
	static double max = 0;
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		
		for (int a = 0;a < N;++a)
		{
			max = 0;
			num = new int[4];
			visited = new boolean[4];
			
			for (int i = 0;i < 4;++i)
			{
				num[i] = in.nextInt();
			}
			
			f(0, 0, '+', "");
			f(0, 1, '+', "");
			f(0, 2, '+', "");
			f(0, 3, '+', "");
			
			System.out.println((int)max);
		}
	}
	
	public static void f(double total, int currentNum, char operator, String x)
	{
		x += " " + operator + num[currentNum];
		
		if (operator == '+')
		{
			total += num[currentNum];
		}
		else if (operator == '-')
		{
			total -= num[currentNum];
		}
		else if (operator == '*')
		{
			total *= num[currentNum];
		}
		else if (operator == '/')
		{
			total /= num[currentNum];
		}
		
		visited[currentNum] = true;
		
		boolean flag = true;
		
		for (int i = 0;i < 4;++i)
		{
			if (!visited[i])
			{
				f(total, i, '+', x);
				f(total, i, '-', x);
				f(total, i, '*', x);
				f(total, i, '/', x);
				
				flag = false;
			}
		}
		
		if (flag)
		{
			System.out.println(total + " " + x);
			
			if ((int)total == total && total <= 24 && total > max)
			{
				max = total;
			}
		}
		
		visited[currentNum] = false;
	}
}
