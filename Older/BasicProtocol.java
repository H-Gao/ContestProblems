
public class BasicProtocol 
{
	public String parseInput(String in)
	{
		if (in != null && in.equals("Start Up"))
			return onStartUp(in);
		else if (in != null && in.substring(0, 4).equals("Exit"))
			return "Server Request Exit" + " reason: " + in.substring(5, in.length());
		else
			return "Server request: " + in;
	}
	
	public String onStartUp(String in)
	{
		return "We are starting up the server.";
	}
}
