package RPGGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GUIStatManager extends JFrame
{
	JButton stats[] = new JButton[4];
	
	public GUIStatManager()
	{
		this.setTitle("Stats");
		this.setLayout(null);
		this.setBounds(100, 100, 48*9 + 200, 48*4);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	public void createComponents()
	{
		for (int n = 0;n != 4;++n)
		{
			setStats(stats, n);
			
			stats[n].setBounds(50*n, 100, 50, 50);
			add(stats[n]);
		}
	}
	
	public void setStats(JButton stats[], int n)
	{
		if (n == 0)
			stats[n] = new JButton("Strength");
		
		if (n == 1)
			stats[n] = new JButton("Intelligence");
		
		if (n == 2)
			stats[n] = new JButton("Dexterity");
		
		if (n == 3)
			stats[n] = new JButton("Charisma");
	}
	
	public class statsListener implements ActionListener
	{
		int n;
		
		public statsListener(int x)
		{
			n = x;
		}
		
		public void actionPerformed(ActionEvent e) 
		{
		}
	}
}
