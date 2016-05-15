package ThirdJavaClass;

public class Rectangle 
{
	//attributes
	private int length;
	private int width;
	private String color;
	
	//main method
	
	public static void main(String[] args)
	{
		Rectangle rec = new Rectangle();
		Rectangle rec2 = new Rectangle(9999, 2134);
		Rectangle rec3 = new Rectangle(10, 5, "blue");
		System.out.println("The Areas are:");
		System.out.println(rec.getArea(rec.length, rec.width));
		System.out.println(rec2.getArea(rec2.length, rec2.width));
		System.out.println(rec3.getArea(rec3.length, rec3.width));
		System.out.println("\nThe Perimeters are:");
		System.out.println(rec.getPerimeter(rec.length, rec.width));
		System.out.println(rec2.getPerimeter(rec2.length, rec2.width));
		System.out.println(rec3.getPerimeter(rec3.length, rec3.width));
	}
	
    //methods
	public Rectangle()
	{
		length = 5;
		width = 5;
		color = "white";
	}
	
	public Rectangle(int l, int w)
	{
		length = l;
		width = w;
		color = "white";
	}
	
	public Rectangle(int l, int w, String c)
	{
		length = l;
		width = w;
		color = c;
	}
	
	public int getArea(int l, int w)
	{
		return l*w;
	}
	
	public int getPerimeter(int l, int w)
	{
		return (l*2)+(w*2);
	}
}
