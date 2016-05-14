import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class BinaryTree 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int cap = Integer.parseInt(in.nextLine());
		String command = in.nextLine();
		
		int[] t = new int[cap];
		
		for (int i = 0;i < cap;++i)
			t[i] = i;
		
		if (command.charAt(0) == 'd')
			display(t, command, cap);
		else if (command.charAt(0) == 'f')
			findCommon(in, cap);
		else if (command.charAt(0) == 'g')
			getHeight(in);
	}
	
	public static void display(int[] t, String command, int cap)
	{
		HashMap<Integer, Integer> t1 = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> t2 = new HashMap<Integer, Integer>();
		
		int numInc = 1;
		
		//Gets t1 and t2.
		for (int i = 2;i < cap;)
		{
			for (int n = i;n < i+numInc;++n)
			{	
				if (n < cap) t1.put(t[n], t[n]);
					else break;
				
				if (n+numInc < cap) t2.put(t[n+numInc], t[n+numInc]);
					else break;
			}
			
			i += numInc*2;
			numInc *= 2;
		}
		
		int[] ord1 = new int[t1.size()], ord2 = new int[t2.size()];
		
		binaryFill(ord1, t1, 0, t1.size(), 2, 'l');
		binaryFill(ord2, t2, 0, t2.size(), 3, 'r');
		
		String str1 = "";
		String str2 = "";
		
		for (int i = 0;i < ord1.length;++i) str1 += ord1[i] + " ";
		for (int i = 0;i < ord2.length;++i) str2 += ord2[i] + " ";
		
		displayFormat(command, str1, str2);
	}
	
	public static void findCommon(Scanner in, int cap)
	{
		HashMap<Integer, Integer> logged = new HashMap<Integer, Integer>();
		
		int a = in.nextInt(), b = in.nextInt();
		
		//For efficiency.
		if (b < a)
		{
			int temp = a;
			a = b;
			b = temp;
		}
		
		while (a >= 1)
			logged.put((a /= 2), 0);
		
		while (a != b) if (logged.get(b) != null)
		{
			System.out.println(b);
			break;
		}
		else b /= 2;
	}
	
	public static void displayFormat(String command, String str1, String str2)
	{
		if (command.equals("d1"))
			System.out.println(str1 + "1 " + str2);
		
		else if (command.equals("d2"))
			System.out.println(str2 + "1 " + str1);
		
		else if (command.equals("d3"))
			System.out.println("1 " + str1 + str2);
	}
	
	public static void getHeight(Scanner in)
	{
		int node = Integer.parseInt(in.nextLine());
		int height = 0;
		
		while ((node /= 2) > 0)
			++height;
		
		System.out.println(height);
	}
	
	public static void binaryFill(int[] ord, HashMap<Integer, Integer> t, int s, int e, int index, char d)
	{
		if (t.get(index) != null)
		{
			int place = 0;
			
			if ((s+e)%2 == 1)
			{
				place = (s+e)/2;
			}
			else
			{
				if (d == 'l') place = (s+e)/2;
				else place = (s+e)/2+(s+e)%2;
			}
			
			ord[place] = index;
			
			int nS = 0; int nE = 0;
			
			for (int i = place;i > 0;--i) if (ord[i] == 0 && (i-1 < 0 || ord[i-1] > 0))
			{
				nS = i-1;
				break;
			}
			
			for (int i = place;i < ord.length;++i) if (ord[i] == 0 && (i+1 >= ord.length || ord[i+1] > 0))
			{
				nE = i+1;
				break;
			}
			
			binaryFill(ord, t, nS, place, (index*2), 'l');
			binaryFill(ord, t, place, nE, (index*2)+1, 'r');
		}
	}
}
