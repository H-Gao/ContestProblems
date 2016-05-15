import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.sql.Date;


public class DatagramServer 
{
	public static void main(String[] args)
	{
    	boolean isRunning = true;
    	
	    try 
	    {
	    	DatagramSocket socket = new DatagramSocket(2315);
		
			while (isRunning) 
			{
			     byte[] buf = new byte[256];
			     // don't wait for request...just send a quote
		
			      buf = "sending data.".getBytes();
		
			      InetAddress group = InetAddress.getByName("localhost");
			      DatagramPacket packet;
			      packet = new DatagramPacket(buf, buf.length, group, 4446);
			      socket.send(packet);
		
			      try 
			      {
			          Thread.sleep(1000);
			      } 
			      catch (InterruptedException e) { }
			}
			
		    socket.close();
	    }
	    catch (IOException e) 
	    {
	       e.printStackTrace();
	       isRunning = false;
	    }
	}
}
