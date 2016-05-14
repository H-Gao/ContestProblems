package BulbGame;

import javax.swing.*;

import java.awt.GridLayout;
import java.awt.event.*;

public class GameBase extends JFrame
{
	int grid = 0;
	
	Timer timer = new Timer(10, new timeListener());
	Bulb bulb[];
	
	JTextArea input = new JTextArea("Lightbulb Game: \n" 
			+ "The objective of the game is to\n"
			+ "turn all the lights ON or OFF\n"
			+ "in the least amount of turns.");
	
	public GameBase()
	{
		setTitle("Lightbulb Game");
		setLayout(null);
		setSize(800, 800);
		setVisible(true);
		
		addKeyListener(new keyListener());
		
		input.setBounds(5, 50, 200, 400);
		add(input);
	}
	
	public static void main(String[] args)
	{
		GameBase gameBase = new GameBase();
	}
	
	public class timeListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			for (int n = 0;n != 25;++n)
			{					
				if (bulb[n] != null)
				{
					if (bulb[n].isOn)
						bulb[n].setIcon(new ImageIcon("C:\\BulbGame\\Lightbulb_On.png"));
					else
						bulb[n].setIcon(new ImageIcon("C:\\BulbGame\\Lightbulb_Off.png"));
				}
			}
		}
	}
	
	public class keyListener implements KeyListener
	{
		public void keyTyped(KeyEvent e) {}

		public void keyPressed(KeyEvent e) 
		{
			if (input.getText().contains("Lightbulb"))
			{
				input.setText("");
			}
			
			if (e.getKeyCode() != KeyEvent.VK_ENTER && input.isVisible())
				input.setText(input.getText() + e.getKeyChar());
			else
			{
				try
				{
					int k = 0;
					
					grid = Integer.parseInt(input.getText());
					bulb = new Bulb[grid*grid];
					
					for (int n = 0;n != grid*grid;++n)
					{
						if (n%grid==0)
							++k;
							
						System.out.println(n);
						bulb[n] = new Bulb();
						
						bulb[n].setBounds((n/grid)*100, 100, 100, 100);
						add(bulb[n]);
					}
					
					
					input.setVisible(false);
					timer.start();
				}
				catch (Exception exception)
				{
					exception.printStackTrace();
					System.out.println("An error occured.");
				}
			}
		}
	
		public void keyReleased(KeyEvent e) {}
	}
}