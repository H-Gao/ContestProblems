import java.util.ArrayList;
import java.util.List;


public class PascalsTriangle 
{
	public static void main(String[] args)
	{
		System.out.println(findTriangle(3));
	}
	
	public static List<Integer> findTriangle(int in)
	{
		ArrayList<ArrayList<Integer>> row = new ArrayList<ArrayList<Integer>>();
		
		//adds the first two rows.
		for (int i = 0;i < 2;++i)
		{
			ArrayList<Integer> newRow = new ArrayList<Integer>();
			
			//If i == 0 it adds one, if it is two, it adds two, ones.
			for(int n = 0;n <= i;++n)
				newRow.add(1);
			
			row.add(newRow);
		}
		
		for (int i = 2;i < in+2;++i)
		{
			ArrayList<Integer> newRow = new ArrayList<Integer>();
			
			//Adds a one to the first col.
			newRow.add(1);
			
			ArrayList<Integer> lastRow = row.get(i-1);
			
			//Gets the numbers in between.
			for (int n = 0;n < lastRow.size()-1;++n)
			{
				int sum = lastRow.get(n) + lastRow.get(n+1);
				
				newRow.add(sum);
			}
			
			//Adds a one to the last col.
			newRow.add(1);
			
			row.add(newRow);
		}
		
		return row.get(in);
	}
}
