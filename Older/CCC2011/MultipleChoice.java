package CCC2011;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MultipleChoice 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		int correctAnswers = 0;
		
		String catcher = in.nextLine();
		
		Queue<String> studentAnswers = new LinkedList<String>();
		
		for (int i = 0;i < N;++i)
		{
			studentAnswers.add(in.nextLine());
		}
		
		for (int i = 0;i < N;++i)
		{
			if (studentAnswers.poll().equals(in.nextLine()))
			{
				++correctAnswers;
			}
		}
		
		System.out.println(correctAnswers);
	}
}
