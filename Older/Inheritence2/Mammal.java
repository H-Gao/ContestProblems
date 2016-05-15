package Inheritence2;

public class Mammal extends Animal
{
	boolean warmBlooded;
	boolean hasFur;
	boolean hasEggs;
	boolean feedsMilk;
	int numberOfYoung;
	
	public Mammal(String n, int l, int a, int w, int h) 
	{
		super(n, l, a, w, h);
		
		boolean warmBlodded = true;
		boolean hasFur = true;
		boolean hasEggs = false;
		boolean feedsMilk = true;
	}
	
	public void setNumberOfYoung(int n)
	{
		numberOfYoung = n;
	}
}
