package GameBase;

import java.awt.event.*;

import javax.swing.*;

import java.awt.*;
import java.beans.PropertyChangeListener;

public class GameBase extends JFrame
{	
	int time = 0;
	
	Timer timer = new Timer(100, new timerListener());
	
	ImageIcon image = new ImageIcon("C:\\GameBase\\"+"Player"+".png");
	GameBaseCharacter player = new GameBaseCharacter(image);
	
	ImageIcon images[] = new ImageIcon[100];
	
	public GameBase()
	{
		setTitle("GameBaseTest");
		setSize(400, 600);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		addKeyListener(new keyListener());
		
		createPlayer();
		
		timer.start();
	}
	
	public static void main(String args[])
	{
		GameBase gameBase = new GameBase();
	}
	
	public void createPlayer()
	{
		player.setFocusable(true);
		player.addMouseListener(new mouseListener());
		player.setBounds(80, 80, image.getIconWidth(), image.getIconHeight());
		add(player);
	}
	
	public void move(JLabel character, int amount, int direction)
	{
		if (direction == 0) character.setLocation(character.getX() + amount, character.getY());
		 if (direction == 1) character.setLocation(character.getX(), character.getY()  + amount);
		 if (direction == 2) character.setLocation(character.getX()  - amount, character.getY());
		 if (direction == 3) character.setLocation(character.getX(), character.getY()  - amount);
	}
	
	public class keyListener implements KeyListener
	{
		public void keyTyped(KeyEvent e) 
		{
		}

		public void keyPressed(KeyEvent e) 
		{
			if (e.getKeyChar() == 'd')
			{
				move(player, 1, 0);
			}
			 if (e.getKeyChar() == 's')
			 {
				move(player, 1, 1);
			 }
			 if (e.getKeyChar() == 'a')
			 {
				move(player, 1, 2);
			 }
			 if (e.getKeyChar() == 'w')
			 {
				move(player, 1, 3);
			 }
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public class mouseListener implements MouseListener
	{
		public void mouseClicked(MouseEvent e) 
		{
			move(player, 20, 0);
		}
		
		public void mousePressed(MouseEvent e) 
		{
			
		}

		public void mouseReleased(MouseEvent e) 
		{
			
		}

		public void mouseEntered(MouseEvent e) 
		{
			
		}

		public void mouseExited(MouseEvent e) 
		{
			
		}
	}
	
	public class timerListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			++time;
			
			if (time > 1000) time = 0;
		}
	}
}
