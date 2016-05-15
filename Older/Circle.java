
public class Circle 
{
	public Circle()
	{
		radius = 0;
		PI = 3.14;
		color = "white";
	}
	
	public Circle(int r)
	{
		radius = r;
		color = "white";
	}
	
	public Circle(int r, double p, String c)
	{
		radius = r;
		PI = p;
		color = c;
	}
	
	double radius;
	double diameter = radius*2;
	double PI;
	String color;
	
	public double getArea()
	{
		return PI*(radius*radius);
	}
	
	public double getCircumference()
	{
		return PI*2*radius;
	}
	
	public double getRadius()
	{
		return radius;
	}
	
	public void setRadius(int r)
	{
		radius = r;
	}
	
	public void setColor(String c)
	{
		color = c;
	}
	
	public void setPI(int p)
	{
		PI = p;
	}
}
