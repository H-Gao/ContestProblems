package RPGGame;

import java.util.Random;
import javax.swing.*;

public class DemonRageProjectiles extends JLabel
{
	Random random = new Random();
	
	int addX = 1;
	int addY = 1;
	
	public DemonRageProjectiles(GameBase gameBase, ActiveSpells demonRage)
	{
		super(new ImageIcon("C:\\RPG\\Spells\\SoulBurst_0.png"));
		this.setBounds(demonRage.getX() + random.nextInt(200) - 100, demonRage.getY() + random.nextInt(200) - 100, 16, 16);
		gameBase.add(this);
		
		resetMovement();
	}
	
	public void update(ActiveSpells demonRage, int time)
	{
		this.setLocation(this.getX() + addX, this.getY() + addY);
		
		if (time%60==0)
		{
			this.setLocation(demonRage.getX() + random.nextInt(200) - 100, demonRage.getY() + random.nextInt(200) - 100);
			resetMovement();
		}
		
		repaint();
	}
	
	public void resetMovement()
	{
		addX = random.nextInt(16) - 8;
		addY = random.nextInt(16) - 8;
	}
}
