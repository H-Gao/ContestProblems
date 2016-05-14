package ScienceFictionGame;

import javax.swing.ImageIcon;

public class Player extends GameBaseCharacter
{
	public Player(ImageIcon imageIcon) 
	{
		super(imageIcon);
		
		race = 0;
		shotCooldown = 0;
		max_ShotCooldown = 4;
		health = 10000;
		damage = 5;
		direction = 0;
		bulletAccuracy = 10;
		movementSpeed = 2;
		armor = 10;
		damage_Melee = 5;
	}
}
