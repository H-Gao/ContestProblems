import java.util.Scanner;


public class RollTheDice 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int diceA = in.nextInt();
		int diceB = in.nextInt();
		
		if (diceA >= 10) diceA = 9;
		if (diceB >= 10) diceB = 9;
		
		int flag = 0;
		
		for (int a = 10-diceA;a <= diceB;++a)
			for (int b = 10-diceB;b <= diceA;++b)
				if (a + b == 10)
					++flag;
		
		System.out.println(flag);
	}
}
