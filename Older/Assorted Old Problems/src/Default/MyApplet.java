package Default;

import java.awt.*;
import javax.swing.JApplet;
import javax.swing.*;

public class MyApplet extends JApplet
{
	JButton button = new JButton("Button");
	
	public void init()
	{
		setSize(400, 400);
		setLayout(null);
		button.setBounds(60, 60, 80, 80);
		System.out.println(button.getLocation() + " " + button.getSize());
		add(button);
	}
	
	public void paint(Graphics g)
	{
	}
}
