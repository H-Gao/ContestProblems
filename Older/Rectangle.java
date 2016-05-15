
public class Rectangle 
{
	private int pointX1;
	private int pointY1;
	private int pointX2;
	private int pointY2;
	private int pointX3;
	private int pointY3;
	private int pointX4;
	private int pointY4;
	
	//This method returns Point One's X value.
	public int getXOne()
	{
		return pointX1;
	}
	
	public int getXTwo()
	{
		return pointX2;
	}
	
	public int getXThree()
	{
		return pointX3;
	}
	
	public int getXFour()
	{
		return pointX4;
	}
	
	public int getYOne()
	{
		return pointY1;
	}
	
	public int getYTwo()
	{
		return pointY2;
	}
	
	public int getYThree()
	{
		return pointY3;
	}
	
	public int getYFour()
	{
		return pointY4;
	}
	
	//This method sets Point One's X and Y. Creating a Point.
	public void setPointOne(int valueX, int valueY)
	{
		pointX1 = valueX;
		pointY1 = valueY;
	}
	
	public void setPointTwo(int valueX, int valueY)
	{
		pointX2 = valueX;
		pointY2 = valueY;
	}
	
	public void setPointThree(int valueX, int valueY)
	{
		pointX3 = valueX;
		pointY3 = valueY;
	}
	
	public void setPointFour(int valueX, int valueY)
	{
		pointX4 = valueX;
		pointY4 = valueY;
	}
}
