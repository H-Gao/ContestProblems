package ScienceFictionGame;

import javax.swing.*;
import java.awt.event.*;

public class ExecuteGame 
{
	int race = 0;
	
	public ExecuteGame()
	{
		final GUISelectRace guiSelectRace = new GUISelectRace();
		
	    Timer timer = new Timer(10, new ActionListener()
	    {
		 public void actionPerformed(ActionEvent event)
		 {
			 if (guiSelectRace.race >= 0)
			 {
				 race = guiSelectRace.race;
				 guiSelectRace.dispose();
			 }
		 }
		});
		
		timer.start();
	}
	
	public static void main(String args[])
	{
		ExecuteGame executeGame = new ExecuteGame();
	}
}
