package RPGGame;

import javax.swing.*;

import java.awt.event.*;
import java.io.File;

public class RunWindows extends JFrame
{
	public RunWindows()
	{
		this.setTitle("RPG Game");
		this.setSize(900, 600);
		this.setVisible(true);
		this.setLayout(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		createButtons();
	}
	
	public static void main(String[] args)
	{
		RunWindows runWindows = new RunWindows();
	}
	
	public void createButtons()
	{
		Background background = new Background(0, this);
		
		JButton play = new JButton("Play");
		play.setBounds(700, 500, 200, 100);
		play.addActionListener(new playListener());
		add(play);
	}
	
	public class playListener implements ActionListener
	{
		boolean doOpen = false;
		
		public void actionPerformed(ActionEvent e) 
		{
			for (int n = 0;n != 4;++n)
				if (new File(stringValues(n)).exists())
					doOpen = true;
			
			if (doOpen)
			{
				GUIManager guiManager = new GUIManager();
				returnRunWindows().dispose();
			}
		}
	}
	
	public RunWindows returnRunWindows()
	{
		return this;
	}
	
	public String stringValues(int n)
	{
		if (n == 0)
			return "C:\\RPG\\PlayerData\\Stats.txt";
		
		if (n == 1)
			return "C:\\RPG\\PlayerData\\Player.txt";
		
		if (n == 2)
			return "C:\\RPG\\ProgramInfo\\ReadMe.txt";
		
		if (n == 3)
			return "C:\\RPG\\ProgramInfo\\ProgramInfo.txt";
		
		if (n == 4)
			return "C:\\RPG\\PlayerData\\Stats.txt";
		
		if (n == 5)
			return "C:\\RPG\\PlayerData\\Stats.txt";
		
		else
			return null;
	}
}
