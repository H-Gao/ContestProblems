import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


public class BasicClient 
{
    public static void main(String[] args) throws IOException 
    {
        String hostName = "localhost";
        int portNumber = 2536;

        try
        {
            Socket echoSocket = new Socket(hostName, portNumber);
            
            echoSocket.setSoTimeout(10000);
        	
            PrintWriter out =  new PrintWriter(echoSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
            
            String userInput;
            
            while ((userInput = stdIn.readLine()) != null) 
            {
                out.println(userInput);
                System.out.println("echo: " + in.readLine());
            }
        } 
        catch (IOException e) 
        {
        	e.printStackTrace();
        } 
    }
}
