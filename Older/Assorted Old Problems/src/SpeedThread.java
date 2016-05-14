
public class SpeedThread implements Runnable
{
	SpeedFinder speedF;
	
	public SpeedThread(SpeedFinder sf)
	{
		speedF = sf;
	}
	
	public void run() 
	{
		System.out.println(speedF.num);
		
		System.exit(0);
	}
}
