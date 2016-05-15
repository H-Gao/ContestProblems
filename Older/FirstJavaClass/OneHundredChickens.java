package FirstJavaClass;

public class OneHundredChickens 
{

	public static void main(String[] args) 
	{
		int possibilities = 0;
		//cr = cost of one rooster, ch = cost of one hen, cc = cost of three chicks
		int cr = 5;
		int ch = 3;
		int cc = 3;
		//the amount of money you have
		int money = 100;
		//biggest amount of chickens Ex. 1,2,3,4,5. 5 is the biggest, so it
		//will be stored, instead of the others.
		int pr = 0;
		int ph = 0;
		int pc = 0;
		//chickens made by roosters and hens. 1 rooster + 1 hen = 1 chicken.
		int rhmc[] = new int[1000000];
		//chickens made by chicks. They will grow up.
		int cmc[] = new int[1000000];
		//maximum amount of times the for loop will run.
		int mr = 0;
		//maximum amount of times the for loop will run.
		int mr2 = 0;
		
		//biggest amount of roosters Ex. 1,2,3,4,5. 5 is the biggest, so it
		//will be stored, instead of the others.
			pr = money/cr;
				
			//biggest amount of hens
			ph = money/ch;
				
			//biggest amount of chicks
			pc = money/cc;
			pc *=3;
		
		//The smallest one will be the one that will be used. Ex. 4 roosters and 20 hens will only make 4 chickens.
	    if (pr < ph)
	    {
	    	for (int x = 0;x != pr + 1;++x)
	    	{
	    		rhmc[x] = x;
	    		mr = x;
	    	}
	    }
	    
	    else if (pr > ph)
	    {
	    	for (int x = 0;x != ph + 1;++x)
	    	{
	    		rhmc[x] = x;
	    		mr = x;
	    	}
	    }
		
		//the number of chickens made chicks.
		for (int x = 0;x != pc;++x)
		{
          cmc[x] = x;
  		  mr2 = x;
		}
		
		//calculates the number of possibilities.
    	for (int k = 0;k != mr + 1;++k)
    	{
    		for (int x = 0;x != mr2 + 1;++x)
    		{
    			if (rhmc[k] + cmc[x] == 100)
    			{
    				++possibilities;
    			}
    		}
    	}
    	
    	System.out.println("There are " + possibilities + " different ways to make 100 chickens with $100.");
	}
}
