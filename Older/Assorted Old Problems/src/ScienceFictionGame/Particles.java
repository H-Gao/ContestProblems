package ScienceFictionGame;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Particles extends JLabel
{
	public Particles(String name)
	{
		super(new ImageIcon("C:\\ScienceFictionGame\\Particles\\Smoke.png"));
		
		if (name.equals("SMOKE"))
			setIcon(new ImageIcon("C:\\ScienceFictionGame\\Particles\\Smoke.png"));
	}
}
