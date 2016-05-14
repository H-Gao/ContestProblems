package RPGGame;

import javax.swing.*;
import java.awt.event.*;

public class StartScreen extends JFrame
{
	boolean isFinished = false;
	
	JLabel background = new JLabel(new ImageIcon("C:\\RPG\\StartScreen\\StartScreen.png"));
	
	JButton start = new JButton("Start");
	
	public StartScreen()
	{
		setTitle("RPG Game");
		setSize(1368, 735);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		createBackground();
		setButtonLocations();
	}
	
	public void createBackground()
	{
		background.setBounds(0, 0, this.getWidth(), this.getHeight());
		add(background);
	}
	
	public void setButtonLocations()
	{
		start.setBounds(550, 250, 600, 100);
		start.addActionListener(new ButtonListener(0, this));
		add(start);
	}
	
	public class ButtonListener implements ActionListener
	{
		StartScreen startScreen;
		int ID;
		
		public ButtonListener(int value, StartScreen start)
		{
			ID = value;
			startScreen = start;
		}
		
		public void actionPerformed(ActionEvent e) 
		{
			if (ID == 0)
			{
				isFinished = true;
				startScreen.dispose();
			}
		}
	}
}
