package Inheritence;
public class Person2
{
	String name;
	int age;

	public Person2(String n)
	{
		name = n;
		age = 1;
	}

	public Person2(String n, int a)
	{
		name = n;
		age = a;
	}

	public void outputInformation()
	{
		System.out.println("The name is " + name + " " + "Age: " + age);
	}
}