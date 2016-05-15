package Inheritence2;
import java.util.Scanner;

public class NextInLine 
{
	public static void main(String[] args) 
	{
		int input1;
		int input2;
		int difference;
		
		Scanner sc = new Scanner(System.in);
		
		input1 = sc.nextInt();
		input2 = sc.nextInt();
		
		difference = input2 - input1;
		
		System.out.println("The next number is " + (difference + input2));
	}
}
