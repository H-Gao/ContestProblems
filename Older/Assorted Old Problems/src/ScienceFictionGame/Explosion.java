package ScienceFictionGame;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Explosion extends JLabel
{
	boolean isExploding;
	
	int timeExploding;
	int type;
	int damage;
	int duration;
	int numChanges;
	
	public Explosion(int t, int da, int du, int nc)
	{
		super(new ImageIcon("C:\\ScienceFictionGame\\Explosion\\Explosion_1.png"));
		
		isExploding = false;
		type = t;
		damage = da;
		duration = du;
		numChanges = nc;
	}
}
