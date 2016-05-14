package Default;

public class Person 
{
	//variables for properties
	String firstName;
	String lastName;
	int age;
	
	//constructors
	public Person (String f, String l, int a)
	{
		firstName = f;
		lastName = l;
		age = a;
	}
	
	public void outputInfo()
	{
		System.out.println("His/Her name is " + firstName + " " + lastName);
		System.out.println("He/She is " + age + " Years old");
	}
}
