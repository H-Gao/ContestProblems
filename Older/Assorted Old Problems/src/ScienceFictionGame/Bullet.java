package ScienceFictionGame;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Bullet extends JLabel
{
	boolean isMoving;
	
	int distanceToTargetX;
	int distanceToTargetY;
	
	int n = 0;
	
	int damage;
	int accuracy;
	int BulletID;
	int direction;
	
	public Bullet(int ID)
	{
		super(new ImageIcon("C:\\ScienceFictionGame\\Projectiles\\"+"Bullet"+".png"));
		
		isMoving = false;
	}
	
	public Bullet(ImageIcon imageIcon)
	{
		super(imageIcon);
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
