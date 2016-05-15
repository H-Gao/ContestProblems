package Inheritence2;

public class Dog extends Mammal
{
	boolean barks;
	String eatsWhat;
	String breed;
	int volumeOfBark;
	
	public Dog(String n, int l, int a, int w, int h, String b) 
	{
		super(n, l, a, w, h);
		
		boolean barks = true;
		String eatsWhat = "Meat";
		String breed = b;
		int volumeOfBark = 1;
	}
	
	public void setVolumeOfBark(int n)
	{
		volumeOfBark = n;
	}
}
