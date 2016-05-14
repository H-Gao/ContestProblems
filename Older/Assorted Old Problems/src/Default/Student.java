package Default;

public class Student extends Person
{
	int grade;
	String homeroom;
	
	public Student(String f, String l, int a, int g, String h) 
	{
		super(f, l, a);
		grade = g;
		homeroom = h;
	}
	
	public static void main(String[] args)
	{
		Student peter = new Student("Peter", "Johnson", 12, 7, "112");
		peter.outputInfo();
	}

	public void outputInfo()
	{
		System.out.println("His/Her name is " + firstName + " " + lastName);
		System.out.println("He/She is " + age + " Years old");
		System.out.println("He is now in Grade " + grade);
		System.out.println("His homeroom is room " + homeroom);
	}
}
