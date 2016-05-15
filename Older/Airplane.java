
public class Airplane implements FlyingObject
{
	int capacity;
	
	public Airplane(int c)
	{
		capacity = c;
	}

	public void wayToFly() 
	{
		System.out.println("I am a Airplane, I am using Gas to fly.");
	}

	public void flying() 
	{
		System.out.println("I am Flying");
	}
	
	public int getCapacity()
	{
		return capacity;
	}
}
