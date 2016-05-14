package Physics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Ball extends JLabel
{
	boolean hasUpwardMomentum = false;
	boolean hasLeftMomentum = false;
	
	boolean hasTouchedGround = false;
	
	double upwardForce = 0;
	double gravity = 0;
	
	public Ball(World world)
	{
		super(new ImageIcon("C:\\Physics\\Ball.png"));
		
		this.setLocation(300, 0);
		this.setSize(100, 100);
		world.add(this);
	}
}
