package ScienceFictionGame;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class AntiAirMissle extends JLabel
{
	boolean isMoving;
	
	int n = 0;
	
	int movementSpeed;
	int missleCooldown;
	int damage;
	int accuracy;
	int BulletID;
	int direction;
	
	public AntiAirMissle(int ID)
	{
		super(new ImageIcon("C:\\ScienceFictionGame\\Projectiles\\"+"AntiAircraftMissle"+".png"));
		
		damage = 2000;
		movementSpeed = 8;
		accuracy = 2;
		isMoving = false;
	}
	
	public void setDirection(int value)
	{
		direction = value;
	}
	
	public void setBulletID(int value)
	{
		BulletID = value;
	}
}
