package ZombieGame;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Character extends JLabel
{
	String path;
	
	boolean isAlive;
	int direction;
	int health;
	int movementSpeed;
	
	public Character(GameBase gameBase, int x, int y)
	{
		this.setProperties();
		this.setDefaultProperties(gameBase, x, y);
	}
	
	public void setProperties() {}
	
	public void setDefaultProperties(GameBase gameBase, int x, int y)
	{
		this.setIcon(new ImageIcon(path));
		this.setFocusable(true);
		this.setBounds(x, y, this.getIcon().getIconWidth(), this.getIcon().getIconHeight());
		gameBase.add(this);
		
		this.direction = 0;
		this.isAlive = true;
	}
	
	public void setDead()
	{
		this.isAlive = false;
		this.setLocation(100, 100);
		this.setVisible(false);
	}
	
	public void walk(int direction)
	{
		if (direction == 0)
		{
			this.direction = 0;
			this.setLocation(this.getX() + movementSpeed, this.getY());
		}
		
		if (direction == 1)
		{
			this.direction = 1;
			this.setLocation(this.getX(), this.getY() + movementSpeed);
		}
		
		if (direction == 2)
		{
			this.direction = 2;
			this.setLocation(this.getX() - movementSpeed, this.getY());
		}
		
		if (direction == 3)
		{
			this.direction = 3;
			this.setLocation(this.getX(), this.getY() + movementSpeed);
		}
	}
	
	public void sprint(int direction)
	{
		if (direction == 0)
		{
			this.direction = 0;
			this.setLocation(this.getX() + (movementSpeed*2), this.getY());
		}
		
		if (direction == 1)
		{
			this.direction = 1;
			this.setLocation(this.getX(), this.getY() + (movementSpeed*2));
		}
		
		if (direction == 2)
		{
			this.direction = 2;
			this.setLocation(this.getX() - (movementSpeed*2), this.getY());
		}
		
		if (direction == 3)
		{
			this.direction = 3;
			this.setLocation(this.getX(), this.getY() + (movementSpeed*2));
		}
	}
}
