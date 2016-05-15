import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class Server 
{
	public static void main(String[] args)
	{
		int portNumber = 2536;

		try 
		{
		    ServerSocket serverSocket = new ServerSocket(portNumber);
		    
		    System.out.println("Connecting the client with the server... ");
		    
		    Socket clientSocket = serverSocket.accept();
		    
		    System.out.println("Successfully connected.");
		    System.out.println("User Data: " + clientSocket.getLocalAddress() + " " + clientSocket.getLocalPort());
		    
		    BasicProtocol kkp = new BasicProtocol();
		    String outputLine = kkp.parseInput("Start Up");
		    
	    	Scanner input = new Scanner(System.in);
	    	String inputLine;
	    	
		    System.out.println(outputLine);

		    while (!(inputLine = kkp.parseInput(inputLine = input.nextLine())).contains("Server Request Exit")) 
		    {
		        System.out.println(inputLine);
		    }
		    
		    System.out.println("The server is shutting down." + " \nReasons:" + inputLine.substring(19, inputLine.length()));
		}
		catch (IOException ioexception)
		{
			ioexception.printStackTrace();
		}
	}
}
