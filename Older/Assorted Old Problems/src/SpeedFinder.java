
public class SpeedFinder 
{
	public int num = 0;
	
	public SpeedFinder() throws InterruptedException
	{
		Thread tr = new Thread(new SpeedThread(this));
		tr.run();
		
		while (true)
			++num;
	}
	
	public static void main(String[] args) throws InterruptedException
	{
		SpeedFinder sf = new SpeedFinder();
	}
}
