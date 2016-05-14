
public class Multithreading implements Runnable
{
	public void run()
	{
		System.out.println("It is running.");
		
		while (true);
	}
	
	public static void main(String[] args)
	{
		Thread running = new Thread(new Multithreading());
		running.start();
		
		Thread newThread = new Thread(new Multithreading());
		newThread.start();
	}
}
