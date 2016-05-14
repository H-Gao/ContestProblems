package RPGGame;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Living extends JLabel
{
	int health;
	int damage;
	int movementSpeed;
	int direction;
	
	public Living(ImageIcon image)
	{
		super(image);
	}
}
