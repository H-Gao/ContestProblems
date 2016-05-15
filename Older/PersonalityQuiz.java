import java.util.Scanner;


public class PersonalityQuiz 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int start = in.nextInt();
		
		for (int i = 0;i < 10;++i)
		{
			System.out.print(6*i + start);
			
			if (i < 9) System.out.print(", ");
			else System.out.print(".");
		}
	}
}
