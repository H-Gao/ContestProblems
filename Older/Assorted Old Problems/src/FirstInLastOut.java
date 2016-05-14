import java.util.Stack;

public class FirstInLastOut 
{
	public static void main(String[] args)
	{
		Stack<String> stack = new Stack<String>();
		
		for (int n = 0;n != 10;++n)
		{
			stack.push(""+n);
		}
		
		while (!stack.isEmpty())
			System.out.println(stack.pop());
	}
}
