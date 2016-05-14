
public class PiChanger 
{
	static int i = 0;
	
	public static void main(String[] args)
	{
		String str = "pipippipipipipipipipipipipipipipipipipipippipipipipipipipppipipipipipipipiipiiipi";
		System.out.println(changePi(str, str.length()-2));
	}
	
	public static String changePi(String str, int n)
	{
		System.out.println(n);
		
		String out = str;
		
		if (n >= 0 && n+1 < str.length())
		{
			if (str.charAt(n) == 'p' && str.charAt(n+1) == 'i')
			{
				String checkPi = str.substring(0, n) + "3.14" + str.substring(n+2, str.length());
				
				out = changePi(checkPi, str.length()-1);
			}
			else
			{
				out = changePi(str, n-1);
			}
		}
		
		return out;
	}
}
