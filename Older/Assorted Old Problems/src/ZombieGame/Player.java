package ZombieGame;

import javax.swing.ImageIcon;

public class Player extends Character
{
	boolean isSprinting;
	
	int sprint;
	
	int food;
	int water;
	int mental;
	
	public Player(GameBase gameBase) 
	{ 
		super(gameBase, 10, 10); 
	}
	
	public void update(GameBase gameBase)
	{
		checkProperties();
		
		this.setIcon(new ImageIcon("C:\\ZombieGame\\Images\\Player\\Player_" + this.direction + ".png"));
	}
	
	public void checkProperties()
	{
		++sprint;
		
		if (health <= 0)
			this.setDead();
		
		if (sprint < 0)
			this.isSprinting = false;
	}
	
	public void setProperties()
	{
		path = "C:\\ZombieGame\\Images\\Player\\Player_" + this.direction + ".png";
		health = 100;
		sprint = 100;
		movementSpeed = 1;
	}
}
