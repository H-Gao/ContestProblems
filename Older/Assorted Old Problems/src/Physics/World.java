package Physics;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Timer;

import WindowDevelopmentClassesHenry.SimpleWindow;

public class World extends SimpleWindow implements ActionListener, MouseListener
{
	Timer timer = new Timer(30, this);
	
	Point mouseLocation = new Point();
	
	boolean isActive = false;
	
	String equipedItem = "Graviator";
	
	Ball ball;
	
	public World() 
	{
		super("Physics", 600, 600, true);
		this.addMouseListener(this);
		timer.start();
	}
	
	public void createComponents()
	{
		ball = new Ball(this);
	}
	
	public static void main(String[] args)
	{
		World world = new World();
	}

	public void actionPerformed(ActionEvent e) 
	{
		doGravity(ball, 2);
		
		if (isActive)
		{
			if (ball.getX() > mouseLocation.getX())
				ball.setLocation(ball.getX() - 1, ball.getY());
			else if (ball.getX() < mouseLocation.getX())
				ball.setLocation(ball.getX() + 1, ball.getY());
			
			if (ball.getY() > mouseLocation.getY())
				ball.setLocation(ball.getX(), ball.getY() - (int)(2 + ball.gravity));
			else if (ball.getY() < mouseLocation.getY())
				ball.setLocation(ball.getX(), ball.getY() + (int)(2  + ball.gravity));
		}
	}
	
	public void doGravity(Ball ball, int gravityValue)
	{
		System.out.println(ball.gravity + " " + ball.upwardForce);
		
		if (ball.gravity <= 8)
			ball.gravity += 0.1;
		
		if (ball.upwardForce <= 16)
			ball.upwardForce += 0.1;
		
		if (ball.hasTouchedGround)
		{
			if (ball.upwardForce <= 0)
				ball.hasTouchedGround = false;
			else
				ball.upwardForce -= 0.125;
			
			ball.setLocation(ball.getX(), ball.getY() - (int)ball.upwardForce);
		}
		
		if (ball.getY() < 586-ball.getHeight())
		{
			ball.hasUpwardMomentum = false;
			ball.setLocation(ball.getX(), ball.getY() + gravityValue + (int)ball.gravity);
		}
		else
		{
			ball.hasTouchedGround = true;
			ball.gravity = 0;
		}
	}

	public void mouseClicked(MouseEvent e) 
	{
		if (equipedItem.equals("Pusher"))
		{
			ball.gravity = 0;
			ball.setLocation(ball.getX(), ball.getY() - 50);
		}
		else if (equipedItem.equals("Graviator"))
		{
			mouseLocation.setLocation(e.getXOnScreen(), e.getYOnScreen());
			
			if (!isActive)
				isActive = true;
			else
				isActive = false;
		}
	}

	public void mousePressed(MouseEvent e) {}

	public void mouseReleased(MouseEvent e) {}

	public void mouseEntered(MouseEvent e) {}

	public void mouseExited(MouseEvent e) {}
}
