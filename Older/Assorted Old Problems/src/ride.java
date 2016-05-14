import java.io.*;

/*
ID: roadtop1
LANG: JAVA
TASK: ride
*/
class ride
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader in = new BufferedReader(new FileReader("ride.in"));
		int groupID = convertNumber(in.readLine());
		int cometID = convertNumber(in.readLine());
		
		PrintWriter out = new PrintWriter("ride.out");
		
		if (groupID%47==cometID%47)
			out.println("GO");
		else
			out.println("STAY");
		
		out.close();
		System.exit(0);
	}
	
	public static int convertNumber(String name)
	{
		int output = (int)name.charAt(0)-64;
		
		for (int n = 1;n != name.length();++n)
			output *= ((int)name.charAt(n)-64);
		
		return output;
	}
}
