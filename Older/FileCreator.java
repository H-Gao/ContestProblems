import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FileCreator 
{
	public static void main(String[] args) throws FileNotFoundException
	{
		PrintWriter in = new PrintWriter("friday.in");
		in.println("");
		
		PrintWriter out = new PrintWriter("friday.out");
		out.println("");
		
		in.close();
		out.close();
	}
}
