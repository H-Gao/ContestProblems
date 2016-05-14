package CommandLineIOTools;

/*
 * Last Update: June 29th, 2014.
 * This simple program checks the time of a Java class.
 * This is measured in milliseconds, using the runtime speed of THIS PROGRAM.
 * This program is accurate to 40ms.
 */

public class TimeChecker 
{
	//The time at the beginning of the program.
	long loggedTime;
	
	public TimeChecker()
	{
		//Sets a checkpoint to log the time before the program started.
		setCheckpoint();
	}
	
	//A checkpoint to reset the time.
	public void setCheckpoint()
	{
		//Sets the logged time to the time that was taken for this to start up.
		loggedTime = System.nanoTime();
	}
	
	//Outputs the time that the program was completed in.
	public void checkTime()
	{
		//The currentTime.
		long currentTime = System.nanoTime();
		
		//Nanoseconds converted to milliseconds, and outputed.
		System.out.println("Program completed in " + (int)((double)(currentTime-loggedTime)/1000000) + " ms");
	}
}
