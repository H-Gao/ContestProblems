package RPGGame;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class StatusBar extends JLabel
{
	public StatusBar(GameBase gameBase)
	{
		super(new ImageIcon("C:\\RPG\\StatusBars\\HealthBar.png"));
		this.setBounds(1, 1, 1, 1);
		gameBase.add(this);
	}
	
	public StatusBar(GameBase gameBase, StatusBar healthBar)
	{
		super(new ImageIcon("C:\\RPG\\StatusBars\\SprintBar.png"));
		this.setBounds(10 + healthBar.getWidth(), 10 + healthBar.getHeight(), 1, 1);
		gameBase.add(this);
	}
	
	public void update(Player player)
	{
		this.setBounds(1, 1, player.health*2, 10);
	}
	
	public void update(Player player, StatusBar healthBar)
	{
		this.setBounds(10 + healthBar.getWidth(), 1, player.sprint, 10);
	}
}
