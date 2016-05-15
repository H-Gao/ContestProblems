package Inheritence2;

public class Animal 
{
	String name;
	boolean isAlive;
	boolean reproduces;
	int lifespan;
	int age;
	int weight;
	int height;
	
	public Animal(String n, int l, int a, int w, int h)
	{
		String name = n;
		boolean isAlive = true;
		boolean reproduces = true;
		int lifespan = l;
		int age = a;
		int weight = w;
		int height = h;
	}
	
	public void getAge()
	{
		System.out.println(age);
	}
	
	public void getWeight()
	{
		System.out.println(weight);
	}
	
	public void getHeight()
	{
		System.out.println(height);
	}
	
	public void setDead()
	{
		isAlive = false;
	}
}
