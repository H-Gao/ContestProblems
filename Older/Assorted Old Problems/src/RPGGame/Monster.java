package RPGGame;

import javax.swing.ImageIcon;

public class Monster extends Living
{
	int damageCooldown;
	
	boolean isAlert;
	
	public Monster(ImageIcon image)
	{
		super(image);
		
		isAlert = false;
	}
	
	public void executeMonster(Player player, int time, int range)
	{
		if (this.getX() < player.getX() + range && this.getX() > player.getX() - range && this.getY() < player.getY() + range && this.getY() > player.getY() - range)
			isAlert = true;
		else
			isAlert = false;
		
		if (isAlert && time%3==0)
		{
			if (this.getX() > player.getX())
				this.setLocation(this.getX() - movementSpeed, this.getY());
			
			if (this.getX() < player.getX())
				this.setLocation(this.getX() + movementSpeed, this.getY());
			
			if (this.getY() > player.getY())
				this.setLocation(this.getX(), this.getY() - movementSpeed);
			
			if (this.getY() < player.getY())
				this.setLocation(this.getX(), this.getY() + movementSpeed);
		}
	}
}
