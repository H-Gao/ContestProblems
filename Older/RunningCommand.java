import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RunningCommand 
{
	public static void main(String[] args)
	{
		System.out.println("Running");
		
		try 
		{
			Thread.sleep(10000);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		/*try 
		{
			//Runtime.getRuntime().exec("runas /profile /user:Administrator /savecred");
			Runtime.getRuntime().exec("cmd /c tasklist > C:\\Judo Workspace\\Default\\TaskList.txt");
			
			BufferedReader in = new BufferedReader(new FileReader("C:\\TaskList.txt"));
			
			String input;
			while ((input = in.readLine()) != null) System.out.println(input);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}*/
	}
    /*private static final String CMD = 
        "netsh int ip set address name = \"Local Area Connection\" source = static addr = 192.168.222.3 mask = 255.255.255.0";
    
    public static void main(String args[]) 
    {

        try {
            // Run "netsh" Windows command
            Process process = Runtime.getRuntime().exec(CMD);

            // Get input streams
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
            BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));

            // Read command standard output
            String s;
            System.out.println("Standard output: ");
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
            }

            // Read command errors
            System.out.println("Standard error: ");
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }*/
}