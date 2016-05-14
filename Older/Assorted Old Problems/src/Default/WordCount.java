package Default;
import java.util.Scanner;

public class WordCount 
{
	public static void main(String args[])
	{
		Scanner scanner = new Scanner(System.in);
		
		String n[];
		String k;
		
		k = scanner.nextLine();
		
		n = k.split(" ");
		
		System.out.println(n.length);
	}
}
