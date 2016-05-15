import java.util.Stack;

public class AutoBoxing 
{
	public static void main(String[] args)
	{
		Stack<Integer> stack = new Stack<Integer>();
		
		stack.push(10);
		
		int out = stack.pop();
		
		System.out.println(out);
	}
}
