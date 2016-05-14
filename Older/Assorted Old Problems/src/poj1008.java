
public class poj1008 
{
	public static void main(String[] args)
	{
		int habbYear = 0;
		int habbMonth = 10;
		int habbDay = 10;
		
		int numDays = (habbYear * 365) + (habbMonth * 20) + (habbMonth/18*5) + habbDay;
		
		System.out.println(numDays);
		
		int TzolkinYear = numDays/260;
		int TzolkinMonth = (numDays/20)%13;
		int TzolkinDay = (numDays%260)%20;
		
		System.out.println(TzolkinYear + " " + TzolkinMonth + " " + TzolkinDay);
	}
	
	public static int habb(String in)
	{
		String[] months = { "pop", "no", "zip", "zotz", "tzec", "xul", "yoxkin", "mol", "chen", "yax", "zac", "ceh", "mac", "kankin", "muan", "pax", "koyab", "cumhu", "uayet"};
		
		for (int i = 0;i < months.length;++i)
		{
			if (in.equals(months[i]))
				return i;
		}
		
		return -1;
	}
	
	public static String TzolkinYear(int i)
	{
		String[] out = "imix, ik, akbal, kan, chicchan, cimi, manik, lamat, muluk, ok, chuen, eb, ben, ix, mem, cib, caban, eznab, canac, ahau".split(", ");
		
		return out[i];
	}
}
