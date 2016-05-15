package FirstJavaClass;

public class student 
{
	public static void main(String[] args) 
	{
		String studentFirstName;
		String studentLastName;
		int grade;
		int age;
		String date;
	}
	
	public int getgrade(int g)
	{
		return g;
	}
	
	public student(String studentFirstName, String studentLastName, int age, int grade)
	{
		studentFirstName = "";
		studentFirstName = "";
		grade = 0;
		age = grade+7;
	}
	
	public static boolean isTeen(int age)
	{
		if (age >= 13 && age < 20)
		{
			return true;
		}
		
		else
		{
			return false;
		}
	}

}
