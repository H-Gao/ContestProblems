package ScienceFictionGame;

import java.awt.*;

import javax.swing.*;

public class GameBaseCharacter extends JLabel
{
	boolean isMoving;
	boolean isGround;
	
	GameBaseCharacter target;
	int damageCooldown;
	int race;
	int damage;
	int health;
	int movementSpeed;
	int bulletAccuracy;
	int armor;
	int damage_Melee;
	int shotCooldown;
	int max_ShotCooldown;
	int direction;
	
	public GameBaseCharacter(ImageIcon imageIcon, int h, int m, int a, int dm, int dr, int dma)
	{
		super(imageIcon);
		
		isGround = true;
		isMoving = false;
		health = h;
		movementSpeed = m;
		armor = a;
		damage_Melee = dm;
	}
	
	public GameBaseCharacter(ImageIcon imageIcon)
	{
		super(imageIcon);
		
		isMoving = false;
		health = 1;
		damage = 1;
		movementSpeed = 0;
		armor = 0;
		damage_Melee = 0;
	}
	
	
	public void update(GameBase gameBase)
	{
		if (gameBase.time == 0) ++health;
	}
	
	public int getHealth()
	{
		return health;
	}
}