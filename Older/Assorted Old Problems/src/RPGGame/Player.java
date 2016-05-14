package RPGGame;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player extends Living
{
	Stats stats = new Stats();
	
	Items weaponSlot;
	Items inventory[] = new Items[32];
	
	int level;
	long exp;
	
	String name;
	String playerClass;
	
	int attack;
	int defense;
	
	boolean hasLoadedClass = false;
	boolean isSprinting;
	int max_Health;
	int max_Damage;
	int max_MovementSpeed;
	int sprint;
	
	public Player(GameBase gamebase, int x, int y)
	{
		super(new ImageIcon("C:\\RPG\\Player\\Player_0.png"));
		this.setBounds(x, y, 28, 77);
		gamebase.add(this);
		
		level = 1;
		exp = 0;
		
		health = 100;
		damage = 1;
		attack = (int)Math.round((2*stats.strength) + (1.5*stats.intelligence));
		movementSpeed = 2;
		max_Health = health;
		max_Damage = damage;
		max_MovementSpeed = movementSpeed*2;
		sprint = 100;
	}
	
	public void update(GameBase gameBase, int time)
	{
		if (gameBase.step < 5)
			this.setIcon(new ImageIcon("C:\\RPG\\Player\\Player_" + this.direction + ".png"));
		
		if (this.sprint <= 100 && time%20==0)
			++this.sprint;
		
		if (this.sprint <= 0)
			this.isSprinting = false;
	}
}
