package ScienceFictionGame;

import javax.swing.ImageIcon;

public class ITH extends Aircraft
{
	public ITH() 
	{
		super(new ImageIcon("C:\\ScienceFictionGame\\Aircraft\\ITH\\ITH.png"));
		
		setIcon(new ImageIcon("C:\\ScienceFictionGame\\Aircraft\\ITH\\ITH.png"));
		isMoving = false;
		health = 6000;
		movementSpeed = 1;
		armor = 10;
		damage_Melee = 0;
	}
}
