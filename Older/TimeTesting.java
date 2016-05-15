
public class TimeTesting 
{
	public static void main(String[] args)
	{
		long log = System.nanoTime();
		
		for (int i = 0;i < 50000000;++i);
		
		System.out.println((System.nanoTime()-log)/1000000 + "ms");
	}
}
