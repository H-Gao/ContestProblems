package Applet;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class AppletExample extends Applet
{
	int x = 0;
	int y = 0;
	int z = 0;
	
	public void init()
	{
		resize(100, 100);
		setBackground(new Color(100, 200, 200));
	}
	
	public void paint(Graphics g)
	{
		setBackground(new Color(10, 195, 156));
	}
}
