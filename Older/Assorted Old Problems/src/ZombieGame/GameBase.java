package ZombieGame;

import javax.swing.*;

import java.awt.event.*;

import WindowDevelopmentClassesHenry.SimpleWindow;

public class GameBase extends SimpleWindow
{
	char move_Right = 'd';
	char move_Left = 'a';
	char move_Up = 'w';
	char move_Down = 's';
	
	String sprint = "SPACE";
	
	int time = 0;
	
	Timer timer = new Timer(10, new timerListener());
	
	Player player = new Player(this);
	
	public GameBase() 
	{
		super("Game Base", 1368, 728, true);
		this.setFocusable(true);
		
		createKeyBindings();
		timer.start();
	}
	
	public void createKeyBindings()
	{
		player.getInputMap().put( KeyStroke.getKeyStroke(move_Left), "moveLeft");
		player.getActionMap().put("moveLeft", new keyListeners(move_Left));
		
		player.getInputMap().put( KeyStroke.getKeyStroke(move_Right), "moveRight");
		player.getActionMap().put("moveRight", new keyListeners(move_Right));
		
		player.getInputMap().put( KeyStroke.getKeyStroke(move_Up), "moveUp");
		player.getActionMap().put("moveUp", new keyListeners(move_Up));
		
		player.getInputMap().put( KeyStroke.getKeyStroke(move_Down), "moveDown");
		player.getActionMap().put("moveDown", new keyListeners(move_Down));
		
		player.getInputMap().put(KeyStroke.getKeyStroke(sprint), "sprint");
		player.getActionMap().put("sprint", new keyListeners((char)KeyEvent.VK_SPACE));
	}
	
	public void createComponents()
	{
	}
	
	public void doTime()
	{
		++time;
		
		if (time > 1000)
			time = 0;
	}
	
	public void doUpdate()
	{
		doTime();
		
		player.update(this);
	}
	
	public class keyListeners extends AbstractAction
	{
		char n;
		
		public keyListeners(char x)
		{
			n = x;
		}
		
		public void actionPerformed(ActionEvent e) 
		{
			System.out.println("It works.");
			
			if (n == (char)KeyEvent.VK_SPACE && !player.isSprinting)
				player.isSprinting = true;
			
			else if (n == (char)KeyEvent.VK_SPACE)
				player.isSprinting = false;
			
			if (player.isSprinting)
			{
				if (n == move_Right)
					player.sprint(0);
			
				if (n == move_Down)
					player.sprint(1);
			
				if (n == move_Left)
					player.sprint(2);
			
				if (n == move_Up)
					player.sprint(3);
			}
			else
			{
				if (n == move_Right)
					player.walk(0);
			
				if (n == move_Down)
					player.walk(1);
			
				if (n == move_Left)
					player.walk(2);
			
				if (n == move_Up)
					player.walk(3);
			}
		}	
	}
	
	public class timerListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) { doUpdate(); }
	}
	
	public static void main(String[] args) { GameBase gameBase = new GameBase(); }
}
