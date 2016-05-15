import java.util.ArrayList;
import java.util.Scanner;


public class DreisamEquations 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		String[] input = reformatEquation(in.nextLine());
		
		String equation = input[0];
		int findNum = Integer.parseInt(input[1]);
		
		System.out.println(equation);
		find(equation, findNum, "");
	}
	
	public static String[] reformatEquation(String equation)
	{
		String[] out = new String[2];
		String temp = "";
		
		String equationStart = equation.substring(0, equation.indexOf('=')-1);
		
		equation = equation.substring(equation.indexOf('=')+2, equation.length());
		
		char[] equationChar = equation.toCharArray();
		
		ArrayList<ArrayList<Character>> priority = new ArrayList<ArrayList<Character>>();
		
		int val = 0;
		
		for (int i = 0;i < equationChar.length;++i)
		{
			char currentChar = equationChar[i];
			
			if (currentChar == '(')
				++val;
			else if (currentChar == ')')
				--val;
			else if (currentChar != ' ')
			{
				if (priority.size() <= val)
					priority.add(new ArrayList<Character>());
				
				priority.get(val).add(currentChar);
			}
		}
		
		for (int i = priority.size()-1;i >= 0;--i)
		{
			for (char n : priority.get(i))
			{
				temp += n + " ";
			}
		}
		
		//Removes the ending " " and adds the beginning (n = ...)
		out[0] = temp;//temp.substring(0, temp.length()-1);
		out[1] = equationStart;
		
		return out;
	}
	
	public static void find(String equation, int findNum, String steps)
	{
		int indexOf = equation.indexOf(' ');
			
		int a = Integer.parseInt(equation.substring(0, indexOf));
		equation = equation.substring(indexOf+1, equation.length());
			
		indexOf = equation.indexOf(' ');
			
		if (indexOf >= 0)
		{
			int b = Integer.parseInt(equation.substring(0, indexOf));
			equation = equation.substring(indexOf+1, equation.length());
			
			//System.out.println(a + " " + b + " | " + equation);
			
			find((a + b) + " " + equation, findNum, steps + "+");
			find((a - b) + " " + equation, findNum, steps + "-");
			find((a * b) + " " + equation, findNum, steps + "*");
		}
		else
		{
			if (a == findNum)
				System.out.println(steps);
		}
	}
}
