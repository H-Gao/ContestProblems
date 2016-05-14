package ScienceFictionGame;

import javax.swing.ImageIcon;

public class StandardInfantry extends GameBaseCharacter
{	
	String raceName;
	
	public StandardInfantry(int value)
	{		
		super(null);
		
		race = value;
		
		if (race == 0) raceName = "Imperial";
		else if (race == 1) raceName = "Legion";
		else if (race == 2) raceName = "Venes";
		else raceName = "";
		
		setIcon(new ImageIcon("C:\\ScienceFictionGame\\" + raceName + "\\Marine\\Player_0.png"));
		shotCooldown = 0;
		max_ShotCooldown = 4;
		bulletAccuracy = 2;
		isMoving = false;
		health = 200;
		damage = 10;
		movementSpeed = 1;
		armor = 0;
		damage_Melee = 0;
	}
}
