
public class simulation 
{
	public simulation()
	{
		int n = 3;
		
		move(n, 'A', 'B', 'C');
	}
	
	public static void main(String[] args)
	{
		simulation s = new simulation();
	}
	
	public void move(int n, char a, char b, char c)
	{
		if (n == 1)
		{
			System.out.println("Move from " + a + " to " + c);
			return;
		}

		move(n-1, a, c, b);
		System.out.println("Move from " + a + " to " + c);
		move(n-1, b, a, c);
	}
}
