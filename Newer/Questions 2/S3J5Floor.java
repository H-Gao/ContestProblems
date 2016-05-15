package Questions;

import java.util.Scanner;

public class S3J5Floor
{
    static Scanner cc;
    static int [] [] house;
    static int r, c;

    public static void main (String [] args)
    {
	cc = new Scanner(System.in);

	String line;
	int n, k;
	int [] room;
	int count, largest;
	boolean done;

	// read grid
	// put -1 for walls, 0 for room
	n = Integer.parseInt(cc.nextLine ());
	r = Integer.parseInt(cc.nextLine ());
	c = Integer.parseInt(cc.nextLine ());
	house = new int [r] [c];
	for (int i = 0 ; i < r ; i++)
	{
	    line = cc.nextLine ();
	    for (int j = 0 ; j < c ; j++)
		if (line.charAt (j) == 'I')
		    house [i] [j] = -1;
		else
		    house [i] [j] = 0;
	}

	//number the rooms
	k = 1;
	for (int i = 0 ; i < r ; i++)
	    for (int j = 0 ; j < c ; j++)
		if (house [i] [j] == 0)
		{
		    check (i, j, k);
		    k++;
		}

	// determine area of rooms
	room = new int [500];
	for (int i = 0 ; i < r ; i++)
	    for (int j = 0 ; j < c ; j++)
		if (house [i] [j] > 0)
		    room [house [i] [j]]++;

	// get next largest room and floor it
	count = 0;
	done = false;
	while (!done && n > 0)
	{
	    largest = 0;
	    for (int i = 0 ; i < 500 ; i++)
		if (room [i] > room [largest])
		    largest = i;
	    if (room [largest] > 0)
	    {
		if (room [largest] <= n)
		{
		    n = n - room [largest];
		    room [largest] = -1;
		    count++;
		}
		else
		    done = true;
	    }
	    else
		done = true;
	}

	System.out.println (count + " rooms, " + n + " square metre(s) left over");

	cc.close ();
    }


    // sets the house grid are current location to k, and recursively
    // sets all connected square to k as well.
    public static void check (int i, int j, int k)
    {
	if (i >= 0 && i < r && j >= 0 && j < c && house [i] [j] == 0)
	{
	    house [i] [j] = k;
	    check (i - 1, j, k);
	    check (i + 1, j, k);
	    check (i, j + 1, k);
	    check (i, j - 1, k);
	}
    }
}