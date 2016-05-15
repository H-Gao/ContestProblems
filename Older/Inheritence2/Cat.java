package Inheritence2;
import java.util.Random;

public class Cat extends Mammal
{
	String eatsWhat;
	String breed;
	boolean hasBeenFed = false;
	
	public Cat(String n, int l, int a, int w, int h, String b) {
		super(n, l, a, w, h);
		
		String eatsWhat = "Meat";
		String breed = b;
	}
	
	Random random = new Random();
	
	public boolean isAffectionate()
	{
		if (random.nextInt(10) > 8 || hasBeenFed)
		{
			return true;
		}
		
		else
		{
			return false;
		}
	}
	
	public boolean setHasBeenFed(boolean x)
	{
		if (x)
		{
			return true;
		}
		
		else
		{
			return false;
		}
	}
}
