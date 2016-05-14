package RPGGame;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class Spells extends JLabel
{
	boolean isMoving;
	
	int damage;
	
	public Spells(GameBase gameBase, ImageIcon image)
	{
		super(image);
		
		damage = 0;
		isMoving = false;
		
		this.setBounds(10, 10, this.getIcon().getIconWidth(), this.getIcon().getIconHeight());
		gameBase.add(this);
	}
	
	public void update(Player player)
	{
		this.damage = player.damage;
	}
}
