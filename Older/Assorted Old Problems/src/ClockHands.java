import java.util.Scanner;


public class ClockHands 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		double h = in.nextDouble(), m = in.nextDouble(), s = in.nextDouble();
		
		double totalSeconds = 0;
		
		m = (m + h)%365;
		s = (m + s)%365;
		
		System.out.println(h + " " + m + " " + s);
		
		s = (s*3/15);
		m = (m*3/15) * 60;	
		h = (h/30) * 3600;
		
		totalSeconds = h + m + s;
		
		System.out.println(m + " " + totalSeconds);
		
		h = totalSeconds/3600;
		m = totalSeconds%60;
		s = totalSeconds/60;
		
		System.out.println(h + " " + m + " " + s);
	}
}
