
public class Bird implements FlyingObject 
{
	int wingSpeed;
	
	public Bird(int wingSpeed)
	{
		this.wingSpeed = wingSpeed;
	}

	public void wayToFly() 
	{
		System.out.println("I am a bird, I am flying from energy from the food I eat.");
	}

	public void flying() 
	{
		System.out.println("I am flying.");
	}
}
