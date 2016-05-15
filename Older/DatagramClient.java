import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;


public class DatagramClient 
{
	public static void main(String[] args)
	{
		try
		{
			MulticastSocket socket = new MulticastSocket(2315);
			InetAddress group = InetAddress.getByName("localhost");
			socket.joinGroup(group);
		
			DatagramPacket packet;
			for (int i = 0; i < 5; i++) {
			    byte[] buf = new byte[256];
			    packet = new DatagramPacket(buf, buf.length);
			    socket.receive(packet);
		
			    String received = new String(packet.getData());
			    System.out.println("Quote of the Moment: " + received);
			}
		
			socket.leaveGroup(group);
			socket.close();
		}
		catch (IOException ioException)
		{
			ioException.printStackTrace();
		}
	}
}
