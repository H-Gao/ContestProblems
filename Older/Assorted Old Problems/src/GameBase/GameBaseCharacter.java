package GameBase;

import java.awt.*;

import javax.swing.*;

public class GameBaseCharacter extends JLabel
{
	int health;
	int movementSpeed;
	int armor;
	int damage_Melee;
	int damage_Ranged;
	int damage_Magic;
	
	public GameBaseCharacter(ImageIcon imageIcon, int h, int m, int a, int dm, int dr, int dma)
	{
		super(imageIcon);
		
		health = h;
		movementSpeed = m;
		armor = a;
		damage_Melee = dm;
		damage_Ranged = dr;
		damage_Magic = dma;
	}
	
	public GameBaseCharacter(ImageIcon imageIcon)
	{
		super(imageIcon);
		
		health = 1;
		movementSpeed = 0;
		armor = 0;
		damage_Melee = 0;
		damage_Ranged = 0;
		damage_Magic = 0;
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