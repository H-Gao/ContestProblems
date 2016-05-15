package Recursion;

import java.util.Scanner;

public class Grid 
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		
		int amountX = 7;//scanner.nextInt();
		int amountY = 6;//scanner.nextInt();
		
		String[] x = new String[amountY];
		
		x[0] = "1110000";
		x[1] = "1111110";
		x[2] = "0010000";
		x[3] = "0000110";
		x[4] = "0001110";
		x[5] = "0111001";
		
		conqueur(x, 4, 2-1, amountX, amountY);
		
		for (int n = 0;n != amountY;++n)
			System.out.println(x[n]);
		
		/*for (int n = 0;n != amountY;++n)
		{
			x[n] = scanner.nextLine();
			System.out.println(x[n]);
		}*/
	}
	
	public static void conqueur(String[] x, int posX, int posY, int maxX, int maxY)
	{
		if (x[posY].charAt(posX) == '0' || !isInBounds(posX, posY, maxX, maxY)) System.out.println("Break.");
		else
		{
			x[posY] = x[posY].substring(0, posX) + '0' + x[posY].substring(posX+1, x[posY].length());
			
			if (isInBounds(posX-1, posY, maxX, maxY) && x[posY].charAt(posX-1) == '1')
			{
				conqueur(x, posX-1, posY, maxX, maxY);
			}
			
			if (isInBounds(posX+1, posY, maxX, maxY) && x[posY].charAt(posX+1) == '1')
			{
				conqueur(x, posX+1, posY, maxX, maxY);
			}
			
			if (isInBounds(posX, posY-1, maxX, maxY) && x[posY-1].charAt(posX) == '1')
			{
				conqueur(x, posX, posY-1, maxX, maxY);
			}
			
			if (isInBounds(posX, posY+1, maxX, maxY) && x[posY+1].charAt(posX) == '1')
			{
				conqueur(x, posX, posY+1, maxX, maxY);
			}
		}
	}
	
	public static boolean isInBounds(int posX, int posY, int maxX, int maxY)
	{
		if (posX >= 0 && posX < maxX && posY >= 0 && posY < maxY)
			return true;
		else
			return false;
	}
}
