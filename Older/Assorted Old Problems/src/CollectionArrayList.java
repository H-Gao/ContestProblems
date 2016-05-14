import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class CollectionArrayList 
{
	public static void main(String[] args)
	{
		List<String> list = new ArrayList<String>();
		
		for (int n = 0;n != 40;++n)
		{
			list.add("List" + n);
		}
		
		for (String str : list)
		{
			System.out.println(str);
		}
		
		Iterator<String> iterator = list.iterator();
		
		while (iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
	}
}
